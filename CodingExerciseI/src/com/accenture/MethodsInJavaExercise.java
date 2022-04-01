package com.accenture;

import java.util.ArrayList;
import java.util.Scanner;

public class MethodsInJavaExercise {

    public static ArrayList<Integer> getOddValues(ArrayList<Integer> myArray){
        ArrayList<Integer> oddIntegers = new ArrayList<Integer>();
        for(int x: myArray){
            if(x%2 != 0) oddIntegers.add(x);
        }
        return oddIntegers;
    }

    public static void displayOddValues(ArrayList<Integer> myArray){
        System.out.print("Odd value(s) : [ ");
        for(int i=0;i< myArray.size()-1;i++){
            System.out.print(myArray.get(i)+", ");
        }
        if(!myArray.isEmpty())System.out.print(myArray.get(myArray.size()-1));
        System.out.println(" ]");
    }

    public static void main(){
        ArrayList<Integer> myArray = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);

        System.out.println("Please input 5 integer values : ");
        for(int i=0;i<5;i++) myArray.add(sc.nextInt());

        ArrayList<Integer> oddIntegers = getOddValues(myArray);
        displayOddValues(oddIntegers);
    }
}
