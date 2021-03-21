package entity;
import helper.ParkingLotHelper;
import helper.ValidationMessages;
import java.util.List;
import java.util.TreeSet;

public class ParkingLot {

    private int noOfSlot;
    private CarSlot[] carSlots;
    //TreeSet data structure used to store data in ascending order.
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

    /**
     * This function create new Car object with passed parameters and add that car to nearest slot available.
     * @param vehicleRegistrationNum - Registration number of the car.
     * @param ageOfDriver - Age of the driver.
     */
    public void allocateParkingSlotToCar(String vehicleRegistrationNum, int ageOfDriver) {
        Car car = new Car(vehicleRegistrationNum,ageOfDriver);
        int nearestAvailableSlot = findAndRemoveNearestAvailableSlot();
        ParkingLotHelper.allocateParkingSlotToCar(carSlots,car,nearestAvailableSlot);
    }

    /**
     * This function get the first element and remove it (Like dequeue in queses). This is helpful to get the nearest slot that is available
     * So that that slots can be assigned and availability of that slot removed.
     * @return - nearest available slot, if no slots are there then -1
     */
    int findAndRemoveNearestAvailableSlot() {
        return (availableSlot!=null && !availableSlot.isEmpty()) ? availableSlot.pollFirst() : -1;
    }

    /**
     * For given age of the driver, this function returns list of registration numbers of the car with give age of car driver
     * @param age - Age of the car driver
     * @return - List of registration numbers of the car with give age of car driver.
     */
    public List<String> getListOfRegistrationNumberForDriverWithGivenAge(int age) {
        return ParkingLotHelper.getListOfRegistrationNumberForDriverWithGivenAge(carSlots,age);
    }

    /**
     * This will return slot Number of parking lot which has car of given registration number
     * @param registrationNumber -Registration number of the car
     * @return - Slot Number of parking lot which has car of given registration number. -1 if No vehicle found.
     */
    public int getSlotNumberOfGivenCarRegistrationNumber(String registrationNumber) {
        return ParkingLotHelper.getSlotNumberOfGivenCarRegistrationNumber(carSlots,registrationNumber);
    }

    /**
     * or given age of the driver, this function returns list of slot numbers
     * of the car with give age of car driver
     * @param age - Age of the car driver
     * @return  List of slot numbers of the car with give age of car driver.
     */
    public List<Integer> getListOfSlotNumbersWithGivenDriverAge (int age) {
        return ParkingLotHelper.getListOfSlotNumbersWithGivenDriverAge(carSlots,age);
    }

    /**
     * This function removes the car from  given slot of parking lot. And adds that slot to availableSlot set.
     * @param slotID - Slot ID of the parking lot in which car needs to be removed.
     */
    public void clearParkingSlot(int slotID) {
        availableSlot.add(slotID);
        ParkingLotHelper.clearParkingSlot(carSlots,slotID);
    }

}
