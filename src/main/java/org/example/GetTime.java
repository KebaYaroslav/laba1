package org.example;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GetTime {
        public static String getCurrentDateTime() {
                LocalDateTime now = LocalDateTime.now(); // Отримання поточного часу
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); // Форматування
                return now.format(formatter); // Повернення форматованого рядка
        }
}
