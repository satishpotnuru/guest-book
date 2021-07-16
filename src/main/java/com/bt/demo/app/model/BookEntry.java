package com.bt.demo.app.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="book_entries")
public class BookEntry {
	
	 @Id
	 @GeneratedValue(strategy = GenerationType.AUTO)
	 @Column(name="id")
	 private int id;
	 private String username;
	 private String comments;
	 private String status;
	 
	 public int getId() {
		return id;
	 }
	 public void setId(int id) {
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
	
	 
}
