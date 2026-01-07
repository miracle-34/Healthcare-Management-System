package model;

import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String patientId;

    private List<Appointment> appointments = new ArrayList<>();

    public Patient(String patientId, String name, String phonenum, String address, String dob) {
        super(name, phonenum, address, dob);
        this.patientId = patientId;
        this.appointments = new ArrayList<>();
    }

    public String getPatientID()
    {
        return patientId;
    }

    public String viewDetails()
    {
        return "PatientID: " + patientId + " | " + getDetails();
    }

    public Appointment bookAppointment(String appointmentId, String clinicianId, String date, String time, String reason)
    {

        String facilityId = "";
        Appointment a = new Appointment(appointmentId, patientId, clinicianId, facilityId, date, time, reason, "BOOKED");
        appointments.add(a);
        return a;
    }

    public void cancelAppointment(Appointment a)
    {
        a.setStatus("CANCELLED");

    }

    public void changeAppointment(Appointment a, String newDate, String newTime, String newReason)
    {
        a.setDate(newDate);
        a.setTime(newTime);
        a.setReason(newReason);
    }

    public void add(Patient patient)
    {

    }
}
