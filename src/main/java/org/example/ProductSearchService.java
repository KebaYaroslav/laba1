package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductSearchService {

    // Метод для пошуку товарів за назвою
    public List<Product> searchProductsByName(List<Product> products, String name) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            if (product.getName().equalsIgnoreCase(name.trim())) { // Ігноруємо регістр та пробіли
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }

    // Метод для пошуку товарів за назвою категорії
    public List<Product> searchProductsByCategoryName(List<Product> products, String categoryName) {
        List<Product> foundProducts = new ArrayList<>();
        for (Product product : products) {
            // Порівняння назви категорії з введеною користувачем назвою (незалежно від регістру)
            if (product.getCategory().getName().equalsIgnoreCase(categoryName.trim())) {
                foundProducts.add(product);
            }
        }
        return foundProducts;
    }
}


