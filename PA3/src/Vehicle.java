/*
  Name: Ripudh Mylapur
  PID:  A15853784
 */
import java.time.LocalDate;
import java.util.ArrayList;
/**
 * Abstract Class Vehicle that defines the functionality of a vehicle
 * @author Ripudh Mylapur
 * @since  10/15/2022
 */

public abstract class Vehicle {

    private LocalDate date;
    private final String vehicle;
    protected final ArrayList<Passenger> currentPassengers;
    protected final ArrayList<String> passengerNames;
    protected int vehicleID;

    /*
    Initializes a Vehicle and assigns the instance variables to the vehicle
    @param VehicleName the name of the vehicle that the class represents
     */

    public Vehicle(String VehicleName) {
        if (VehicleName == null) {
            throw new IllegalArgumentException();
        }
        this.date = LocalDate.now();
        this.vehicle = VehicleName;
        this.currentPassengers = new ArrayList<Passenger>();
        this.passengerNames = new ArrayList<String>();
    }


    /*
    Gets the date that the vehicle is at
    @return returns the date for the vehicle
    */
    public LocalDate getDate() {
        return this.date;
    }

    /*
    Gets the name fo the vehicle
    @return returns the name of the vehicle
    */
    public String getVehicleName() {
        return this.vehicle;
    }

    /*
    Gets the passengers who are in the vehicle
    @return returns a list of Passengers who are in the vehicle
    */
    public ArrayList<Passenger> getCurrentPassengers() {
        return this.currentPassengers;
    }

    /*
    Gets the ID of the vehicle
    @return returns the ID as an int
    */
    public Integer getVehicleID() {
        return this.vehicleID;
    }

    public abstract boolean addPassengerToVehicle(Passenger p)
            throws OperationDeniedException;

    public abstract String getVehicleInfo();

}
