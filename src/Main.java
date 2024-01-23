import additions.ArabicNumbers;
import additions.RomanNumerals;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println(calc(scanner.nextLine().replaceAll(" ", "")));
    }

    public static String calc(String input) {
        if (Pattern.compile("\\b([1-9]|10)\\s*([-+*/])\\s*([1-9]|10)\\b").matcher(input).matches()) {
            ArabicNumbers arabicNumbers = new ArabicNumbers();
            arabicNumbers.setStringArabicNumbers(input);
            return arabicNumbers.getStringArabicNumbers();
        }else if (Pattern.compile("([IVX]{1,10})\\s*([-+*/])\\s*([IVX]{1,10})").matcher(input).matches()) {
            RomanNumerals romanNumerals = new RomanNumerals();
            romanNumerals.setStringRomanNumbers(input);
            return romanNumerals.getStringRomanNumbers();
        }else if (!input.matches(".*[-+*/].*")) {
            throw new RuntimeException("Incorrect acquisition value");
        } else if (Pattern.compile("\\b([1-9]|10)\\s*([-+*/])\\s*([IVX]{1,10})").matcher(input).matches()
                || Pattern.compile("([IVX]{1,10})\\s*([-+*/])\\s*([1-9]|10)\\b").matcher(input).matches()) {
            throw new RuntimeException("Different number systems are used simultaneously");
        } else if (input.length() < 1) {
            throw new RuntimeException("The format of the mathematical operation does not satisfy the task");
        } else {
            return "No name exception";
        }
    }
}