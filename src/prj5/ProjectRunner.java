package prj5;

// Project 5 Spring 2026

// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Santiago Gonzalez-Zunino (906693577)
// -- Dohoon Kim (kim)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * The entry point for the Social Media Dashboard application
 * 
 * @author Santiago Gonzalez-Zunino
 * @author Dohoon Kim
 * @version Apr 23, 2026
 */
public class ProjectRunner
{

    private static final boolean SHOW_CONSOLE = true;
    private static final boolean SHOW_GUI = true;
    private static final DecimalFormat decimalFormat = new DecimalFormat("#.#");

    /**
     * Entry point for social media dashboard application
     * 
     * @param args
     *            optional command-line argument specifying the input file name;
     *            defaults to "SampleInput1_2023.csv" if not provided
     */
    public static void main(String[] args)
    {
        String fileName = (args.length > 0) ? args[0] : "SampleInput1_2023.csv";

        try
        {
            InputFileReader reader = new InputFileReader(fileName);
            DoublyLinkedList<InfluencerData> influencers =
                reader.getInfluencers();
            AnalyticsManager manager = new AnalyticsManager(influencers);

            if (SHOW_GUI)
            {
                SocialMediaDashboard dashboard =
                    new SocialMediaDashboard(manager);
                new GUISocialMediaWindowView(dashboard);
            }

            if (SHOW_CONSOLE)
            {
                printReportOnConsole(manager, EngagementFormula.TRADITIONAL);
                System.out.println("**********");
                System.out.println("**********");
                printReportOnConsole(manager, EngagementFormula.REACH);
            }
        }
        catch (IOException e)
        {
            System.out.println("Error: Could not read file " + fileName);
        }
    }


    /**
     * Prints Report on Console
     * 
     * @param manager
     *            AnalyticsManager object
     */
    private static void printReportOnConsole(
        AnalyticsManager manager,
        EngagementFormula formula)
    {
        DoublyLinkedList<ChannelData> data =
            manager.getFilteredData(Period.FIRST_QUARTER, formula);

        manager.sortData(
            data,
            formula == EngagementFormula.TRADITIONAL
                ? new ChannelNameComparator()
                : new EngagementComparator());

        // transform to ArrayList to make it iterable
        ArrayList<ChannelData> channelList = data.toArrayList();

        for (ChannelData channel : channelList)
        {
            System.out.println(channel.getChannelName());

            Double engagementRate = channel.getEngagementRate();

            if (formula == EngagementFormula.REACH)
            {
                if (engagementRate < 0)
                {
                    System.out.println("reach: N/A");
                }
                else
                {
                    System.out.println(
                        "reach: " + decimalFormat
                            .format(channel.getEngagementRate()));
                }
            }
            else
            {
                System.out.println(
                    "traditional: "
                        + decimalFormat.format(channel.getEngagementRate()));
            }

            System.out.println("==========");
        }
    }
}
