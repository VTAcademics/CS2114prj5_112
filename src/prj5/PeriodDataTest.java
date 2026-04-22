package prj5;
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

import student.TestCase;

public class PeriodDataTest
    extends TestCase
{
    private PeriodData period;

    /**
     * Sets up a PeriodData object before each test.
     */
    public void setUp()
    {
        period = new PeriodData("January", 1000, 50, 5000, 200, 30000);
    }


    /**
     * Tests that getMonth returns the correct month.
     */
    public void testGetMonth()
    {
        assertEquals("January", period.getMonth());
    }


    /**
     * Tests that getLikes returns the correct value.
     */
    public void testGetLikes()
    {
        assertEquals(1000, period.getLikes());
    }


    /**
     * Tests that getPosts returns the correct value.
     */
    public void testGetPosts()
    {
        assertEquals(50, period.getPosts());
    }


    /**
     * Tests that getFollowers returns the correct value.
     */
    public void testGetFollowers()
    {
        assertEquals(5000, period.getFollowers());
    }


    /**
     * Tests that getComments returns the correct value.
     */
    public void testGetComments()
    {
        assertEquals(200, period.getComments());
    }


    /**
     * Tests that getViews returns the correct value.
     */
    public void testGetViews()
    {
        assertEquals(30000, period.getViews());
    }


    /**
     * Tests that zero values are stored and returned correctly.
     */
    public void testZeroValues()
    {
        PeriodData zeroPeriod = new PeriodData("February", 0, 0, 0, 0, 0);
        assertEquals(0, zeroPeriod.getLikes());
        assertEquals(0, zeroPeriod.getPosts());
        assertEquals(0, zeroPeriod.getFollowers());
        assertEquals(0, zeroPeriod.getComments());
        assertEquals(0, zeroPeriod.getViews());
    }


    /**
     * Tests that different months are stored correctly.
     */
    public void testDifferentMonths()
    {
        PeriodData feb = new PeriodData("February", 500, 10, 2000, 100, 5000);
        PeriodData mar = new PeriodData("March", 750, 20, 3000, 150, 8000);
        assertEquals("February", feb.getMonth());
        assertEquals("March", mar.getMonth());
    }
}
