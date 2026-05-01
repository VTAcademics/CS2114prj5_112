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

import java.awt.Color;
import java.awt.GraphicsConfiguration;

import cs2.*;

// -------------------------------------------------------------------------
/**
 * Write a one-sentence summary of your class here. Follow it with additional
 * details about its purpose, what abstraction it represents, and how to use it.
 * 
 * @author Dohoon Kim
 * @version Apr 20, 2026
 */
public class GUISocialMediaWindowView
{
    // ~ Fields ................................................................
    private static final String WINDOW_TITLE = "Social Media Vis";

    private SocialMediaDashboard model;
    private Window window;

    private Button traditionalButton;
    private Button reachButton;

    private Button sortByChannelNameButton;
    private Button sortByEngagementRateButton;
    private Button quitButton;

    private Button januaryButton;
    private Button februaryButton;
    private Button marchButton;
    private Button firstQuarterButton;

    private DoublyLinkedList<ChannelData> graphData;

    // ~ Constructors ..........................................................

    /**
     * Creates a new GUI wrapper for the model
     * 
     * @param model
     *            dashboard model
     */
    public GUISocialMediaWindowView(SocialMediaDashboard model)
    {
        this.model = model;
        graphData = new DoublyLinkedList<ChannelData>();
        initializeControls();
        redrawGraph();
    }

    // ~ Public Methods ........................................................


    /**
     * Initializes controls for the GUI wrapper
     */
    public void initializeControls()
    {
        window = new Window(WINDOW_TITLE);
        window.setSize(1000, 700);

        traditionalButton = new Button("Traditional Engagement Rate");
        reachButton = new Button("Reach Engagement Rate");

        sortByChannelNameButton = new Button("Sort by Channel Name");
        sortByEngagementRateButton = new Button("Sort by Engagement Rate");
        quitButton = new Button("Quit");

        januaryButton = new Button("January");
        februaryButton = new Button("February");
        marchButton = new Button("March");
        firstQuarterButton = new Button("First Quarter (Jan - March)");

        traditionalButton.onClick(this, "onTraditionalFormula");
        reachButton.onClick(this, "onReachFormula");
        sortByChannelNameButton.onClick(this, "onSortByChannelName");
        sortByEngagementRateButton.onClick(this, "onSortByEngagementRate");
        quitButton.onClick(this, "onQuit");
        januaryButton.onClick(this, "onJanuary");
        februaryButton.onClick(this, "onFebruary");
        marchButton.onClick(this, "onMarch");
        firstQuarterButton.onClick(this, "onFirstQuarter");

        window.addButton(sortByChannelNameButton, WindowSide.NORTH);
        window.addButton(sortByEngagementRateButton, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);

        window.addButton(traditionalButton, WindowSide.WEST);
        window.addButton(reachButton, WindowSide.WEST);

        window.addButton(januaryButton, WindowSide.SOUTH);
        window.addButton(februaryButton, WindowSide.SOUTH);
        window.addButton(marchButton, WindowSide.SOUTH);
        window.addButton(firstQuarterButton, WindowSide.SOUTH);
    }


    /**
     * Selects the traditional engagement formula.
     * 
     * @param button
     *            Clicked button object
     */
    public void onTraditionalFormula(Button button)
    {
        model.setFormula(EngagementFormula.TRADITIONAL);
        onEngagementFormulaChange();
    }


    /**
     * Selects the reach engagement formula.
     * 
     * @param button
     *            Clicked button object
     */
    public void onReachFormula(Button button)
    {
        model.setFormula(EngagementFormula.REACH);
        onEngagementFormulaChange();
    }


    /**
     * Changes the formula and redraws
     */
    public void onEngagementFormulaChange()
    {
        // TODO Method stub
        redrawGraph();
    }


    /**
     * Selects sorting via channel name.
     * 
     * @param button
     *            Clicked button object
     */
    public void onSortByChannelName(Button button)
    {
        model.setSortMode(SortMode.CHANNEL_NAME);
        onSortModeChange();
    }


    /**
     * Selects sorting via channel name.
     * 
     * @param button
     *            Clicked button object
     */
    public void onSortByEngagementRate(Button button)
    {
        model.setSortMode(SortMode.ENGAGEMENT_RATE);
        onSortModeChange();
    }


    /**
     * Changes the sort mode and redraws
     */
    public void onSortModeChange()
    {
        // TODO Method stub
        redrawGraph();
    }


    /**
     * Selects January.
     * 
     * @param button
     *            Clicked button object
     */
    public void onJanuary(Button button)
    {
        model.setPeriod(Period.JANUARY);
        onPeriodChange();
    }


    /**
     * Selects February.
     * 
     * @param button
     *            Clicked button object
     */
    public void onFebruary(Button button)
    {
        model.setPeriod(Period.FEBRUARY);
        onPeriodChange();
    }


    /**
     * Selects March.
     * 
     * @param button
     *            Clicked button object
     */
    public void onMarch(Button button)
    {
        model.setPeriod(Period.MARCH);
        onPeriodChange();
    }


    /**
     * Selects First Quarter.
     * 
     * @param button
     *            Clicked button object
     */
    public void onFirstQuarter(Button button)
    {
        model.setPeriod(Period.FIRST_QUARTER);
        onPeriodChange();
    }


    /**
     * Changes the period and redraws
     */
    public void onPeriodChange()
    {
        // TODO Method stub
        redrawGraph();
    }


    /**
     * Closes the view and clears the graph
     */
    public void onQuit()
    {
        window = null;
        clearGraph();
    }


    /**
     * Closes the view and clears the graph
     * 
     * @param button
     *            clicked button
     */
    public void onQuit(Button button)
    {
        onQuit();
    }


    /**
     * Redraws the graph for the GUI wrapper.
     */
    private void redrawGraph()
    {
        clearGraph();
        drawGraphBars(model.getCurrentViewData());
        updateLabels();
    }


    /**
     * Draws the graph bars using the data
     * 
     * @param data
     *            graph data
     */
    private void drawGraphBars(DoublyLinkedList<ChannelData> data)
    {
        if (window == null)
            return;
        if (data == null || data.isEmpty())
            return;

        int baseHeight = window.getGraphPanelHeight();
        // TODO Method stub
    }


    /**
     * Update labels for the graph bars
     */
    private void updateLabels()
    {
        // TODO Method stub
    }


    /**
     * Clears saved last graph data
     */
    private void clearGraph()
    {
        graphData.clear();
    }
}
