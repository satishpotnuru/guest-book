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
	 private byte[] filedata;
	 private String filename;
	 private String filetype;
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
	public byte[] getFiledata() {
		return filedata;
	}
	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public String getFiletype() {
		return filetype;
	}
	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}
	 
	 
	
	 
}
