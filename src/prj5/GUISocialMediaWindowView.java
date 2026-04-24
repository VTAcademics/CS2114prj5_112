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
    private Button feburaryButton;
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

        traditionalButton = new Button("Traditional Engagement Rate");
        reachButton = new Button("Reach Engagement Rate");

        sortByChannelNameButton = new Button("Sort by Channel Name");
        sortByEngagementRateButton = new Button("Sort by Engagement Rate");
        quitButton = new Button("Quit");

        januaryButton = new Button("January");
        feburaryButton = new Button("Feburary");
        marchButton = new Button("March");
        firstQuarterButton = new Button("First Quarter (Jan - March)");

        traditionalButton.onClick(this, "onTraditionalFormula");
        reachButton.onClick(this, "onReachFormula");
        sortByChannelNameButton.onClick(this, "onSortByChannelName");
        sortByEngagementRateButton.onClick(this, "onSortByEngagementRate");
        quitButton.onClick(this, "onQuit");
        januaryButton.onClick(this, "onJanuary");
        feburaryButton.onClick(this, "onFeburary");
        marchButton.onClick(this, "onMarch");
        firstQuarterButton.onClick(this, "onFirstQuarter");

        window.addButton(sortByChannelNameButton, WindowSide.NORTH);
        window.addButton(sortByEngagementRateButton, WindowSide.NORTH);
        window.addButton(quitButton, WindowSide.NORTH);

        window.addButton(traditionalButton, WindowSide.WEST);
        window.addButton(reachButton, WindowSide.WEST);

        window.addButton(januaryButton, WindowSide.SOUTH);
        window.addButton(feburaryButton, WindowSide.SOUTH);
        window.addButton(marchButton, WindowSide.SOUTH);
        window.addButton(firstQuarterButton, WindowSide.SOUTH);
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
     * Changes the sort mode and redraws
     */
    public void onSortModeChange()
    {
        // TODO Method stub
        redrawGraph();
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
