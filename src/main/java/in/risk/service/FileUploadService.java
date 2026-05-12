package in.risk.service;

import in.risk.model.FileUploadResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.*;

@Service
public class FileUploadService {

    @Value("${file.upload-dir}")
    private String uploadDir;

    public FileUploadResponse uploadFile(MultipartFile file) throws IOException {

        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        String originalFileName = file.getOriginalFilename();

        Path tempFile = uploadPath.resolve(originalFileName + ".uploading");

        Files.copy(
                file.getInputStream(),
                tempFile,
                StandardCopyOption.REPLACE_EXISTING
        );

        Path finalFile = uploadPath.resolve(originalFileName);

        Files.move(
                tempFile,
                finalFile,
                StandardCopyOption.REPLACE_EXISTING
        );

        //Path doneFile = uploadPath.resolve(originalFileName + ".done");

       // Files.createFile(doneFile);
        
        return new FileUploadResponse(
                originalFileName,
                "UPLOADED",
                finalFile.toString()
        );
    }
}