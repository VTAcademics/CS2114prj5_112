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
 * /** A comparator that compares channels by channel name
 * 
 * @author Alejandro Trinidad
 * @version 2026.04.21
 */
public class ChannelNameComparator
    implements Comparator<ChannelData>
{
    // ~ Fields ................................................................

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Compares two channels by channel name
     * 
     * @param a
     *            first channel
     * @param b
     *            second channel
     * @return a positive integer if a's name comes after b, 0 if equal, and
     *             negative if a comes before b
     */
    @Override
    public int compare(ChannelData a, ChannelData b)
    {
        return a.getChannelName().toLowerCase()
            .compareTo(b.getChannelName().toLowerCase());
    }
}
