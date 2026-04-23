package prj5;

// Project 5 Spring 2026

// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Santiago Gonzalez-Zunino (906693577)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

import java.io.IOException;

/**
 * // -------------------------------------------------------------------------
 * /** The entry point for the Social Media Dashboard application
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 23, 2026
 */
public class ProjectRunner
{

    public static void main(String[] args)
    {
        String fileName = (args.length > 0) ? args[0] : "SampleInput1_2023.csv";

        try
        {
            InputFileReader reader = new InputFileReader(fileName);
            DoublyLinkedList<InfluencerData> influencers =
                reader.getInfluencers();

            AnalyticsManager manager = new AnalyticsManager(influencers);

            SocialMediaDashboard dashboard = new SocialMediaDashboard(manager);

            new GUISocialMediaWindowView(dashboard);

        }
        catch (IOException e)
        {
            System.out.println("Error: Could not read file " + fileName);
        }
    }
}
