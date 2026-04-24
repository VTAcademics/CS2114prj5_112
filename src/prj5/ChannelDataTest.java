// Project 5 Spring 2026
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dohoon Kim (kim)
//
// LLM Statement:
// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

// -------------------------------------------------------------------------
/**
 * Tests methods in ChannelData class.
 * 
 * @author Dohoon Kim
 * @version Apr 23, 2026
 */
public class ChannelDataTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private ChannelData channelData;

    // ~ Constructors ..........................................................

    /**
     * Sets up an ChannelData object for testing.
     */
    public void setUp()
    {
        channelData = new ChannelData("HokieTV", 100.00);
    }

    // ~ Public Methods ........................................................


    /**
     * Tests getChannelName() method in ChannelData class.
     */
    public void testGetChannelName()
    {
        assertEquals(channelData.getChannelName(), "HokieTV");
    }


    /**
     * Tests getEngagementRate() method in ChannelData class.
     */
    public void testGetEngagementRate()
    {
        assertEquals(channelData.getEngagementRate(), 100.00, 0.1);
    }


    /**
     * Tests toString() method in ChannelData class.
     */
    public void testToString()
    {
        assertEquals(channelData.toString(), "HokieTV: 100.0");
    }
}
