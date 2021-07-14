package com.bt.demo.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryVO;
import com.bt.demo.app.repository.BookEntryRepository;
import com.bt.demo.app.repository.UserRepository;

@Component
public class GuestBookServiceImpl implements GuestBookService {
	
	@Autowired
	UserRepository userRepository;
	@Autowired
	BookEntryRepository bookEntryRepository;

	@Override
	public List<BookEntry> getAllEntries() {
		return bookEntryRepository.findAll();
	}

	@Override
	public void approveEntry(int id) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(id);
		if( bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setStatus("Approved");
			bookEntryRepository.save(bookEntryEntity);
		}
	}

	@Override
	public void deleteEntry(int id) {
		bookEntryRepository.deleteById(id);
	}

	@Override
	public void updateEntry(BookEntryVO bookentry) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(bookentry.getId());
		if( bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setComments(bookentry.getComments());
			bookEntryRepository.save(bookEntryEntity);
		}
	}

	@Override
	public void addEntry(BookEntryVO bookentry) {
		BookEntry bookEntryEntity = new BookEntry();
		bookEntryEntity.setUserid(bookentry.getUserid());
		bookEntryEntity.setComments(bookentry.getComments());
		bookEntryRepository.save(bookEntryEntity);
	}

}
