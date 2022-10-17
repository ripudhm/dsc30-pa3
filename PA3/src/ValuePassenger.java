/*
  Name: Ripudh Mylapur
  PID:  A15853784
 */

/**
 * Value Passenger class extends the Passenger class and has more unique features
 * @author Ripudh Mylapur
 * @since  10/16/2022
 */
public class ValuePassenger extends Passenger{

    // instance variable
    private String customTitle;

    public ValuePassenger(String username, String bio){
        super(username, bio);
        this.customTitle = "Value Passenger";
        this.passengerID = 1;
    }

    public String displayName() {
        return String.format("<%s> ", this.customTitle) + String.format("%s", this.username);
    }

    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;

    }
}
