package in.risk.controller;

import in.risk.model.FileDetailsResponse;
import in.risk.model.FileUploadResponse;
import in.risk.service.FileUploadService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/files")
@CrossOrigin("*")
public class FileUploadController {

	@Autowired
	private FileUploadService fileUploadService;

	@PostMapping("/upload")
	public ResponseEntity<FileUploadResponse> uploadFile(@RequestParam("file") MultipartFile file) throws Exception {

		return ResponseEntity.ok(fileUploadService.uploadFile(file));
	}

	@GetMapping("/download")
	public String downloadFile() {
		return "file downloaded";
	}
	

	@GetMapping("/getAllFiles")
	public ResponseEntity<List<FileDetailsResponse>> getAllFiles() {
		List<FileDetailsResponse> allFiles = this.fileUploadService.getAllFiles();
		return ResponseEntity.ok(allFiles);
	}
}
