package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;

import controller.AppointmentController;


public class AppointmentsPanel extends JPanel{

    private JTable table;
    private DefaultTableModel tableModel;
    private AppointmentController controller;

    public AppointmentsPanel()
    {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton loadButton = new JButton("Load");
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");


        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(loadButton);

        String[] columns = {
                "Appointment ID",
                "Patient",
                "Clinician",
                "Date",
                "Time",
                "Status",
                "Reason"
        };

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);

        addButton.addActionListener(e -> addAppointment());
        editButton.addActionListener(e -> editAppointment());
        deleteButton.addActionListener(e -> deleteAppointment());
        loadButton.addActionListener(e -> loadAppointmentsFromFile());
    }

    private void addAppointment()
    {
        String id = JOptionPane.showInputDialog(this, "Appointment ID: ");
        if (id == null) return;

        String patient = JOptionPane.showInputDialog(this, "Patient: ");
        if (patient == null) return;

        String clinician = JOptionPane.showInputDialog(this, "Patient: ");
        if (clinician== null) return;

        String date= JOptionPane.showInputDialog(this, "Patient: ");
        if (date == null) return;

        String time = JOptionPane.showInputDialog(this, "Patient: ");
        if (time == null) return;

        String status = JOptionPane.showInputDialog(this, "Patient: ");
        if (status == null) return;

        String reason = JOptionPane.showInputDialog(this, "Patient: ");
        if (reason == null) return;

        controller.addAppointment(id, patient, clinician, date, time, status, reason);

    }

    private void editAppointment() {
        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select an appointment first.");
            return;
        }

        for (int col = 0; col < tableModel.getColumnCount(); col++) {
            String current = tableModel.getValueAt(row, col).toString();
            String updated = JOptionPane.showInputDialog(this, "Update" + tableModel.getColumnName(col), current);
            if (updated != null) {
                tableModel.setValueAt(updated, row, col);
            }
        }
    }

    private void deleteAppointment()
    {
        int row = table.getSelectedRow();
        if (row == -1)
        {
            JOptionPane.showMessageDialog(this, "Select an appointment first");
            return;
        }

        controller.deleteAppointment(row);
    }

    private void loadAppointmentsFromFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select appointments.csv");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (parts.length < 7) continue;

                tableModel.addRow(new Object[]{
                        parts[0].trim(), // appointment id
                        parts[1].trim(), // patient
                        parts[2].trim(), // clinician
                        parts[3].trim(), // date
                        parts[4].trim(), // time
                        parts[5].trim(), // status
                        parts[6].replace("\"", "").trim() // reason
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load appointments file.");
            e.printStackTrace();
        }
    }

}
