package CarModel;

public class Car {

    private int numberOfDoors;
    private int numberOfWheels = 4;
    private int passengerCapacity;
    private int currentNumberOfPassengers = 1;
    private String EngineType;
    private int maxSpeed;
    private int maxSpeedPossible;
    private int currentSpeed;
    private double accelerationTimeTo100km;
    private boolean isOpenDoor;
    private boolean isOpenWindow;
    private final String DateOfManufacture;

    CarDoor[] door;
    CarWheel[] wheel;


    Car(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = Message.UNKNOWN_DATE;
        this.passengerCapacity = 10;
        this.EngineType = Message.ENGINE_USUAL;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
        {
           if (this.EngineType.equals(Message.ENGINE_USUAL)) {
               this.maxSpeed = 150;
               this.accelerationTimeTo100km = 5.7;
           }
           else if (this.EngineType.equals(Message.ENGINE_SPORTCAR)) {
               this.maxSpeed = 270;
               this.accelerationTimeTo100km = 2.8;
           }
           else if (this.EngineType.equals(Message.ENGINE_TANK)) {
               this.maxSpeed = 1000;
               this.accelerationTimeTo100km = 0.02;
           }
        }
    }

    Car(int numberOfDoors, String dateOfManufacture, int passengerCapacity, String EngineType) {
        this.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = dateOfManufacture;
        this.passengerCapacity = passengerCapacity;
        this.EngineType = EngineType;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
        {
            if (this.EngineType.equals(Message.ENGINE_USUAL)) {
                this.maxSpeed = 150;
                this.accelerationTimeTo100km = 5.7;
            }
            else if (this.EngineType.equals(Message.ENGINE_SPORTCAR)) {
                this.maxSpeed = 270;
                this.accelerationTimeTo100km = 2.8;
            }
            else if (this.EngineType.equals(Message.ENGINE_TANK)) {
                this.maxSpeed = 1000;
                this.accelerationTimeTo100km = 0.02;
            }
        }
    }

    Car(int numberOfDoors, int passengerCapacity, String EngineType) {
        this.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = Message.UNKNOWN_DATE;
        this.passengerCapacity = passengerCapacity;
        this.EngineType = EngineType;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
        {
            if (this.EngineType.equals(Message.ENGINE_USUAL)) {
                this.maxSpeed = 150;
                this.accelerationTimeTo100km = 5.7;
            }
            else if (this.EngineType.equals(Message.ENGINE_SPORTCAR)) {
                this.maxSpeed = 270;
                this.accelerationTimeTo100km = 2.8;
            }
            else if (this.EngineType.equals(Message.ENGINE_TANK)) {
                this.maxSpeed = 1000;
                this.accelerationTimeTo100km = 0.02;
            }
        }
    }

    Car(String dateOfManufacture) {
        this.numberOfDoors = 4;
        this.DateOfManufacture = dateOfManufacture;
        this.passengerCapacity = 5;
        this.currentNumberOfPassengers = 0;   //  Машина пуста (вдруг её надо подарить, или продать), в других вариантах в ней есть водитель
        this.EngineType = Message.ENGINE_SPORTCAR;
        this.door = new CarDoor[numberOfDoors];
        this.wheel = new CarWheel[this.numberOfWheels];
        {
            if (this.EngineType.equals(Message.ENGINE_USUAL)) {
                this.maxSpeed = 150;
                this.accelerationTimeTo100km = 5.7;
            }
            else if (this.EngineType.equals(Message.ENGINE_SPORTCAR)) {
                this.maxSpeed = 270;
                this.accelerationTimeTo100km = 2.8;
            }
            else if (this.EngineType.equals(Message.ENGINE_TANK)) {
                this.maxSpeed = 1000;
                this.accelerationTimeTo100km = 0.02;
            }
        }
    }


        public void carLaunch() {

            statusDoorsAndWindowsChoose();   //  определение статуса дверей и окон :  закрыты или открыты


            for (int i = 0; i < this.numberOfWheels; i++) {

                this.wheel[i] = new CarWheel();   //    создание массива колес,  конструктор пустой

            }

            this.maxSpeedPossible = this.maxSpeed;  //  Так как шины пока все новые, то и скорость максимальная


        }


        private void wheelsChangeNumber(int newNumberOfWheels) {

            if (newNumberOfWheels < 0) {newNumberOfWheels = 0;}
            if (newNumberOfWheels > 100) {newNumberOfWheels = 100;}

            CarWheel[] wheel = new CarWheel[this.numberOfWheels];    //  Создание резервной копии массива колес

            for (int i = 0; i < this.numberOfWheels; i++) {
                wheel[i] = this.wheel[i];                     //  Заполнение резервной копии из основного массива колес
            }

            this.wheel = new CarWheel[newNumberOfWheels];    //  Переинициализация массива колес, нового размера


            if (newNumberOfWheels < this.numberOfWheels)  {   //  убрать элементы в массиве

                for (int i = 0; i < newNumberOfWheels; i++) {

                    this.wheel[i] = new CarWheel();   //    создание нового массива колес (меньшего размера)
                    this.wheel[i] = wheel[i];         //    заполнение значениями из ранее созданной копии

                }

            }

            else {

                if (newNumberOfWheels > this.numberOfWheels) {  //  добавить элементы в массиве

                    for (int i = 0; i < newNumberOfWheels; i++) {

                        this.wheel[i] = new CarWheel();   //    создание нового массива колес (большего размера)
                        if (i < this.numberOfWheels) {
                            this.wheel[i] = wheel[i];     //    заполнение значениями из ранее созданной копии
                        }
                    }
                }
            }

            this.numberOfWheels = newNumberOfWheels;    //  новое количество колес сохранено

        }




        private void statusDoorsAndWindowsChoose() {

            //  Заполнение массива дверей и окон  (пользователь назначает им статус :  закрыты или открыты)

            for (int i = 0; i < numberOfDoors; i++) {

                chooseStatusDoor(i);    //  returns isOpenDoor
                chooseStatusWindow(i);   //  returns isOpenWindow

                this.door[i] = new CarDoor(isOpenDoor, isOpenWindow);      //  передача в конструктор дверей параметров

            }


            //  Просмотр статуса дверей и окон

            for (int i = 0; i < numberOfDoors; i++) {

                this.door[i].showStatusTheDoorAndTheWindow(i);

            }

        }


        private int choiceIfDoorOrWindowOpen () {
            boolean trigger = true;
            int choice = 0;

            while (trigger) {
                choice = DataReader.readIntNumber();
                if (choice < 1 || choice > 2) {
                    System.out.print(Message.INPUT_ONE_OR_TWO);
                    trigger = true;
                } else trigger = false;
            }

            return choice;
        }

        private void chooseStatusDoor ( int number){
            System.out.println(Message.INPUT_DOORS + (number + 1) + Message.SYMBOL_COLON);
            System.out.print(Message.INPUT_OPEN_CLOSED);

            if (choiceIfDoorOrWindowOpen() == 1) {
                isOpenDoor = true;
            } else {
                isOpenDoor = false;
            }

        }

        private void chooseStatusWindow ( int number){
            System.out.println(Message.INPUT_WINDOWS + (number + 1) + Message.SYMBOL_COLON);
            System.out.print(Message.INPUT_OPEN_CLOSED);

            if (choiceIfDoorOrWindowOpen() == 1) {
                isOpenWindow = true;
            } else {
                isOpenWindow = false;
            }

        }


    //  Здесь пошли методы для работы с полями объекта Car  (включая массивы дверей/окон, шин и т.д.)


    public int getNumberOfDoors() {
        return this.numberOfDoors;
    }


    public void showStatusDoorAndWindow(int number) {
        this.door[number].showStatusTheDoorAndTheWindow(number);
    }


    public void showAllDoorsAndWindowsStatus() {

        int counter = this.numberOfDoors;

        for (int i = 0; i < counter; i++) {                           //  Просмотр состояния дверей и окон
            this.door[i].showStatusTheDoorAndTheWindow(i); }
    }


    public void openTheDoor(int number) {
        this.door[number].openTheDoor();
    }

    public void closeTheDoor(int number) {
        this.door[number].closeTheDoor();
    }

    public void openTheWindow(int number) {
        this.door[number].openTheWindow();
    }

    public void closeTheWindow(int number) {
        this.door[number].closeTheWindow();
    }

    public void openOrCloseTheDoor(int number) {
        this.door[number].openOrCloseTheDoor();
    }

    public void openOrCloseTheWindow(int number) {
        this.door[number].openOrCloseTheWindow();
    }


    public boolean getStatusDoor(int number) {

        return this.door[number].getStatusDoor();

    }

    public boolean getStatusWindow(int number) {

        return this.door[number].getStatusWindow();

    }


    public String getStringStatusDoor(int number) {

        return this.door[number].getStringStatusDoor();

    }

    public String getStringStatusWindow(int number) {

        return this.door[number].getStringStatusWindow();

    }


    public int getNumberOfWheels() {
        return this.numberOfWheels;
    }

    public double getWheelTireIntegrity(int number) {
        return this.wheel[number].getTireIntegrity();
    }

    public void changeWheelTireToNewOne(int number) {
        this.wheel[number].changeTireToNewOne();
    }

    public void wipeTheWheelTire(int number, double ValueToWipeTheTire) {
        this.wheel[number].wipeTheTire(ValueToWipeTheTire);
    }

    public void wipeTheWheelTire(int number, int percentToWipeTheTire) {     //  Перегрузка, можно передавать число (насколько стереть шину)
        this.wheel[number].wipeTheTire(percentToWipeTheTire);                //  и в виде процентов, и в виде готового double значения
    }

    public void setNumberOfWheels(int number) {

        if (number < 0) {number = 0;}
        if (number > 100) {number = 100;}

        wheelsChangeNumber(number);

    }


    public int getCurrentNumberOfPassengers() {
        return this.currentNumberOfPassengers;
    }

    public int getPassengerCapacity() {
        return this.passengerCapacity;
    }

    public void setPassengerCapacity (int passengerCapacity) {

        if (passengerCapacity < 0) {
            System.out.println("\nWe could'n even imagine such a car!!!");
            System.out.println("So, we install one passenger chair only for you!");
            passengerCapacity = 1;
        }
        if (passengerCapacity == 0) {
            System.out.println("\nOh, you want a dron instead car?!   OK! ");
            System.out.println("Elon Musk, it's you? :) :) ");
        }
        if (passengerCapacity > 100) {
            System.out.println("\n" + Message.ARE_YOU_SURE);
            System.out.println("It's not a train! :) ");
            passengerCapacity = 100;
        }

        this.passengerCapacity = passengerCapacity;

        if (this.currentNumberOfPassengers > this.passengerCapacity) {
            this.currentNumberOfPassengers = this.passengerCapacity;
            int a = (int) (Math.random() * (4-2) ) + 2;
            System.out.print("Пришлось высадить часть пассажиров. ");
            System.out.println("Мы оставили им запасной аккумулятор и " + a + " гаечных ключа.");
        }
    }


    public boolean addOnePassenger() {
        if (this.currentNumberOfPassengers == this.passengerCapacity) {
            System.out.println("\nБольше не влазит! :) ");
            return false;
        }

        if (this.currentNumberOfPassengers > this.passengerCapacity) {
            this.currentNumberOfPassengers = this.passengerCapacity;
            return true;
        }

        this.currentNumberOfPassengers++;
        return true;
    }

    public void subOnePassenger() {
        if  (this.currentNumberOfPassengers == 0) {
            System.out.println("\nНекого высаживать! ");
            System.out.println("Мы можем выкинуть двигатель! :) ");
            return;
        }
        this.currentNumberOfPassengers--;
        if  (this.currentNumberOfPassengers < 0) {this.currentNumberOfPassengers = 0;}

        if (this.currentNumberOfPassengers > this.passengerCapacity) {
            this.currentNumberOfPassengers = this.passengerCapacity;
        }
    }

    public void subAllPassengers() {
        this.currentNumberOfPassengers = 0;
    }


    public String getStringDateOfManufacture() {

        return this.DateOfManufacture;

    }


    public int getMaxSpeed() {
        return this.maxSpeed;
    }

    public int getCurrentSpeed() {
        return this.currentSpeed;
    }

    public void setCurrentSpeed(int currentSpeed) {
        int maxSpeedPossible = getMaxSpeedPossible();

        if (currentSpeed > getMaxSpeed()) {
            currentSpeed = maxSpeedPossible;
            System.out.println(Message.SPEED_SORRY);
            System.out.print(Message.SPEED_MAX + this.maxSpeed + Message.SPEED_KM);
            System.out.println(Message.SPEED_FORWARD_BACK);
        }
        else {
            if (currentSpeed < 0) {  // Здесь нужно ограничить отрицательную скорость теми же значениями
                currentSpeed = -(currentSpeed);
                if (currentSpeed > getMaxSpeed()) {
                    currentSpeed = maxSpeedPossible;
                    System.out.println(Message.SPEED_SORRY);
                    System.out.print(Message.SPEED_MAX + this.maxSpeed + Message.SPEED_KM);
                    System.out.println(Message.SPEED_FORWARD_BACK);
                }
                if (currentSpeed > maxSpeedPossible) {
                    currentSpeed = maxSpeedPossible;
                    System.out.println(Message.SPEED_TIRES);
                    System.out.println(Message.SPEED_POSSIBLE + (-maxSpeedPossible) + Message.SPEED_KM);
                }
                currentSpeed = -(currentSpeed);
            }
        }

        if (currentSpeed > maxSpeedPossible)
        {
            System.out.println(Message.SPEED_TIRES);
            System.out.println(Message.SPEED_POSSIBLE + maxSpeedPossible + Message.SPEED_KM);

            currentSpeed = maxSpeedPossible;
        }

        System.out.println(Message.SPEED_CURRENT + currentSpeed + Message.SPEED_KM);

        this.currentSpeed = currentSpeed;

    }


    public double getAccelerationTimeTo100km() {
        return this.accelerationTimeTo100km;
    }


    public int getMaxSpeedPossible() {    //  макс. стертая шина * maxSpeed

        this.maxSpeedPossible = (int) (findMaxWipedTire() * this.maxSpeed);

        return this.maxSpeedPossible;
    }

    public double findMaxWipedTire() {   //  Наиболее стертая шина
        double maxWipedTire = 1.0;
        double number;

        for (int i = 0; i < this.numberOfWheels; i++) {       //  Поиск наименьшего значения в массиве колес
            number = getWheelTireIntegrity(i);
            if (number < maxWipedTire) { maxWipedTire = number; }
        }

        return maxWipedTire;
    }


    public String getEngineType() {
        return this.EngineType;
    }

    public void setEngineType(String EngineType) {

        switch (EngineType) {
            case Message.ENGINE_USUAL:
                break;
            case Message.ENGINE_SPORTCAR:
                break;
            case Message.ENGINE_TANK:
                break;
            default: {
                System.out.println("Какой-то незнакомый тип двигателя.  Вряд ли его удастся установить.");
                return;
            }
        }

        this.EngineType = EngineType;

        switch (this.EngineType) {
            case Message.ENGINE_USUAL:
                this.maxSpeed = 150;
                this.accelerationTimeTo100km = 5.7;
                break;
            case Message.ENGINE_SPORTCAR:
                this.maxSpeed = 270;
                this.accelerationTimeTo100km = 2.8;
                break;
            case Message.ENGINE_TANK:
                this.maxSpeed = 1000;
                this.accelerationTimeTo100km = 0.02;
                break;
        }
                this.currentSpeed = 0;   //  Смена двигателя требует остановки машины
    }


}

