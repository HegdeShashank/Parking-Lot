import entity.ParkingLot;
import helper.FileReader;
import helper.ParkingActionHelper;
import helper.ValidationMessages;

import java.io.FileNotFoundException;
import java.util.List;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        ParkingLot parkingLot = null;
        List<String> lines = FileReader.getLinesFromInputFile(args[0]);
        for(int i=0;i<lines.size();i++) {
            String ithLine = lines.get(i);
            String[] lineSplit = ithLine.split(" ");
            if (i == 0) {
                parkingLot = createParkingLot(Integer.parseInt(lineSplit[1]));
            }
            else {
                ParkingActionHelper.performAction(parkingLot, lineSplit);
            }
        }
    }


    // This function creates parking lot of given size.
    private static ParkingLot createParkingLot(int lotSize) {
        ParkingLot parkingLot = new ParkingLot(lotSize);
        System.out.println(ValidationMessages.getCreateParkingSuccessMessage(lotSize));
        return parkingLot;
    }
}

