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
        if (this.passengers.size() > CARPOOL_LIMIT*this.vehicles.size()) {
            throw new OperationDeniedException(INVALID_ACTION);
        }
        for (int i = 0; i <= CARPOOL_LIMIT; i++) {

        }
    }


    public ArrayList<String> getRecords() {
        return this.assignments;
    }
}
