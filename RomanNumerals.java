import java.util.TreeMap;

public class RomanNumerals {

    private final static TreeMap<Integer, String> toRomanMap = new TreeMap<>();
    private final static TreeMap<Character, Integer> toIntMap = new TreeMap<>();

    static {
        toRomanMap.put(1000, "M");
        toRomanMap.put(900, "CM");
        toRomanMap.put(500, "D");
        toRomanMap.put(400, "CD");
        toRomanMap.put(100, "C");
        toRomanMap.put(90, "XC");
        toRomanMap.put(50, "L");
        toRomanMap.put(40, "XL");
        toRomanMap.put(10, "X");
        toRomanMap.put(9, "IX");
        toRomanMap.put(5, "V");
        toRomanMap.put(4, "IV");
        toRomanMap.put(1, "I");

        toIntMap.put('I',1);
        toIntMap.put('V',5);
        toIntMap.put('X',10);
        toIntMap.put('L',50);
        toIntMap.put('C',100);
        toIntMap.put('D',500);
        toIntMap.put('M',1000);
    }

    public static String toRoman(int number) {
        int l =  toRomanMap.floorKey(number);
        if ( number == l ) {
            return toRomanMap.get(number);
        }
        return toRomanMap.get(l) + toRoman(number-l);
    }

    public static int parseInt(String number){
        number = number.replace("IV","IIII");
        number = number.replace("IX","VIIII");
        number = number.replace("XL","XXXX");
        number = number.replace("XC","LXXXX");
        number = number.replace("CD","CCCC");
        number = number.replace("CM","DCCCC");
        int res = 0;

        for(int i = 0; i < number.length(); i++) {
            res += toIntMap.get(number.charAt(i));
        }
        return res;
    }

    public static boolean isRoman(String number) {
        switch (number){
            case "I":
            case "II":
            case "III":
            case "IV":
            case "V":
            case "VI":
            case "VII":
            case "VIII":
            case "IX":
            case "X":
                return true;
        }

        return false;
    }


}
