package com.bt.demo.app.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryVO;

@Service
public interface GuestBookService {
	
	
	String getUserType(String username);
	BookEntry getEntry(int id);
	List<BookEntry> getAllEntries();
	void approveEntry(int id);
	void deleteEntry(int id);
	void updateEntry(BookEntryVO bookentry);
	void addEntry(BookEntryVO bookentry);
    BookEntry uploadFile(MultipartFile file);
}
