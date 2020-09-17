package string;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {
    public static void main(String[] args) {
        String noDuplicateText = "Single char";
        String duplicateCharText = "Java rocks!!";

        reverseText(duplicateCharText);

        printDuplicateCharacters(noDuplicateText);
        printDuplicateCharacters(duplicateCharText);

        printDuplicateCharactersCount(duplicateCharText);
    }

    /**
     * Reverses the text and prints it
     * @param text the text to be reversed
     */
    public static void reverseText(String text){
        String reverse = "";
        for (int i = text.length()-1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }
        System.out.println(reverse);
    }

    /**
     * Finds and prints duplicate characters in given text, otherwise prints that there are no duplicates.
     * Adds character to a String of duplicates if it has duplicates and if it has not been added to duplicate
     * string earlier.
     * @param text the text to look for duplicate characters
     */
    public static void printDuplicateCharacters(String text){
        String duplicates = "";

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            for (int j = i+1; j < text.length(); j++) {
                char nextChar = text.charAt(j);
                if(Character.toLowerCase(currentChar)  == Character.toLowerCase(nextChar)
                        && (duplicates.indexOf(currentChar) == -1)) {
                    duplicates = duplicates + currentChar;
                }
            }
        }

        if(duplicates.length() > 0) {
            duplicates = duplicates.toLowerCase();
            System.out.print("In '" + text + "' the duplicate characters are: ");
            for (int i = 0; i < duplicates.length(); i++) {
                System.out.print("'" + duplicates.charAt(i) + "' ");
            }
            System.out.println("");
        }
        else {

            System.out.println("In '" + text + "' there are no duplicate characters");
        }
    }

    /**
     * Finds and prints duplicate characters with numbers how many time they occur,
     * otherwise prints that there are no duplicate characters.
     * @param text the text to look for duplicate characters
     */
    public static void printDuplicateCharactersCount(String text){
        boolean haveDuplicates = false;
        Map<Character, Integer> charToCount = new HashMap<>();

        for (char currentChar : text.toCharArray()) {
            if(charToCount.containsKey(currentChar)){
                charToCount.put(currentChar, charToCount.get(currentChar) + 1);
                haveDuplicates = true;
            }
            else
                charToCount.put(currentChar, 1);
        }

        if(haveDuplicates) {
            System.out.println("'" + text + "' has following duplicate characters: ");
            for (var entry : charToCount.entrySet()) {
                if (entry.getValue() > 1) {
                    System.out.println(entry);
                }
            }
        }
        else
            System.out.println("Text doesn't have duplicate characters");
    }
}

