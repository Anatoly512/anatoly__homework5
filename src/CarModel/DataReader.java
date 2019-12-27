package CarModel;

import java.util.Scanner;

public class DataReader {

    public static int readNumber () {
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

    public static float readFloatNumber () {
        int a = 0;
        float floatNumber = 0f;
        boolean floatTrue = false;
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
                        floatNumber = Float.parseFloat(numberInputString);
                        floatTrue = true;
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


       return floatNumber;
    }


}
