import java.util.ArrayList;

public class ShareableRide implements RideScheduler{

    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private final int CARPOOL_LIMIT = 5;

    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    public ShareableRide(){
        this.vehicles = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }


    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }


    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }


    public boolean addPassenger(Passenger p) throws OperationDeniedException {
        if (p instanceof ValuePassenger) {
            if (!this.passengers.contains(p)) {
                this.passengers.add(p);
                return true;
            }
            return false;
        }
        throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
    }



    public boolean addVehicle(Vehicle v) {
        if (this.vehicles.contains(v)) {
            return false;
        }
        this.vehicles.add(v);
        return true;
    }



    public void assignPassengerToVehicle() throws OperationDeniedException {
        if (this.passengers.size() > CARPOOL_LIMIT * this.vehicles.size()) {
            throw new OperationDeniedException(INVALID_ACTION);
        }
        int counter = 0;
        for (int i = 0; i < this.passengers.size(); i++) {
            System.out.println(i);
            this.vehicles.get(counter).addPassengerToVehicle(this.passengers.get(i));
            if (i == CARPOOL_LIMIT - 1) {
                counter += 1;
            }
        }
        for (int i = 0; i < this.vehicles.size(); i++) {
            this.assignments.add(this.vehicles.get(i).getVehicleInfo());
        }
    }


    public ArrayList<String> getRecords() {
        return this.assignments;
    }
    public static void main(String[] args) throws OperationDeniedException {

         EconomyVehicle test = new EconomyVehicle("ferrari");
         PremiumVehicle test2 = new PremiumVehicle("mercedes");
         PremiumVehicle test3 = new PremiumVehicle("audi");
         ShareableRide testride = new ShareableRide();
         testride.addVehicle(test);
         testride.addVehicle(test2);
         //testride.addVehicle(test3);
         ValuePassenger subject = new ValuePassenger("Ken", "lol");
         ValuePassenger subject1 = new ValuePassenger("Lewis", "WDC7");
         testride.addPassenger(subject);
         testride.addPassenger(subject1);
         testride.assignPassengerToVehicle();
         System.out.println(testride.assignments);
    }
}
