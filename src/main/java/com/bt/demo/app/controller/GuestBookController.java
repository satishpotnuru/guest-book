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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryVO;
import com.bt.demo.app.service.GuestBookService;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class GuestBookController {
	
	@Autowired
	private GuestBookService guestBookSvc;
	
	
	@GetMapping("/admin/entries")
	public List<BookEntry> getEntries() {
		System.out.println("got call");
		return guestBookSvc.getAllEntries();
	}
	
	@GetMapping("/admin/entry")
	public BookEntry getEntry(@RequestParam("entryid") int entryid) {
		System.out.println("single entry");
		return guestBookSvc.getEntry(entryid);
	}
	
	
	@PutMapping("/admin/approveentry")
	public void approveEntry(@RequestParam("entryid") int entryid) {
		guestBookSvc.approveEntry(entryid);
	}
	
	@PutMapping("/admin/editentry")
	public void editEntry(@RequestBody BookEntryVO bookentry) {
		guestBookSvc.updateEntry(bookentry);
	}
	
	
	@DeleteMapping("/admin/removeentry")
	public void removeEntry(@RequestParam("entryid") int entryid){
		guestBookSvc.deleteEntry(entryid);
	}
	
	@PostMapping("/guest/addentry")
	public void addEntry(@RequestBody BookEntryVO bookentry) {
		System.out.println("in add entry");
		guestBookSvc.addEntry(bookentry);
	}
	
	@GetMapping("/usertype")
	public String getUserType(@RequestParam("username") String username) {
		System.out.println("username : "+ username);
		return guestBookSvc.getUserType(username);
	}
	
	@PostMapping("/uploadFile")
    public BookEntry uploadFile(@RequestParam("file") MultipartFile file) {
		return guestBookSvc.uploadFile(file);
    } 
	
	@GetMapping("/downloadFile")
	public ResponseEntity<Resource> downloadFile(@RequestParam("entryid") int entryid){
		BookEntry bookEntry = guestBookSvc.getEntry(entryid);
		return ResponseEntity.ok()
	            .contentType(MediaType.parseMediaType(bookEntry.getFileType()))
	            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + bookEntry.getFileName() + "\"")
	            .body(new ByteArrayResource(bookEntry.getFileData()));
	}

}
