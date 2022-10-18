import java.util.ArrayList;
import java.util.Arrays;

/**
 * Premium Vehicle class extends the vehicle class and has more unique features
 * @author Ripudh Mylapur
 * @since  10/15/2022
 */
public class PremiumVehicle extends Vehicle {

    // Error message to use in OperationDeniedException
    private static final String INVALID_INPUT =
            "The input vehicle is not a premium vehicle.";
    private static final String [] PREMIUM_VEHICLE_BRAND =
            new String[] {"lamborghini", "ferrari", "bmw", "mercedes","audi"};
    private static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";

    /*
    Initializes a Premium vehicle and gives an ID number
    @param takes in the name of the vehicle as a String
    @throws OperationDeniedException when vehicle name is not a premium brand
    */
    public PremiumVehicle(String VehicleName) throws OperationDeniedException {
        super(VehicleName);
        String lowerName = this.getVehicleName().toLowerCase();
        for (String make : PREMIUM_VEHICLE_BRAND) {
            if (lowerName.contains(make)) {
                this.vehicleID = 1;
                return;
            }
        }
        throw new OperationDeniedException(INVALID_INPUT);
    }

    /*
    Adds input passenger into the vehicle
    @param takes in the passenger who is going to be added to the vehicle
    @throws OperationDeniedException when input passenger is not a Value Passenger
    */
    public boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException {
        if (p instanceof ValuePassenger) {
            if (this.currentPassengers.contains(p)) {
                return false;
            }
            this.currentPassengers.add(p);
            return true;
        }
        throw new OperationDeniedException(DENIED_PASSENGER_GROUP);
    }

    /*
    Gets the information about the vehicle
    @return returns the information as a string
    */
    // bmw01 (Premium) [2022-10-08]: [<Value Passenger> Yunyi]
    public String getVehicleInfo() {
        String name = String.format("%s ", this.getVehicleName());
        ArrayList<String> passNames = new ArrayList<String>();
        for (Passenger p: this.currentPassengers) {
            passNames.add(p.displayName());
        }
        return name + "(Premium) " + String.format("[%s]", this.getDate()) + ": " + String.format("%s", passNames);
    }
    public static void main(String[] args) throws OperationDeniedException {
        //PremiumVehicle test = new PremiumVehicle("ferrari01");
        //ValuePassenger subject = new ValuePassenger("Ken", "lol");
        //test.addPassengerToVehicle(subject);
        //System.out.println(test.getVehicleInfo());
    }
}
