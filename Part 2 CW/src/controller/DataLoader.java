package controller;

import model.Patient;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataLoader {

    public static List<Patient> loadPatients(String filePatch) {
        List<Patient> patients = new ArrayList<>();


        try {
            BufferedReader reader = new BufferedReader(new FileReader(filePatch));
            String line;

            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) { // skip header
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (parts.length < 5) continue;

                String id = parts[0].trim();
                String name = parts[1].trim();
                String phone = parts[2].trim();
                String address = parts[3].replace("\"", "").trim();
                String dob = parts[4].trim();

                patients.add(new Patient(id, name, phone, address, dob));
            }

        } catch (Exception e) {
            e.printStackTrace(); // IMPORTANT for debugging
        }

        return patients;
    }
}
