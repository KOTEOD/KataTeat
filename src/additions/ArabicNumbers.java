package additions;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicNumbers {

    private String stringArabicNumbers;

    public String getStringArabicNumbers() {
        return calculatorArabic(stringArabicNumbers);
    }

    public void setStringArabicNumbers(String stringArabicNumbers) {
        this.stringArabicNumbers = stringArabicNumbers;
    }


    private String calculatorArabic(String stringArabicNumbers) {
        Matcher matcher = Pattern.compile("[-+*/]").matcher(stringArabicNumbers);
        int index = 0;

        String element = null;

        while (matcher.find()) {
            index = matcher.start();
            element = String.valueOf(stringArabicNumbers.charAt(index));
        }


        Integer integerStart = Integer.parseInt(stringArabicNumbers.substring(0, index));
        Integer integerEnd = Integer.parseInt(stringArabicNumbers.substring(index + 1));

        switch (element) {
            case ("+"):
                int i1 = integerStart + integerEnd;
                String s1 = String.valueOf(i1);
                stringArabicNumbers = s1;
                break;
            case ("-"):
                int i2 = integerStart - integerEnd;
                String s2 = String.valueOf(i2);
                stringArabicNumbers = s2;
                break;
            case ("/"):
                int i3 = integerStart / integerEnd;
                String s3 = String.valueOf(i3);
                stringArabicNumbers = s3;
                break;
            case ("*"):
                int i4 = integerStart * integerEnd;
                String s4 = String.valueOf(i4);
                stringArabicNumbers = s4;
                break;
        }

        return stringArabicNumbers;
    }
}
