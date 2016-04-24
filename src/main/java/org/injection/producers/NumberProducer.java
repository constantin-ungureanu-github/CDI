package org.injection.producers;

import java.util.Random;

import javax.enterprise.inject.Produces;

import org.injection.api.Discount;
import org.injection.api.ISBN;
import org.injection.api.ISSN;
import org.injection.api.Vat;

public class NumberProducer {
    @Produces
    @Vat
    private Double vatRate = 0.2; // 20% VAT

    @Produces
    @Discount
    private Double discountRate = 0.5; // 50% discount

    @Produces
    @ISSN
    private String issn = String.format("%08d", Math.abs((new Random().nextLong()) % 100000000L));

    @Produces
    @ISBN
    private String isbn = String.format("%013d", Math.abs((new Random().nextLong()) % 10000000000000L));
}
