package CarModel;

public class CarControl {

    public void carControl() {

        int numberOfDoors;

        System.out.print("Введите число дверей в автомобиле : ");
        numberOfDoors = DataReader.readIntNumber();
        System.out.println();

            if (numberOfDoors > 10) {
                System.out.println(Message.ARE_YOU_SURE);
                System.out.println("It's too much.  We set only 10 doors and went to drink coffee.  :))) \n");
                numberOfDoors = 10;
            } else {
                if (numberOfDoors == 0) {
                    System.out.println(Message.ARE_YOU_SURE);
                    System.out.println("Can you imagine a car without doors?  How you get inside it?");
                    System.out.println("So, we set one door especially for you.  It's a present :)))  Don't thank! \n");
                    numberOfDoors = 1;
                } else {
                    if (numberOfDoors < 0) {
                        System.out.println("We couldn't even imagine such a car!!!");
                        System.out.println("So, only for you, we set two doors.  It would be a sport car! :))  Don't thank! \n");
                        numberOfDoors = 2;
                    }
                }
            }

         Car car = new Car(numberOfDoors);
         car.carLaunch();

        System.out.println("\nTEST STRING : ");
        // System.out.println("\nStatus Of DOOR " + car.getStatusDoor(0));
        // System.out.println("\nStatus Of WINDOW " + car.getStatusWindow(0));
        // car.showStatusDoor(0);
        // System.out.println( car.getStringStatusDoor(i) );
        // System.out.println( car.getStringStatusWindow(i) );

        for (int i = 0; i < numberOfDoors; i++) {



        }




    }
}

