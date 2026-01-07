package controller;

import javax.swing.table.DefaultTableModel;

public class ClinicianController {

    private DefaultTableModel tableModel;

    public ClinicianController(DefaultTableModel tableModel)
    {
        this.tableModel = tableModel;
    }

    public void addClinician(String staffId, String name, String role, String specialty, String workplace)
    {
        tableModel.addRow(new Object[]
                {
                        staffId, name, role, specialty, workplace
                });
    }

    public void updateClinician(int row, int column, String newValue)
    {
        tableModel.setValueAt(newValue, row, column);
    }

    public void deleteClinician(int row)
    {
        tableModel.removeRow(row);
    }
}
