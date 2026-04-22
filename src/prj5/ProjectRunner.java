package prj5;

import java.io.IOException;
import java.text.DecimalFormat;
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
 * // -------------------------------------------------------------------------
 * /** Entry point for the Social Media Visualization project. reads the input
 * file, computes engagement rates, and prints the console output for the
 * intermediate submission
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 22, 2026
 */
public class ProjectRunner
{
    /**
     * @param args command line arguments; args[0] is the input file name
     * @throws IOException if the input file cannot be read
     */
    public static void main(String[] args) throws IOException
    {
        InputFileReader filer;
        
        if (args.length > 0) 
        {
            filer = new InputFileReader(args[0]);
        }
        else 
        {
            filer = new InputFileReader("SampleInput1_2023.csv");
        }
        
        boolean showConsole = true;
        boolean showGUI = false;
        
        if (showConsole) 
        {
            DoublyLinkedList<InfluencerData> influencers =
                filer.getInfluencers();

            DecimalFormat df = new DecimalFormat("#.#");
            
            DoublyLinkedList<InfluencerData> alphaSorted =
                copyList(influencers);
            alphaSorted.insertionSort(new ChannelNameComparator());

            ArrayList<InfluencerData> alphaList = alphaSorted.toArrayList();
            for (InfluencerData inf : alphaList)
            {
                double rate = inf.getTraditionalEngagement();
                System.out.println(inf.getChannelName());
                if (rate < 0)
                {
                    System.out.println("traditional: N/A");
                }
                else
                {
                    System.out.println("traditional: " + df.format(rate));
                }
                System.out.println("==========");
            }
            
            System.out.println("**********");
            System.out.println("**********");
           
            DoublyLinkedList<InfluencerData> reachSorted =
                copyList(influencers);
            reachSorted.insertionSort(new EngagementComparator());

            ArrayList<InfluencerData> reachList = reachSorted.toArrayList();
            for (InfluencerData inf : reachList)
            {
                double rate = inf.getReachEngagement();
                System.out.println(inf.getChannelName());
                if (rate < 0)
                {
                    System.out.println("reach: N/A");
                }
                else
                {
                    System.out.println("reach: " + df.format(rate));
                }
                System.out.println("==========");
            }
        }
        if (showGUI) 
        {
            
        }
    
    }
    /**
     *  Creates a shallow copy of the influencer list so sorting one
     * does not affect the other.
     *
     * @param original
     *            the original DoublyLinkedList
     * @return a new DoublyLinkedList with the same elements
     */
    private static DoublyLinkedList<InfluencerData> copyList(
        DoublyLinkedList<InfluencerData> original)
    {
        DoublyLinkedList<InfluencerData> copy =
            new DoublyLinkedList<InfluencerData>();
        ArrayList<InfluencerData> items = original.toArrayList();
        for (InfluencerData inf : items)
        {
            copy.add(inf);
        }
        return copy;
    }
}

//TEMPORARY: ChannelNameComparator compares ChannelData not InfluencerData, using InfluencerChannelNameComparator until fixed
