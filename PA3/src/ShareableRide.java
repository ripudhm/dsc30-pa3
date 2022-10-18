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

    /*
    Initializes a Standard ride class with the vehicles, passengers and the assignments
    */
    public ShareableRide(){
        this.vehicles = new ArrayList<>();
        this.passengers = new ArrayList<>();
        this.assignments = new ArrayList<>();
    }

    /*
    Gets the list of vehicles in the ride
    @return returns the list of vehicles
    */
    public ArrayList<Vehicle> getVehicles() {
        return this.vehicles;
    }

    /*
    Gets the list of passengers in the ride
    @return returns the list of passengers
    */
    public ArrayList<Passenger> getPassengers() {
        return this.passengers;
    }

    /*
    Adds the input passenger to the list of passengers in the ride
    @param p input passenger that needs to be added
    @return true if successful or false if already in the list
    @throw OperationDeniedException when StandardPassenger is tried to add
    */
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


    /*
    Adds the input vehicle to the list of vehicles in the ride
    @param v input vehicle that needs to be added
    @return true if successful or false if already in the list
    */
    public boolean addVehicle(Vehicle v) {
        if (this.vehicles.contains(v)) {
            return false;
        }
        this.vehicles.add(v);
        return true;
    }


    /*
    Assigns passengers to the vehicles based on passenger and vehicle rules
    @throw OperationDeniedException if there is a mismatch in the number of vehicles and passengers
    */
    public void assignPassengerToVehicle() throws OperationDeniedException {
        if (this.passengers.size() > CARPOOL_LIMIT * this.vehicles.size()) {
            throw new OperationDeniedException(INVALID_ACTION);
        }
        int counter = 0; // counter to move to the next vehicle
        for (int i = 0; i < this.passengers.size(); i++) { // Assigning the passengers to vehicles
            this.vehicles.get(counter).addPassengerToVehicle(this.passengers.get(i));
            if (i == CARPOOL_LIMIT - 1) { // checking if vehicle is full
                counter += 1;
            }
        }
        for (int i = 0; i < this.vehicles.size(); i++) { // Adding assignments to the record
            this.assignments.add(this.vehicles.get(i).getVehicleInfo());
        }
    }

    /*
    Gets the record of previous assignments
    @return the list of assignments
    */
    public ArrayList<String> getRecords() {
        return this.assignments;
    }
    public static void main(String[] args) throws OperationDeniedException {
        /**
         EconomyVehicle test = new EconomyVehicle("ferrari");
         PremiumVehicle test2 = new PremiumVehicle("mercedes");
         PremiumVehicle test3 = new PremiumVehicle("audi");
         ShareableRide testride = new ShareableRide();
         testride.addVehicle(test);
         testride.addVehicle(test2);
         testride.addVehicle(test3);
         ValuePassenger subject = new ValuePassenger("Ken", "lol");
         ValuePassenger subject1 = new ValuePassenger("Lewis", "WDC7");
         testride.addPassenger(subject);
         testride.addPassenger(subject1);
         testride.assignPassengerToVehicle();
         System.out.println(testride.assignments);
         */
    }
}
