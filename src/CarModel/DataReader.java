package CarModel;

import java.util.Scanner;

public class DataReader {

    public static int readIntNumber () {
        boolean trigger = true;
        int number = 0;
        String numberInputString = "";
        Scanner in = new Scanner(System.in);

        do {
            try {
                numberInputString = in.next();
                number = Integer.parseInt(numberInputString);
                trigger = false;
            } catch (Exception ex) {
                System.out.println(Message.ERROR_INT_INPUT_MESSAGE);
                trigger = true;
            }
        } while (trigger);

        return number;
    }

    public static double readDoubleNumber () {
        int a = 0;
        double doubleNumber = 0f;
        boolean doubleTrue = false;
        boolean trigger = true;
        boolean trigger2 = false;
        String numberInputString = "";
        Scanner scanner = new Scanner(System.in);

        do {
            try {
                numberInputString = scanner.next();
                trigger2 = false;
                try {
                    a = Integer.parseInt(numberInputString);
                }
                catch (NumberFormatException | NullPointerException nfe) {
                    try {
                        doubleNumber = Double.parseDouble(numberInputString);
                        doubleTrue = true;
                    }
                    catch (NumberFormatException | NullPointerException n) {
                        System.out.println(Message.WRONG_DURING_INPUT);
                        System.out.print(Message.PLEASE_TRY_AGAIN);
                        trigger2 = true;
                    }
                }

                trigger = false;

            } catch (Exception ex) {
                System.out.println(Message.ERROR_NUMBER_INPUT_MESSAGE);
                trigger = true;
            }
        } while (trigger | trigger2);


        //  Если пользователь ввел обычное число (без точки),
        //  явно приводим его к типу Double

        if (doubleTrue) {
        }
        else {
                doubleNumber  = (double) a;
             }

        //  Округляем до двух цифр после запятой

        doubleNumber = aRoundDouble(doubleNumber, 2);

       return doubleNumber;
    }


    public static double aRoundDouble (double number, int decimalPlace) {
        double doubleRound = number;

        double roundDouble = Math.pow(10, 2);
        doubleRound = Math.round(doubleRound * roundDouble) / roundDouble;

        return doubleRound;
    }

}
