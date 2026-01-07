package model;

public class Nurse extends MedicalStaff{

    public Nurse(String name, String phonenum, String address, String dob, String staffId, String qualification, String specialty, String workplaceId) {
        super(name, phonenum, address, dob, staffId, qualification, specialty, workplaceId);
    }

    public String updateVitals(String patientName, String temperature, String bloodPressure, String pulse)
    {
        return patientName + "\n " + "Temperature: " +
                temperature + "\n" + "Blood pressure: " +
                bloodPressure + "\n" + "Pulse: " +
                pulse + "\n";

    }
}
