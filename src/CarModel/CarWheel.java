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
        this.tireIntegrity = tireIntegrity;
        if (this.tireIntegrity < 0) {this.tireIntegrity = 0.00;}
        if (this.tireIntegrity > 1) {this.tireIntegrity = 1.00;}
    }

    public void changeTireToNewOne() {
        setTireIntegrity(1.00);
    }

    public void wipeTheTire(double percentToWipeTheTire) throws Exception {

        if (percentToWipeTheTire < 0) {percentToWipeTheTire = 0.00;}

        double percentValue = (getTireIntegrity() - percentToWipeTheTire);

        if (percentValue < 0) {percentValue = 0.00;}
        else {
            if (percentValue > 1) {percentValue = 1.00;}
        }

        setTireIntegrity(percentValue);
    }


}

