package model;

public class Clinician extends Person {
    private String clinicianId;
    private String role;
    private String specialty;
    private String qualification;
    private String facilityId;


    public Clinician(String clinicianId, String name, String phone, String address, String dob, String role, String specialty, String qualification, String facilityId)
    {
        super(name, phone, address, dob);
        this.clinicianId = clinicianId;
        this.role = role;
        this.specialty = specialty;
        this.qualification = qualification;
        this.facilityId = facilityId;
    }

    public String getClinicianId(){return clinicianId;}
    public String getRole(){return role;}
    public String getSpecialty(){return specialty;}
    public String getQualification(){return qualification;}
    public String getFacilityId(){return facilityId;}


    public String viewDetails()
    {
        return "Clinician ID: " + clinicianId +
                ", Role: " + role +
                ", Specialty: " + specialty +
                ", Qualification: " + qualification +
                ", Facility: " + facilityId +
                " | " + getDetails();
    }
}
