package helper;

import entity.ParkingLot;

import java.util.List;

public class ParkingActionHelper {

    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private ParkingActionHelper() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    /**
     *This function perform some actions like parking, getting driver info, clear parking slot etc. And also this function logs
     * corresponding logging messages.
     * @param parkingLot - Parking Lot object which has been already created, for which some actions needs to be done.
     * @param actionsParams - This consists of action (First element) and corresponding parameters.
     */
    public static void performAction(ParkingLot parkingLot, String[] actionsParams ) {
        String action = actionsParams[0];
        switch (action) {
            case ParkingActionTypes.PARK :
                parkingLot.allocateParkingSlotToCar(actionsParams[1],Integer.parseInt(actionsParams[3]));
                break;
            case ParkingActionTypes.SLOT_NUMBERS_FOR_DRIVER_OF_AGE:
                printListOfSlotNumbersWithGivenDriverAge(parkingLot,actionsParams);
                break;
            case ParkingActionTypes.SLOT_NUMBER_FOR_CAR_WITH_NUMBER:
                printSlotNumberOfGivenCarRegistrationNumber(parkingLot,actionsParams);
                break;
            case ParkingActionTypes.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE:
                printListOfRegistrationNumberForDriverWithGivenAge(parkingLot,actionsParams);
                break;
            case ParkingActionTypes.LEAVE :
                parkingLot.clearParkingSlot(Integer.parseInt(actionsParams[1]));
                break;
            default:System.out.println(ValidationMessages.INVALID_INPUT_ERROR_MESSAGE);
        }
    }

    //Prints comma separated slot numbers that consists of car with given driver age.
    private static void printListOfSlotNumbersWithGivenDriverAge(ParkingLot parkingLot, String[] actionParams) {
        int driverAge = Integer.parseInt(actionParams[1]);
        List<Integer> listOfSlotNumbersWithGivenDriverAge =  parkingLot.getListOfSlotNumbersWithGivenDriverAge(driverAge);
        System.out.println(CommonHelper.convertIntegerListToCommaSeparatedString(listOfSlotNumbersWithGivenDriverAge));
    }

    //Prints comma separated registration numbers of the cars that consists of car with given driver age.
    private static void printListOfRegistrationNumberForDriverWithGivenAge(ParkingLot parkingLot, String[] actionParams) {
        int driverAge = Integer.parseInt(actionParams[1]);
        List<String> listOfRegistrationNumberForDriverWithGivenAge = parkingLot.getListOfRegistrationNumberForDriverWithGivenAge(driverAge);
        System.out.println(CommonHelper.convertStringListToCommaSeparatedString(listOfRegistrationNumberForDriverWithGivenAge)) ;
    }

    // Print slot number of the car, for given registration number.
    private static void printSlotNumberOfGivenCarRegistrationNumber(ParkingLot parkingLot,String[] actionParams ) {
        String registrationNumber = actionParams[1];
        int slotNum = parkingLot.getSlotNumberOfGivenCarRegistrationNumber(registrationNumber);
        System.out.println(slotNum == -1 ? ValidationMessages.INVALID_REGISTRATION_NUM_ERROR_MESSAGE:slotNum);
    }
}

