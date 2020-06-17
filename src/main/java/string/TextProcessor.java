package string;

public class TextProcessor {
    public static void main(String[] args) {
        String textToReverse = "Lilit rocks!";
        reverseText(textToReverse);
    }

    public static void reverseText(String text){
        String reverse = "";
        for (int i = text.length()-1; i >= 0; i--) {
            reverse = reverse + text.charAt(i);
        }
        System.out.println(reverse);
    }

    public static void reverseText1(String text){

    }
}

