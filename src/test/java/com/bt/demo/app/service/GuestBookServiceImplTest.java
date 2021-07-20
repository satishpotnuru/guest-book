package com.bt.demo.app.service;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.bt.demo.app.exception.BookEntryNotFoundException;
import com.bt.demo.app.model.User;
import com.bt.demo.app.repository.BookEntryRepository;
import com.bt.demo.app.repository.UserRepository;

@RunWith(MockitoJUnitRunner.class)
public class GuestBookServiceImplTest {
	
	 GuestBookService guestBookService;
	 
	 @Mock
	 BookEntryRepository bookEntryRepository;
	 
	 @Mock
	 UserRepository userRepository;
	 
	 
	 @Before
	 public void setup() {
		 guestBookService = new GuestBookServiceImpl(userRepository, bookEntryRepository);
	 }
	 
	 @Test
	 public void getUserTypeTest() {
		 User user = new User();
		 user.setType("A");
		 String userType = guestBookService.getUserType("test");
		 Mockito.when(userRepository.findByUsername(Mockito.any())).thenReturn(user);
		 assertEquals(userType, "A");
	 }
	 
	 @Test(expected = BookEntryNotFoundException.class)
	 public void getBookEntryTest() {
		 guestBookService.getBookEntry(12345L);
		 Mockito.when(bookEntryRepository.findById(12345L)).thenReturn(null);
	 }
}
