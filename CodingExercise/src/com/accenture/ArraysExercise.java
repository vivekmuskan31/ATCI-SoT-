package com.accenture;

public class ArraysExercise {
    public static void main(){
        int n = 15; // size
        int[] myArray = new int[n]; // array
        long sum = 0;   // sum
        double avg = 0; // average
        for (int i = 0; i < n; i++) {
            myArray[i] = 1 << i;    // doubling each element
            sum += myArray[i];  // computing sum
        }
        avg = ((double)sum)/n; // computing average

        System.out.println("Sum = "+ sum + "\tAverage = "+ avg);
    }
}
