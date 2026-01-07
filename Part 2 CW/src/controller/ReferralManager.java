package controller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReferralManager {


    private static ReferralManager instance;

    private List<String> referralQueue;

    private static final String REFERRAL_FILE = "datafiles/referrals.csv";

    private ReferralManager()
    {
        referralQueue = new ArrayList<>();
        loadExistingReferrals();
    }

    public static ReferralManager getInstance()
    {
        if (instance == null){
            instance = new ReferralManager();
        }
        return instance;
    }

    private void loadExistingReferrals()
    {
        try (BufferedReader reader = new BufferedReader(new FileReader(REFERRAL_FILE)))
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
                    referralQueue.add(line);
                }
            }
        } catch (IOException e)
        {
            System.out.println("Referrals file not found. A new one will be created.");
        }
    }

    public void addReferral(String referralText)
    {
        referralQueue.add(referralText);
        saveToFile(referralText);
    }

    public List<String> getReferralQueue()
    {
        return referralQueue;
    }

    private void saveToFile(String referralText)
    {
        try (FileWriter writer = new FileWriter(REFERRAL_FILE, true))
        {
            String csvLine = referralText.replace("\n", " | ");
            writer.write(csvLine);
            writer.write("\n");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }}


