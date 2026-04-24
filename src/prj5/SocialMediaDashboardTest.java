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
 * Tests methods in SocialMediaDashboard class.
 * 
 * @author Dohoon Kim
 * @version Apr 23, 2026
 */
public class SocialMediaDashboardTest
    extends student.TestCase
{
    // ~ Fields ................................................................

    private SocialMediaDashboard socialMediaDashboard;

    // ~ Constructors ..........................................................

    /**
     * Sets up an SocialMediaDashboard object for testing.
     */
    public void setUp()
    {
        DoublyLinkedList<InfluencerData> influencerData =
            new DoublyLinkedList<>();
        AnalyticsManager analyticsManager =
            new AnalyticsManager(influencerData);
        socialMediaDashboard = new SocialMediaDashboard(analyticsManager);
    }

    // ~ Public Methods ........................................................


    /**
     * Tests getter and setter methods for Period.
     */
    public void testPeriod()
    {
        socialMediaDashboard.setPeriod(Period.JANUARY);
        assertEquals(socialMediaDashboard.getCurrentPeriod(), Period.JANUARY);

        socialMediaDashboard.setPeriod(null);
        assertEquals(socialMediaDashboard.getCurrentPeriod(), Period.JANUARY);
    }


    /**
     * Tests getter and setter methods for SortMode.
     */
    public void testSortMode()
    {
        socialMediaDashboard.setSortMode(SortMode.CHANNEL_NAME);
        assertEquals(
            socialMediaDashboard.getCurrentSortMode(),
            SortMode.CHANNEL_NAME);

        socialMediaDashboard.setSortMode(null);
        assertEquals(
            socialMediaDashboard.getCurrentSortMode(),
            SortMode.CHANNEL_NAME);
    }


    /**
     * Tests getter and setter methods for Formula.
     */
    public void testFormula()
    {
        socialMediaDashboard.setFormula(EngagementFormula.TRADITIONAL);
        assertEquals(
            socialMediaDashboard.getCurrentFormula(),
            EngagementFormula.TRADITIONAL);

        socialMediaDashboard.setFormula(null);
        assertEquals(
            socialMediaDashboard.getCurrentFormula(),
            EngagementFormula.TRADITIONAL);
    }


    /**
     * Tests getCurrentViewData() method for Formula.
     */
    public void testGetCurrentViewData()
    {
        assertEquals(socialMediaDashboard.getCurrentViewData().getSize(), 0);
        socialMediaDashboard.setSortMode(SortMode.ENGAGEMENT_RATE);
        assertEquals(socialMediaDashboard.getCurrentViewData().getSize(), 0);
    }
}
