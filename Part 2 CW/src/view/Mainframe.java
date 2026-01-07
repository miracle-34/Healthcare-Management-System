package view;

import javax.swing.*;

public class Mainframe extends JFrame {

    public Mainframe() {

        setTitle("Healthcare Management System");
        setSize(900, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JTabbedPane tabbedPane = new JTabbedPane();

        // Patients
        tabbedPane.addTab("Patients", new PatientsPanel());

        // Clinicians
        tabbedPane.addTab("Clinicians", new CliniciansPanel());

        // Appointments
        tabbedPane.addTab("Appointments", new AppointmentsPanel());

        // Prescriptions  ✅ THIS WAS THE BIG BUG
        tabbedPane.addTab("Prescriptions", new PrescriptionPanel());

        // Referrals
        tabbedPane.addTab("Referrals", new ReferralsPanel());

        add(tabbedPane);
        setVisible(true);
    }
}
