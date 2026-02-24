package appointment;

import java.util.Date;

/*
 * Name: Gary Travis
 * Course: CS 320
 *
 * The Appointment class represents a single appointment.
 * Each appointment has a unique appointmentId, a required date,
 * and a required description.
 */
public class Appointment {

    // appointmentId is final so it cannot be updated
    private final String appointmentId;
    private Date appointmentDate;
    private String description;

    /*
     * Creates an Appointment with validated values.
     * All fields are required and must meet the rules.
     */
    public Appointment(String appointmentId, Date appointmentDate, String description) {

        // appointmentId: required, <= 10 characters
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }

        // appointmentDate: required, cannot be in the past
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }

        // description: required, <= 50 characters
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters

    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }

    /*
     * Setters for fields that are allowed to change.
     * Note: appointmentId does not have a setter.
     */

    public void setAppointmentDate(Date appointmentDate) {
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        this.appointmentDate = appointmentDate;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid appointment description");
        }
        this.description = description;
    }
}