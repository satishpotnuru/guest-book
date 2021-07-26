package com.bt.demo.app.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.bt.demo.app.constants.Constants;
import com.bt.demo.app.exception.BookEntryNotFoundException;
import com.bt.demo.app.exception.FileStorageException;
import com.bt.demo.app.model.BookEntry;
import com.bt.demo.app.model.BookEntryDTO;
import com.bt.demo.app.model.User;
import com.bt.demo.app.model.UserDTO;
import com.bt.demo.app.repository.BookEntryRepository;
import com.bt.demo.app.repository.UserRepository;

@Component
public class GuestBookServiceImpl implements GuestBookService {

	private UserRepository userRepository;
	private BookEntryRepository bookEntryRepository;

	public GuestBookServiceImpl(UserRepository userRepository, BookEntryRepository bookEntryRepository) {
		this.userRepository = userRepository;
		this.bookEntryRepository = bookEntryRepository;
	}

	@Override
	public List<BookEntry> getAllEntries() {
		return bookEntryRepository.findAll();
	}

	@Override
	public void approveBookEntry(long id) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(id);
		if (bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setStatus(Constants.APPROVED);
			bookEntryRepository.save(bookEntryEntity);
		}
	}

	@Override
	public void deleteBookEntry(long id) {
		bookEntryRepository.deleteById(id);
	}

	@Override
	public void updateBookEntry(BookEntryDTO bookentry) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(bookentry.getId());
		if (bookEntryOpt.isPresent()) {
			BookEntry bookEntryEntity = bookEntryOpt.get();
			bookEntryEntity.setComments(bookentry.getComments());
			bookEntryRepository.save(bookEntryEntity);
		}
	}

	@Override
	public void addBookEntry(BookEntryDTO bookentry) {
		BookEntry bookEntryEntity = new BookEntry();
		bookEntryEntity.setUsername(bookentry.getUsername());
		bookEntryEntity.setComments(bookentry.getComments());
		bookEntryEntity.setStatus(Constants.PENDING);
		bookEntryRepository.save(bookEntryEntity);
	}

	@Override
	public BookEntry getBookEntry(long id) {
		Optional<BookEntry> bookEntryOpt = bookEntryRepository.findById(id);
		if (bookEntryOpt.isPresent()) {
			return bookEntryOpt.get();
		} else {
			throw new BookEntryNotFoundException("Entry not found");
		}
	}

	@Override
	public String getUserRole(UserDTO user) {
		if (user != null) {
			User userDb = userRepository.findUser(user.getUsername(), user.getPassword());
			return userDb != null ? userDb.getRole() : "Invalid User";
		} else
			return null;
	}

	@Override
	public BookEntry uploadFile(MultipartFile file) {
		BookEntry bookEntryEntity = new BookEntry();
		try {
			String fileName = StringUtils.cleanPath(file.getOriginalFilename());
			bookEntryEntity.setFilename(fileName);
			bookEntryEntity.setFiledata(file.getBytes());
			bookEntryEntity.setFiletype(file.getContentType());
			bookEntryEntity.setStatus(Constants.PENDING);
			bookEntryRepository.save(bookEntryEntity);
		} catch (IOException ex) {
			throw new FileStorageException("File storing failed", ex);
		}
		return bookEntryEntity;
	}

};