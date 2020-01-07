package CarModel;

public class Car {

    private int numberOfDoors;
    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private final String DateOfManufacture;


    Car(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = "Unknown";
    }

    Car(int numberOfDoors, String dateOfManufacture) {
        this.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = dateOfManufacture;
    }

    Car(String dateOfManufacture) {
        this.numberOfDoors = 4;
        this.DateOfManufacture = dateOfManufacture;
    }


    public void carLaunch() {

        CarDoor[] door = new CarDoor[numberOfDoors];

        //  Заполнение массива дверей и окон

        for (int i = 0; i < numberOfDoors; i++) {

            chooseStatusDoor(i);    //  returns isOpenDoor
            chooseStatusWindow(i);   //  returns isOpenWindow

            door[i] = new CarDoor(isOpenDoor, isOpenWindow);      //  передача в конструктор дверей параметров

        }


        //  Проверка работы геттеров и сеттеров

        for (int i = 0; i < numberOfDoors; i++) {

            //  Test output string

            door[i].showStatusTheDoorAndTheWindow(i);

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



}
