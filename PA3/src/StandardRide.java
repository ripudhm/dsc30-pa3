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

    public StandardRide() {
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


    public boolean addPassenger(Passenger p) {
        if (this.passengers.contains(p)) {
            return false;
        }
        this.passengers.add(p);
        return true;
    }

    public boolean addVehicle(Vehicle v) {
        if (this.vehicles.contains(v)) {
            return false;
        }
        this.vehicles.add(v);
        return true;
    }

    public void assignPassengerToVehicle() throws OperationDeniedException {
        if (this.vehicles.size() != this.passengers.size()) {
            throw new OperationDeniedException(MISMATCH_MSG);
        }
        ArrayList<Passenger> staPass = new ArrayList<>();
        ArrayList<Passenger> valPass = new ArrayList<>();
        ArrayList<Vehicle> preVeh = new ArrayList<>();
        ArrayList<Vehicle> ecoVeh = new ArrayList<>();

        for (Passenger p : this.passengers) {
            if (p.passengerID == 0) {
                staPass.add(p);
            }
            else {
                valPass.add(p);
            }
        }

        for (Vehicle v : this.vehicles) {
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
        ArrayList<Passenger> passList = new ArrayList<>();
        passList.addAll(staPass);
        passList.addAll(valPass);
        ArrayList<Vehicle> vehList = ecoVeh;
        vehList.addAll(preVeh);
        for (int i = 0; i < vehList.size(); i++) {
            vehList.get(i).addPassengerToVehicle(passList.get(i));
            this.assignments.add(vehList.get(i).getVehicleInfo());
        }
    }


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
