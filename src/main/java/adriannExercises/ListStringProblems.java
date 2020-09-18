package adriannExercises;

import java.util.*;

public class ListStringProblems {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(87, 1, 111, 0, 5, 10, -5, 12));

        //findMinNoSorting(list);
        //findMaxNoSorting(list);
        System.out.println("Minimum element is: " + findMin(list));
        System.out.println("Maximum element is: " + findMax(list));

        reverseList(list);

        System.out.println(isElementPresent(list, 11));
        System.out.println(binarySearch(list, 5));
        System.out.println(isPresentWithListContains(list, 0));

        System.out.println(oddIndexElements(list));
        System.out.println(calculateRunningTotal(list));

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
}
