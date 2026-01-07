package view;

import controller.ClinicianController;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;

public class CliniciansPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;
    private ClinicianController controller;

    public CliniciansPanel()
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

        add(buttonPanel, BorderLayout.NORTH);

        loadButton.addActionListener(e -> loadCliniciansFromFile());

        String[] columns =
                {
                        "Staff ID",
                        "Name",
                        "Role",
                        "Specialty",
                        "Workplace"
                };
        tableModel = new DefaultTableModel(columns, 0);
        table = new JTable(tableModel);

        add(new JScrollPane(table), BorderLayout.CENTER);

        controller = new ClinicianController(tableModel);

        addButton.addActionListener(e -> addClinician());
        editButton.addActionListener(e -> editClinician());
        deleteButton.addActionListener(e -> deleteClinician());

    }

    private void addClinician()
    {
        String staffId = JOptionPane.showInputDialog(this, "Staff ID: ");
        if (staffId == null) return;

        String name= JOptionPane.showInputDialog(this, "Staff ID: ");
        if (name == null) return;

        String role= JOptionPane.showInputDialog(this, "Staff ID: ");
        if (role == null) return;

        String specialty = JOptionPane.showInputDialog(this, "Staff ID: ");
        if (specialty == null) return;

        String workplace = JOptionPane.showInputDialog(this, "Staff ID: ");
        if (workplace == null) return;

        controller.addClinician(staffId, name, role, specialty, workplace);


    }

    private void editClinician()
    {
        int row = table.getSelectedRow();
        if (row == -1)
        {
            JOptionPane.showMessageDialog(this, "Select a clinican first.");
            return;
        }

        for (int col = 0; col < tableModel.getColumnCount(); col++)
        {
            String current = tableModel.getValueAt(row, col).toString();

            String updated = JOptionPane.showInputDialog(this, "Update" + tableModel.getColumnName(col), current);


            if (updated != null)
            {
                controller.updateClinician(row, col, updated);
            }
        }
    }

    private void deleteClinician()
    {
        int row = table.getSelectedRow();
        if (row == -1)
        {
            JOptionPane.showMessageDialog(this, "Select a clinician first.");
            return;
        }
        controller.deleteClinician(row);
    }

    private void loadCliniciansFromFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select clinicians.csv");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        tableModel.setRowCount(0);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false; // skip header
                    continue;
                }

                String[] parts = line.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)");

                if (parts.length < 5) continue;

                tableModel.addRow(new Object[]{
                        parts[0].trim(), // staffId
                        parts[1].trim(), // name
                        parts[2].trim(), // role
                        parts[3].replace("\"", "").trim(), // specialty
                        parts[4].replace("\"", "").trim()  // workplace
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load clinicians file.");
            e.printStackTrace();
        }
    }


}
