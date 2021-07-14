package com.bt.demo.app.controller;

import java.util.List;
import java.util.Optional;

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
import com.bt.demo.app.repository.BookEntryRepository;
import com.bt.demo.app.repository.UserRepository;

@RestController
public class GBController {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookEntryRepository bookEntryRepository;
	
	@GetMapping("/admin/entries")
	public List<BookEntry> getEntries() {
		return bookEntryRepository.findAll();
	}
	
	
	@PutMapping("/admin/approveentry")
	public void approveEntry(@RequestBody BookEntryVO bookentry) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(bookentry.getId());
		if( bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setStatus("Approved");
			bookEntryRepository.save(bookEntryEntity);
		}
	}
	
	@PutMapping("/admin/editentry")
	public void ediEntry(@RequestBody BookEntryVO bookentry) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(bookentry.getId());
		if( bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setComments(bookentry.getComments());
			bookEntryRepository.save(bookEntryEntity);
		}
	}
	
	
	@DeleteMapping("/admin/removeentry")
	public void removeEntry(@RequestParam("entryid") int entryid)
	{
		bookEntryRepository.deleteById(entryid);
	}
	
	@PostMapping("/guest/addentry")
	public void addEntry(@RequestBody BookEntryVO bookentry) {
		BookEntry bookEntryEntity = new BookEntry();
		bookEntryEntity.setUserid(bookentry.getUserid());
		bookEntryEntity.setComments(bookentry.getComments());
		bookEntryRepository.save(bookEntryEntity);
	}

}
