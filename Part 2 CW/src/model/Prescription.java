package model;

public class Prescription {

    private String prescriptionId;
    private String patientId;
    private String clinicianId;
    private String medication;
    private String dosage;
    private String pharmacy;
    private String collectionStatus;
    private String dateIssued;

    public Prescription(String prescriptionId, String patientId, String clinicianId, String medication, String dosage, String pharmacy, String collectionStatus, String dateIssued)
    {
        this.prescriptionId = prescriptionId;
        this.patientId = patientId;
        this.clinicianId = clinicianId;
        this.medication = medication;
        this.dosage = dosage;
        this.pharmacy = pharmacy;
        this.collectionStatus = collectionStatus;
        this.dateIssued = dateIssued;
    }

    public String getPrescriptionId(){return prescriptionId;}
    public String getPatientId(){return patientId;}
    public String getClinicianId(){return clinicianId;}
    public String getMedication(){return medication;}
    public String getDosage(){return dosage;}
    public String getPharmacy(){return pharmacy;}
    public String getCollectionStatus(){return collectionStatus;}
    public String getDateIssued(){return dateIssued;}


    public void setCollectionStatus(String collectionStatus)
    {
        this.collectionStatus = collectionStatus;
    }

    public void setPharmacy(String pharmacy)
    {
        this.pharmacy = pharmacy;
    }

    public String generatePrescriptionText()
    {
        return "Prescription ID: " + prescriptionId + "\n" +
        "Patient ID: " + patientId + "\n" +
        "Clinician ID: " + clinicianId + "\n" +
        "Medication ID: " + medication + "\n" +
        "Dosage: " + dosage + "\n" +
        "Pharmacy: " + pharmacy + "\n" +
        "Status: " + collectionStatus + "\n" +
        "Date Issued: " + dateIssued;
    }




}
