package prj5;

import java.util.ArrayList;
import student.TestCase;
// Project 5 Spring 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself
// with honor and integrity at all times.

// I will not lie, cheat, or steal,
// nor will I accept the actions of those who do.

// -- Jai Mylavarupu (jaim)
// LLM Statement:

// I have not used any assistance for
// the assignment beyond course resources and staff.
/**
 * Tests the AnalyticsManager class, including constructor behavior, engagement
 * rate calculations, filtered data creation, and sorting.
 *
 * @author Jai Mylavarupu
 * @version 2026-04-23
 */
public class AnalyticsManagerTest
    extends TestCase
{
    private AnalyticsManager manager;
    private InfluencerData alpha;
    private InfluencerData gamma;

    /**
     * Sets up sample influencer records used by the test methods.
     */
    public void setUp()
    {
        DoublyLinkedList<InfluencerData> records =
            new DoublyLinkedList<InfluencerData>();

        alpha = new InfluencerData("user1", "AlphaChannel", "US", "music");
        alpha.addPeriodData(new PeriodData("January", 100, 5, 1000, 50, 2000));
        alpha
            .addPeriodData(new PeriodData("February", 200, 5, 1200, 100, 3000));
        alpha.addPeriodData(new PeriodData("March", 300, 5, 2000, 150, 5000));

        InfluencerData beta =
            new InfluencerData("user2", "BetaChannel", "US", "sports");
        beta.addPeriodData(new PeriodData("January", 50, 5, 500, 25, 1000));
        beta.addPeriodData(new PeriodData("February", 50, 5, 600, 25, 1000));
        beta.addPeriodData(new PeriodData("March", 100, 5, 1000, 50, 2000));

        gamma = new InfluencerData("user3", "GammaChannel", "US", "tech");
        gamma.addPeriodData(new PeriodData("January", 10, 5, 100, 10, 0));
        gamma.addPeriodData(new PeriodData("February", 20, 5, 100, 20, 0));
        gamma.addPeriodData(new PeriodData("March", 30, 5, 0, 30, 0));

        records.add(beta);
        records.add(gamma);
        records.add(alpha);

        manager = new AnalyticsManager(records);
    }


    /**
     * Tests that the constructor creates an empty records list when given null.
     */
    public void testConstructorWithNullList()
    {
        AnalyticsManager emptyManager = new AnalyticsManager(null);
        DoublyLinkedList<ChannelData> data = emptyManager.getFilteredData(
            Period.FIRST_QUARTER,
            EngagementFormula.TRADITIONAL);

        assertNotNull(data);
        assertEquals(0, data.getSize());
    }


    /**
     * Tests traditional engagement rate calculation for January.
     */
    public void testCalculateTraditionalRateJanuary()
    {
        double rate = manager.calculateTraditionalRate(alpha, Period.JANUARY);

        assertEquals(15.0, rate, 0.001);
    }


    /**
     * Tests traditional engagement rate calculation for February.
     */
    public void testCalculateTraditionalRateFebruary()
    {
        double rate = manager.calculateTraditionalRate(alpha, Period.FEBRUARY);

        assertEquals(25.0, rate, 0.001);
    }


    /**
     * Tests traditional engagement rate calculation for March.
     */
    public void testCalculateTraditionalRateMarch()
    {
        double rate = manager.calculateTraditionalRate(alpha, Period.MARCH);

        assertEquals(22.5, rate, 0.001);
    }


    /**
     * Tests traditional engagement rate calculation for the first quarter.
     */
    public void testCalculateTraditionalRateFirstQuarter()
    {
        double rate =
            manager.calculateTraditionalRate(alpha, Period.FIRST_QUARTER);

        assertEquals(45.0, rate, 0.001);
    }


    /**
     * Tests traditional engagement rate calculation with a null record.
     */
    public void testCalculateTraditionalRateNullRecord()
    {
        assertEquals(
            -1.0,
            manager.calculateTraditionalRate(null, Period.JANUARY),
            0.001);
    }


    /**
     * Tests traditional engagement rate calculation with a null period.
     */
    public void testCalculateTraditionalRateNullPeriod()
    {
        assertEquals(
            -1.0,
            manager.calculateTraditionalRate(alpha, null),
            0.001);
    }


    /**
     * Tests traditional engagement rate calculation when month data is missing.
     */
    public void testCalculateTraditionalRateMissingMonth()
    {
        InfluencerData missing =
            new InfluencerData("missing", "MissingChannel", "US", "art");

        assertEquals(
            -1.0,
            manager.calculateTraditionalRate(missing, Period.JANUARY),
            0.001);
    }


    /**
     * Tests traditional engagement rate calculation with zero followers.
     */
    public void testCalculateTraditionalRateZeroFollowers()
    {
        assertEquals(
            -1.0,
            manager.calculateTraditionalRate(gamma, Period.MARCH),
            0.001);
    }


    /**
     * Tests first quarter traditional rate when March has no followers.
     */
    public void testCalculateTraditionalRateFirstQuarterNoMarchFollowers()
    {
        assertEquals(
            -1.0,
            manager.calculateTraditionalRate(gamma, Period.FIRST_QUARTER),
            0.001);
    }


    /**
     * Tests reach engagement rate calculation for January.
     */
    public void testCalculateReachRateJanuary()
    {
        double rate = manager.calculateReachRate(alpha, Period.JANUARY);

        assertEquals(7.5, rate, 0.001);
    }


    /**
     * Tests reach engagement rate calculation for February.
     */
    public void testCalculateReachRateFebruary()
    {
        double rate = manager.calculateReachRate(alpha, Period.FEBRUARY);

        assertEquals(10.0, rate, 0.001);
    }


    /**
     * Tests reach engagement rate calculation for March.
     */
    public void testCalculateReachRateMarch()
    {
        double rate = manager.calculateReachRate(alpha, Period.MARCH);

        assertEquals(9.0, rate, 0.001);
    }


    /**
     * Tests reach engagement rate calculation for the first quarter.
     */
    public void testCalculateReachRateFirstQuarter()
    {
        double rate = manager.calculateReachRate(alpha, Period.FIRST_QUARTER);

        assertEquals(9.0, rate, 0.001);
    }


    /**
     * Tests reach engagement rate calculation with a null record.
     */
    public void testCalculateReachRateNullRecord()
    {
        assertEquals(
            -1.0,
            manager.calculateReachRate(null, Period.JANUARY),
            0.001);
    }


    /**
     * Tests reach engagement rate calculation with a null period.
     */
    public void testCalculateReachRateNullPeriod()
    {
        assertEquals(-1.0, manager.calculateReachRate(alpha, null), 0.001);
    }


    /**
     * Tests reach engagement rate calculation when month data is missing.
     */
    public void testCalculateReachRateMissingMonth()
    {
        InfluencerData missing =
            new InfluencerData("missing", "MissingChannel", "US", "art");

        assertEquals(
            -1.0,
            manager.calculateReachRate(missing, Period.JANUARY),
            0.001);
    }


    /**
     * Tests reach engagement rate calculation with zero views.
     */
    public void testCalculateReachRateZeroViews()
    {
        assertEquals(
            -1.0,
            manager.calculateReachRate(gamma, Period.MARCH),
            0.001);
    }


    /**
     * Tests first quarter reach rate when total views are zero.
     */
    public void testCalculateReachRateFirstQuarterZeroViews()
    {
        assertEquals(
            -1.0,
            manager.calculateReachRate(gamma, Period.FIRST_QUARTER),
            0.001);
    }


    /**
     * Tests filtered data using the traditional engagement formula.
     */
    public void testGetFilteredDataTraditional()
    {
        DoublyLinkedList<ChannelData> data = manager.getFilteredData(
            Period.FIRST_QUARTER,
            EngagementFormula.TRADITIONAL);

        ArrayList<ChannelData> list = data.toArrayList();

        assertEquals(3, data.getSize());
        assertEquals("BetaChannel", list.get(0).getChannelName());
    }


    /**
     * Tests filtered data using the reach engagement formula.
     */
    public void testGetFilteredDataReach()
    {
        DoublyLinkedList<ChannelData> data = manager
            .getFilteredData(Period.FIRST_QUARTER, EngagementFormula.REACH);

        ArrayList<ChannelData> list = data.toArrayList();

        assertEquals(3, data.getSize());
        assertEquals("BetaChannel", list.get(0).getChannelName());
        assertEquals(7.5, list.get(0).getEngagementRate(), 0.001);
        assertEquals("GammaChannel", list.get(1).getChannelName());
        assertEquals(-1.0, list.get(1).getEngagementRate(), 0.001);
        assertEquals("AlphaChannel", list.get(2).getChannelName());
        assertEquals(9.0, list.get(2).getEngagementRate(), 0.001);
    }


    /**
     * Tests sorting channel data alphabetically by channel name.
     */
    public void testSortDataByChannelName()
    {
        DoublyLinkedList<ChannelData> data = manager.getFilteredData(
            Period.FIRST_QUARTER,
            EngagementFormula.TRADITIONAL);

        manager.sortData(data, new ChannelNameComparator());

        ArrayList<ChannelData> list = data.toArrayList();

        assertEquals("AlphaChannel", list.get(0).getChannelName());
        assertEquals("BetaChannel", list.get(1).getChannelName());
        assertEquals("GammaChannel", list.get(2).getChannelName());
    }


    /**
     * Tests sorting channel data by engagement rate.
     */
    public void testSortDataByEngagementRate()
    {
        DoublyLinkedList<ChannelData> data = manager
            .getFilteredData(Period.FIRST_QUARTER, EngagementFormula.REACH);

        manager.sortData(data, new EngagementComparator());

        ArrayList<ChannelData> list = data.toArrayList();

        assertEquals("AlphaChannel", list.get(0).getChannelName());
        assertEquals("BetaChannel", list.get(1).getChannelName());
        assertEquals("GammaChannel", list.get(2).getChannelName());
    }


    /**
     * Tests that sorting with a null list does not cause an error.
     * 
     * @author Dohoon Kim
     */
    public void testSortDataNullList()
    {
        try
        {
            manager.sortData(null, new ChannelNameComparator());
        }
        catch (NullPointerException exception)
        {
            assertNull(exception);
        }
    }


    /**
     * Tests that sorting with a null comparator leaves the data unchanged.
     */
    public void testSortDataNullComparator()
    {
        DoublyLinkedList<ChannelData> data = manager.getFilteredData(
            Period.FIRST_QUARTER,
            EngagementFormula.TRADITIONAL);

        manager.sortData(data, null);

        assertEquals(3, data.getSize());
    }


    /**
     * Tests that sorting a one item list keeps the item in the list.
     */
    public void testSortDataOneItem()
    {
        DoublyLinkedList<ChannelData> data =
            new DoublyLinkedList<ChannelData>();

        data.add(new ChannelData("OnlyChannel", 50.0));

        manager.sortData(data, new ChannelNameComparator());

        assertEquals(1, data.getSize());
        assertEquals("OnlyChannel", data.toArrayList().get(0).getChannelName());
    }
    
    /**
     * Tests periodToString method in AnalyticsManager class.
     */
    public void testPeriodToString()
    {
        assertEquals(manager.periodToString(Period.JANUARY), "January");
        assertEquals(manager.periodToString(Period.FEBRUARY), "February");
        assertEquals(manager.periodToString(Period.MARCH), "March");
        assertEquals(manager.periodToString(Period.FIRST_QUARTER), "");
    }
}
