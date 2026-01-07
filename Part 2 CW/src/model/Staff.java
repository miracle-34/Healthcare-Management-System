package model;

public class Staff extends Person {
    private String staffId;
    private String role;
    private String facilityId;
    private String email;

    public Staff(String staffId, String name, String phonenum, String address, String dob, String role, String facilityId, String email) {
        super(name, phonenum, address, dob);
        this.staffId = staffId;
        this.role = role;
        this.facilityId = facilityId;
        this.email = email;
    }

    public String getStaffId() {return staffId;}
    public String getRole() {return role;}
    public String getFacilityId() {return facilityId;}
    public String getEmail() {return email;}

    public void setRole(String role){this.role = role;}
    public void setFacilityId(String facilityId) {this.facilityId= facilityId;}
    public void setEmail(String email) {this.email = email;}

    public String viewDetails()
    {
        return "StaffID: " + staffId +
                ", Role: " + role +
                ", Facility: " + facilityId +
                ", Email: " + email +
                " | " + getDetails();

    }
}
