package com.bt.demo.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryVO;
import com.bt.demo.app.service.GuestBookService;

@RestController
public class GBController {
	
	@Autowired
	private GuestBookService guestBookSvc;
	
	@GetMapping("/admin/entries")
	public List<BookEntry> getEntries() {
		return guestBookSvc.getAllEntries();
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
		guestBookSvc.addEntry(bookentry);
	}

}
