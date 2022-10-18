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

    /*
    Initiates a passenger class that will travel using the vehicle class
    @param username the username of the passenger
    @param bio a brief description about the person
    */
    public ValuePassenger(String username, String bio){
        super(username, bio);
        this.customTitle = "Value Passenger";
        this.passengerID = 1;
    }

    /*
    Displays the name of the passenger with titles if any
    @return returns the name as a String
    */
    public String displayName() {
        return String.format("<%s> ", this.customTitle) + String.format("%s", this.username);
    }

    /*
    Updates the custom title of the passenger
    @param newTitle the new title that the passenger wants to use
    */
    public void setCustomTitle(String newTitle) {
        this.customTitle = newTitle;

    }
}
