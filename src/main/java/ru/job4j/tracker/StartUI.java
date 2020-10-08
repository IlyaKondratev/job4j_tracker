package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {
    public static void main(String[] args) {
        Item request = new Item(1, "new request");
        LocalDateTime requestDateTime = request.getDateTime();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String requestDateTimeFormat = requestDateTime.format(formatter);
        System.out.println("Дата и время запроса: " + requestDateTimeFormat);
        System.out.println(request.toString());
    }
}
