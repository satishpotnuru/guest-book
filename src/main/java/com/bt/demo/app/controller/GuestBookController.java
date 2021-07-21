package com.bt.demo.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryDTO;
import com.bt.demo.app.service.GuestBookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookSvc;
	
	
	@GetMapping("/admin/entries")
	public List<BookEntry> getEntries() {
		return guestBookSvc.getAllEntries();
	}
	
	@GetMapping("/admin/entry/{id}")
	public BookEntry getEntry(@PathVariable("id") long id) {
		return guestBookSvc.getBookEntry(id);
	}
	
	
	@PutMapping("/admin/approveentry/{id}")
	public void approveEntry(@PathVariable("id") long id) {
		guestBookSvc.approveBookEntry(id);
	}
	
	@PutMapping("/admin/editentry")
	public void editEntry(@RequestBody BookEntryDTO bookentry) {
		guestBookSvc.updateBookEntry(bookentry);
	}
	
	
	@DeleteMapping("/admin/removeentry/{id}")
	public void removeEntry(@PathVariable("id") long id){
		guestBookSvc.deleteBookEntry(id);
	}
	
	@PostMapping("/guest/addentry")
	public void addEntry(@RequestBody BookEntryDTO bookentry) {
		guestBookSvc.addBookEntry(bookentry);
	}
	
	@GetMapping("/userrole")
	public String getUserRole(@RequestParam("username") String username) {
		return guestBookSvc.getUserRole(username);
	}
	
	@PostMapping("/uploadfile")
    public BookEntry uploadFile(@RequestParam("file") MultipartFile file) {
		return guestBookSvc.uploadFile(file);
    } 
	
	@GetMapping("/downloadfile")
	public ResponseEntity<Resource> downloadFile(@RequestParam("entryid") int entryid){
		BookEntry bookEntry = guestBookSvc.getBookEntry(entryid);
		return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(bookEntry.getFiletype()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + bookEntry.getFilename() + "\"")
	            .body(new ByteArrayResource(bookEntry.getFiledata()));
	}

}
