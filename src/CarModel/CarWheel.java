package CarModel;

public class CarWheel {

    private double tireIntegrity;

    CarWheel() {
        this.tireIntegrity = 1.00;
    }

    CarWheel(double tireIntegrity) {
        this.tireIntegrity = tireIntegrity;
    }


    public double getTireIntegrity() {
        return this.tireIntegrity;
    }


    private void setTireIntegrity(double tireIntegrity) {
        tireIntegrity = DataReader.aRoundDouble(tireIntegrity, 2);        //  Округлить до 2-х знаков после запятой

        if (tireIntegrity < 0) {tireIntegrity = 0.00;}
        if (tireIntegrity > 1) {tireIntegrity = 1.00;}

        this.tireIntegrity = tireIntegrity;
    }


    public void changeTireToNewOne() {
        setTireIntegrity(1.00);
    }


    public void wipeTheTire(double ValueDoubleToWipeTheTire) {

        if (ValueDoubleToWipeTheTire < 0) {ValueDoubleToWipeTheTire = 0.00;}
        if (ValueDoubleToWipeTheTire > 1) {ValueDoubleToWipeTheTire = 1.00;}

        double percentValue = (getTireIntegrity() - ValueDoubleToWipeTheTire);

        if (percentValue < 0) {percentValue = 0.00;}
        else {
            if (percentValue > 1) {percentValue = 1.00;}
        }

        setTireIntegrity(percentValue);
    }


    public void wipeTheTire(int percentToWipeTheTire) {

        if (percentToWipeTheTire < 0) {percentToWipeTheTire = 0;}
        if (percentToWipeTheTire > 100) {percentToWipeTheTire = 100;}

        double percentValue = (double) percentToWipeTheTire / 100;

        percentValue = (getTireIntegrity() - percentValue);

        if (percentValue < 0) {percentValue = 0.00;}
        else {
            if (percentValue > 1) {percentValue = 1.00;}
        }

        setTireIntegrity(percentValue);
    }



}

