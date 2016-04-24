package org.injection.services;

import javax.inject.Inject;

import org.injection.api.Discount;
import org.injection.api.Vat;
import org.injection.objects.Order;
import org.slf4j.Logger;

public class OrderService {
    @Inject
    private Logger logger;

    @Inject
    @Vat
    private Double vatRate;

    @Inject
    @Discount
    private Double discountRate;

    public Order purchase(Object object, Double subTotal) {
        Order order = executeOrder(subTotal);

        logger.info("{} for {}", order, object);

        return order;
    }

    public Order purchase(Double subTotal) {
        Order order = executeOrder(subTotal);

        logger.info("New order: {}", order);

        return order;
    }

    private Order executeOrder(Double subTotal) {
        Order order = new Order(subTotal * (1 + vatRate - discountRate), subTotal, vatRate, discountRate);

        return order;
    }
}
