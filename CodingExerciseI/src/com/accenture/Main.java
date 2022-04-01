package com.accenture;

import mybank.AccountMain;
import mycontribution.ContributorMain;
import myexception.EmployeeMain;

public class Main {

    public static void main(String[] args) {
        System.out.println("Results of each coding Exercise is given below.");
        System.out.println("----------------------------------------------------");

        // Arrays Exercise
        System.out.println("CODING EXERCISE 1 : ArraysExercise\n");
        ArraysExercise.main();
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 2 : MethodsInJavaExercise\n");
        MethodsInJavaExercise.main();
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 3 : Employee\n");
        Employee.main();
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 4 : AccountMain\n");
        AccountMain.main(4);
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 5 : AccountMain (Privileged)\n");
        AccountMain.main(5);
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 6 : ContributorMain\n");
        ContributorMain.main();
        System.out.println("----------------------------------------------------");

        System.out.println("CODING EXERCISE 7 : InvalidUserDetailException\n");
        EmployeeMain.main();
        System.out.println("----------------------------------------------------");
    }
}
