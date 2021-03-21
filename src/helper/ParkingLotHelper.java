package helper;

import entity.Car;
import entity.CarSlot;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotHelper {

    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private ParkingLotHelper() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }
    public static List<String>  getListOfRegistrationNumberForDriverWithGivenAge(CarSlot []carSlots, int age) {
        List<String> registrationNumber = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                registrationNumber.add(carSlot.getAllocatedCar().getVehicleRegistrationNumber());
            }
        }
        return registrationNumber;
    }

    public static int getSlotNumberOfGivenCarRegistrationNumber(CarSlot []carSlots,String registrationNumber) {
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getVehicleRegistrationNumber().equals(registrationNumber)) {
                return carSlot.getCarSlotID();
            }
        }
        return -1;
    }

    public static List<Integer> getListOfSlotNumbersWithGivenDriverAge (CarSlot []carSlots,int age) {
        List<Integer> slotNumbersWithGivenAge = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                slotNumbersWithGivenAge.add(carSlot.getCarSlotID());
            }
        }
        return slotNumbersWithGivenAge;
    }

    public static void allocateParkingSlotToCar(CarSlot []carSlots, Car car, int nearestAvailableSlot) {
        if(nearestAvailableSlot> -1) {
            carSlots[nearestAvailableSlot-1].addCarToTheCarSlot(car,nearestAvailableSlot);
            System.out.println(ValidationMessages.getAllocateParkingSuccessMessage(car.getVehicleRegistrationNumber(),nearestAvailableSlot)) ;
        }
        else{
            System.out.println( ValidationMessages.SLOTS_FULL_VALIDATION_MESSAGE );
        }
    }

    public static void clearParkingSlot(CarSlot[] carSlots, int slotID) {
        try {
            CarSlot carSlot = carSlots[slotID-1];
            String successMessage = ValidationMessages.getClearParkingLotSuccessMessage(slotID,carSlot.getAllocatedCar().getVehicleRegistrationNumber(),carSlot.getAllocatedCar().getAgeOfDriver());
            carSlot.removeCarFromCarSlot();
            System.out.println(successMessage);
        }
        catch(Exception ex) {
            System.out.println(ValidationMessages.CLEAR_PARKING_SLOT_ERROR_MESSAGE) ;
        }
    }
}
