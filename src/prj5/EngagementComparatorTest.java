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

import student.TestCase;

/**
 * Test class for EngagementComparator
 * 
 * @author Alejandro Trinidad (alextv5002)
 * @version 2026.04.23
 */
public class EngagementComparatorTest
    extends TestCase
{
    // ~ Fields ................................................................
    private EngagementComparator cmp;
    private ChannelData a;
    private ChannelData b;
    private ChannelData c;
    private ChannelData d;

    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Sets up the comparator and different ChannelData objects to be tested
     */
    public void setUp()
    {
        cmp = new EngagementComparator();

        a = new ChannelData("A", 1.0);
        b = new ChannelData("B", 2.0);
        c = new ChannelData("C", 1.0); // same as a
        d = new ChannelData("D", -1.0); // negative
    }


    /**
     * Tests the compare() method
     */
    public void testCompare()
    {
        assertTrue(cmp.compare(a, b) < 0);
        assertTrue(cmp.compare(b, a) > 0);
        assertEquals(0, cmp.compare(a, c));
        assertTrue(cmp.compare(d, a) < 0);
        assertTrue(cmp.compare(a, d) > 0);
    }
}
