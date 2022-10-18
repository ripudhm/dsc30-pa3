import java.util.ArrayList;
import java.util.Arrays;

public class StandardRide implements RideScheduler{

    private final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    private final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Passenger> passengers;
    private ArrayList<String> assignments;

    /*
    Initializes a Standard ride class with the vehicles, passengers and the assignments
    */
    public StandardRide() {
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
    */
    public boolean addPassenger(Passenger p) {
        if (this.passengers.contains(p)) {
            return false;
        }
        this.passengers.add(p);
        return true;
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
        if (this.vehicles.size() != this.passengers.size()) {
            throw new OperationDeniedException(MISMATCH_MSG);
        }
        ArrayList<Passenger> staPass = new ArrayList<>(); //making a new list with only Standard Passengers
        ArrayList<Passenger> valPass = new ArrayList<>(); //making a new list with only Value Passengers
        ArrayList<Vehicle> preVeh = new ArrayList<>(); //making a new list with only Premium Vehicles
        ArrayList<Vehicle> ecoVeh = new ArrayList<>(); //making a new list with only Economy Vehicles

        for (Passenger p : this.passengers) { //looping to sort passengers
            if (p.passengerID == 0) {
                staPass.add(p);
            }
            else {
                valPass.add(p);
            }
        }

        for (Vehicle v : this.vehicles) {//looping to sort vehicles
            if (v.vehicleID == 0) {
                ecoVeh.add(v);
            }
            else {
                preVeh.add(v);
            }
        }
        if (staPass.size() > ecoVeh.size()) {
            throw new OperationDeniedException(INVALID_ACTION);
        }
        ArrayList<Passenger> passList = new ArrayList<>(); //joining both lists to make sorted Passenger list
        passList.addAll(staPass);
        passList.addAll(valPass);
        ArrayList<Vehicle> vehList = ecoVeh; //joining both lists to make sorted Vehicle list
        vehList.addAll(preVeh);
        for (int i = 0; i < vehList.size(); i++) { // Assigning the passengers to vehicles
            vehList.get(i).addPassengerToVehicle(passList.get(i));
            this.assignments.add(vehList.get(i).getVehicleInfo());
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
        StandardRide testride = new StandardRide();
        testride.addVehicle(test);
        testride.addVehicle(test2);
        //testride.addVehicle(test3);
        ValuePassenger subject = new ValuePassenger("Ken", "lol");
        StandardPassenger subject1 = new StandardPassenger("Lewis", "WDC7");
        testride.addPassenger(subject);
        testride.addPassenger(subject1);
        testride.assignPassengerToVehicle();
        System.out.println(testride.assignments);
        */
    }
}
