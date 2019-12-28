package CarModel;

public class CarControl {

    boolean isOpenDoor;
    boolean isOpenWindow;
    String StatusDoor;
    String StatusWindow;

    CarControl () {
        System.out.println("CONSTRUCTOR  !");
    }

    public void carLaunch() {

        setStatusDoor();
        setStatusWindow();


        System.out.println("\nStatus  DOORS  :  " + StatusDoor);
        System.out.println("Status  WINDOWS  :  " + StatusWindow);


     // CarDoor door = new CarDoor();
        CarDoor door = new CarDoor(isOpenDoor, isOpenWindow);

        System.out.println("\nStatus  this  DOOR  :  " + door.isOpenDoor);
        System.out.println("Status  this  WINDOW  :  " + door.isOpenWindow);


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


    private void setStatusDoor() {
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


    private void setStatusWindow() {
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

