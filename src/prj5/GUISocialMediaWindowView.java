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
import java.text.DecimalFormat;
import java.util.ArrayList;

import cs2.*;

// -------------------------------------------------------------------------
/**
 * Displays SocialMediaDashboard as a bar chart GUI.
 * 
 * @author Dohoon Kim
 * @version Apr 20, 2026
 */
public class GUISocialMediaWindowView
{
    // ~ Fields ................................................................

    private static final String WINDOW_TITLE = "Social Media Vis";
    private static final String PATTERN = "#.#";

    private static final int HEADER_X = 25;
    private static final int FONT_SIZE = 14;
    private static final String FONT_FAMILY = "Arial";

    private static final int PERIOD_Y = 15;
    private static final int FORMULA_Y = 40;
    private static final int SORT_Y = 65;

    private static final int BAR_START_X = 100;
    private static final int BAR_GAP = 110;
    private static final int BAR_WIDTH = 50;
    private static final int MAX_BAR_HEIGHT = 300;
    private static final int MIN_BAR_HEIGHT = 5;

    private static final int LABEL_Y_OFFSET = 35;
    private static final int VALUE_Y_OFFSET = 58;
    private static final int MAX_LABEL_LENGTH = 13;

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
    private DecimalFormat formatter;

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
        formatter = new DecimalFormat(PATTERN);
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
        window.hideInfoPanel();

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
     * Selects the traditional engagement formula
     * 
     * @param button
     *            clicked button object
     */
    public void onTraditionalFormula(Button button)
    {
        model.setFormula(EngagementFormula.TRADITIONAL);
        onEngagementFormulaChange();
    }


    /**
     * Selects the reach engagement formula
     * 
     * @param button
     *            clicked button object
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
        redrawGraph();
    }


    /**
     * Selects sorting by channel name
     * 
     * @param button
     *            clicked button object
     */
    public void onSortByChannelName(Button button)
    {
        model.setSortMode(SortMode.CHANNEL_NAME);
        onSortModeChange();
    }


    /**
     * Selects sorting by engagement rate
     * 
     * @param button
     *            clicked button object
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
        redrawGraph();
    }


    /**
     * Selects January.
     * 
     * @param button
     *            clicked button object
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
     *            clicked button object
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
     *            clicked button object
     */
    public void onMarch(Button button)
    {
        model.setPeriod(Period.MARCH);
        onPeriodChange();
    }


    /**
     * Selects the first quarter
     * 
     * @param button
     *            clicked button object
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
        redrawGraph();
    }


    /**
     * Closes the view and clears the graph
     * 
     * @param button
     *            clicked button object
     */
    public void onQuit(Button button)
    {
        clearGraph();
        window = null;
        System.exit(0);
    }


    /**
     * Returns the window.
     * 
     * @return the window
     */
    public Window getWindow()
    {
        return window;
    }


    /**
     * Returns the last graph data drawn.
     * 
     * @return graph data
     */
    public DoublyLinkedList<ChannelData> getGraphData()
    {
        return graphData;
    }

    // ~ Private Methods .......................................................


    /**
     * Redraws the graph for the GUI wrapper
     */
    private void redrawGraph()
    {
        clearGraph();

        if (window != null)
        {
            drawGraphBars(model.getCurrentViewData());
            updateLabels();
        }
    }


    /**
     * Draws the graph bars using the data
     * 
     * @param data
     *            graph data
     */
    private void drawGraphBars(DoublyLinkedList<ChannelData> data)
    {
        if (window == null || data == null || data.isEmpty())
        {
            return;
        }

        ArrayList<ChannelData> list = data.toArrayList();
        double maxRate = findMaxRate(list);
        int baseHeight = getGraphBaseHeight(window.getGraphPanelHeight());

        for (int i = 0; i < list.size(); i++)
        {
            ChannelData channel = list.get(i);
            graphData.add(channel);

            int x = BAR_START_X + i * BAR_GAP;
            int barHeight = getBarHeight(channel.getEngagementRate(), maxRate);
            int y = baseHeight - barHeight;

            Shape bar = new Shape(x, y, BAR_WIDTH, barHeight, getBarColor());
            window.addShape(bar);

            TextShape nameLabel = new TextShape(
                x,
                baseHeight + LABEL_Y_OFFSET,
                shorten(channel.getChannelName()),
                Color.BLACK,
                FONT_SIZE,
                FONT_FAMILY);
            window.addShape(nameLabel);

            TextShape valueLabel = new TextShape(
                x,
                baseHeight + VALUE_Y_OFFSET,
                formatRate(channel.getEngagementRate()),
                Color.BLACK,
                FONT_SIZE,
                FONT_FAMILY);
            window.addShape(valueLabel);
        }
    }


    /**
     * Returns the graph baseline height
     * 
     * @param height
     *            graph panel height
     * @return baseline y coordinate
     */
    private int getGraphBaseHeight(int height)
    {
        if (height <= 0)
        {
            return 360;
        }

        return Math.max(360, height - 160);
    }


    /**
     * Finds the largest valid rate in the provided list
     * 
     * @param list
     *            channel data list
     * @return largest valid rate
     */
    private double findMaxRate(ArrayList<ChannelData> list)
    {
        double max = 0.0;

        for (ChannelData data : list)
        {
            Double rate = data.getEngagementRate();

            if (rate != null && rate >= 0 && rate > max && !Double.isNaN(rate)
                && !Double.isInfinite(rate))
            {
                max = rate;
            }
        }

        return max;
    }


    /**
     * Returns the height for one bar
     * 
     * @param rate
     *            engagement rate
     * @param maxRate
     *            largest engagement rate
     * @return bar height
     */
    private int getBarHeight(Double rate, double maxRate)
    {
        if (rate == null || rate < 0 || maxRate <= 0 || Double.isNaN(rate)
            || Double.isInfinite(rate))
        {
            return MIN_BAR_HEIGHT;
        }

        return Math.max(
            MIN_BAR_HEIGHT,
            (int)Math.round((rate / maxRate) * MAX_BAR_HEIGHT));
    }


    /**
     * Formats a rate for display
     * 
     * @param rate
     *            engagement rate
     * @return formatted rate or N/A
     */
    private String formatRate(Double rate)
    {
        if (rate == null || rate < 0 || Double.isNaN(rate)
            || Double.isInfinite(rate))
        {
            return "N/A";
        }

        return formatter.format(rate);
    }


    /**
     * Returns a random bar color for a channel
     * 
     * @return color for the channel
     */
    private Color getBarColor()
    {
        return new Color(
            50 + (int)(Math.random() * 156),
            50 + (int)(Math.random() * 156),
            50 + (int)(Math.random() * 156));
    }


    /**
     * Shortens long channel names so they fit under the bars
     * 
     * @param text
     *            original label
     * @return shortened label
     */
    private String shorten(String text)
    {
        if (text == null)
        {
            return "";
        }

        if (text.length() > MAX_LABEL_LENGTH)
        {
            return text.substring(0, MAX_LABEL_LENGTH);
        }

        return text;
    }


    /**
     * Updates the graph header labels
     */
    private void updateLabels()
    {
        if (window == null)
        {
            return;
        }

        window.addShape(
            new TextShape(
                HEADER_X,
                PERIOD_Y,
                getPeriodLabel(),
                Color.BLACK,
                FONT_SIZE,
                FONT_FAMILY));

        window.addShape(
            new TextShape(
                HEADER_X,
                FORMULA_Y,
                getFormulaLabel(),
                Color.BLACK,
                FONT_SIZE,
                FONT_FAMILY));

        window.addShape(
            new TextShape(
                HEADER_X,
                SORT_Y,
                getSortLabel(),
                Color.BLACK,
                FONT_SIZE,
                FONT_FAMILY));
    }


    /**
     * Gets the current period label
     * 
     * @return period label
     */
    private String getPeriodLabel()
    {
        if (model.getCurrentPeriod() == Period.JANUARY)
        {
            return "January";
        }
        else if (model.getCurrentPeriod() == Period.FEBRUARY)
        {
            return "February";
        }
        else if (model.getCurrentPeriod() == Period.MARCH)
        {
            return "March";
        }

        return "First Quarter (Jan-March)";
    }


    /**
     * Gets the current formula label
     * 
     * @return formula label
     */
    private String getFormulaLabel()
    {
        if (model.getCurrentFormula() == EngagementFormula.REACH)
        {
            return "Reach Engagement Rate";
        }

        return "Traditional Engagement Rate";
    }


    /**
     * Gets the current sorting label
     * 
     * @return sorting label
     */
    private String getSortLabel()
    {
        if (model.getCurrentSortMode() == SortMode.ENGAGEMENT_RATE)
        {
            return "Sorting by Engagement Rate";
        }

        return "Sorting by Channel Name";
    }


    /**
     * Clears saved graph data and removes all shapes
     */
    private void clearGraph()
    {
        graphData.clear();

        if (window != null)
        {
            window.removeAllShapes();
        }
    }
}
