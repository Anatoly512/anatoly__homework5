package CarModel;

public class Car {

    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private static int numberOfDoors;
    private final String DateOfManufacture;

    CarDoor[] door;


    Car(int numberOfDoors) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = "Unknown date of manufacture";

        this.door = new CarDoor[numberOfDoors];

    }

    Car(int numberOfDoors, String dateOfManufacture) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = dateOfManufacture;

        this.door = new CarDoor[numberOfDoors];
    }

    Car(String dateOfManufacture) {
        Car.numberOfDoors = 4;
        this.DateOfManufacture = dateOfManufacture;

        this.door = new CarDoor[numberOfDoors];
    }


    public void carLaunch() {


        //  Заполнение массива дверей и окон  (пользователь назначает им статус :  закрыты или открыты)

        for (int i = 0; i < numberOfDoors; i++) {

            chooseStatusDoor(i);    //  returns isOpenDoor
            chooseStatusWindow(i);   //  returns isOpenWindow

            this.door[i] = new CarDoor(isOpenDoor, isOpenWindow);      //  передача в конструктор дверей параметров

        }


        //  Проверка работы геттеров и сеттеров

        for (int i = 0; i < numberOfDoors; i++) {

            //  Test output string

            this.door[i].showStatusTheDoorAndTheWindow(i);

        }

    }


        private int choiceIfDoorOrWindowOpen () {
            boolean trigger = true;
            int choice = 0;

            while (trigger) {
                choice = DataReader.readIntNumber();
                if (choice < 1 || choice > 2) {
                    System.out.print(Message.INPUT_ONE_OR_TWO);
                    trigger = true;
                } else trigger = false;
            }

            return choice;
        }

        private void chooseStatusDoor ( int number){
            System.out.println(Message.INPUT_DOORS + (number + 1) + Message.SYMBOL_COLON);
            System.out.print(Message.INPUT_OPEN_CLOSED);

            if (choiceIfDoorOrWindowOpen() == 1) {
                isOpenDoor = true;
            } else {
                isOpenDoor = false;
            }

        }

        private void chooseStatusWindow ( int number){
            System.out.println(Message.INPUT_WINDOWS + (number + 1) + Message.SYMBOL_COLON);
            System.out.print(Message.INPUT_OPEN_CLOSED);

            if (choiceIfDoorOrWindowOpen() == 1) {
                isOpenWindow = true;
            } else {
                isOpenWindow = false;
            }

        }


    public void showStatusDoor(int number) {

        this.door[number].showStatusTheDoorAndTheWindow(number);

    }


    public boolean getStatusDoor(int number) {

       return this.door[number].getStatusDoor();

    }

    public boolean getStatusWindow(int number) {

        return this.door[number].getStatusWindow();

    }

    public String getStringStatusDoor(int number) {

        return this.door[number].getStringStatusDoor();
    }

    public String getStringStatusWindow(int number) {

        return this.door[number].getStringStatusWindow();

    }



}

