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
 * Generates and manages the view data for the GUI.
 * 
 * @author Dohoon Kim
 * @version Apr 20, 2026
 */
public class SocialMediaDashboard
{
    // ~ Fields ................................................................

    private AnalyticsManager analyticsManager;
    private Period currentPeriod;
    private EngagementFormula currentEngagementFormula;
    private SortMode currentSortMode;

    // ~ Constructors ..........................................................

    /**
     * Creates a new dashboard with default configurations
     */
    public SocialMediaDashboard(AnalyticsManager manager)
    {
        analyticsManager = manager;
        currentPeriod = Period.FIRST_QUARTER;
        currentEngagementFormula = EngagementFormula.TRADITIONAL;
        currentSortMode = SortMode.CHANNEL_NAME;
    }

    // ~ Public Methods .......................................................


    /**
     * Sets period to the specified Period.
     * 
     * @param period
     *            new Period
     */
    public void setPeriod(Period period)
    {
        if (period != null)
        {
            currentPeriod = period;
        }
    }


    /**
     * Sets formula to the specified EngagementFormula.
     * 
     * @param formula
     *            new EngagementFormula
     */
    public void setFormula(EngagementFormula formula)
    {
        if (formula != null)
        {
            currentEngagementFormula = formula;
        }
    }


    /**
     * Sets sort mode to the specified SortMode.
     * 
     * @param sortMode
     *            new SortMode
     */
    public void setSortMode(SortMode sortMode)
    {
        if (sortMode != null)
        {
            currentSortMode = sortMode;
        }
    }


    /**
     * Returns the current Period.
     * 
     * @return current Period
     */
    public Period getCurrentPeriod()
    {
        return currentPeriod;
    }


    /**
     * Returns the current EngagementFormula.
     * 
     * @return current EngagementFormula
     */
    public EngagementFormula getCurrentFormula()
    {
        return currentEngagementFormula;
    }


    /**
     * Returns the current SortMode.
     * 
     * @return current SortMode
     */
    public SortMode getCurrentSortMode()
    {
        return currentSortMode;
    }


    /**
     * Returns the current sorted view data.
     * 
     * @return current sorted view data
     */
    public DoublyLinkedList<ChannelData> getCurrentViewData()
    {
        DoublyLinkedList<ChannelData> data = analyticsManager
            .getFilteredData(currentPeriod, currentEngagementFormula);

        if (currentSortMode == SortMode.ENGAGEMENT_RATE)
        {
            analyticsManager.sortData(data, new EngagementComparator());
        }
        else
        {
            analyticsManager.sortData(data, new ChannelNameComparator());
        }
        return data;
    }
}
