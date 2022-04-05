package com.accenture.shopping.project;

import java.time.LocalTime;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        LocalTime startTime = LocalTime.parse("08:15:00");
        LocalTime endTime = LocalTime.parse("17:30:00");
        Customer myCustomer = new Customer("Michale");
        Cashier myCashier = new Cashier("John", startTime, endTime);

        Store myStore = new Store(myCustomer, myCashier);
        myStore.shop();
    }
}
