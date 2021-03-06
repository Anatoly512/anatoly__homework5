package CarModel;

public class CarDoor {

    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private String StatusDoor;
    private String StatusWindow;

    CarDoor(boolean isOpenDoor, boolean isOpenWindow) {
        this.isOpenDoor = isOpenDoor;
        this.isOpenWindow = isOpenWindow;

        if (isOpenDoor) {this.StatusDoor = Message.STATUS_OPEN;}
        else this.StatusDoor = Message.STATUS_CLOSED;

        if (isOpenWindow) {this.StatusWindow = Message.STATUS_OPEN;}
        else this.StatusWindow = Message.STATUS_CLOSED;
    }

    CarDoor() {
        this.isOpenDoor = false;
        this.isOpenWindow  = false;
        this.StatusDoor = Message.STATUS_CLOSED;
        this.StatusWindow = Message.STATUS_CLOSED;
    }


    public boolean getStatusDoor() {
        return isOpenDoor;
    }

    public boolean getStatusWindow() {
        return isOpenWindow;
    }


    public String getStringStatusDoor() {
        return StatusDoor;
    }

    public String getStringStatusWindow() {
        return StatusWindow;
    }


    private void setStatusDoor(boolean openDoor) {
        this.isOpenDoor = openDoor;

        if (this.isOpenDoor) {this.StatusDoor = Message.STATUS_OPEN;}
        else this.StatusDoor = Message.STATUS_CLOSED;
    }


    private void setStatusWindow(boolean openWindow) {
        this.isOpenWindow = openWindow;

        if (this.isOpenWindow) {this.StatusWindow = Message.STATUS_OPEN;}
        else this.StatusWindow = Message.STATUS_CLOSED;
    }


    public void openTheDoor() {
        setStatusDoor(true);
    }

    public void closeTheDoor() {
        setStatusDoor(false);
    }

    public void openTheWindow() {
        setStatusWindow(true);
    }

    public void closeTheWindow() {
        setStatusWindow(false);
    }


    public void openOrCloseTheDoor() {
        boolean statusDoor = false;
        if (!getStatusDoor()) statusDoor = true;
        setStatusDoor(statusDoor);
    }

    public void openOrCloseTheWindow() {
        boolean statusWindow = false;
        if (!getStatusWindow()) statusWindow = true;
        setStatusWindow(statusWindow);
    }


    public void showStatusTheDoorAndTheWindow(int number) {

        System.out.println(Message.STATUS_DOOR + (number+1) + Message.SYMBOL_COLON + getStringStatusDoor());
        System.out.println(Message.STATUS_WINDOW + (number+1) + Message.SYMBOL_COLON + getStringStatusWindow());

    }

}
