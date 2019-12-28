package CarModel;

public class CarDoor {

    private boolean isOpenDoor;
    private boolean isOpenWindow;

    CarDoor(boolean isOpenDoor, boolean isOpenWindow) {
        this.isOpenDoor = isOpenDoor;
        this.isOpenWindow = isOpenWindow;
    }

    CarDoor() {
        this.isOpenDoor = false;
        this.isOpenWindow  = false;
    }


    public boolean getStatusDoor() {
        return isOpenDoor;
    }

    public boolean getStatusWindow() {
        return isOpenWindow;
    }

    public void setStatusDoor(boolean openDoor) {
        this.isOpenDoor = openDoor;
    }

    public void setStatusWindow(boolean openWindow) {
        this.isOpenWindow = openWindow;
    }


}
