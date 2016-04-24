package org.injection;

import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;

import org.injection.objects.Book;
import org.injection.services.BookService;
import org.injection.services.OrderService;
import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

public class Main {
    public static void main(String[] args) {
        WeldContainer weldContainer = new Weld().initialize();
        BeanManager beanManager = weldContainer.getBeanManager();

        Bean<?> bookServiceBean = beanManager.resolve(beanManager.getBeans(BookService.class));
        Bean<?> orderServiceBean = beanManager.resolve(beanManager.getBeans(OrderService.class));

        BookService bookService = (BookService) beanManager.getReference(bookServiceBean, BookService.class,
                beanManager.createCreationalContext(bookServiceBean));
        OrderService orderService = (OrderService) beanManager.getReference(orderServiceBean, OrderService.class,
                beanManager.createCreationalContext(orderServiceBean));

        Book book = bookService.createBook("CDI");
        orderService.purchase(book, 100.0);

        weldContainer.shutdown();
    }
}
