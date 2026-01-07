package model;

public class Appointment {
    private String appointmentId;
    private String patientId;
    private String clinicianId;
    private String facilityId;
    private String date;
    private String time;
    private String reason;
    private String status;


    public Appointment(String appointmentId, String patientId, String clinicianId, String facilityId, String date, String time, String reason, String status)
    {
        this.appointmentId = appointmentId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.facilityId = facilityId;
        this.date = date;
        this.time = time;
        this.reason = reason;
        this.status = status;

    }

    public String getAppointmentId(){return appointmentId;}
    public String getClinicianId() {return clinicianId;}
    public String getPatientId() {return patientId;}
    public String getFacilityId() {return facilityId;}
    public String getDate() {return date;}
    public String getTime() {return time;}
    public String getReason() {return reason;}
    public String getStatus() {return status;}

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setDate(String date)
    {
        this.date = date;
    }
    public void setTime(String time)
    {
        this.time = time;
    }

    public void setReason(String reason)
    {
        this.reason = reason;
    }

    public String getDetails()
    {
        return "Appointment ID " + appointmentId +
                ", Date: " + date +
                ", Time: " + time +
                ", Reason: " + reason +
                ", Status: " + status;
    }
}
