package entity;
import helper.ParkingLotHelper;
import helper.ValidationMessages;
import java.util.List;
import java.util.TreeSet;

public class ParkingLot {
    private int noOfSlot;
    private CarSlot[] carSlots;
    private TreeSet<Integer> availableSlot;

    public ParkingLot(int noOfSlot) {
        this.noOfSlot = noOfSlot;
        this.carSlots = new CarSlot[noOfSlot];
        this.availableSlot = new TreeSet<>();
        //When creating new Parking lot object, All the parking slots are available.
        for(int i=0;i<noOfSlot;i++) {
            carSlots[i] = new CarSlot(i+1);
            availableSlot.add(i+1);
        }
    }

    public void allocateParkingSlotToCar(String vehicleRegistrationNo, int ageOfDriver) {
        Car car = new Car(vehicleRegistrationNo,ageOfDriver);
        int nearestAvailableSlot = findAndRemoveNearestAvailableSlot();
        ParkingLotHelper.allocateParkingSlotToCar(carSlots,car,nearestAvailableSlot);
    }

    int findAndRemoveNearestAvailableSlot() {
        return (availableSlot!=null && !availableSlot.isEmpty()) ? availableSlot.pollFirst() : -1;
    }

    public List<String> getListOfRegistrationNumberForDriverWithGivenAge(int age) {
        return ParkingLotHelper.getListOfRegistrationNumberForDriverWithGivenAge(carSlots,age);
    }

    public int getSlotNumberOfGivenCarRegistrationNumber(String registrationNumber) {
        return ParkingLotHelper.getSlotNumberOfGivenCarRegistrationNumber(carSlots,registrationNumber);
    }

    public List<Integer> getListOfSlotNumbersWithGivenDriverAge (int age) {
        return ParkingLotHelper.getListOfSlotNumbersWithGivenDriverAge(carSlots,age);
    }

    public void clearParkingSlot(int slotID) {
        availableSlot.add(slotID);
        ParkingLotHelper.clearParkingSlot(carSlots,slotID);
    }

}
