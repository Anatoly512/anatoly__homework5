package CarModel;

public class Car {

    private static int numberOfDoors;
    private int numberOfWheels = 4;
    private int passangerCapacity;
    private int currentNumberOfPassangers = 1;
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
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = Message.UNKNOWN_DATE;
        this.passangerCapacity = 10;
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

    Car(int numberOfDoors, String dateOfManufacture, int passangerCapacity, String EngineType) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = dateOfManufacture;
        this.passangerCapacity = passangerCapacity;
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

    Car(int numberOfDoors, int passangerCapacity, String EngineType) {
        Car.numberOfDoors = numberOfDoors;
        this.DateOfManufacture = Message.UNKNOWN_DATE;
        this.passangerCapacity = passangerCapacity;
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
        Car.numberOfDoors = 4;
        this.DateOfManufacture = dateOfManufacture;
        this.passangerCapacity = 5;
        this.currentNumberOfPassangers = 0;   //  Машина пуста (вдруг её надо подарить, или продать), в других вариантах в ней есть водитель
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


    //  Здесь пошли методы для работы с полями объекта car  (включая массивы дверей/окон и шин)


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


    public void showStatusDoor(int number) {

        this.door[number].showStatusTheDoorAndTheWindow(number);

    }


    public String getStringDateOfManufacture() {

        return this.DateOfManufacture;

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


    public int getCurrentNumberOfPassangers() {
        return this.currentNumberOfPassangers;
    }

    public int getPassangerCapacity() {
        return this.passangerCapacity;
    }

    public void setPassangerCapacity (int passangerCapacity) {
        this.passangerCapacity = passangerCapacity;
    }


    public boolean addOnePassenger() {
        if (this.currentNumberOfPassangers == this.passangerCapacity) {return false;}

        this.currentNumberOfPassangers++;
        return true;
    }

    public void subOnePassenger() {
        this.currentNumberOfPassangers--;
        if  (this.currentNumberOfPassangers < 0) {this.currentNumberOfPassangers = 0;}
    }

    public void subAllPassengers() {
        this.currentNumberOfPassangers = 0;
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
                this.currentSpeed = 0;   //  Считается что смена двигателя требует остановки машины
    }


}

