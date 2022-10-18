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

    /*
    Initiates a passenger class that will travel using the vehicle class
    @param username the username of the passenger
    @param bio a brief description about the person
    */
    public Passenger(String username, String bio) {
        if (username == null || bio == null) {
            throw new IllegalArgumentException();
        }
        this.username = username;
        this.bio = bio;
    }

    /*
    Updates the bio of the passenger
    @param newBio the new description the passenger wants to use
    */
    public void setBio(String newBio) {
        if (newBio == null) {
            throw new IllegalArgumentException();
        }
        this.bio = newBio;
    }

    /*
    Displays the current bio of the passenger
    @return returns the bio as a String
    */
    public String displayBio() {
        return this.bio;
    }

    /*
    Gets the ID the passenger uses
    @return returns the ID as an int
    */
    public Integer getPassengerID() {
        return this.passengerID;
    }

    /*
    Displays the name of the passenger with titles if any
    @return returns the name as a String
    */
    public abstract String displayName();
}
