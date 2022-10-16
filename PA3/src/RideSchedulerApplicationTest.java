/*
  Name: Your Name
  PID:  A12345678
 */

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.time.LocalDate;

/**
 * TODO
 * @author TODO
 * @since  TODO
 */
public class RideSchedulerApplicationTest {
    protected static final String DENIED_PASSENGER_GROUP =
            "This operation is disabled in your passenger group.";
    ValuePassenger yunyi;
    StandardPassenger viren;
    PremiumVehicle pv1;
    LocalDate date = LocalDate.now();


    @Before
    public void setup() throws OperationDeniedException {
        yunyi = new ValuePassenger("Yunyi", "Tutor");
        viren = new StandardPassenger("Viren", "Tutor");
        pv1 = new PremiumVehicle("bmw01");
    }

    @Test (expected = IllegalArgumentException.class)
    public void TestValuePassengerThrowsIAE(){
        yunyi = new ValuePassenger("Yunyi",null);
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

    /*TODO: Add your tests*/
}
