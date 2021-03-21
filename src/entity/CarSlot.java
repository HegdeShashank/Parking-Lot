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

    /**
     * This function add car, Once car is added isAllocated variable set to true, automatically.
     * @param car - The car object which need sbe added to the slot.
     */
    public void addCarToTheCarSlot(Car car) {
        this.allocatedCar = car;
        this.isAllocated = true;
    }

    /**
     * This function reset the allocated car object to null, and make isAllocated variable to false.
     */
    public void removeCarFromCarSlot() {
        this.isAllocated = false;
        this.allocatedCar = null;
    }

}
