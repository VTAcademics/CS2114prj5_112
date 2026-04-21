package prj5;

import java.io.IOException;
import java.util.Scanner;
import java.io.File;

// Project 4 Spring 2026
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
 * // -------------------------------------------------------------------------
 * /** Write a one-sentence summary of your class here. Follow it with
 * additional details about its purpose, what abstraction it represents, and how
 * to use it.
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 21, 2026
 */
public class InputFileReader
{
    // gotta wait for others
    private DoublyLinkedList<InfluencerData> influencers;

    private static final String[] VALID_MONTHS =
        { "january", "febuary", "march", "april", "may", "june", "july",
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
        // gotta wait for others
        influencers = new DoublyLinkedList<InfluencerData>();
        readFile(fileName);

    }


    /**
     * 
     */
    public DoublyLinkedList<InfluencerData> getInfluencers()
    {
        return influencers;
    }


    /**
     * 
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
     * 
     */
    
    
    /**
     * 
     */
    
    
    /**
     * 
     */

}
