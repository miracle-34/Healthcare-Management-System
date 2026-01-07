package controller;

import javax.swing.table.DefaultTableModel;

public class AppointmentController {

    private DefaultTableModel tableModel;

    public AppointmentController(DefaultTableModel tableModel) {
        this.tableModel = tableModel;
    }

    public void addAppointment(String id, String patient, String clinician, String date, String time, String status, String reason) {
        tableModel.addRow(new Object[]
                {
                        id, patient, clinician, date, time, status, reason
                });
    }

    public void updateAppointment(int row, int column, String newValue)
    {
        tableModel.setValueAt(newValue, row, column);
    }

    public void deleteAppointment(int row)
    {
        tableModel.removeRow(row);
    }
}

