package view;

import controller.DataLoader;
import model.Patient;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.JFileChooser;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.List;



public class PatientsPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public PatientsPanel() {
        setLayout(new BorderLayout());

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton loadButton = new JButton("Load");
        JButton addButton = new JButton("Add");
        JButton editButton = new JButton("Edit");
        JButton deleteButton = new JButton("Delete");

        buttonPanel.add(loadButton);
        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.NORTH);


        String[] columns =
                {
                        "Patient ID",
                        "Name",
                        "Phone",
                        "Address",
                        "Date of Birth"
                };

        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);

        loadButton.addActionListener(e -> loadPatientsFromFile());
        addButton.addActionListener(e -> addPatient());
        editButton.addActionListener(e -> editPatient());
        deleteButton.addActionListener(e -> deletePatient());

    }
    private void loadPatientsFromFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select patients.csv");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        List<Patient> patients = DataLoader.loadPatients(filePath);

        if (patients == null || patients.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this,
                    "No patients loaded.\nCheck file format.",
                    "Load Patients",
                    JOptionPane.WARNING_MESSAGE
            );
            return;
        }

        tableModel.setRowCount(0);

        for (Patient p : patients) {
            tableModel.addRow(new Object[] {
                    p.getPatientID(),
                    p.getName(),
                    p.getPhone(),
                    p.getAddress(),
                    p.getDob()
            });
        }
    }


    private void addPatient() {

        String id = JOptionPane.showInputDialog(this, "Patient ID:");
        if (id == null) return;

        String name = JOptionPane.showInputDialog(this, "Name:");
        if (name == null) return;

        String phone = JOptionPane.showInputDialog(this, "Phone:");
        if (phone == null) return;

        String address = JOptionPane.showInputDialog(this, "Address:");
        if (address == null) return;

        String dob = JOptionPane.showInputDialog(this, "Date of Birth:");
        if (dob == null) return;

        tableModel.addRow(new Object[] { id, name, phone, address, dob });
    }

    // ---------- EDIT ----------
    private void editPatient() {

        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a patient first.");
            return;
        }

        for (int col = 0; col < tableModel.getColumnCount(); col++) {

            String current = tableModel.getValueAt(row, col).toString();

            String updated = JOptionPane.showInputDialog(
                    this,
                    "Update " + tableModel.getColumnName(col),
                    current
            );

            if (updated != null) {
                tableModel.setValueAt(updated, row, col);
            }
        }
    }

    // ---------- DELETE ----------
    private void deletePatient() {

        int row = table.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Select a patient first.");
            return;
        }

        tableModel.removeRow(row);
    }
}
