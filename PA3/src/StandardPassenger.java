/*
  Name: Ripudh Mylapur
  PID:  A15853784
 */

/**
 * Standard Passenger class extends the Passenger class and has more unique features
 * @author Ripudh Mylapur
 * @since  10/16/2022
 */
public class StandardPassenger extends Passenger{

    public StandardPassenger(String username, String bio){
        super(username, bio);
        this.passengerID = 0;
    }

    public String displayName() {
        return this.username;
    }

    public static void main(String[] args) {
        EconomyVehicle test = new EconomyVehicle("ferrari");
        StandardPassenger subject = new StandardPassenger("Ken", "lol");
        test.addPassengerToVehicle(subject);
        System.out.println(test.getVehicleInfo());
    }
}
