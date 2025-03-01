package Huy;

import java.util.Arrays;
import java.util.Scanner;

public class bai65 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        double[] array = new double[size];
        System.out.println("Enter " + size + " elements for the array:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextDouble();
        }
        Arrays.sort(array);
        double sum = 0;
        for (double num : array) {
            sum += num;
        }
        double average = sum / size;
        System.out.println("\nSorted Array: " + Arrays.toString(array));
        System.out.println("Sum: " + sum);
        System.out.println("Average: " + average);
        scanner.close();
    }
}
