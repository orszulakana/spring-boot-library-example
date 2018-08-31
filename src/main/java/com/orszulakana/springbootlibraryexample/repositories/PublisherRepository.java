package com.orszulakana.springbootlibraryexample.repositories;

import com.orszulakana.springbootlibraryexample.models.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
