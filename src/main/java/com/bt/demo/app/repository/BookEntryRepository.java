package com.bt.demo.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bt.demo.app.model.BookEntry;

@Repository
public interface BookEntryRepository extends JpaRepository<BookEntry, Long> {

}
