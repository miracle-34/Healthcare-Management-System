package view;

import controller.ReferralManager;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.io.BufferedReader;
import java.io.FileReader;

public class ReferralsPanel extends JPanel{

    private JTextArea outputArea;

    public ReferralsPanel()
    {
        setLayout(new BorderLayout());

        JButton loadButton = new JButton("Load");

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JButton createButton = new JButton("Create Referral");
        JButton viewQueueButton = new JButton(("View Referrals"));
        loadButton.addActionListener(e -> loadReferralsFromFile());

        buttonPanel.add(createButton);
        buttonPanel.add(viewQueueButton);
        buttonPanel.add(loadButton);

        add(buttonPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        add(scrollPane, BorderLayout.CENTER);

        createButton.addActionListener(e -> createReferral());
        viewQueueButton.addActionListener(e -> viewReferrals());

    }

    private void createReferral()
    {
        String patientName = JOptionPane.showInputDialog(this, "Patient name:");
        if (patientName == null) return;

        String referredTo = JOptionPane.showInputDialog(this, "Referred to (department/hospital)");
        if (referredTo == null) return;

        String urgency = JOptionPane.showInputDialog(this, "Urgency (Routine / Urgent)");
        if (urgency == null) return;

        String summary = JOptionPane.showInputDialog(this, "Clinician summary: ");
        if (summary == null) return;

        String referralText =
                "Referral\n" + "Patient: " +
                        patientName + "\n" + "Referred to: " +
                        referredTo + "\n" + "Urgency: " +
                        urgency +"\n" + "Summary: " + summary;

        ReferralManager.getInstance().addReferral(referralText);

        outputArea.append(referralText + "\n--------------------------------------\n");
    }

    private void viewReferrals()
    {
        outputArea.setText("");

        for (String referral : ReferralManager.getInstance().getReferralQueue())
        {
            outputArea.append(referral + "\n----------------------------------\n");

        }
    }

    private void loadReferralsFromFile() {

        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Select referrals.csv");

        int result = fileChooser.showOpenDialog(this);
        if (result != JFileChooser.APPROVE_OPTION) return;

        String filePath = fileChooser.getSelectedFile().getAbsolutePath();

        outputArea.setText("");

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                outputArea.append(line + "\n---------------------\n");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Failed to load referrals file.");
            e.printStackTrace();
        }
    }

}



