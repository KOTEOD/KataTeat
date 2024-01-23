package additions;

public enum EnumRomanNumerals {
    I(1), II(2), III(3), IV(4), V(5), VI(6), VII(7), VIII(8), IX(9), X(10), L(50), XC(90), C(100);
    public final int count;

    EnumRomanNumerals(int count) {
        this.count = count;
    }

    public int getCount() {
        return count;
    }

    public static EnumRomanNumerals compareStringToEnum(String inputString) {
        for (EnumRomanNumerals enumRomanNumerals : EnumRomanNumerals.values()) {
            if (enumRomanNumerals.name().equalsIgnoreCase(inputString)) {
                return enumRomanNumerals;
            }
        }
        return null;
    }

    public static EnumRomanNumerals fromValue(int value) {
        for (EnumRomanNumerals enumRomanNumerals : EnumRomanNumerals.values()) {
            if (enumRomanNumerals.count == value) {
                return enumRomanNumerals;
            }
        }
        return null;
    }

}
