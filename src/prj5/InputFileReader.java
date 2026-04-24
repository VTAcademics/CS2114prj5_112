package prj5;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

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

/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 21, 2026
 */
public class InputFileReader
{
    private DoublyLinkedList<InfluencerData> influencers;

    private static final String[] VALID_MONTHS =
        { "january", "february", "march", "april", "may", "june", "july",
            "august", "september", "october", "november", "december" };

    /**
     * Creates a new InputFileReader and immediatly reads the given file.
     * 
     * @param fileName
     *            the path to the CSV file to read
     * @throws IOException
     *             if the file cannot be opened
     */
    public InputFileReader(String fileName)
        throws IOException
    {
        influencers = new DoublyLinkedList<InfluencerData>();
        readFile(fileName);

    }


    /**
     * Returns the list of influencers parsed from the file
     * 
     * @return DoublyLinkedList of InfluencerData
     */
    public DoublyLinkedList<InfluencerData> getInfluencers()
    {
        return influencers;
    }


    /**
     * Returns true if the given month string is a valid calendar month.
     * 
     * @param month
     *            the month string to check
     * @return true if valid
     */
    private boolean isValidMonth(String month)
    {
        for (String m : VALID_MONTHS)
        {
            if (m.equalsIgnoreCase(month))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Finds an existing InfluencerData in the list by username, or returns null
     * if not found
     * 
     * @param username
     *            the username to search for
     * @return matching InfluencerData, or null
     */
    private InfluencerData findInfluencer(String username)
    {
        ArrayList<InfluencerData> list = influencers.toArrayList();
        for (InfluencerData inf : list)
        {
            if (inf.getUsername().equals(username))
            {
                return inf;
            }
        }
        return null;
    }


    /**
     * converts a string to an int. Returns 0 if the conversion fails.
     * 
     * @param str
     *            the string to convert
     * @return integer value, or 0 on failure
     */
    private int toInt(String str)
    {
        try
        {
            return Integer.parseInt(str);

        }
        catch (Exception e)
        {
            return 0;
        }
    }


    /**
     * Parses the CSV file to populate the influencers list.
     * 
     * @param fileName
     *            name of the file to read
     * @throws IOException
     *             if the file is missing or unreadable
     */
    private void readFile(String fileName)
        throws IOException
    {
        Scanner inStream = new Scanner(new File(fileName));
        inStream.nextLine();

        while (inStream.hasNextLine())
        {
            String line = inStream.nextLine().replaceAll(" ", "");
            if (line.isEmpty())
            {
                continue;
            }

            String[] values = line.split(",");
            if (values.length < 10)
            {
                continue;
            }

            String month = values[0];
            String username = values[1];
            String channel1 = values[2];
            String country = values[3];
            String mainTopic = values[4];
            int likes = toInt(values[5]);
            int posts = toInt(values[6]);
            int followers = toInt(values[7]);
            int comments = toInt(values[8]);
            int views = toInt(values[9]);

            if (!isValidMonth(month))
            {
                continue;
            }

            PeriodData periodData =
                new PeriodData(month, likes, posts, followers, comments, views);

            InfluencerData influencer = findInfluencer(username);
            if (influencer == null)
            {
                influencer =
                    new InfluencerData(username, channel1, country, mainTopic);
                influencers.add(influencer);

            }
            influencer.addPeriodData(periodData);

        }
        inStream.close();

    }

}
