package helper;

import entity.ParkingLot;

import java.util.List;

public class ParkingActionHelper {
    public static String performAction(ParkingLot parkingLot, String[] actions ) {
        String actionResult = "";
        switch (actions[0]) {
            case ParkingActionTypes.PARK : actionResult = parkingLot.allocateParkingSlotToCar(actions[1],Integer.parseInt(actions[3]));
                break;
            case ParkingActionTypes.SLOT_NUMBERS_FOR_DRIVER_OF_AGE:
                actionResult = getListOfSlotNumbersWithGivenDriverAge(parkingLot,Integer.parseInt(actions[1]));
                break;
            case ParkingActionTypes.SLOT_NUMBER_FOR_CAR_WITH_NUMBER:
                actionResult = String.valueOf(parkingLot.getSlotNumberOfGivenCarRegistrationNumber(actions[1]));
                break;
            case ParkingActionTypes.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE:
                actionResult = getListOfRegistrationNumberForDriverWithGivenAge(parkingLot,Integer.parseInt(actions[1]));
                break;
            case ParkingActionTypes.LEAVE : actionResult = parkingLot.clearParkingSlot(Integer.parseInt(actions[1]));
                break;
            default:actionResult = ValidationMessages.INVALID_INPUT_ERROR;
        }
        return actionResult;
    }

    private static String getListOfSlotNumbersWithGivenDriverAge(ParkingLot parkingLot, int driverAge) {
        List<Integer> listOfSlotNumbersWithGivenDriverAge =  parkingLot.getListOfSlotNumbersWithGivenDriverAge(driverAge);
        return  CommonHelper.convertIntegerListToCommaSeparatedString(listOfSlotNumbersWithGivenDriverAge);
    }

    private static String getListOfRegistrationNumberForDriverWithGivenAge(ParkingLot parkingLot, int driverAge) {
        List<String> listOfRegistrationNumberForDriverWithGivenAge = parkingLot.getListOfRegistrationNumberForDriverWithGivenAge(driverAge);
        return CommonHelper.convertStringListToCommaSeparatedString(listOfRegistrationNumberForDriverWithGivenAge);
    }
}

