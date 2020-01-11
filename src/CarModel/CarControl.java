package CarModel;

public class CarControl {

    private int numberOfDoors;
    Car car;

    CarControl() {
        this.numberOfDoors = chooseNumberOfDoorsInCar();
        this.car = new Car(this.numberOfDoors);

     // this.car = new Car("01 January, 2018");
     // this.car = new Car(numberOfDoors, 10, Message.ENGINE_SPORTCAR);
     // this.car = new Car(numberOfDoors, "01 January, 2018", 5, Message.ENGINE_USUAL);
    }

    CarControl(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        this.car = new Car(this.numberOfDoors);
    }


    public void carControl() {

         car.carLaunch();







    }


    public static int chooseNumberOfDoorsInCar() {
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

        return numberOfDoors;
    }


/* //  Проверка работы массива колес

    private void testWheel() {

        System.out.println("\nTest WHEEL String !");
        int numberOfWheels = car.getNumberOfWheels();
        System.out.print("\nNumber of wheels : " + numberOfWheels);
        car.wipeTheWheelTire(0, 0.10);
        car.wipeTheWheelTire(1, 0.20);
        car.wipeTheWheelTire(2, 0.30);
        car.wipeTheWheelTire(3, 67);

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

 }
      */


/*  //  Проверка работы логики изменения скорости в зависимости от состояния шин

    private void testSpeed() {

        car.wipeTheWheelTire(0, 0.15);
        car.wipeTheWheelTire(1, 28);
        car.wipeTheWheelTire(2, 0.10);
        car.wipeTheWheelTire(3, 12);

        System.out.println("\nTest SPEED String !\n");
        System.out.println("Max Speed :  " + car.getMaxSpeed());
        System.out.println("Current Speed :  " + car.getCurrentSpeed());
        System.out.println("Most Wiped Tire :  " + car.findMaxWipedTire());
        System.out.println("Max Speed Possible:  " + car.getMaxSpeedPossible());
        System.out.print("SET new CURRENT Speed :  ");
        car.setCurrentSpeed(DataReader.readIntNumber());
        System.out.println();
        System.out.println("Current Speed :  " + car.getCurrentSpeed());

        }

   */

}

