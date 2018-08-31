package com.orszulakana.springbootlibraryexample.repositories;

import com.orszulakana.springbootlibraryexample.models.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
