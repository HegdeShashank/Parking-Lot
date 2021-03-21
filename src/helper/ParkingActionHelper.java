package helper;

import entity.ParkingLot;

import java.util.List;

public class ParkingActionHelper {
    public static void performAction(ParkingLot parkingLot, String[] actions ) {
        switch (actions[0]) {
            case ParkingActionTypes.PARK :
                parkingLot.allocateParkingSlotToCar(actions[1],Integer.parseInt(actions[3]));
                break;
            case ParkingActionTypes.SLOT_NUMBERS_FOR_DRIVER_OF_AGE:
                printListOfSlotNumbersWithGivenDriverAge(parkingLot,Integer.parseInt(actions[1]));
                break;
            case ParkingActionTypes.SLOT_NUMBER_FOR_CAR_WITH_NUMBER:
                printSlotNumberOfGivenCarRegistrationNumber(parkingLot,actions[1]);
                break;
            case ParkingActionTypes.VEHICLE_REGISTRATION_NUMBER_FOR_DRIVER_OF_AGE:
                printListOfRegistrationNumberForDriverWithGivenAge(parkingLot,Integer.parseInt(actions[1]));
                break;
            case ParkingActionTypes.LEAVE :
                parkingLot.clearParkingSlot(Integer.parseInt(actions[1]));
                break;
            default:System.out.println(ValidationMessages.INVALID_INPUT_ERROR);
        }
    }

    private static void printListOfSlotNumbersWithGivenDriverAge(ParkingLot parkingLot, int driverAge) {
        List<Integer> listOfSlotNumbersWithGivenDriverAge =  parkingLot.getListOfSlotNumbersWithGivenDriverAge(driverAge);
        System.out.println( CommonHelper.convertIntegerListToCommaSeparatedString(listOfSlotNumbersWithGivenDriverAge));
    }

    private static void printListOfRegistrationNumberForDriverWithGivenAge(ParkingLot parkingLot, int driverAge) {
        List<String> listOfRegistrationNumberForDriverWithGivenAge = parkingLot.getListOfRegistrationNumberForDriverWithGivenAge(driverAge);
        System.out.println(CommonHelper.convertStringListToCommaSeparatedString(listOfRegistrationNumberForDriverWithGivenAge)) ;
    }

    private static void printSlotNumberOfGivenCarRegistrationNumber(ParkingLot parkingLot,String registrationNumber) {
        System.out.println(parkingLot.getSlotNumberOfGivenCarRegistrationNumber(registrationNumber));
    }
}

