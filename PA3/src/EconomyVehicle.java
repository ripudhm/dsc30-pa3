import java.util.ArrayList;

/**
 * Economy Vehicle class extends the vehicle class and has more unique features
 * @author Ripudh Mylapur
 * @since  10/15/2022
 */
public class EconomyVehicle extends Vehicle {

    public EconomyVehicle(String VehicleName) {
        super(VehicleName);
        this.vehicleID = 0;
    }


    public boolean addPassengerToVehicle(Passenger p) {
        if (this.currentPassengers.contains(p)) {
            return false;
        }
        this.currentPassengers.add(p);
        return true;
    }

    // civic [2022-10-08]: [Steven]
    public String getVehicleInfo() {
        String name = String.format("%s ", this.getVehicleName());
        ArrayList<String> passNames = new ArrayList<String>();
        for (Passenger p: this.currentPassengers) {
            passNames.add(p.username);
        }
        return name + String.format("[%s]", this.getDate()) + ": " + String.format("%s", passNames);
    }
    public static void main(String[] args) {
        EconomyVehicle test = new EconomyVehicle("ferrari");
        StandardPassenger subject = new StandardPassenger("Ken", "lol");
        test.addPassengerToVehicle(subject);
        System.out.println(test.getVehicleInfo());
    }
}
