package CarModel;

public class CarControl {

    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private String StatusDoor;
    private String StatusWindow;

    CarControl () {
    }

    public void carLaunch() {

        chooseStatusDoor();
        chooseStatusWindow();

    //  Test output string
        System.out.println("\nStatus  DOORS  :  " + StatusDoor);
        System.out.println("Status  WINDOWS  :  " + StatusWindow);


     // CarDoor door = new CarDoor();
        CarDoor door = new CarDoor(isOpenDoor, isOpenWindow);

    //  Проверка работы геттеров
        if (door.getStatusDoor()) {
            StatusDoor = Message.STATUS_OPEN;
        } else StatusDoor = Message.STATUS_CLOSED;

        if (door.getStatusWindow()) {
            StatusWindow = Message.STATUS_OPEN;
        } else StatusWindow = Message.STATUS_CLOSED;

    //  Test output string
        System.out.println("\nStatus  this  DOOR  :  " + StatusDoor);
        System.out.println("Status  this  WINDOW  :  " + StatusWindow);


    }


    private int choiceIfDoorsWindowsOpen() {
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


    private void chooseStatusDoor() {
        System.out.println(Message.INPUT_DOORS);
        System.out.print(Message.INPUT_OPEN_CLOSED);

        if (choiceIfDoorsWindowsOpen() == 1) {
            isOpenDoor = true;
            StatusDoor = Message.STATUS_OPEN;
        }
        else {
            isOpenDoor = false;
            StatusDoor = Message.STATUS_CLOSED;
        }

    }


    private void chooseStatusWindow() {
        System.out.println(Message.INPUT_WINDOWS);
        System.out.print(Message.INPUT_OPEN_CLOSED);

        if (choiceIfDoorsWindowsOpen() == 1) {
            isOpenWindow = true;
            StatusWindow = Message.STATUS_OPEN;
        }
        else {
            isOpenWindow = false;
            StatusWindow = Message.STATUS_CLOSED;
        }

    }

}

