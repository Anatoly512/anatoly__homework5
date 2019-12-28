package CarModel;

public class CarDoor {

    boolean isOpenDoor;
    boolean isOpenWindow;

    CarDoor() {
        this.isOpenDoor = false;
        this.isOpenWindow  = false;
    }

    CarDoor(boolean isOpenDoor, boolean isOpenWindow) {
        this.isOpenDoor = isOpenDoor;
        this.isOpenWindow = isOpenWindow;
    }

}
