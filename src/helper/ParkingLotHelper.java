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

    /**
     * This function gets the list of registration numbers of all the car for which the driver is of given age.
     * @param carSlots - All the car slots in he parking lot.
     * @param age - age of the car driver
     * @return - List of slot of all the registration numbers that are parked for which the driver is of given age.
     */
    public static List<String>  getListOfRegistrationNumberForDriverWithGivenAge(CarSlot []carSlots, int age) {
        List<String> registrationNumber = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                registrationNumber.add(carSlot.getAllocatedCar().getVehicleRegistrationNumber());
            }
        }
        return registrationNumber;
    }

    /**
     * This will return slot Number of parking lot which has car of given registration number
     * @param carSlots - All the car slots in he parking lot.
     * @param registrationNumber - age of the car driver
     * @return - Slot Number of parking lot which has car of given registration number. -1 if No vehicle found.
     */
    public static int getSlotNumberOfGivenCarRegistrationNumber(CarSlot []carSlots,String registrationNumber) {
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getVehicleRegistrationNumber().equals(registrationNumber)) {
                return carSlot.getCarSlotID();
            }
        }
        return -1;
    }

    /**
     *This function gets the list of slot of all the car that are parked for which the driver is of given age.
     * @param carSlots - All the car slots in he parking lot.
     * @param age - age of the car driver
     * @return - List of slot of all the car that are parked for which the driver is of given age.
     */
    public static List<Integer> getListOfSlotNumbersWithGivenDriverAge (CarSlot []carSlots,int age) {
        List<Integer> slotNumbersWithGivenAge = new ArrayList<>();
        for (CarSlot carSlot : carSlots) {
            if (carSlot.isAllocated() && carSlot.getAllocatedCar().getAgeOfDriver() == age) {
                slotNumbersWithGivenAge.add(carSlot.getCarSlotID());
            }
        }
        return slotNumbersWithGivenAge;
    }

    /**
     * This function add the car to nearest available slot.
     * @param carSlots - All the car slots in he parking lot.
     * @param car - Car that needs to be added in parking lot.
     * @param nearestAvailableSlot - nearest available slot where car can be added/
     */
    public static void allocateParkingSlotToCar(CarSlot []carSlots, Car car, int nearestAvailableSlot) {
        if(nearestAvailableSlot> -1) {
            carSlots[nearestAvailableSlot-1].addCarToTheCarSlot(car);
            System.out.println(ValidationMessages.getAllocateParkingSuccessMessage(car.getVehicleRegistrationNumber(),nearestAvailableSlot)) ;
        }
        else{
            System.out.println( ValidationMessages.SLOTS_FULL_VALIDATION_MESSAGE );
        }
    }

    /**
     * This function removes car from give slot of the parking lot.
     * @param carSlots - All the car slots in he parking lot.
     * @param slotID - ID of the slot in parking lo.
     */
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
