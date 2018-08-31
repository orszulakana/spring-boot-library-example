package com.orszulakana.springbootlibraryexample.repositories;

import com.orszulakana.springbootlibraryexample.models.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
