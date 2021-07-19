package com.bt.demo.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name="book_entries")
public class BookEntry {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="id")
	 private long id;
	 private String username;
	 private String comments;
	 @Lob
	 private byte[] fileData;
	 private String fileName;
	 private String fileType;
	 private String status;
	 
	 public long getId() {
		return id;
	 }
	 public void setId(long id) {
		this.id = id;
	 }
	 public String getUsername() {
		return username;
	 }
	 public void setUsername(String username) {
		this.username = username;
	 }
	 public String getComments() {
		return comments;
	 }
	 public void setComments(String comments) {
		this.comments = comments;
	 }
	 public String getStatus() {
			return status;
	 }
	 public void setStatus(String status) {
			this.status = status;
	 }
	 
	 public byte[] getFileData() {
			return fileData;
		}
	 
	 public void setFileData(byte[] fileData) {
			this.fileData = fileData;
		}
	 
	 public String getFileName() {
			return fileName;
		}
	 
	 public void setFileName(String fileName) {
			this.fileName = fileName;
		}
	public String getFileType() {
		return fileType;
	}
	public void setFileType(String fileType) {
		this.fileType = fileType;
	}
	
	 
}
