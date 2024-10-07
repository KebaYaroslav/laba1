package org.example;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Створення категорій
        Category electronics = new Category(1, "Електроніка");
        Category smartphones = new Category(2, "Смартфони");
        Category accessories = new Category(3, "Аксесуари");
        // Створення об'єктів класу Product з вказівкою категорії
        Product product1 = new Product(1, "Ноутбук", 19999.99, "Високопродуктивний ноутбук для роботи та ігор", electronics);
        Product product2 = new Product(2, "Смартфон", 12999.50, "Смартфон з великим екраном…", smartphones);
        Product product3 = new Product(3, "Навушники", 2499.00, "Бездротові навушники з шумозаглушенням", accessories);

        List<Product> products = new ArrayList<>();
        products.add(product1);
        products.add(product2);
        products.add(product3);

        Scanner scanner = new Scanner(System.in);

        Cart cart = new Cart();
        ProductSearchService searchService = new ProductSearchService();

        System.out.println(GetTime.getCurrentDateTime());
        while (true) {
            System.out.println("\nВиберіть опцію:");
            System.out.println("1 - Переглянути список товарів");
            System.out.println("2 - Додати товар до кошика");
            System.out.println("3 - Переглянути кошик");
            System.out.println("4 - Зробити замовлення");
            System.out.println("5 - Видалити з кошика");
            System.out.println("6 - Історія кошика");
            System.out.println("7 - Пошук товарів за назвою");
            System.out.println("8 - Пошук товарів за категорією");
            System.out.println("0 - Вийти");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(product1);
                    System.out.println(product2);
                    System.out.println(product3);
                    break;
                case 2:
                    System.out.println("Введіть ID товару для додавання до кошика:");
                    int id = scanner.nextInt();
                    // Проста логіка додавання, для прикладу використаємо ID для вибору
                    if (id == 1) cart.addProduct(product1);
                    else if (id == 2) cart.addProduct(product2);
                    else if (id == 3) cart.addProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 3:
                    System.out.println(cart);
                    break;
                case 4:
                    if (cart.getProducts().isEmpty()) {
                        System.out.println("Кошик порожній. Додайте товари перед оформленням замовлення.");
                    } else {
                        Order order = new Order(cart);
                        cart.saveHistory(order); // Додавання до історії
                        System.out.println("Замовлення оформлено:");
                        System.out.println(order);
                        cart.clear(); // Очищення кошика
                    }
                    break;
                case 5:
                    System.out.println("Введіть ID товару для видалення з кошика:");
                    int id4remove = scanner.nextInt();
                    if (id4remove == 1) cart.removeProduct(product1);
                    else if (id4remove == 2) cart.removeProduct(product2);
                    else if (id4remove == 3) cart.removeProduct(product3);
                    else System.out.println("Товар з таким ID не знайдено");
                    break;
                case 6:
                    // Отримання історії покупок з об'єкта `Cart`
                    List<PurchaseHistory> purchaseRecords = cart.getPurchaseHistory().getHistory();

                    if (purchaseRecords.isEmpty()) {
                        System.out.println("Історія покупок порожня.");
                    } else {
                        System.out.println("Історія покупок:");
                        for (PurchaseHistory record : purchaseRecords) {
                            System.out.println(record); // Використовуємо `toString()` з `PurchaseHistory`
                            System.out.println("--------------");
                        }
                    }
                    break;
                case 7:
                    System.out.println("Введіть назву товару для пошуку:");
                    scanner.nextLine(); // Очистка буфера після `nextInt()`
                    String productName = scanner.nextLine();
                    List<Product> productsByName = searchService.searchProductsByName(products, productName);

                    if (productsByName.isEmpty()) {
                        System.out.println("Товар з такою назвою не знайдено.");
                    } else {
                        System.out.println("Знайдені товари:");
                        for (Product product : productsByName) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 8:
                    // Пошук за назвою категорії
                    System.out.println("Введіть назву категорії для пошуку:");
                    scanner.nextLine(); // Очистка буфера після `nextInt()`
                    String categoryName = scanner.nextLine();
                    List<Product> productsByCategoryName = searchService.searchProductsByCategoryName(products, categoryName);

                    if (productsByCategoryName.isEmpty()) {
                        System.out.println("Товари з такою категорією не знайдено.");
                    } else {
                        System.out.println("Знайдені товари:");
                        for (Product product : productsByCategoryName) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 0:
                    System.out.println("Дякуємо, що використовували наш магазин!");
                    return;
                default:
                    System.out.println("Невідома опція. Спробуйте ще раз.");
                    break;
            }
        }
    }
}