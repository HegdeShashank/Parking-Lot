package helper;

public class ParkingActionTypes {
    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private ParkingActionTypes() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }
    public static final String PARK = "Park";
    public static final String SLOT_NUMBERS_FOR_DRIVER_OF_AGE = "Slot_numbers_for_driver_of_age";
    public static final String SLOT_NUMBER_FOR_CAR_WITH_NUMBER = "Slot_number_for_car_with_number";
    public static final String VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE = "Vehicle_registration_number_for_driver_of_age";
    public static final String LEAVE = "Leave";
}
