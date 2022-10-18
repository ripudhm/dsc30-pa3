import java.util.ArrayList;

/**
 * Economy Vehicle class extends the vehicle class and has more unique features
 * @author Ripudh Mylapur
 * @since  10/15/2022
 */
public class EconomyVehicle extends Vehicle {
    /*
    Initializes an Economy vehicle and gives an ID number
    @param takes in the name of the vehicle as a String
    */
    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }

    /*
    Adds the input passenger to the vehicle
    @param takes in a passenger who is going to be added to the vehicle
    @return returns true if the addition was successful and false if the passenger was already there
    */
    public boolean addPassengerToVehicle(Passenger p) {
        if (this.currentPassengers.contains(p)) {
            return false;
        }
        this.currentPassengers.add(p);
        return true;
    }

    /*
    Gets the information about the vehicle
    @return returns the information as a String
    */
    // civic [2022-10-08]: [Steven]
    public String getVehicleInfo() {
        String name = String.format("%s ", this.getVehicleName());
        ArrayList<String> passNames = new ArrayList<String>();
        for (Passenger p: this.currentPassengers) {
            passNames.add(p.displayName());
        }
        return name + String.format("[%s]", this.getDate()) + ": " + String.format("%s", passNames);
    }
    public static void main(String[] args) {
        //EconomyVehicle test = new EconomyVehicle("ferrari");
        //StandardPassenger subject = new StandardPassenger("Ken", "lol");
        //test.addPassengerToVehicle(subject);
        //System.out.println(test.getVehicleInfo());
    }
}
