package view;

import controller.PrescriptionManager;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionPanel extends JPanel {

    private JTextArea outputArea;

    public PrescriptionPanel()
    {
        setLayout(new BorderLayout());

        JButton loadButton = new JButton("Load");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.add(loadButton);


        JButton createButton = new JButton("Create Prescription");
        JButton viewQueueButton = new JButton(("View Prescriptions"));



        buttonPanel.add(createButton);
        buttonPanel.add(viewQueueButton);

        add(buttonPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        createButton.addActionListener(e -> createPrescription());
        viewQueueButton.addActionListener(e -> viewPrescriptions());
        loadButton.addActionListener(e -> loadPrescriptionsFromFile());

    }
    private void createPrescription()
    {
        String patientName = JOptionPane.showInputDialog(this, "Patient name: ");
        if (patientName == null) return;

        String medication = JOptionPane.showInputDialog(this, "Medication: ");
        if (medication == null) return;

        String dosage = JOptionPane.showInputDialog(this, "Dosage: ");
        if (dosage == null) return;

        String pharmacy = JOptionPane.showInputDialog(this, "Pharmacy: ");
        if (pharmacy == null) return;

        String collectionStatus = JOptionPane.showInputDialog(this, "Collection: ");
        if (collectionStatus == null) return;

        String prescriptionText =
                "Prescription\n" +
                        "Patient: " + patientName + "\n" +
                        "Medication: " + medication + "\n" +
                        "Dosage: " + dosage + "\n" +
                        "Pharmacy: " + pharmacy + "\n" +
                        "Status: " + collectionStatus;

        PrescriptionManager.getInstance().addPrescription(prescriptionText);

        outputArea.append(prescriptionText + "\n-------------------------\n");

    }
    private void viewPrescriptions()
    {
        outputArea.setText("");
        for (String p : PrescriptionManager.getInstance().getPrescriptions())
        {
            outputArea.append(p + "\n--------------------\n");
        }
    }
    private void loadPrescriptionsFromFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select prescriptions.csv");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        List<String> loadedPrescriptions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }

                if (!line.trim().isEmpty()) {
                    loadedPrescriptions.add(line);
                }
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(
                    this,
                    "Failed to load prescriptions file.",
                    "Load Prescriptions",
                    JOptionPane.ERROR_MESSAGE
            );
            e.printStackTrace();
            return;
        }

        if (loadedPrescriptions.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No prescriptions loaded.\nCheck file format.",
                    "Load Prescriptions",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        // Clear manager + reload
        PrescriptionManager.getInstance().getPrescriptions().clear();
        PrescriptionManager.getInstance().getPrescriptions().addAll(loadedPrescriptions);

        // Display in UI
        outputArea.setText("");
        for (String p : loadedPrescriptions) {
            outputArea.append(p + "\n-------------------------\n");
        }
    }

}


