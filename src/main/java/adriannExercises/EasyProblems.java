package adriannExercises;

import java.util.*;

/* In this class I will be practicing Elementary programming problems from following url:
https://adriann.github.io/programming_problems.html
* */
public class EasyProblems {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        int number = askUserForNumber(scanner);
        printSum(number); //Problem #4
        printSumOfMultiplies(number);  //Problem #5

        int answer = askUserForComputingOperation(scanner);
        if(answer == 0){  //Problem #6
            printSum(number);
        }
        else
            printProduct(number);

        int tableSize = askUserForNumber(scanner);
        printMultiplicationTable(tableSize);  //Problem #7

        printPrimeNumbers(100);  //Problem #8


        // Problem #9
        int upperBound = 25;
        int secretNumber = random.nextInt(upperBound);
        int userGuessNumber;

        Set userGuess = new HashSet();

        do{
            userGuessNumber = askUserToGuessNumber(scanner);
            userGuess.add(userGuessNumber);
            checkSecretNumber(secretNumber, userGuessNumber);
        } while (secretNumber!=userGuessNumber);

        System.out.println("User entered " + userGuess.size() + " unique numbers");

        //Problem #10
        printNextLeapYears(3);

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

    //8. Write a program that prints all prime numbers. (Note: if your programming language does not support
    // arbitrary size numbers, printing all primes up to the largest number you can easily represent is fine too.)

    /**
     * Checks if given number is prime
     * @param number given number
     * @return true if Prime, false if not
     */
    public static boolean isPrime(int number){
        if(number <= 1) //validate corner case
            return false;

        for (int i = 2; i < number; i++) {
            if(number%i == 0)
                return false;
        }
        return true; //if the program gets here, than the number is Prime.
    }

    /**
     * Prints prime numbers
     * @param limit up to given limit, not included
     */
    public static void printPrimeNumbers(int limit){
        List primeNumbers = new ArrayList<>();

        for (int i = 2; i < limit; i++) {
            if(isPrime(i)) {
                primeNumbers.add(i); //adds to ArrayList collection
                //System.out.print(i + " "); //prints prime numbers
            }
        }

        Iterator i = primeNumbers.iterator();
        while(i.hasNext())
            System.out.print(i.next() + " "); //prints prime numbers of the ArrayList
    }

    //9. Write a guessing game where the user has to guess a secret number. After every guess the program tells
    // the user whether their number was too large or too small. At the end the number of tries needed should be printed.
    // It counts only as one try if they input the same number multiple times consecutively.

    static int askUserToGuessNumber(Scanner scanner){
        System.out.println("Please enter a number");
        return scanner.nextInt();
    }

    static void checkSecretNumber(int secretNumber, int userGuessNumber){
        if(secretNumber == userGuessNumber){
            System.out.println("You guessed the secret number!!");
        }
        if(secretNumber > userGuessNumber)
            System.out.println("Secret number is greater than " + userGuessNumber);
        else
            System.out.println("Secret number is less than " + userGuessNumber);
    }

    static void printUserGuess(LinkedList userGuess){
        System.out.print("User guesses are: ");
        userGuess.forEach((n -> System.out.print(n + " ")));
    }

    /*
    //This part of the code asks the user if they want to play again and quits the game if not, this might be used later
    static boolean playAgain(Scanner scanner){
        boolean again;

        System.out.println("Do you want to play again? True / False");
        again = scanner.nextBoolean();

        return again;
    }

    static boolean askIfPlayAgain(Scanner scanner){
        String answer = "";
        boolean again = false;

        do{
            System.out.println("Do you want to play again? Yes / No");
            answer = scanner.nextLine();
            if(answer.equalsIgnoreCase("yes")) {
                again = true;
                break;
            }
            else
                again = false;
        }while (!answer.equalsIgnoreCase("yes") && !answer.equalsIgnoreCase("no"));

        return again;
    }*/

    //10. Write a program that prints the next 20 leap years.

    /**
     * This method will check if the year is leap or not
     * @param year given the year to be checked
     * @return true if the year is leap, false if not
     */
    public static boolean isLeapYear(int year){
        if(year%4 == 0 && year%100 != 0 || year%400 == 0) {
            return true;
        }
        return false;
    }

    /**
     * This method prints next N leap years
     * @param leapYearCount given next leap years to print
     */
    public static void printNextLeapYears(int leapYearCount){
        int startYear = 2017;
        int count = 0;

        while(count < leapYearCount){
            if(isLeapYear(startYear)) {
                System.out.print(startYear + " ");
                count++;
                System.out.println(count);
            }
            startYear++;
        }

     /* second solution
        for (int i = startYear; i < startYear + leapYearCount*4; i++) {
            if(isLeapYear(i)){
                System.out.print(i + " ");
            }
            else continue;
        }*/
    }
}
