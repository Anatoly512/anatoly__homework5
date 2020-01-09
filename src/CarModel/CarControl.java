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

    //  Car car = new Car("2018");

    // Car car = new Car(numberOfDoors, "01 January, 2018");

         car.carLaunch();

        // System.out.println("\nTEST STRING : ");
        // System.out.println("\nStatus Of DOOR " + car.getStatusDoor(0));
        // System.out.println("\nStatus Of WINDOW " + car.getStatusWindow(0));
        // car.showStatusDoor(0);
        // System.out.println(car.getStringStatusDoor(i));
        // System.out.println(car.getStringStatusWindow(i));
        // System.out.println(car.getStringDateOfManufacture());

        System.out.println("\nTest WHEEL String !");
        int numberOfWheels = car.getNumberOfWheels();
        System.out.print("\nNumber of wheels : " + numberOfWheels);
        car.wipeTheWheelTire(0, 0.10);
        car.wipeTheWheelTire(1, 0.20);
        car.wipeTheWheelTire(2, 0.30);

        for (int i = 0; i < numberOfWheels; i++) {

            System.out.print("\nStatus of wheel # " + (i+1) + " : " + car.getWheelTireIntegrity(i));
        }

        car.setNumberOfWheels(2);
        numberOfWheels = car.getNumberOfWheels();
        System.out.print("\nNew number of wheels : " + numberOfWheels);

        for (int i = 0; i < numberOfWheels; i++) {
          System.out.print("\nNew status of wheel # " + (i+1) + " : " + car.getWheelTireIntegrity(i));
        }

        car.setNumberOfWheels(5);
        numberOfWheels = car.getNumberOfWheels();
        System.out.print("\nNew number of wheels : " + numberOfWheels);

        for (int i = 0; i < numberOfWheels; i++) {
            System.out.print("\nNew status of wheel # " + (i+1) + " : " + car.getWheelTireIntegrity(i));
        }

        System.out.println();


    }

}

