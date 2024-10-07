package org.example;

import lombok.Getter;
import lombok.ToString;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@ToString
@NoArgsConstructor
public class History {
    private List<PurchaseHistory> history = new ArrayList<>(); // Масив для зберігання історії покупок

    // Метод для додавання нового запису про покупку
    public void addRecord(Order order) {
        history.add(new PurchaseHistory(order, GetTime.getCurrentDateTime()));
    }

    // Метод для отримання всієї історії
    public List<PurchaseHistory> getHistory() {
        return new ArrayList<>(history); // Повертаємо копію списку історії
    }
}

