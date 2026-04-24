// Project 4 Spring 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Alejandro Trinidad (alextv5002)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

import java.util.Comparator;

/**
 * // -------------------------------------------------------------------------
 * /** A comparator that compares channels by engagement rate
 * 
 * @author Alejandro Trinidad
 * @version 2026.04.21
 */
public class EngagementComparator
    implements Comparator<ChannelData>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Compares two channels by engagement rate
     * 
     * @param a
     *            first channel
     * @param b
     *            second channel
     * @return a positive integer if a's engagement rate is greater than b, 0 if
     *             equal, and negative if a < b
     */
    @Override
    public int compare(ChannelData a, ChannelData b)
    {
        return a.getEngagementRate().compareTo(b.getEngagementRate());
    }
}
