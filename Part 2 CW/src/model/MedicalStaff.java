package model;

public class MedicalStaff extends Person{
    private String staffId;
    private String qualification;
    private String specialty;
    private String workplaceId;


    public MedicalStaff(String name, String phonenum, String address, String dob, String staffId, String qualification, String specialty, String workplaceId) {
        super(name, phonenum, address, dob);
        this.staffId = staffId;
        this.qualification = qualification;
        this.specialty = specialty;
        this.workplaceId = workplaceId;
    }
    public String getStaffId() {return staffId;}
    public String getQualification(){return qualification;}
    public String getSpecialty(){return specialty;}
    public String getWorkplaceId(){return workplaceId;}

}
