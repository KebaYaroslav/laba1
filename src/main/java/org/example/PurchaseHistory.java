package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public class PurchaseHistory {
    private Order order; // Замовлення
    private String purchaseDate; // Дата покупки
}
