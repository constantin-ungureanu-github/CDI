package org.injection.services;

import javax.inject.Inject;

import org.injection.api.ISBN;
import org.injection.api.ISSN;
import org.injection.objects.Book;
import org.slf4j.Logger;

public class BookService {
    @Inject
    private Logger logger;

    @Inject
    @ISSN
    private String issn;

    @Inject
    @ISBN
    private String isbn;

    public Book createBook(String title) {
        Book book = new Book(title, issn, isbn);

        logger.info("{}", book);

        return book;
    }
}
