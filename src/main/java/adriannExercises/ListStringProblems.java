package adriannExercises;

import java.util.*;

public class ListStringProblems {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.addAll(Arrays.asList(87, 1, 111, 5, 10, -5));

        //findMinNoSorting(list);
        //findMaxNoSorting(list);
        System.out.println("Minimum element is: " + findMin(list));
        System.out.println("Maximum element is: " + findMax(list));
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
}
