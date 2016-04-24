package org.injection.objects;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@ToString
public class Order {
    @Getter
    @Setter
    private Double total;

    @Getter
    @Setter
    private Double subTotal;

    @Getter
    @Setter
    private Double vatRate;

    @Getter
    @Setter
    private Double discountRate;
}
