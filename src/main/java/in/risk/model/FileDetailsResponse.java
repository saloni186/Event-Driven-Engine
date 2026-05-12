package in.risk.model;

import java.sql.Timestamp;

public class FileDetailsResponse {
	private String fileName;
	private double fileSize;
	private Timestamp uploadOn;
	private String uploadedBy;
	private Timestamp modifiedOn;
	
	public FileDetailsResponse() {
		// TODO Auto-generated constructor stub
	}
	
	

	public FileDetailsResponse(String fileName, double fileSize, Timestamp uploadOn, String uploadedBy,
			Timestamp modifiedOn) {
		super();
		this.fileName = fileName;
		this.fileSize = fileSize;
		this.uploadOn = uploadOn;
		this.uploadedBy = uploadedBy;
		this.modifiedOn = modifiedOn;
	}



	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public double getFileSize() {
		return fileSize;
	}

	public void setFileSize(double fileSize) {
		this.fileSize = fileSize;
	}

	public Timestamp getUploadOn() {
		return uploadOn;
	}

	public void setUploadOn(Timestamp uploadOn) {
		this.uploadOn = uploadOn;
	}

	public String getUploadedBy() {
		return uploadedBy;
	}

	public void setUploadedBy(String uploadedBy) {
		this.uploadedBy = uploadedBy;
	}

	public Timestamp getModifiedOn() {
		return modifiedOn;
	}

	public void setModifiedOn(Timestamp modifiedOn) {
		this.modifiedOn = modifiedOn;
	}

}
