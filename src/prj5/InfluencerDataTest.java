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

public class InfluencerDataTest
    extends TestCase
{
    private InfluencerData influencer;

    /**
     * Sets up an InfluencerData object with three months of data matching
     * JustBeatz values from SampleInput1_2023.csv.
     */
    public void setUp()
    {
        influencer =
            new InfluencerData("BigGiantCircles", "JustBeatz", "US", "music");

        // January
        influencer.addPeriodData(
            new PeriodData("January", 3065, 43, 9203, 3021, 46456));
        // February
        influencer.addPeriodData(
            new PeriodData("February", 19165, 367, 78023, 15371, 454132));
        // March
        influencer.addPeriodData(
            new PeriodData("March", 30065, 430, 93203, 38021, 416456));
    }


    /**
     * Tests that getUsername returns the correct value.
     */
    public void testGetUsername()
    {
        assertEquals("BigGiantCircles", influencer.getUsername());
    }


    /**
     * Tests that getChannelName returns the correct value.
     */
    public void testGetChannelName()
    {
        assertEquals("JustBeatz", influencer.getChannelName());
    }


    /**
     * Tests that getCountry returns the correct value.
     */
    public void testGetCountry()
    {
        assertEquals("US", influencer.getCountry());
    }


    /**
     * Tests that getTopic returns the correct value.
     */
    public void testGetTopic()
    {
        assertEquals("music", influencer.getTopic());
    }


    /**
     * Tests that getPeriodData returns the correct PeriodData for a month.
     */
    public void testGetPeriodData()
    {
        PeriodData jan = influencer.getPeriodData("January");
        assertNotNull(jan);
        assertEquals("January", jan.getMonth());
        assertEquals(3065, jan.getLikes());
    }


    /**
     * Tests that getPeriodData is case insensitive.
     */
    public void testGetPeriodDataCaseInsensitive()
    {
        assertNotNull(influencer.getPeriodData("january"));
        assertNotNull(influencer.getPeriodData("MARCH"));
        assertNotNull(influencer.getPeriodData("February"));
    }


    /**
     * Tests that getPeriodData returns null for a month with no data.
     */
    public void testGetPeriodDataMissing()
    {
        assertNull(influencer.getPeriodData("April"));
    }


    /**
     * Tests traditional engagement rate against known output. JustBeatz
     * traditional rate should be 116.6.
     */
    public void testGetTraditionalEngagement()
    {
        double rate = influencer.getTraditionalEngagement();
        assertEquals(116.6, rate, 0.05);
    }


    /**
     * Tests reach engagement rate against known output. JustBeatz reach rate
     * should be 11.9.
     */
    public void testGetReachEngagement()
    {
        double rate = influencer.getReachEngagement();
        assertEquals(11.9, rate, 0.05);
    }


    /**
     * Tests that traditional engagement returns -1 when March is missing.
     */
    public void testTraditionalEngagementNoMarch()
    {
        InfluencerData noMarch =
            new InfluencerData("user1", "channel1", "US", "music");
        noMarch.addPeriodData(
            new PeriodData("January", 1000, 10, 5000, 200, 10000));
        noMarch.addPeriodData(
            new PeriodData("February", 1000, 10, 5000, 200, 10000));
        assertEquals(-1.0, noMarch.getTraditionalEngagement(), 0.001);
    }


    /**
     * Tests that traditional engagement returns -1 when March followers is 0.
     */
    public void testTraditionalEngagementZeroFollowers()
    {
        InfluencerData zeroFollowers =
            new InfluencerData("user2", "channel2", "US", "art");
        zeroFollowers.addPeriodData(
            new PeriodData("January", 1000, 10, 5000, 200, 10000));
        zeroFollowers
            .addPeriodData(new PeriodData("March", 500, 5, 0, 100, 5000));
        assertEquals(-1.0, zeroFollowers.getTraditionalEngagement(), 0.001);
    }


    /**
     * Tests that reach engagement returns -1 when total views is 0.
     */
    public void testReachEngagementZeroViews()
    {
        InfluencerData noViews =
            new InfluencerData("user3", "channel3", "CA", "art");
        noViews
            .addPeriodData(new PeriodData("January", 1000, 10, 5000, 200, 0));
        noViews.addPeriodData(new PeriodData("February", 500, 5, 3000, 100, 0));
        noViews.addPeriodData(new PeriodData("March", 750, 8, 4000, 150, 0));
        assertEquals(-1.0, noViews.getReachEngagement(), 0.001);
    }


    /**
     * Tests that April data is ignored in engagement calculations.
     */
    public void testEngagementIgnoresNonFirstQuarter()
    {
        InfluencerData withApril =
            new InfluencerData("user4", "channel4", "US", "tech");
        withApril.addPeriodData(
            new PeriodData("January", 1000, 10, 5000, 200, 10000));
        withApril.addPeriodData(
            new PeriodData("February", 1000, 10, 5000, 200, 10000));
        withApril
            .addPeriodData(new PeriodData("March", 1000, 10, 5000, 200, 10000));
        withApril.addPeriodData(
            new PeriodData("April", 999999, 999, 999999, 999999, 999999));

        assertEquals(72.0, withApril.getTraditionalEngagement(), 0.05);
        assertEquals(12.0, withApril.getReachEngagement(), 0.05);
    }
}
