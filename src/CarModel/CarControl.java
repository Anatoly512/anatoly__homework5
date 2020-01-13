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


        boolean trigger = true;
        boolean subtrigger = true;
        int choice;

        while (trigger) {

            /*
            Двери\окна :
               открыть дверь
               закрыть дверь
               открыть/закрыть дверь (если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
               открыть окно
               закрыть окно
               открыть/закрыть окно(если дверь открыта и вызывается эта функция, значит дверь необходимо закрыть и наоборот)
               получить дверь по индексу
            Шины :
               Сменить шину на новую
               Стереть шину на X%
               Получить состояние (return)
            Пассажиры :
               Посадить 1 пассажира в машину
               Высадить 1 пассажира
               Высадить всех пассажиров
            Скорость и тип двигателя :
               Изменить текущую скорость
               Вычислить текущую возможную максимальную скорость (Максимальная скорость равна 0 если в машине нет ни одного пассажира, так как некому ее вести)
               Узнать текущую скорость
               Сменить тип двигателя
            Колеса :
               Снять с машины X колес
               Снять все колеса с машины
               Установить на машину X новых колесу (вдобавок к имеющимся)
               Получить колесо по индексу
            Машина :
               Вывести в консоль данные об объекте (все поля и вычисленную максимальную скорость в зависимости от целостности колес и наличия водителя)

             */

            System.out.println("\nCAR CONTROL MENU : ");
            System.out.println("1.  Doors and windows ");
            System.out.println("2.  Wheels (tires) ");
            System.out.println("3.  Passengers ");
            System.out.println("4.  Speed (engine) ");
            System.out.println("5.  Wheels (set and remove)  ");
            System.out.println("6.  Show all info about car ");


            subtrigger = true;

            choice = DataReader.readIntNumber();
            switch (choice){

                case 1:
                    System.out.println("\nDoors and windows menu ! \n");

                    while (subtrigger) {

                        System.out.println("\n1. Open the door ");
                        System.out.println("2. Close the door  ");
                        System.out.println("3. Open/close the door ");
                        System.out.println("4. Open the window ");
                        System.out.println("5. Close the window ");
                        System.out.println("6. Open/close the window ");
                        System.out.println("7. Show info");
                        System.out.println("0. Return to main menu ");

                        choice = DataReader.readIntNumber();
                        switch (choice) {
                            case 1:
                                System.out.print("\nWhat NUMBER of door to open  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.openTheDoor(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 2:
                                System.out.print("\nWhat NUMBER of door to close  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.closeTheDoor(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 3:
                                System.out.print("\nWhat NUMBER of door to open/close  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.openOrCloseTheDoor(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 4:
                                System.out.print("\nWhat NUMBER of window to open  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.openTheWindow(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 5:
                                System.out.print("\nWhat NUMBER of window to close  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.closeTheWindow(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 6:
                                System.out.print("\nWhat NUMBER of window to open/close  :  ");
                                choice = DataReader.readIntNumber();

                                if (!checkOut(choice)) { break;}

                                choice--;
                                car.openOrCloseTheWindow(choice);
                                car.showStatusDoorAndWindow(choice);
                                break;
                            case 7:      //  Свободные цифры пусть тоже участвуют в показе информации
                            case 8:
                            case 9:
                                car.showAllDoorsAndWindowsStatus();      //  Просмотр статуса дверей и окон
                                DataReader.pressEnterKeyToContinue();
                                break;
                            case 0:
                                subtrigger = false;
                                break;

                            default:
                                System.out.println(Message.ERROR_INPUT_MESSAGE);
                        }
                    }
                    break;

                case 2:
                    System.out.println("\nWheels (tires) menu ! \n");

                    while (subtrigger) {
                        System.out.println("1. ");
                        System.out.println("2. ");
                        System.out.println("3. ");
                        System.out.println("4. ");
                        System.out.println("5. ");
                        System.out.println("0.  Return to main menu ");

                        choice = DataReader.readIntNumber();
                        switch (choice) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 0:
                                subtrigger = false;
                                break;

                            default:
                                System.out.println(Message.ERROR_INPUT_MESSAGE);
                        }
                    }
                    break;

                case 3:
                    System.out.println("\nPassengers menu ! \n");

                    while (subtrigger) {
                        System.out.println("1.  Add 1 passenger ");
                        System.out.println("2.  Sub 1 passenger ");
                        System.out.println("3.  Empty the car ");
                        System.out.println("4.  Show passenger capacity ");
                        System.out.println("5.  Change passenger capacity");
                        System.out.println("0.  Return to main menu ");

                        System.out.println("  Current number of passengers  : " + car.getCurrentNumberOfPassengers());

                        choice = DataReader.readIntNumber();
                        switch (choice){
                            case 1:
                                System.out.println("Add 1 passenger");
                                car.addOnePassenger();
                                break;
                            case 2:
                                System.out.println("Sub 1 passenger ");
                                car.subOnePassenger();
                                break;
                            case 3:
                                System.out.println("Car is empty now!");
                                car.subAllPassengers();
                                break;
                            case 4:
                                System.out.println("  Passenger capacity of this car  : " + car.getPassengerCapacity());
                                break;
                            case 5:
                                System.out.print("  Please, enter new passenger capacity of this car  : ");
                                car.setPassengerCapacity(DataReader.readIntNumber());
                                break;
                            case 0:
                                subtrigger = false;
                                break;

                            default:
                                System.out.println(Message.ERROR_INPUT_MESSAGE);
                        }
                    }
                    break;

                case 4:
                    System.out.println("\nSpeed (engine) menu ! \n");

                    while (subtrigger) {
                        System.out.println("1. ");
                        System.out.println("2. ");
                        System.out.println("3. ");
                        System.out.println("4. ");
                        System.out.println("5. ");
                        System.out.println("0.  Return to main menu ");

                        choice = DataReader.readIntNumber();
                        switch (choice) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 0:
                                subtrigger = false;
                                break;

                            default:
                                System.out.println(Message.ERROR_INPUT_MESSAGE);
                        }
                    }
                    break;

                case 5:
                    System.out.println("\nWheels (set and remove) menu ! \n");

                    while (subtrigger) {
                        System.out.println("1. ");
                        System.out.println("2. ");
                        System.out.println("3. ");
                        System.out.println("4. ");
                        System.out.println("5. ");
                        System.out.println("0.  Return to main menu ");

                        choice = DataReader.readIntNumber();
                        switch (choice) {
                            case 1:
                                break;
                            case 2:
                                break;
                            case 3:
                                break;
                            case 4:
                                break;
                            case 5:
                                break;
                            case 0:
                                subtrigger = false;
                                break;

                            default:
                                System.out.println(Message.ERROR_INPUT_MESSAGE);
                        }
                    }
                    break;

                case 6:
                case 7:
                case 8:
                case 9:
                case 0:
                    //  Show all info about car

                    System.out.println("\nShow all info about car ");


                    break;

                default:
                    System.out.println(Message.ERROR_INPUT_MESSAGE);
            }

        }

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


    private boolean checkOut(int choice) {

        if (choice > car.getNumberOfDoors()) {
            System.out.println("\nУ нас нет так много дверей!");
            System.out.println("Их в этой модели машины всего  " + car.getNumberOfDoors());
            return false;
        }
        if (choice == 0) {
            System.out.print("\nНу, хоть одна дверь у машины должна же быть!  На планете Земля так принято... :) ");
            return false;
        }
        if (choice <= 0) {
            System.out.println();
            System.out.println(Message.ARE_YOU_SURE);
            System.out.print("Где вы видели такую машину?!  У этой двери самые обычные, и находятся на обычных местах.");
            return false;
        }
        return true;
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

