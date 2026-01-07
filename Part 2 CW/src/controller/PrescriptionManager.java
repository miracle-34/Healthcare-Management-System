package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionManager {

    private static PrescriptionManager instance;

    private List<String> prescriptions;

    private static final String PRESCRIPTION_FILE = "datafiles/prescriptions.csv";

    private PrescriptionManager()
    {
        prescriptions = new ArrayList<>();
        loadExistingPrescriptions();
    }

    public static PrescriptionManager getInstance()
    {
        if (instance == null)
        {
            instance = new PrescriptionManager();
        }
        return instance;
    }
    private void loadExistingPrescriptions()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(PRESCRIPTION_FILE)))
        {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null)
            {
                if (firstLine)
                {
                    firstLine = false;
                    continue;
                }

                if (!line.trim().isEmpty())
                {
                    prescriptions.add(line);
                }
            }
        } catch (IOException e)
        {
            System.out.println("Prescription file not found. A new one will be created.");
        }
    }
    public void addPrescription(String prescriptionText)
    {
        prescriptions.add(prescriptionText);
        saveToFile(prescriptionText);
    }
    private void saveToFile(String prescriptionText) {

        try (FileWriter writer = new FileWriter(PRESCRIPTION_FILE, true)) {

            // Convert multi-line text to single CSV line
            String csvLine = prescriptionText.replace("\n", " | ");
            writer.write(csvLine);
            writer.write("\n");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ---------- ACCESS LIST ----------
    public List<String> getPrescriptions() {
        return prescriptions;
    }
}

