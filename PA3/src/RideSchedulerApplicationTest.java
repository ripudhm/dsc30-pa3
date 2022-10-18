/*
  Name: Ripudh Mylapur
  PID:  A15853784
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Test class to test the Ridescheduler Application
 * @author Ripudh Mylapur
 * @since  10/17/2022
 */
public class RideSchedulerApplicationTest {
    protected static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    protected static final String MISMATCH_MSG =
            "Each passenger should have one vehicle matched.";
    protected static final String INVALID_ACTION =
            "Not able to perform proper assignment.";
    ValuePassenger yunyi;
    ValuePassenger Lewis;
    ValuePassenger Max;
    ValuePassenger Alonso;
    ValuePassenger Kimi;
    ValuePassenger Vettel;
    StandardPassenger viren;
    StandardPassenger Karlo;
    StandardPassenger Adi;
    PremiumVehicle pv1;
    PremiumVehicle pv2;
    PremiumVehicle pv3;
    EconomyVehicle ev1;
    EconomyVehicle ev2;
    EconomyVehicle ev3;
    StandardRide testride1;
    StandardRide testride2;
    StandardRide testride3;
    ShareableRide shareride1;
    ShareableRide shareride2;
    ShareableRide shareride3;

    LocalDate date = LocalDate.now();


    @Before
    public void setup() throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "VAL Tutor");
        Lewis = new ValuePassenger("Lewis", "WDC7");
        Max = new ValuePassenger("Max", "WDC2");
        Alonso = new ValuePassenger("Alonso", "WDC2");
        Kimi = new ValuePassenger("Kimi", "WDC1");
        Vettel = new ValuePassenger("Vettel", "WDC4");
        viren = new StandardPassenger("Viren", "STA Tutor");
        Karlo = new StandardPassenger("Karlo", "roommate");
        Adi = new StandardPassenger("Adi", "L Fan");
        pv1 = new PremiumVehicle("bmw01");
        pv2 = new PremiumVehicle("ferrari");
        pv3 = new PremiumVehicle("mercedes");
        ev1 = new EconomyVehicle("honda");
        ev2 = new EconomyVehicle("hyundai");
        ev3 = new EconomyVehicle("toyota");
        testride1 = new StandardRide();
        testride2 = new StandardRide();
        testride3 = new StandardRide();
        shareride1 = new ShareableRide();
        shareride2 = new ShareableRide();
        shareride3 = new ShareableRide();
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestEconomyVehicleThrowsIAE(){
        ev1 = new EconomyVehicle(null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestPremiumVehicleThrowsIAE() throws OperationDeniedException {
        pv1 = new PremiumVehicle(null);
    }

    @Test
    public void TestPremiumVehicleThrowsODE(){
        try {
            pv1.addPassengerToVehicle(viren);
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(DENIED_PASSENGER_GROUP, ode.getMessage());
        }
    }

    @Test (expected = OperationDeniedException.class)
    public void TestPremiumVehicleThrowsODEforbrand() throws OperationDeniedException {
        pv1 = new PremiumVehicle("honda");
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestValuePassengerThrowsIAE(){
        yunyi = new ValuePassenger("Yunyi",null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestStandardPassengerThrowsIAE(){
        Adi = new StandardPassenger("Adi",null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestPassengerThrowsIAEforsetBio(){
        Adi.setBio(null);
    }

    @Test
    public void TestTooManyPassengersStandardThrowsODE(){
        try {
            testride1.addPassenger(Adi);
            testride1.addPassenger(Max);
            testride1.addVehicle(ev1);
            testride1.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(MISMATCH_MSG, ode.getMessage());
        }
    }

    @Test
    public void TestStandardPassengersHasNoVehiclesStandardThrowsODE(){
        try {
            testride1.addPassenger(Adi);
            testride1.addPassenger(Max);
            testride1.addVehicle(pv1);
            testride1.addVehicle(pv2);
            testride1.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_ACTION, ode.getMessage());
        }
    }

    @Test
    public void TestStandardPassengersAddedToShareableThrowsODE(){
        try {
            shareride1.addPassenger(Adi);
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(DENIED_PASSENGER_GROUP, ode.getMessage());
        }
    }

    @Test
    public void TestTooManyPassengersShareableThrowsODE(){
        try {
            shareride1.addVehicle(ev1);
            shareride1.addPassenger(Lewis);
            shareride1.addPassenger(yunyi);
            shareride1.addPassenger(Max);
            shareride1.addPassenger(Alonso);
            shareride1.addPassenger(Kimi);
            shareride1.addPassenger(Vettel);
            shareride1.assignPassengerToVehicle();
            fail("Exception not thrown"); // will execute if last line didn't throw exception
        } catch (OperationDeniedException ode) {
            assertEquals(INVALID_ACTION, ode.getMessage());
        }
    }

    @Test
    public void getDateTest() {
        assertEquals(ev1.getDate(), date);
        assertEquals(ev2.getDate(), date);
        assertEquals(ev3.getDate(), date);
        assertEquals(pv1.getDate(), date);
        assertEquals(pv2.getDate(), date);
        assertEquals(pv3.getDate(), date);
    }

    @Test
    public void getVehicleNameTest() {
        assertEquals(ev1.getVehicleName(), "honda");
        assertEquals(pv1.getVehicleName(), "bmw01");
    }

    @Test
    public void getCurrentPassengersTest() {
        assertEquals(ev1.getCurrentPassengers(), new ArrayList<>());
        assertEquals(pv1.getCurrentPassengers(), new ArrayList<>());
    }

    @Test
    public void getVehicleIDTest() {
        assertTrue(ev1.getVehicleID() == 0);
        assertTrue(pv1.getVehicleID() == 1);
    }

    @Test
    public void addPassengerToVehicleTest() throws OperationDeniedException {
        assertEquals(ev1.addPassengerToVehicle(yunyi), true);
        assertEquals(ev1.addPassengerToVehicle(yunyi), false);
        assertEquals(pv1.addPassengerToVehicle(Max), true);
    }

    @Test
    public void getVehicleInfoTest() {
        assertEquals(ev1.getVehicleInfo(), "honda " + "[" + date + "]: []");
        ev1.addPassengerToVehicle(yunyi);
        assertEquals(ev1.getVehicleInfo(), "honda " + "[" + date + "]: [<Value Passenger> Yunyi]");
        assertEquals(pv1.getVehicleInfo(), "bmw01 (Premium) " + "[" + date + "]: []");
    }

    @Test
    public void setBioTest() {
        assertEquals(Adi.bio, "L Fan");
        Adi.setBio("friend");
        assertEquals(Adi.bio, "friend");
    }

    @Test
    public void displayBioTest() {
        assertEquals(Adi.displayBio(), "L Fan");
        assertEquals(Max.displayBio(), "WDC2");
    }

    @Test
    public void getPassengerIDTest() {
        assertTrue(Adi.getPassengerID() == 0);
        assertTrue(Max.getPassengerID() == 1);
    }

    @Test
    public void displayNameTest() {
        assertEquals(Adi.displayName(), "Adi");
        assertEquals(Max.displayName(), "<Value Passenger> Max");
    }

    @Test
    public void getVehiclesTest() {
        assertEquals(testride1.getVehicles(), new ArrayList<>());
    }

    @Test
    public void setCustomTitleTest() {
        assertEquals(Max.displayName(), "<Value Passenger> Max");
        Max.setCustomTitle("2022 WDC");
        assertEquals(Max.displayName(), "<2022 WDC> Max");
    }

    @Test
    public void getPassengersTest() {
        assertEquals(testride1.getPassengers(), new ArrayList<>());
    }

    @Test
    public void addPassengerTest() throws OperationDeniedException {
        assertEquals(testride1.getPassengers(), new ArrayList<>());
        testride1.addPassenger(Adi);
        assertEquals(testride1.getPassengers().size(), 1);

        assertEquals(testride2.getPassengers(), new ArrayList<>());
        testride2.addPassenger(Adi);
        assertEquals(testride2.getPassengers().size(), 1);

        assertEquals(testride3.getPassengers(), new ArrayList<>());
        testride3.addPassenger(Adi);
        assertEquals(testride3.getPassengers().size(), 1);


        assertEquals(shareride1.getPassengers(), new ArrayList<>());
        shareride1.addPassenger(Lewis);
        assertEquals(shareride1.getPassengers().size(), 1);

        assertEquals(shareride2.getPassengers(), new ArrayList<>());
        shareride2.addPassenger(Lewis);
        assertEquals(shareride2.getPassengers().size(), 1);

        assertEquals(shareride3.getPassengers(), new ArrayList<>());
        shareride3.addPassenger(Lewis);
        assertEquals(shareride3.getPassengers().size(), 1);
    }

    @Test
    public void addVehicleTest() {
        assertEquals(testride1.getVehicles(), new ArrayList<>());
        testride1.addVehicle(ev1);
        assertEquals(testride1.getVehicles().size(), 1);

        assertEquals(testride2.getVehicles(), new ArrayList<>());
        testride2.addVehicle(ev1);
        assertEquals(testride2.getVehicles().size(), 1);

        assertEquals(testride3.getVehicles(), new ArrayList<>());
        testride3.addVehicle(ev1);
        assertEquals(testride3.getVehicles().size(), 1);


        assertEquals(shareride1.getVehicles(), new ArrayList<>());
        shareride1.addVehicle(ev1);
        assertEquals(shareride1.getVehicles().size(), 1);

        assertEquals(shareride2.getVehicles(), new ArrayList<>());
        shareride2.addVehicle(ev1);
        assertEquals(shareride2.getVehicles().size(), 1);

        assertEquals(shareride3.getVehicles(), new ArrayList<>());
        shareride3.addVehicle(ev1);
        assertEquals(shareride3.getVehicles().size(), 1);
    }

    @Test
    public void assignPassengerToVehicleTest() throws OperationDeniedException {
        testride1.addVehicle(ev1);
        testride1.addPassenger(Adi);
        testride1.assignPassengerToVehicle();
        ArrayList<String> expected1 = new ArrayList<>();
        expected1.add("honda " + "[" + date + "]: [Adi]");
        assertEquals(testride1.getRecords(), expected1);

        testride2.addVehicle(ev2);
        testride2.addPassenger(Karlo);
        testride2.assignPassengerToVehicle();
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("hyundai " + "[" + date + "]: [Karlo]");
        assertEquals(testride2.getRecords(), expected2);

        testride3.addVehicle(pv3);
        testride3.addPassenger(Max);
        testride3.assignPassengerToVehicle();
        ArrayList<String> expected3 = new ArrayList<>();
        expected3.add("mercedes (Premium) " + "[" + date + "]: [<Value Passenger> Max]");
        assertEquals(testride3.getRecords(), expected3);


        shareride1.addVehicle(ev3);
        shareride1.addPassenger(Lewis);
        shareride1.assignPassengerToVehicle();
        ArrayList<String> expected4 = new ArrayList<>();
        expected4.add("toyota " + "[" + date + "]: [<Value Passenger> Lewis]");
        assertEquals(shareride1.getRecords(), expected4);

        shareride2.addVehicle(pv1);
        shareride2.addPassenger(Lewis);
        shareride2.addPassenger(Max);
        shareride2.assignPassengerToVehicle();
        ArrayList<String> expected5 = new ArrayList<>();
        expected5.add("bmw01 (Premium) " + "[" + date + "]: [<Value Passenger> Lewis, <Value Passenger> Max]");
        assertEquals(shareride2.getRecords(), expected5);

        shareride3.addVehicle(pv2);
        shareride3.addPassenger(Lewis);
        shareride3.addPassenger(yunyi);
        shareride3.assignPassengerToVehicle();
        ArrayList<String> expected6 = new ArrayList<>();
        expected6.add("ferrari (Premium) " + "[" + date + "]: [<Value Passenger> Lewis, <Value Passenger> Yunyi]");
        assertEquals(shareride3.getRecords(), expected6);
    }

    @Test
    public void getRecordsTest() throws OperationDeniedException {
        testride1.addVehicle(ev1);
        testride1.addPassenger(Adi);
        testride1.assignPassengerToVehicle();
        ArrayList<String> expected1 = new ArrayList<>();
        expected1.add("honda " + "[" + date + "]: [Adi]");
        assertEquals(testride1.getRecords(), expected1);

        testride2.addVehicle(ev2);
        testride2.addPassenger(Karlo);
        testride2.assignPassengerToVehicle();
        ArrayList<String> expected2 = new ArrayList<>();
        expected2.add("hyundai " + "[" + date + "]: [Karlo]");
        assertEquals(testride2.getRecords(), expected2);

        testride3.addVehicle(pv3);
        testride3.addPassenger(Max);
        testride3.assignPassengerToVehicle();
        ArrayList<String> expected3 = new ArrayList<>();
        expected3.add("mercedes (Premium) " + "[" + date + "]: [<Value Passenger> Max]");
        assertEquals(testride3.getRecords(), expected3);


        shareride1.addVehicle(ev3);
        shareride1.addPassenger(Lewis);
        shareride1.assignPassengerToVehicle();
        ArrayList<String> expected4 = new ArrayList<>();
        expected4.add("toyota " + "[" + date + "]: [<Value Passenger> Lewis]");
        assertEquals(shareride1.getRecords(), expected4);

        shareride2.addVehicle(pv1);
        shareride2.addPassenger(Lewis);
        shareride2.addPassenger(Max);
        shareride2.assignPassengerToVehicle();
        ArrayList<String> expected5 = new ArrayList<>();
        expected5.add("bmw01 (Premium) " + "[" + date + "]: [<Value Passenger> Lewis, <Value Passenger> Max]");
        assertEquals(shareride2.getRecords(), expected5);

        shareride3.addVehicle(pv2);
        shareride3.addPassenger(Lewis);
        shareride3.addPassenger(yunyi);
        shareride3.assignPassengerToVehicle();
        ArrayList<String> expected6 = new ArrayList<>();
        expected6.add("ferrari (Premium) " + "[" + date + "]: [<Value Passenger> Lewis, <Value Passenger> Yunyi]");
        assertEquals(shareride3.getRecords(), expected6);
    }

}
