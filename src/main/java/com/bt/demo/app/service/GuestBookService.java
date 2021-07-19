package com.bt.demo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryDTO;

@Service
public interface GuestBookService {
	
	String getUserType(String username);
	BookEntry getBookEntry(long id);
	List<BookEntry> getAllEntries();
	void approveBookEntry(long id);
	void deleteBookEntry(long id);
	void updateBookEntry(BookEntryDTO bookentry);
	void addBookEntry(BookEntryDTO bookentry);
    BookEntry uploadFile(MultipartFile file);
}
