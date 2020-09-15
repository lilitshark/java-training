package arrays;

import java.util.Scanner;

/* In this class I will be practicing Elementary programming problems from following url:
https://adriann.github.io/programming_problems.html
* */
public class EasyProblemsAdriann {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = askUserForNumber(scanner);
        printSum(number);
        printSumOfMultiplies(number);

        int answer = askUserForComputingOperation(scanner);
        if(answer == 0){
            printSum(number);
        }
        else
            printProduct(number);

        int tableSize = askUserForNumber(scanner);
        printMultiplicationTable(tableSize);

        scanner.close();
    }

    public static int askUserForNumber(Scanner scanner){
        int number;
        do{
            System.out.println("Please enter an integer number greater than 1");
            number = scanner.nextInt();
        } while(number <= 1);

        return number;
    }

    //4.Write a program that asks the user for a number n and prints the sum of the numbers 1 to n
    public static void printSum(int number){
        int sum = 0;
        for (int i = 1; i <= number; i++) {
                sum+= i;
        }
        System.out.println("Sum of numbers from 1 to " + number + " is " + sum);
    }

    //5. Modify the previous program such that only multiples of three or five are considered in the sum,
    // e.g. 3, 5, 6, 9, 10, 12, 15 for n=17
    public static void printSumOfMultiplies(int number){
        int sum = 0;
        for (int i = 1; i < number; i++) {
            if(isMultiply(i))
                sum+= i;
            else
                continue;
        }
        System.out.println("Sum of numbers from 1 to " + number + " is " + sum);
    }
    public static boolean isMultiply(int number){
        if (number%3 == 0 || number%5 == 0)
            return true;

        return false;
    }

    //6. Write a program that asks the user for a number n and gives them the possibility to choose between
    // computing the sum and computing the product of 1,…,n.
    public static int askUserForComputingOperation(Scanner scanner){
        int operation;

        do{
            System.out.println("Enter 0 if you want to calculate the Sum and 1 if the Product of numbers.");
            operation = scanner.nextInt();
        } while (operation != 0 && operation != 1); // true

        return operation;
    }

    public static void printProduct(int number){
        int product = 1;
        for (int i = 1; i <=number ; i++) {
            product *= i;
        }
        System.out.println("The Product of numbers from 1 to " + number + " is " + product);
    }

    //7. Write a program that prints a multiplication table for numbers up to 12.
    public static void printMultiplicationTable(int tableSize){

        System.out.print("      "); //prints space for vertical number allocation space
        for (int i = 1; i <= tableSize; i++) {
            System.out.format("%3d | ", i);
        }
        System.out.println(); //prints new line after table horizontal header

        for (int i = 1; i <= tableSize; i++) {
            System.out.format("%3d | ", i); // prints the vertical axis of the table

            for (int j = 1; j <= tableSize; j++) {
                System.out.format("%3d | ", i*j); // prints product of numbers
            }
            System.out.println(); //prints new line for each line starting from 2nd
        }
    }
}
