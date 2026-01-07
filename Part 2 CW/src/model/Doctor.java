package model;

public class Doctor extends MedicalStaff{
    public Doctor(String name, String phonenum, String address, String dob, String staffId, String qualification, String specialty, String workplaceId) {
        super(name, phonenum, address, dob, staffId, qualification, specialty, workplaceId);
    }

    public String diagnosePatient(String patientName, String symptoms)
    {
        return "Doctor " + getName() +
                "diagnosed patient " + patientName +
                " with symptoms: " + symptoms;
    }

    public String prescribeMedication(String patientName, String medication)
    {
        return patientName + " has been prescribed " +
                medication + ". ";
    }

}
