package appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

/*
 * Name: Gary Travis
 * Course: CS 320
 *
 * These tests verify that the AppointmentService class
 * can add and delete appointments correctly.
 */
public class AppointmentServiceTest {

    // Helper to get a future date (tomorrow)
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    @Test
    public void testAddAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1", futureDate, "Checkup");

        service.addAppointment(appt);

        assertNotNull(service.getAppointment("1"));
        assertEquals("Checkup", service.getAppointment("1").getDescription());
    }

    @Test
    public void testAddAppointmentDuplicateId() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();

        Appointment a1 = new Appointment("1", futureDate, "Checkup");
        Appointment a2 = new Appointment("1", futureDate, "Follow-up");

        service.addAppointment(a1);

        assertThrows(IllegalArgumentException.class, () -> {
            service.addAppointment(a2);
        });
    }

    @Test
    public void testDeleteAppointment() {
        AppointmentService service = new AppointmentService();
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1", futureDate, "Checkup");

        service.addAppointment(appt);
        service.deleteAppointment("1");

        assertNull(service.getAppointment("1"));
    }

    @Test
    public void testDeleteAppointmentDoesNotExist() {
        AppointmentService service = new AppointmentService();

        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteAppointment("999");
        });
    }
}