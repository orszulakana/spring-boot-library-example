package com.orszulakana.springbootlibraryexample.bootstrap;

import com.orszulakana.springbootlibraryexample.models.Author;
import com.orszulakana.springbootlibraryexample.models.Book;
import com.orszulakana.springbootlibraryexample.models.Publisher;
import com.orszulakana.springbootlibraryexample.repositories.AuthorRepository;
import com.orszulakana.springbootlibraryexample.repositories.BookRepository;
import com.orszulakana.springbootlibraryexample.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData() {
        Publisher publisher = new Publisher();
        publisher.setName("Helion");
        publisher.setAddress("Warsaw");
        publisherRepository.save(publisher);

        Author williamFaulkner = new Author("William", "Faulkner");
        Book theSoundAndTheFury = new Book("The Sound and the Fury", "2356", publisher);
        williamFaulkner.getBooks().add(theSoundAndTheFury);
        theSoundAndTheFury.getAuthors().add(williamFaulkner);

        authorRepository.save(williamFaulkner);
        bookRepository.save(theSoundAndTheFury);

        Author aldousHuxley = new Author("Aldous", "Huxley");
        Book braveNewWorld = new Book("Brave New World", "1234", publisher);
        aldousHuxley.getBooks().add(braveNewWorld);
        braveNewWorld.getAuthors().add(aldousHuxley);

        authorRepository.save(aldousHuxley);
        bookRepository.save(braveNewWorld);
    }

}
