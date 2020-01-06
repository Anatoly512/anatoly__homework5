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

    public void setStatusDoor(boolean openDoor) {
        this.isOpenDoor = openDoor;

        if (isOpenDoor) {this.StatusDoor = Message.STATUS_OPEN;}
        else this.StatusDoor = Message.STATUS_CLOSED;
    }

    public void setStatusWindow(boolean openWindow) {
        this.isOpenWindow = openWindow;

        if (isOpenWindow) {this.StatusWindow = Message.STATUS_OPEN;}
        else this.StatusWindow = Message.STATUS_CLOSED;
    }


}
