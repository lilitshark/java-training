package adriannExercises;

import java.util.*;

public class ListStringProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(87, 1, 111, 0, 5, 10, -5, 12));

        List<Integer> list2 = new ArrayList();
        list2.addAll(Arrays.asList(0, 1, 2, 4, 5, 6, 7, 9, 12, 16, 20, 25, 32, 36));

        //Problem #1, 1b
        //findMinNoSorting(list);
        //findMaxNoSorting(list);
        System.out.println("Minimum element is: " + findMin(list));
        System.out.println("Maximum element is: " + findMax(list));

        //Problem #2
        reverseList(list);

        //Problem #3
        System.out.println(isElementPresent(list, 11));
        System.out.println(binarySearch(list, 5));
        System.out.println(isPresentWithListContains(list, 0));

        //Problem #4
        System.out.println(oddIndexElements(list));
        //Problem #5
        System.out.println(calculateRunningTotal(list));

        //Problem #6
        System.out.println("Please enter a text to check if it's a palindrome: ");
        String text = scanner.nextLine();
        if(isPalindrome(text))
            System.out.println("The text is a palindrome");
        else
            System.out.println("The text is not a palindrome");

        //Problem #7
        System.out.println("The sum of the list elements is " + calculateSumForLoop(list));
        System.out.println("The sum of the list elements is " + calculateSumWhileLoop(list));
        System.out.println("The sum of the list elements is " + calculateSumRecursion(list));

        //Problem #8
        printPerfectSquaresApplyingMethodOnElements();
        System.out.println();
        System.out.print("Perfect square numbers in the list are: ");
        printPerfectSquare(list2);

        scanner.close();
    }

    //1. Write a function that returns the largest element in a list.
    /**
     * Returns max element of list using sorting method if the list is not null or empty
     * @param list given to look for max element
     * @return the last element of sorted list(max element) if list is not null or empty, Integer.MIN_VALUE is it is
     */
    public static Integer findMax(List<Integer> list){
        if(!isEmpty(list)){
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            return (sortedList.get(sortedList.size() - 1));
        }
        else
            return Integer.MIN_VALUE;
    }

    /**
     * Returns max number in unsorted list if the list is not null or empty
     * Method first checks if the list is not empty or is not null; then finds the max of given list
     * @param list given to look for max element
     * @return the max element if the list is not null or empty, Integer.MIN_VALUE if it is
     */
    public static Integer findMaxNoSorting(List<Integer> list){
        int max;

        if(isEmpty(list))
            return Integer.MIN_VALUE;
        else
            max = list.get(0); //initializing max here, when checked that list is not empty or null

        for (int i = 0; i < list.size(); i++) {
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        return max;
    }

    //1b. Write a function that returns the minimum element in a list.
    /**
     * Returns min element of list using sorting method if the list is not null or empty
     * @param list given list to look for the min element
     * @return the first element of sorted list(min element) if list is not null or empty, Integer.MIN_VALUE is it is
     */
    public static Integer findMin(List<Integer> list){
        if(!isEmpty(list)){
            List<Integer> sortedList = new ArrayList<>(list);
            Collections.sort(sortedList);
            return sortedList.get(0);
        }
        else
            return Integer.MAX_VALUE;
    }

    /**
     * Returns min element in unsorted list if the list is not null or empty
     * @param list given list to look for the min element
     * @return the min element if the list is not null or empty, Integer.MIN_VALUE if it is
     */
    public static Integer findMinNoSorting(List<Integer> list){
        int min;
        if(isEmpty(list))
            return Integer.MAX_VALUE;
        else
            min = list.get(0); //initializing max here, when checked that list is not empty or null

        for (Integer numbers : list) {
            if(min > numbers)
                min = numbers;
        }
        return min;
    }

    /**
     * Checks if the collection is null or empty
     * @param collection given collection to check
     * @return true if the collection is empty or null, false if not.
     */
    public static boolean isEmpty(Collection collection){
        return (collection == null || collection.size() == 0);
    }

    //2. Write function that reverses a list, preferably in place.
    /**
     * Reverses values of the list in the same list
     * @param list given list to reverse values
     */
    public static void reverseList(List<Integer> list){
        int tmpValue;
        int size = list.size();

        for (int i = 0; i < size/2; i++) {
            tmpValue = list.get(i);
            list.set(i, list.get((size-1) -i));
            list.set(size-1-i, tmpValue);
        }
        System.out.println(list);
    }
    //3. Write a function that checks whether an element occurs in a list.

    /**
     * Checks if given list is not empty and then checks if the element is present using linear search
     * Time complexity = O(n)
     * @param list list to look for the element
     * @param elementToCheck element to check if exists in the list
     * @return true if the element exists, false if not present or the given list is empty or null
     */
    public static boolean isElementPresent(List<Integer> list, int elementToCheck){
        boolean isPresent = false;

        if(isEmpty(list))
            isPresent = false;

        for (Integer number:list) {
            if(number == elementToCheck) {
                isPresent = true;
                break;
            }
        }
        //System.out.println("Is " + elementToCheck + " present in the list: " + isPresent);
        return isPresent;
    }

    /**
     * Checks if the given element is present in the given list using binary search
     * Time complexity = O(lob2N)
     * @param list list to look for the element
     * @param elementToCheck element to check if exists in the list
     * @return true if the element exists, false if not
     */
    public static boolean binarySearch(List<Integer> list, int elementToCheck){
        List<Integer> sortedList = new ArrayList<>(list);
        Collections.sort(sortedList);

        int index = Collections.binarySearch(sortedList, elementToCheck); //if index=-1 the element doesn't exist in the list

        if(index >= 0)
            return true;
        else
            return false;
    }

    /**
     * Checks if the given element is present in the given list using contains() method of a list
     * @param list list to look for the element
     * @param elementToCheck element to check if exists in the list
     * @return true if the element exists, false if not
     */
    public static boolean isPresentWithListContains(List<Integer> list, int elementToCheck){
        return list.contains(elementToCheck);
    }

    //4. Write a function that returns the elements on odd positions in a list.
    /**
     * Returns elements on odd position as a new list
     * @param list to look for elements on odd index
     * @return a new list with elements on odd indexes of the list
     */
    public static List oddIndexElements(List<Integer> list) {
        List<Integer> oddIndexElements = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            if(i%2 != 0)
                oddIndexElements.add(list.get(i));
        }
        return oddIndexElements;
    }

    //5. Write a function that computes the running total of a list
    /**
     * Calculates, prints and returns the running total of the given list
     * @param list given list to calculate running total
     * @return running total as a new list
     */
    static List calculateRunningTotal(List<Integer> list){
        List<Integer> runningTotal = new ArrayList<>();
        int total = 0;

        for (int i = 0; i < list.size(); i++) {
            total += list.get(i);
            runningTotal.add(total);
            System.out.println("Running total is: " + total);
        }

        return runningTotal;
    }

    //6. Write a function that tests whether a string is a palindrome.
    /**
     * Checks if the string is a palindrome or not
     * @param text given string to check
     * @return true if the given string is a palindrome, false if not
     */
    public static boolean isPalindrome(String text){
        int textLength = text.length();

        for (int i = 0; i < textLength/2; i++) {
            if(text.charAt(i) != text.charAt(textLength -1 - i))
                return false;
        }
        return true;
    }

    //7. Write three functions that compute the sum of the numbers in a list: using a for-loop, a while-loop and recursion.

    /**
     * Calculates the sum of list elements using 'for' loop
     * @param list given list to calculate sum
     * @return sum of given list elements
     */
    public static int calculateSumForLoop(List<Integer> list){
        int sum = 0;
        for (Integer number:list) {
            sum+=number;
        }
        return sum;
    }

    /**
     * Calculates the sum of list elements using 'while' loop
     * @param list given list to calculate sum
     * @return sum of given list elements
     */
    public static int calculateSumWhileLoop(List<Integer> list){
        int index = 0;
        int sum = 0;

        while(index < list.size()) {
            sum = list.get(index) + sum;
            index++;
        }
        return sum;
    }

    /**
     * Calculates the sum of list elements using recursion
     * @param list given list to calculate sum
     * @return sum of given list elements
     */
    public static int calculateSumRecursion(List<Integer> list){
        int size = list.size();

        switch (size){
            case 0:
                return 0;
            case 1:
                return list.get(0);
            default:
                return list.get(0) + calculateSumRecursion(list.subList(1, size));
                //another option to divide the list in 2 and call calculateSumRecursion for each part of list
        }
    }

    //8. Write a function on_all that applies a function to every element of a list. Use it to print the first
    // twenty perfect squares. The perfect squares can be found by multiplying each natural number with itself.
    // The first few perfect squares are 1*1= 1, 2*2=4, 3*3=9, 4*4=16. Twelve for example is not a perfect square
    // because there is no natural number m so that m*m=12.
    /**
     * Prints first perfect square numbers maxCountToPrint times.
     * Applies calculateSquare() method on every item of the list
     */
    public static void printPerfectSquaresApplyingMethodOnElements(){
        int maxCountToPrint = 20;
        System.out.print("Printing first " + maxCountToPrint + " perfect square numbers: ");

        for (int i = 1; i <= maxCountToPrint; i++) {
            System.out.print(calculateSquare(i) + " ");
        }
    }

    /**
     * Calculates square of a number
     * @param number given number to calculate square
     * @return square of the given number
     */
    static int calculateSquare(int number){
        return number * number;
    }

    /**
     * Prints perfect square numbers of the list
     * @param list given list to check for perfect square number
     */
    static void printPerfectSquare(List<Integer> list){
        for (Integer number:list) {
            if(isPerfectSquare(number) && number > 0)
                System.out.print(number + " ");
        }
    }

    /**
     * Checks if the given number is a perfect square number or not.
     * Method checks if the square root of the given number is equal to the square of the result.
     * This also means that the square root of the number is a whole number (integer).
     * @param number given number to check
     * @return true if number is perfect square number, false if not
     */
    public static boolean isPerfectSquare(int number){
        int n = (int)Math.sqrt(number);
        return n*n == number;
    }
}
