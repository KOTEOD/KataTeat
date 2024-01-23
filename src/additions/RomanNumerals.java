package additions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RomanNumerals {
    String stringRomanNumbers;

    public String getStringRomanNumbers() {
        return calculatorRoman(stringRomanNumbers);
    }

    public void setStringRomanNumbers(String stringRomanNumbers) {
        this.stringRomanNumbers = stringRomanNumbers;
    }

    public String calculatorRoman(String stringRomanNumbers) {

        Matcher matcher = Pattern.compile("[-+*/]").matcher(stringRomanNumbers);

        int index = 0;
        int resultCount;
        String element = null;



        while (matcher.find()) {
            index = matcher.start();
            element = String.valueOf(stringRomanNumbers.charAt(index));
        }

        String integerStart = (stringRomanNumbers.substring(0, index));
        String integerEnd = stringRomanNumbers.substring(index + 1);
        EnumRomanNumerals resultStart = EnumRomanNumerals.compareStringToEnum(integerStart);
        EnumRomanNumerals resultEnd = EnumRomanNumerals.compareStringToEnum(integerEnd);
        int startOut = 0;
        resultCount = resultStart.getCount() + resultEnd.getCount();
        switch (element) {
            case ("+"):
                int i1 = resultStart.getCount() + resultEnd.getCount();
                String s1 = String.valueOf(i1);
                startOut = Integer.parseInt(s1);
                break;
            case ("-"):
                int i2 = resultStart.getCount() - resultEnd.getCount();
                String s2 = String.valueOf(i2);
                startOut = Integer.parseInt(s2);
                break;
            case ("/"):
                int i3 = resultStart.getCount() / resultEnd.getCount();
                String s3 = String.valueOf(i3);
                startOut = Integer.parseInt(s3);
                break;
            case ("*"):
                int i4 = resultStart.getCount() * resultEnd.getCount();
                String s4 = String.valueOf(i4);
                startOut = Integer.parseInt(s4);
                break;
        }
        if (startOut <= 0) {
            throw new RuntimeException("Value negative int Roman Caclc");
        }
        StringBuilder stringBuilderValues = new StringBuilder();
        if (startOut <= 10) {
            return EnumRomanNumerals.fromValue(startOut).toString();
        } else if (startOut >= 10 && startOut <= 100) {
            String valuesOne;
            valuesOne = Integer.toString(startOut);
            String s1 = valuesOne.substring(0, 1);
            String s2 = valuesOne.substring(1);
            if (startOut < 49) {
                for (int i = 0; i < Integer.parseInt(s1); i++) {
                    stringBuilderValues.append(EnumRomanNumerals.fromValue(EnumRomanNumerals.X.count));
                }
            } else if (startOut > 50 && startOut < 90) {
                stringBuilderValues.append(EnumRomanNumerals.fromValue(EnumRomanNumerals.L.count));
                for (int i = 0; i < Integer.parseInt(s1) - 5; i++) {
                    stringBuilderValues.append(EnumRomanNumerals.fromValue(EnumRomanNumerals.X.count));
                }
            } else if (startOut >= 90 && startOut < 99) {
                stringBuilderValues.append(EnumRomanNumerals.fromValue(EnumRomanNumerals.XC.count));
            } else if (startOut == 100) {
                stringBuilderValues.append(EnumRomanNumerals.fromValue(EnumRomanNumerals.C.count));
            }
            if (!(startOut % 10 == 0)) {
                stringBuilderValues.append(EnumRomanNumerals.fromValue(Integer.parseInt(s2)));
            }

        }
        stringRomanNumbers = stringBuilderValues.toString();
        return stringRomanNumbers.toString();
    }
}