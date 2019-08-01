package com.example.spring5webapp.bootstrap;

import com.example.spring5webapp.model.Author;
import com.example.spring5webapp.model.Book;
import com.example.spring5webapp.model.Publisher;
import com.example.spring5webapp.repositories.AuthorRepository;
import com.example.spring5webapp.repositories.BookRepository;
import com.example.spring5webapp.repositories.PublisherRepository;
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
        Publisher publisher = new Publisher("Izdavac", "Adresa");
        publisherRepository.save(publisher);

        //Eric
        Author eric = new Author("Eric", "Evans");
        Book k1 = new Book("Knjiga1", "1111", publisher);
        eric.getBooks().add(k1);
        k1.getAuthors().add(eric);

        authorRepository.save(eric);
        bookRepository.save(k1);

        //Rob
        Author rob = new Author("Rob", "Jons");
        Book k2 = new Book("Knjiga2", "2222", publisher);
        rob.getBooks().add(k2);
        Publisher publisher2 = new Publisher("Izdavac2", "adresa2");

        authorRepository.save(rob);
        bookRepository.save(k2);
    }
}
