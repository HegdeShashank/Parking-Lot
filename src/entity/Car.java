package entity;

public class Car {
    private String vehicleRegistrationNumber;
    private int ageOfDriver;
    Car( String vehicleRegistrationNumber, int ageOfDriver) {
        this.ageOfDriver = ageOfDriver;
        this.vehicleRegistrationNumber = vehicleRegistrationNumber;
    }
    public String getVehicleRegistrationNumber() {
        return vehicleRegistrationNumber;
    }

    public int getAgeOfDriver() {
        return ageOfDriver;
    }

}
