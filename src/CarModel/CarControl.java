package CarModel;

public class CarControl {

    private boolean isOpenDoor;
    private boolean isOpenWindow;

    CarControl () {
    }

    public void carLaunch() {

        int numberOfDoors;

        System.out.print("Введите число дверей в автомобиле : ");
        numberOfDoors = DataReader.readIntNumber();
        System.out.println();

            if (numberOfDoors > 10) {
                System.out.println(Message.ARE_YOU_SURE);
                System.out.println("It's too much.  We set only 10 doors and went to drink coffee.  :))) \n");
                numberOfDoors = 10;
            } else {
                if (numberOfDoors == 0) {
                    System.out.println(Message.ARE_YOU_SURE);
                    System.out.println("Can you imagine a car without doors?  How you get inside it?");
                    System.out.println("So, we set one door especially for you.  It's a present :)))  Don't thank! \n");
                    numberOfDoors = 1;
                } else {
                    if (numberOfDoors < 0) {
                        System.out.println(Message.ARE_YOU_SURE);
                        System.out.println("We couldn't even imagine such a car!!!");
                        System.out.println("So, only for you, we set two doors.  It would be a sport car! :))  Don't thank! \n");
                        numberOfDoors = 2;
                    }
                }
            }


        CarDoor[] door = new CarDoor[numberOfDoors];

            //  Заполнение массива дверей и окон

        for (int i = 0; i < numberOfDoors;  i++) {

            chooseStatusDoor(i);    //  returns isOpenDoor
            chooseStatusWindow(i);   //  returns isOpenWindow

            door[i] = new CarDoor(isOpenDoor, isOpenWindow);      //  передача в конструктор параметров

        }



        //  Проверка работы геттеров и сеттеров
            String StatusDoor;
            String StatusWindow;

        for (int i = 0; i < numberOfDoors;  i++) {

            StatusDoor = door[i].getStringStatusDoor();
            StatusWindow = door[i].getStringStatusWindow();


         //  Test output string
             System.out.println("\nStatus  DOOR  № " + (i+1) + "  :  " + StatusDoor);
             System.out.println("Status  WINDOW  № " + (i+1) + "  :  " + StatusWindow);

        }


    }


    private int choiceIfDoorOrWindowOpen() {
        boolean trigger = true;
        int choice = 0;

        while (trigger) {
            choice = DataReader.readIntNumber();
            if (choice < 1 || choice > 2 ) {
                System.out.print(Message.INPUT_ONE_OR_TWO);
                trigger = true;
            }
            else trigger = false;
        }

        return choice;
    }


    private void chooseStatusDoor(int number) {
        System.out.println(Message.INPUT_DOORS + (number+1) + Message.SYMBOL_COLON);
        System.out.print(Message.INPUT_OPEN_CLOSED);

        if (choiceIfDoorOrWindowOpen() == 1) {
            isOpenDoor = true;
        }
        else {
            isOpenDoor = false;
        }

    }


    private void chooseStatusWindow(int number) {
        System.out.println(Message.INPUT_WINDOWS + (number+1) + Message.SYMBOL_COLON);
        System.out.print(Message.INPUT_OPEN_CLOSED);

        if (choiceIfDoorOrWindowOpen() == 1) {
            isOpenWindow = true;
        }
        else {
            isOpenWindow = false;
        }

    }

}

