package CarModel;

public class Car {

    private static int numberOfDoors;
    private int numberOfWheels = 4;
    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private final String DateOfManufacture;

    CarDoor[] door;
    CarWheel[] wheel;


    Car(int numberOfDoors) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = Message.UNKNOWN_DATE;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
    }

    Car(int numberOfDoors, String dateOfManufacture) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = dateOfManufacture;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
    }

    Car(String dateOfManufacture) {
        Car.numberOfDoors = 4;
        this.DateOfManufacture = dateOfManufacture;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
    }


    public void carLaunch() {

        statusDoorsAndWindowsChoose();

        this.numberOfWheels = 2;


    }


        private void wheelsCreate(int newNumberOfWheels) {



        }



        private void statusDoorsAndWindowsChoose() {

            //  Заполнение массива дверей и окон  (пользователь назначает им статус :  закрыты или открыты)

            for (int i = 0; i < numberOfDoors; i++) {

                chooseStatusDoor(i);    //  returns isOpenDoor
                chooseStatusWindow(i);   //  returns isOpenWindow

                this.door[i] = new CarDoor(isOpenDoor, isOpenWindow);      //  передача в конструктор дверей параметров

            }


            //  Просмотр статуса дверей и окон

            for (int i = 0; i < numberOfDoors; i++) {

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


    public void showStatusDoor(int number) {

        this.door[number].showStatusTheDoorAndTheWindow(number);

    }


    public String getStringDateOfManufacture() {

        return this.DateOfManufacture;

    }


    public void openTheDoor(int number) {
        this.door[number].openTheDoor();
    }

    public void closeTheDoor(int number) {
        this.door[number].closeTheDoor();
    }

    public void openTheWindow(int number) {
        this.door[number].openTheWindow();
    }

    public void closeTheWindow(int number) {
        this.door[number].closeTheWindow();
    }

    public void openOrCloseTheDoor(int number) {
        this.door[number].openOrCloseTheDoor();
    }

    public void openOrCloseTheWindow(int number) {
        this.door[number].openOrCloseTheWindow();
    }



}

