import entity.ParkingLot;
import helper.CommonHelper;
import helper.FileReader;
import helper.ParkingActionHelper;
import helper.ValidationMessages;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.logging.Logger;

public class Application {

    public static void main(String[] args) throws FileNotFoundException {
        ParkingLot parkingLot = null;
        List<String> lines = FileReader.getLinesFromInputFile(args[0]);
        int index = 0;
        for(String line:lines){
            String[] split = line.split(" ");
            if(index == 0) {
                parkingLot = new ParkingLot(Integer.parseInt(split[1]));
                System.out.println(ValidationMessages.getCreateParkingSuccessMessage(split[1]));
            }


            else
                System.out.println(ParkingActionHelper.performAction(parkingLot,split));
            index++;

        }
    }
}

