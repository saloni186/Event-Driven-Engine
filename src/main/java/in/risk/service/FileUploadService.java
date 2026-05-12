package in.risk.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import in.risk.model.FileDetailsResponse;
import in.risk.model.FileUploadResponse;

@Service
public class FileUploadService {

	@Value("${file.upload-dir}")
	private String uploadDir;

	private String name;

	public FileUploadResponse uploadFile(MultipartFile file) throws IOException {

		Path uploadPath = Paths.get(uploadDir);

		if (!Files.exists(uploadPath)) {
			Files.createDirectories(uploadPath);
		}

		String originalFileName = file.getOriginalFilename();

		Path tempFile = uploadPath.resolve(originalFileName + ".uploading");

		Files.copy(file.getInputStream(), tempFile, StandardCopyOption.REPLACE_EXISTING);

		Path finalFile = uploadPath.resolve(originalFileName);

		Files.move(tempFile, finalFile, StandardCopyOption.REPLACE_EXISTING);

		return new FileUploadResponse(originalFileName, "UPLOADED", finalFile.toString());
	}

	public List<FileDetailsResponse> getAllFiles() {
		List<FileDetailsResponse> list = new ArrayList<>();

		list.add(new FileDetailsResponse("risk_report_jan.pdf", 2.5, Timestamp.valueOf("2026-01-10 10:15:00"), "admin",
				Timestamp.valueOf("2026-01-11 12:20:00")));

		list.add(new FileDetailsResponse("claims_data.xlsx", 5.8, Timestamp.valueOf("2026-01-12 09:30:00"), "vikram",
				Timestamp.valueOf("2026-01-12 10:45:00")));

		list.add(new FileDetailsResponse("policy_document.docx", 1.2, Timestamp.valueOf("2026-01-13 14:00:00"), "rahul",
				Timestamp.valueOf("2026-01-14 15:10:00")));

		list.add(new FileDetailsResponse("audit_log.txt", 0.8, Timestamp.valueOf("2026-01-15 08:25:00"), "system",
				Timestamp.valueOf("2026-01-15 09:00:00")));

		list.add(new FileDetailsResponse("customer_data.csv", 10.4, Timestamp.valueOf("2026-01-16 11:40:00"),
				"khelendra", Timestamp.valueOf("2026-01-17 13:50:00")));

		list.add(new FileDetailsResponse("premium_calculation.xls", 3.6, Timestamp.valueOf("2026-01-18 16:20:00"),
				"neha", Timestamp.valueOf("2026-01-18 17:05:00")));

		list.add(new FileDetailsResponse("fraud_analysis.pdf", 6.7, Timestamp.valueOf("2026-01-19 10:10:00"), "amit",
				Timestamp.valueOf("2026-01-20 11:45:00")));

		list.add(new FileDetailsResponse("monthly_summary.ppt", 4.1, Timestamp.valueOf("2026-01-21 13:15:00"), "sneha",
				Timestamp.valueOf("2026-01-21 14:30:00")));

		list.add(new FileDetailsResponse("backup_file.zip", 25.9, Timestamp.valueOf("2026-01-22 18:00:00"),
				"backup_user", Timestamp.valueOf("2026-01-22 18:30:00")));

		list.add(new FileDetailsResponse("compliance_report.pdf", 7.3, Timestamp.valueOf("2026-01-23 09:50:00"),
				"manager", Timestamp.valueOf("2026-01-24 10:15:00")));

		return list;
	}
}