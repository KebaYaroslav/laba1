package org.example;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor

public class Category {
    // Геттери та сеттери - lombok
    private int id; // Унікальний ідентифікатор категорії
    private String name; // Назва категорії
    // Конструктор класу - lombok

    public String toString() {
        return "Категорія{" +
                "id=" + id +
                ", назва='" + name + '\'' +
                '}';
    }


}
