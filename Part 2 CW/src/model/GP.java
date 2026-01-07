package model;

import controller.ReferralManager;

public class GP extends MedicalStaff{
    public GP(String name, String phonenum, String address, String dob, String staffId, String qualification, String specialty, String workplaceId) {

        super(name, phonenum, address, dob, staffId, qualification, specialty, workplaceId);
    }
    public String createReferral(String patientName, String referredTo, String clinicalSummary, String urgency)
    {
        String referralText =
                "GP " + getName() +
                " created a referral for patient" + patientName +
                "\nReferred to: " + referredTo +
                "\nUrgency: " + urgency +
                "\nClinical summary: " + clinicalSummary;

        ReferralManager.getInstance().addReferral(referralText);

        return referralText;    }
}
