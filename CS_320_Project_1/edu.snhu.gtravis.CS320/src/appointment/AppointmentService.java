package appointment;

import java.util.HashMap;
import java.util.Map;

/*
 * Name: Gary Travis
 * Course: CS 320
 *
 * AppointmentService manages Appointment objects in memory.
 * It lets me add and delete appointments using a unique ID.
 */
public class AppointmentService {

    // Stores appointments using appointmentId as the key
    private final Map<String, Appointment> appointments = new HashMap<>();

    /*
     * Adds a new appointment.
     * The appointmentId must be unique.
     */
    public void addAppointment(Appointment appointment) {
        if (appointment == null) {
            throw new IllegalArgumentException("Appointment cannot be null");
        }

        String id = appointment.getAppointmentId();
        if (appointments.containsKey(id)) {
            throw new IllegalArgumentException("Appointment ID already exists");
        }

        appointments.put(id, appointment);
    }

    /*
     * Deletes an appointment using the appointmentId.
     */
    public void deleteAppointment(String appointmentId) {
        if (appointmentId == null) {
            throw new IllegalArgumentException("Appointment ID cannot be null");
        }

        if (!appointments.containsKey(appointmentId)) {
            throw new IllegalArgumentException("Appointment ID does not exist");
        }

        appointments.remove(appointmentId);
    }

    /*
     * Looks up and returns an appointment by ID.
     * This is mainly used for testing.
     */
    public Appointment getAppointment(String appointmentId) {
        return appointments.get(appointmentId);
    }
}