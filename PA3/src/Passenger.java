/*
  Name: Ripudh Mylapur
  PID:  A15853784
 */

/**
 * Passenger class defines the functionality of a vehicle user
 * @author Ripudh Mylapur
 * @since  10/16/2022
 */
public abstract class Passenger {

    // instance variables
    protected String username;
    protected String bio;
    protected int passengerID;

    public Passenger(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
    }

    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        this.bio = newBio;
    }

    public String displayBio() {
        return this.bio;
    }

    public Integer getPassengerID() {
        return this.passengerID;
    }

    public abstract String displayName();
}
