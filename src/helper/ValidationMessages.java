package helper;

public class ValidationMessages {

    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private ValidationMessages() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    public static final String CLEAR_PARKING_SLOT_ERROR_MESSAGE = "Error in clear parking slot";
    public static final String SLOTS_FULL_VALIDATION_MESSAGE = "All slots are full, cannot park new vehicle";
    public static final String INVALID_INPUT_ERROR_MESSAGE = "There is an error in provided input. Please correct it";
    public static final String INVALID_REGISTRATION_NUM_ERROR_MESSAGE = "No slot found for the provided registration number. Please check the registration number.";

    public static String getClearParkingLotSuccessMessage(int slotID, String registrationNumber,int age) {
        return "Slot number "+slotID+ " vacated, the car with vehicle registration number \""+registrationNumber+"\" left the space, the driver of the car was of age "+age;
    }

    public static String getAllocateParkingSuccessMessage(String vehicleRegistrationNo, int nearestAvailableSlot) {
        return "Car with vehicle registration number \""+vehicleRegistrationNo+"\" has been parked at slot number "+nearestAvailableSlot;
    }

    public static String getCreateParkingSuccessMessage(int noOfSlots) {
        return "Created parking of "+noOfSlots+" slots";
    }

}
