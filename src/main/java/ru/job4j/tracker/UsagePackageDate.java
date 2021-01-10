package ru.job4j.tracker;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class UsagePackageDate {

    public static void main(String[] args) {
        LocalDate currentDate = LocalDate.now();
        LocalTime currentTime = LocalTime.now();
        LocalDateTime currentDateAndTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        String currentDateTimeFormat = currentDateAndTime.format(formatter);
        System.out.println("Current date: " + currentTime);
        System.out.println("Current time: " + currentDate);
        System.out.println("Current date & time : " + currentDateTimeFormat);

    }
}
