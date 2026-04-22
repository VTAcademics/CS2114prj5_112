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

import java.awt.Window;

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

    private SocialMediaDashboard model;
    private Window window;
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
        window = null;
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
        // TODO Method stub
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
