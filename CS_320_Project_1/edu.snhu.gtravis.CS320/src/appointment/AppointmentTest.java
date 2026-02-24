package appointment;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Calendar;
import java.util.Date;

import org.junit.jupiter.api.Test;

/*
 * Name: Gary Travis
 * Course: CS 320
 *
 * These tests verify that the Appointment class
 * follows the ID, date, and description rules.
 */
public class AppointmentTest {

    // Helper to get a future date (tomorrow)
    private Date getFutureDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, 1);
        return cal.getTime();
    }

    // Helper to get a past date (yesterday)
    private Date getPastDate() {
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DAY_OF_YEAR, -1);
        return cal.getTime();
    }

    @Test
    public void testValidAppointmentCreation() {
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1234567890", futureDate, "Regular checkup");

        assertEquals("1234567890", appt.getAppointmentId());
        assertEquals(futureDate, appt.getAppointmentDate());
        assertEquals("Regular checkup", appt.getDescription());
    }

    @Test
    public void testAppointmentIdNull() {
        Date futureDate = getFutureDate();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentIdTooLong() {
        Date futureDate = getFutureDate();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678901", futureDate, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentDateNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Regular checkup");
        });
    }

    @Test
    public void testAppointmentDateInPast() {
        Date pastDate = getPastDate();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Regular checkup");
        });
    }

    @Test
    public void testDescriptionNull() {
        Date futureDate = getFutureDate();

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, null);
        });
    }

    @Test
    public void testDescriptionTooLong() {
        Date futureDate = getFutureDate();
        String longDescription = "This description is definitely longer than fifty characters in length";

        assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, longDescription);
        });
    }

    @Test
    public void testUpdateAppointmentDateValid() {
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1234567890", futureDate, "Regular checkup");

        Date newFutureDate = getFutureDate();
        appt.setAppointmentDate(newFutureDate);

        assertEquals(newFutureDate, appt.getAppointmentDate());
    }

    @Test
    public void testUpdateAppointmentDateToPastFails() {
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1234567890", futureDate, "Regular checkup");

        Date pastDate = getPastDate();

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setAppointmentDate(pastDate);
        });
    }

    @Test
    public void testUpdateDescriptionValid() {
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1234567890", futureDate, "Regular checkup");

        appt.setDescription("Updated description");
        assertEquals("Updated description", appt.getDescription());
    }

    @Test
    public void testUpdateDescriptionTooLongFails() {
        Date futureDate = getFutureDate();
        Appointment appt = new Appointment("1234567890", futureDate, "Regular checkup");

        String longDescription = "This description is definitely longer than fifty characters in length";

        assertThrows(IllegalArgumentException.class, () -> {
            appt.setDescription(longDescription);
        });
    }
}