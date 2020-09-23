package adriannExercises;

import java.util.*;
import java.util.stream.Stream;

public class ListStringProblems {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list1 = new ArrayList();
        list1.addAll(Arrays.asList(87, 1, 111, 0, 5, 10, -5, 12));

        List<Integer> list2 = new ArrayList();
        list2.addAll(Arrays.asList(0, 1, 2, 4, 5, 6, 7, 9, 12, 16, 20, 25, 32, 36));

        List<String> list3 = new ArrayList();
        list3.addAll(Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h"));

        //Problem #1, 1b
        //findMinNoSorting(list1);
        //findMaxNoSorting(list1);
        System.out.println("Minimum element is: " + findMin(list1));
        System.out.println("Maximum element is: " + findMax(list1));

        //Problem #2
        reverseList(list1);

        //Problem #3
        System.out.println(isElementPresent(list1, 11));
        System.out.println(binarySearch(list1, 5));
        System.out.println(isPresentWithListContains(list1, 0));

        //Problem #4
        System.out.println(oddIndexElements(list1));
        //Problem #5
        System.out.println(calculateRunningTotal(list1));

        //Problem #6
        System.out.println("Please enter a text to check if it's a palindrome: ");
        String text = scanner.nextLine();
        if(isPalindrome(text))
            System.out.println("The text is a palindrome");
        else
            System.out.println("The text is not a palindrome");

        //Problem #7
        System.out.println("The sum of the list1 elements is " + calculateSumForLoop(list1));
        System.out.println("The sum of the list1 elements is " + calculateSumWhileLoop(list1));
        System.out.println("The sum of the list1 elements is " + calculateSumRecursion(list1));

        //Problem #8
        printPerfectSquaresApplyingMethodOnElements();
        System.out.println();
        System.out.print("Perfect square numbers in the list1 are: ");
        printPerfectSquare(list2);

        //Problem #9
        System.out.println(concatLists(list1, list2));

        //Problem #10
        System.out.println(combineLists(list2, list3));
        //Problem #11
        System.out.println(mergeSortedLists(list1, list2));

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

    //9. Write a function that concatenates two lists. [a,b,c], [1,2,3] → [a,b,c,1,2,3]
    /**
     * Program concatenates two lists
     * @param list1 given list to concatenate
     * @param list2 given list to concatenate
     * @return a new list as concatenation of list1 and list2
     */
    static List concatLists(List list1, List list2){
        List newList = new ArrayList();
        newList.addAll(list1);
        newList.addAll(list2);
        return newList;
    }

    //10. Write a function that combines two lists by alternatingly taking elements, e.g. [a,b,c], [1,2,3] → [a,1,b,2,c,3].
    /**
     * Program combines two lists with sequential order, 1 element from each list. The program checks for 3 cases,
     * if the given list sizes are equal, greater or less than the other and combines lists accordingly.
     * @param list1 given list to combine
     * @param list2 given list to combine
     * @return new list as combination of list1 and list2
     */
    static List combineLists(List list1, List list2){
        List newList = new ArrayList();
        int length = list1.size() + list2.size();
        int length1 = list1.size();
        int length2 = list2.size();

        if(length1 == length2) {
            for (int i = 0; i < length/2; i++) {
                newList.add(list1.get(i));
                newList.add(list2.get(i));
            }
        }
        else if(length1 > length2){
            for (int i = 0; i < length2; i++) {
                newList.add(list1.get(i));
                newList.add(list2.get(i));
            }
            newList.addAll(length2*2, list1.subList(length2, length1));
        }
        else{
            for (int i = 0; i < length1; i++) {
                newList.add(list1.get(i));
                newList.add(list2.get(i));
            }
            newList.addAll(length1*2, list2.subList(length1, length2));
        }
        return newList;
    }

    //11. Write a function that merges two sorted lists into a new sorted list. [1,4,6],[2,3,5] → [1,2,3,4,5,6].
    /**
     * Merges given sorted lists (in this program I didn't use sortedList as parameters and used already existing lists)
     * @param list1 - given already sorted list
     * @param list2 - given already sorted list
     * @return a new sorted list as merge of given list1 and list2
     */
    static List mergeSortedLists(List list1, List list2){
        List newList = new ArrayList();
        newList.addAll(list1);
        newList.addAll(list2);
        Collections.sort(newList);
        return newList;
    }
}
