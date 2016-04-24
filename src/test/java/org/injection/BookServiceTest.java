package org.injection;

import static org.junit.Assert.assertEquals;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.injection.objects.Book;
import org.injection.services.BookService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BookServiceTest {
    private WeldContainer weldContainer;
    private BookService bookService;

    @Before
    public void initBeanManager() {
        weldContainer = new Weld().initialize();

        final BeanManager beanManager = weldContainer.getBeanManager();
        final Bean<?> bookServiceBean = beanManager.resolve(beanManager.getBeans(BookService.class));

        bookService = (BookService) beanManager.getReference(bookServiceBean, BookService.class, beanManager.createCreationalContext(bookServiceBean));
    }

    @After
    public void closeBeanManager() {
        weldContainer.shutdown();
    }

    @Test
    public void testCreateBook() {
        Book book = bookService.createBook("CDI");
        assertEquals(8, book.getIssn().length());
        assertEquals(13, book.getIsbn().length());
    }
}
