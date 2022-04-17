package com;

import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {
    /**
     * Task 1
     * Определить среднюю стоимость товаров и товар с
     * минимальной стоимостью
     * Task 2
     * Вывести сведения о товарах, срок годности которых менее
     * 20-ти дней. Определить количество просроченных товаров.
     */
    public static void main(String[] args) {
        int counter = 0;
        System.out.println("Task1");
        double smallest;
        CalculatorOne objectOne = new CalculatorOne("Pencil", 28, 1.98, "AProject", "May 19, 2015");
        CalculatorOne objectTwo = new CalculatorOne("Pen", 15, 1.88, "BProject", "April 17, 2012");
        CalculatorOne objectThree = new CalculatorOne("Line", 25, 1.49, "CProject", "October 26, 2007");
        System.out.println("Average value: " + ((objectOne.price + objectTwo.price + objectThree.price) / CalculatorOne.getNumberObject()));
        smallest = (objectOne.price < objectTwo.price) ? ((objectOne.price < objectThree.price) ? objectOne.price : objectThree.price) : ((objectTwo.price < objectThree.price) ? objectTwo.price : objectThree.price);
        System.out.println("minimum cost: " + smallest);
        /*--------2---------*/
        System.out.println("Task2");
        GregorianCalendar Now = new GregorianCalendar(2022, Calendar.APRIL, 17);
        CalculatorTwo objectfour = new CalculatorTwo("Pencil", 28, 1.98, "AProject", new GregorianCalendar(2022, Calendar.APRIL, 27), new GregorianCalendar(2021, Calendar.APRIL, 27));
        CalculatorTwo objectfive = new CalculatorTwo("Pencil", 28, 1.98, "AProject", new GregorianCalendar(2023, Calendar.JANUARY, 23), new GregorianCalendar(2021, Calendar.FEBRUARY, 25));
        java.util.Date utilDate = Now.getTime();
        java.util.Date utilDate2 = objectfour.expirationDate.getTime();
        long DayToExpiration = (utilDate2.getTime() - utilDate.getTime()) / (1000 * 60 * 60 * 24);
        java.util.Date utilDate3 = objectfive.expirationDate.getTime();
        long DayToExpiration2 = (utilDate3.getTime() - utilDate.getTime()) / (1000 * 60 * 60 * 24);
        if ((DayToExpiration == 0))
            System.out.println("Last Day");
        else if (DayToExpiration < 20) {
            System.out.println("Name: " + objectfour.name);
            System.out.println("Number: " + objectfour.number);
            System.out.println("price: " + objectfour.price);
            System.out.println("Manufacturer: " + objectfour.manufacturer);
            System.out.println(DayToExpiration + " remain day");
        } else {
            counter++;
        }
        if ((DayToExpiration2 == 0))
            System.out.println("Last Day");
        else if (DayToExpiration2 < 20) {
            System.out.println("Name: " + objectfive.name);
            System.out.println("Number: " + objectfive.number);
            System.out.println("price: " + objectfive.price);
            System.out.println("Manufacturer: " + objectfive.manufacturer);
            System.out.println(DayToExpiration + " remain day");
        } else {
            counter++;
        }

        System.out.println("overdue " + counter);
    }


}

/**
 * Наименование
 * Количество
 * Цена
 * Производитель
 * Дата выпуска
 */
class CalculatorOne {
    private static int Count = 0;
    String name, manufacturer, date;
    int number;
    double price;


    public CalculatorOne(String name, int number, double price, String manufacturer, String date) {
        this.Count++;
        this.name = name;
        this.number = number;
        this.price = price;
        this.manufacturer = manufacturer;
        this.date = date;
    }

    public static int getNumberObject() {
        return Count;
    }

    public CalculatorOne(String pencil, int i, double v, String aProject, GregorianCalendar gregorianCalendar, GregorianCalendar calendar) {
    }
}

/**
 * Наименование
 * Цена
 * Дата производства
 * Срок годности
 * Количество
 * Производитель
 */
class CalculatorTwo {
    private static int Count = 0;
    String name, manufacturer;
    int number;
    double price;
    Calendar data;
    Calendar expirationDate;

    public CalculatorTwo(String name, int number, double price, String manufacturer, Calendar expirationDate, Calendar data) {
        this.Count++;
        this.name = name;
        this.number = number;
        this.price = price;
        this.manufacturer = manufacturer;
        this.expirationDate = expirationDate;
        this.data = data;
    }

    public static int getNumberObject() {
        return Count;
    }


    public CalculatorTwo() {
    }


}

