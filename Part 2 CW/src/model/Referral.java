package model;

public class Referral {
    private String referralId;
    private String patientId;
    private String clinicianId;
    private String fromFacilityId;
    private String toFacilityId;
    private String clinicalSummary;
    private String urgencyLevel;
    private String status;
    private String dateCreated;


    public Referral(String referralId, String patientId,String clinicianId, String fromFacilityId, String toFacilityId, String clinicalSummary, String urgencyLevel, String status, String dateCreated)
    {
        this.referralId = referralId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.fromFacilityId = fromFacilityId;
        this.toFacilityId = toFacilityId;
        this.clinicalSummary = clinicalSummary;
        this.urgencyLevel = urgencyLevel;
        this.status = status;
        this.dateCreated = dateCreated;
    }

    public String getReferralId(){return referralId;}
    public String getPatientId(){return patientId;}
    public String getClinicianId() {return clinicianId;}
    public String getFromFacilityId() {return fromFacilityId;}
    public String getToFacilityId() {return toFacilityId;}
    public String getClinicalSummary() {return clinicalSummary;}
    public String getUrgencyLevel() {return urgencyLevel;}
    public String getStatus() {return status;}
    public String getDateCreated() {return dateCreated;}

    public void setStatus(String status)
    {
        this.status = status;
    }

    public void setClinicalSummary(String clinicalSummary)
    {
        this.clinicalSummary = clinicalSummary;
    }

    public String generateReferralText()
    {
        return "Referral ID: " + referralId + "\n" +
                "Date Created: " + dateCreated + "\n" +
                "Urgency: " + urgencyLevel + "\n" +
                "Patient ID: " + patientId + "\n" +
                "Clinician ID: " + clinicianId + "\n" +
                "From Facility: " + fromFacilityId + "\n" +
                "To Facility: " + toFacilityId + "\n" +
                "Clinical Summary:\n" + clinicalSummary +"\n\n" +
                "Staus: " + status;
    }
}
