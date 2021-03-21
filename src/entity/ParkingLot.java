package entity;


import helper.ValidationMessages;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


public class ParkingLot {
    private int noOfSlot;
    private CarSlot[] carSlots;
    private TreeSet<Integer> availableSlot;

    public ParkingLot(int noOfSlot) {
        this.noOfSlot = noOfSlot;
        this.carSlots = new CarSlot[noOfSlot];
        for(int i=0;i<noOfSlot;i++) {
            carSlots[i] = new CarSlot(i+1);
        }
        this.availableSlot = new TreeSet<>();
        //When creating new Parking lot object, All the parking slots are available.
        for(int i=0; i< noOfSlot; i++) {
            availableSlot.add(i+1);
        }
    }

    public String allocateParkingSlotToCar(String vehicleRegistrationNo, int ageOfDriver) {
        Car car = new Car(vehicleRegistrationNo,ageOfDriver);
        int nearestAvailableSlot = findAndRemoveNearestAvailableSlot();
        if(nearestAvailableSlot> -1) {
            carSlots[nearestAvailableSlot-1].addCarToTheCarSlot(car,nearestAvailableSlot);
            return ValidationMessages.getAllocateParkingSuccessMessage(vehicleRegistrationNo,nearestAvailableSlot);
        }
        else{
            return ValidationMessages.SLOTS_FULL_VALIDATION_MESSAGE;
        }
    }

    int findAndRemoveNearestAvailableSlot() {
        return (availableSlot!=null && !availableSlot.isEmpty()) ? availableSlot.pollFirst() : -1;
    }

    public List<String> getListOfRegistrationNumberForDriverWithGivenAge(int age) {
        List<String> registrationNumber = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                registrationNumber.add(carSlot.getAllocatedCar().getVehicleRegistrationNumber());
            }
        }
        return registrationNumber;
    }

    public int getSlotNumberOfGivenCarRegistrationNumber(String registrationNumber) {
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getVehicleRegistrationNumber().equals(registrationNumber)) {
                return carSlot.getCarSlotID();
            }
        }
        return -1;
    }

    public List<Integer> getListOfSlotNumbersWithGivenDriverAge (int age) {
        List<Integer> slotNumbersWithGivenAge = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                slotNumbersWithGivenAge.add(carSlot.getCarSlotID());
            }
        }
        return slotNumbersWithGivenAge;
    }

    public String clearParkingSlot(int slotID) {
        try {
            CarSlot carSlot = carSlots[slotID-1];
            String successMessage = ValidationMessages.getClearParkingLotSuccessMessage(slotID,carSlot.getAllocatedCar().getVehicleRegistrationNumber(),carSlot.getAllocatedCar().getAgeOfDriver());
            availableSlot.add(slotID);
            carSlot.removeCarFromCarSlot();
            return  successMessage;
        }
        catch(Exception ex) {
            return ValidationMessages.CLEAR_PARKING_SLOT_ERROR_MESSAGE;
        }

    }

}
