import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Calculator {
    private static final String MULTIPLY = "*";
    private static final String DIVIDE = "/";
    private static final String ADD = "+";
    private static final String SUB = "-";
    public static void main(String[] args) throws Exception {
        String[] expSplitted;
        int x,y;
        String romanX = "", romanY = "";
        boolean isRomanOperation = false;
        Integer res = null;
        String operation;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String exp = reader.readLine();
        expSplitted = exp.split(" ");

        if (expSplitted.length != 3) throw new Exception("Invalid format, must be \"x + y\", \"x - y\", \"x * y\" or \"x / y\"");

        operation = expSplitted[1];

        if (RomanNumerals.isRoman(expSplitted[0]) && RomanNumerals.isRoman(expSplitted[2])) {
            x = RomanNumerals.parseInt(expSplitted[0]);
            y = RomanNumerals.parseInt(expSplitted[2]);
            romanX = expSplitted[0];
            romanY = expSplitted[2];
            isRomanOperation = true;
        } else if ((RomanNumerals.isRoman(expSplitted[0]) && !RomanNumerals.isRoman(expSplitted[2])) || (RomanNumerals.isRoman(expSplitted[2]) && !RomanNumerals.isRoman(expSplitted[0]))) {
            throw new Exception("Different number formats");
        } else {
            try {
                x = Integer.parseInt(expSplitted[0]);
                y = Integer.parseInt(expSplitted[2]);
            } catch (Exception e) {
                throw new Exception("Invalid number format");
            }
        }

        if (x < 1 || x > 10 || y < 1 || y > 10) throw new Exception("Numbers must be between 1 and 10 inclusive");
        switch (operation)
        {
            case MULTIPLY:
                res = x * y;
                break;
            case DIVIDE:
                res = x / y;
                break;
            case ADD:
                res = x + y;
                break;
            case SUB:
                res = x - y;
                break;
        }

        if (res != null) {
            if (isRomanOperation){
                if (res <= 0) throw new Exception("Roman number less than or equal to zero");
                System.out.println(RomanNumerals.toRoman(res));
            } else {
                System.out.println(res);
            }

        } else {
            throw new Exception("Invalid operation, must be *, /, + or -");
        }
    }
}
