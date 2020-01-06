package CarModel;

public class CarControl {

    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private String StatusDoor;
    private String StatusWindow;

    CarControl () {
    }

    public void carLaunch() {

         CarDoor[] door = new CarDoor[4];

      for (int i = 0; i < 4;  i++) {
         chooseStatusDoor(i);
         chooseStatusWindow(i);

         //  Test output string
         //  System.out.println("\nStatus  DOORS  :  " + StatusDoor);
         //  System.out.println("Status  WINDOWS  :  " + StatusWindow);


         door[i] = new CarDoor(isOpenDoor, isOpenWindow);
      }


        for (int i = 0; i < 4;  i++) {

            //  Проверка работы геттеров и сеттеров
            if (door[i].getStatusDoor()) {
                StatusDoor = Message.STATUS_OPEN;
            } else StatusDoor = Message.STATUS_CLOSED;

            if (door[i].getStatusWindow()) {
                StatusWindow = Message.STATUS_OPEN;
            } else StatusWindow = Message.STATUS_CLOSED;



         //  Test output string
             System.out.println("\nStatus  this  DOOR  № " + (i+1) + "  :  " + StatusDoor);
             System.out.println("Status  this  WINDOW  № " + (i+1) + "  :  " + StatusWindow);

        }




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


    private void chooseStatusDoor(int number) {
        System.out.println(Message.INPUT_DOORS + (number+1) + " : ");
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


    private void chooseStatusWindow(int number) {
        System.out.println(Message.INPUT_WINDOWS + (number+1) + " : ");
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

