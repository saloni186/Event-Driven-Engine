package in.risk.model;

public class FileUploadResponse {

    private String fileName;
    private String status;
    private String path;

    public FileUploadResponse() {
    }

    public FileUploadResponse(String fileName, String status, String path) {
        this.fileName = fileName;
        this.status = status;
        this.path = path;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}


