package org.example;

import lombok.Getter;
import lombok.Setter;

import lombok.AllArgsConstructor;


@Setter
@Getter
@AllArgsConstructor

public class Product {
    //інші методи...
    private int id; // Унікальний ідентифікатор товару
    private String name; // Назва товару
    private double price; // Ціна товару
    private String description; // Опис товару
    private Category category; // Додано поле для зберігання категорії

    @Override
    public String toString() {
        return "Товар{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                ", ціна=" + price +
                ", опис='" + description + '\'' +
                '}';
    }

}


