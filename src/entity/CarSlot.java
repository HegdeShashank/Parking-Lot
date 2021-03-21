package entity;

public class CarSlot {

    private int carSlotID;
    private Car allocatedCar;
    private boolean isAllocated;

    CarSlot(int carSlotID) {
        this.carSlotID = carSlotID;
    }

    public int getCarSlotID() {
        return carSlotID;
    }

    public Car getAllocatedCar() {
        return allocatedCar;
    }

    public boolean isAllocated() {
        return isAllocated;
    }

    public void addCarToTheCarSlot(Car car, int carSlotID) {
        this.carSlotID = carSlotID;
        this.allocatedCar = car;
        this.isAllocated = true;
    }

    public void removeCarFromCarSlot() {
        this.isAllocated = false;
        this.allocatedCar = null;
    }

}
