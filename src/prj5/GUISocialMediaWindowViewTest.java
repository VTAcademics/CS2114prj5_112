// Project 5 Spring 2026
// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Dohoon Kim (kim)
//
// LLM Statement:
// During the preparation of this assignment, I, Dohoon Kim, used ChatGPT 5.5
// Thinking in GUISocialMediaWIndowViewTest to get assisted on writing my test
// cases. After using this tool, I reviewed and edited the content as needed to
// ensure its accuracy and take full responsibility for the content in relation
// to grading. I understand that I am responsible for being able to complete
// this work without the use of assistance.

package prj5;

import java.awt.Color;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.Permission;
import java.util.ArrayList;

import student.TestCase;

// -------------------------------------------------------------------------
/**
 * Tests GUISocialMediaWindowView.
 * 
 * @author Dohoon Kim
 * @version May 1, 2026
 */
public class GUISocialMediaWindowViewTest
    extends TestCase
{
    private SocialMediaDashboard dashboard;
    private GUISocialMediaWindowView view;

    /**
     * Tests the whole GUI view without opening many windows.
     * 
     * @throws Exception
     *             if reflection fails
     */
    public void testView()
        throws Exception
    {
        makeView();

        assertNotNull(view.getWindow());
        assertEquals(4, view.getGraphData().getSize());

        assertEquals(Period.FIRST_QUARTER, dashboard.getCurrentPeriod());
        assertEquals(
            EngagementFormula.TRADITIONAL,
            dashboard.getCurrentFormula());
        assertEquals(SortMode.CHANNEL_NAME, dashboard.getCurrentSortMode());

        assertEquals(
            "First Quarter (Jan-March)",
            invokeNoArgString("getPeriodLabel"));
        assertEquals(
            "Traditional Engagement Rate",
            invokeNoArgString("getFormulaLabel"));
        assertEquals(
            "Sorting by Channel Name",
            invokeNoArgString("getSortLabel"));

        view.onReachFormula(null);
        assertEquals(EngagementFormula.REACH, dashboard.getCurrentFormula());
        assertEquals(
            "Reach Engagement Rate",
            invokeNoArgString("getFormulaLabel"));

        view.onTraditionalFormula(null);
        assertEquals(
            EngagementFormula.TRADITIONAL,
            dashboard.getCurrentFormula());
        assertEquals(
            "Traditional Engagement Rate",
            invokeNoArgString("getFormulaLabel"));

        view.onSortByEngagementRate(null);
        assertEquals(SortMode.ENGAGEMENT_RATE, dashboard.getCurrentSortMode());
        assertEquals(
            "Sorting by Engagement Rate",
            invokeNoArgString("getSortLabel"));

        view.onSortByChannelName(null);
        assertEquals(SortMode.CHANNEL_NAME, dashboard.getCurrentSortMode());
        assertEquals(
            "Sorting by Channel Name",
            invokeNoArgString("getSortLabel"));

        view.onJanuary(null);
        assertEquals(Period.JANUARY, dashboard.getCurrentPeriod());
        assertEquals("January", invokeNoArgString("getPeriodLabel"));

        view.onFebruary(null);
        assertEquals(Period.FEBRUARY, dashboard.getCurrentPeriod());
        assertEquals("February", invokeNoArgString("getPeriodLabel"));

        view.onMarch(null);
        assertEquals(Period.MARCH, dashboard.getCurrentPeriod());
        assertEquals("March", invokeNoArgString("getPeriodLabel"));

        view.onFirstQuarter(null);
        assertEquals(Period.FIRST_QUARTER, dashboard.getCurrentPeriod());
        assertEquals(
            "First Quarter (Jan-March)",
            invokeNoArgString("getPeriodLabel"));

        assertEquals(360, invokeGraphBaseHeight(0));
        assertEquals(360, invokeGraphBaseHeight(400));
        assertEquals(540, invokeGraphBaseHeight(700));

        assertEquals(5, invokeBarHeight(null, 100.0));
        assertEquals(5, invokeBarHeight(-1.0, 100.0));
        assertEquals(5, invokeBarHeight(10.0, 0.0));
        assertEquals(5, invokeBarHeight(Double.NaN, 100.0));
        assertEquals(5, invokeBarHeight(Double.POSITIVE_INFINITY, 100.0));
        assertEquals(5, invokeBarHeight(1.0, 1000.0));
        assertEquals(150, invokeBarHeight(50.0, 100.0));
        assertEquals(300, invokeBarHeight(100.0, 100.0));

        assertEquals("7.2", invokeRateString("formatRate", 7.24));
        assertEquals("5", invokeRateString("formatRate", 5.0));
        assertEquals("N/A", invokeRateString("formatRate", null));
        assertEquals("N/A", invokeRateString("formatRate", -1.0));
        assertEquals("N/A", invokeRateString("formatRate", Double.NaN));
        assertEquals(
            "N/A",
            invokeRateString("formatRate", Double.POSITIVE_INFINITY));

        assertEquals("", invokeTextString("shorten", null));
        assertEquals("short", invokeTextString("shorten", "short"));
        assertEquals(
            "alphaChannelW",
            invokeTextString("shorten", "alphaChannelWithLongName"));

        testFindMaxRateHelper();
        testColorHelper();

        invokeDrawGraphBars(null);
        invokeDrawGraphBars(new DoublyLinkedList<ChannelData>());

        assertEquals(4, view.getGraphData().getSize());

        testQuitAndNullWindowBranches();
    }


    /**
     * Creates the view with sample data.
     */
    private void makeView()
    {
        DoublyLinkedList<InfluencerData> influencers =
            new DoublyLinkedList<InfluencerData>();

        InfluencerData alpha = new InfluencerData(
            "alpha",
            "alphaChannelWithLongName",
            "US",
            "Tech");
        alpha.addPeriodData(new PeriodData("January", 100, 1, 100, 0, 100));
        alpha.addPeriodData(new PeriodData("February", 80, 1, 100, 0, 100));
        alpha.addPeriodData(new PeriodData("March", 60, 1, 100, 0, 100));

        InfluencerData beta =
            new InfluencerData("beta", "beta", "US", "Sports");
        beta.addPeriodData(new PeriodData("January", 10, 1, 100, 0, 50));
        beta.addPeriodData(new PeriodData("February", 20, 1, 100, 0, 50));
        beta.addPeriodData(new PeriodData("March", 30, 1, 100, 0, 50));

        InfluencerData delta =
            new InfluencerData("delta", "delta", "US", "Art");
        delta.addPeriodData(new PeriodData("January", 20, 1, 100, 0, 0));
        delta.addPeriodData(new PeriodData("February", 20, 1, 100, 0, 0));
        delta.addPeriodData(new PeriodData("March", 20, 1, 100, 0, 0));

        InfluencerData gamma =
            new InfluencerData("gamma", "gamma", "US", "Fashion");
        gamma.addPeriodData(new PeriodData("January", 40, 1, 0, 0, 100));
        gamma.addPeriodData(new PeriodData("February", 40, 1, 0, 0, 100));
        gamma.addPeriodData(new PeriodData("March", 40, 1, 0, 0, 100));

        influencers.add(alpha);
        influencers.add(beta);
        influencers.add(delta);
        influencers.add(gamma);

        dashboard = new SocialMediaDashboard(new AnalyticsManager(influencers));
        view = new GUISocialMediaWindowView(dashboard);
    }


    /**
     * Tests findMaxRate.
     * 
     * @throws Exception
     *             if reflection fails
     */
    private void testFindMaxRateHelper()
        throws Exception
    {
        ArrayList<ChannelData> data = new ArrayList<ChannelData>();
        data.add(new NullRateChannelData("null"));
        data.add(new ChannelData("negative", -1.0));
        data.add(new ChannelData("nan", Double.NaN));
        data.add(new ChannelData("infinite", Double.POSITIVE_INFINITY));
        data.add(new ChannelData("small", 4.0));
        data.add(new ChannelData("large", 9.0));
        data.add(new ChannelData("smaller", 3.0));

        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod("findMaxRate", ArrayList.class);
        method.setAccessible(true);

        assertEquals(
            9.0,
            ((Double)method.invoke(view, data)).doubleValue(),
            0.01);
    }


    /**
     * Tests getBarColor.
     * 
     * @throws Exception
     *             if reflection fails
     */
    private void testColorHelper()
        throws Exception
    {
        Method method =
            GUISocialMediaWindowView.class.getDeclaredMethod("getBarColor");
        method.setAccessible(true);

        Color color = (Color)method.invoke(view);

        assertEquals(true, color.getRed() >= 50);
        assertEquals(true, color.getRed() <= 205);
        assertEquals(true, color.getGreen() >= 50);
        assertEquals(true, color.getGreen() <= 205);
        assertEquals(true, color.getBlue() >= 50);
        assertEquals(true, color.getBlue() <= 205);
    }


    /**
     * Tests quit and null-window branches.
     * 
     * @throws Exception
     *             if reflection fails
     */
    private void testQuitAndNullWindowBranches()
        throws Exception
    {
        SecurityManager oldManager = System.getSecurityManager();
        System.setSecurityManager(new NoExitSecurityManager());

        try
        {
            view.onQuit(null);
            fail("System.exit should have been blocked.");
        }
        catch (SecurityException exception)
        {
            assertNull(view.getWindow());
            assertEquals(0, view.getGraphData().getSize());
        }
        finally
        {
            System.setSecurityManager(oldManager);
        }

        invokeVoid("updateLabels");
        invokeVoid("clearGraph");
        invokeVoid("redrawGraph");

        DoublyLinkedList<ChannelData> data =
            new DoublyLinkedList<ChannelData>();
        data.add(new ChannelData("afterQuit", 1.0));
        invokeDrawGraphBars(data);

        assertNull(view.getWindow());
        assertEquals(0, view.getGraphData().getSize());
    }


    /**
     * Invokes getGraphBaseHeight.
     * 
     * @param value
     *            height value
     * @return result
     * @throws Exception
     *             if reflection fails
     */
    private int invokeGraphBaseHeight(int value)
        throws Exception
    {
        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod("getGraphBaseHeight", int.class);
        method.setAccessible(true);
        return ((Integer)method.invoke(view, value)).intValue();
    }


    /**
     * Invokes getBarHeight.
     * 
     * @param rate
     *            rate
     * @param maxRate
     *            max rate
     * @return height
     * @throws Exception
     *             if reflection fails
     */
    private int invokeBarHeight(Double rate, double maxRate)
        throws Exception
    {
        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod("getBarHeight", Double.class, double.class);
        method.setAccessible(true);
        return ((Integer)method.invoke(view, rate, maxRate)).intValue();
    }


    /**
     * Invokes a private no-arg String method.
     * 
     * @param methodName
     *            method name
     * @return result
     * @throws Exception
     *             if reflection fails
     */
    private String invokeNoArgString(String methodName)
        throws Exception
    {
        Method method =
            GUISocialMediaWindowView.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        return (String)method.invoke(view);
    }


    /**
     * Invokes a private String method that takes a Double.
     * 
     * @param methodName
     *            method name
     * @param value
     *            value
     * @return result
     * @throws Exception
     *             if reflection fails
     */
    private String invokeRateString(String methodName, Double value)
        throws Exception
    {
        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod(methodName, Double.class);
        method.setAccessible(true);
        return (String)method.invoke(view, value);
    }


    /**
     * Invokes a private String method that takes a String.
     * 
     * @param methodName
     *            method name
     * @param value
     *            value
     * @return result
     * @throws Exception
     *             if reflection fails
     */
    private String invokeTextString(String methodName, String value)
        throws Exception
    {
        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod(methodName, String.class);
        method.setAccessible(true);
        return (String)method.invoke(view, value);
    }


    /**
     * Invokes a private void method with no parameters.
     * 
     * @param methodName
     *            method name
     * @throws Exception
     *             if reflection fails
     */
    private void invokeVoid(String methodName)
        throws Exception
    {
        Method method =
            GUISocialMediaWindowView.class.getDeclaredMethod(methodName);
        method.setAccessible(true);
        method.invoke(view);
    }


    /**
     * Invokes drawGraphBars.
     * 
     * @param data
     *            data to pass
     * @throws Exception
     *             if reflection fails
     */
    private void invokeDrawGraphBars(DoublyLinkedList<ChannelData> data)
        throws Exception
    {
        Method method = GUISocialMediaWindowView.class
            .getDeclaredMethod("drawGraphBars", DoublyLinkedList.class);
        method.setAccessible(true);
        method.invoke(view, data);
    }

    /**
     * ChannelData that returns null for its engagement rate.
     */
    private static class NullRateChannelData
        extends ChannelData
    {
        /**
         * Creates null-rate channel data.
         * 
         * @param name
         *            channel name
         */
        public NullRateChannelData(String name)
        {
            super(name, 0.0);
        }


        /**
         * Returns null.
         * 
         * @return null
         */
        public Double getEngagementRate()
        {
            return null;
        }
    }


    /**
     * Security manager that blocks System.exit.
     */
    private static class NoExitSecurityManager
        extends SecurityManager
    {
        /**
         * Allows normal permissions.
         * 
         * @param permission
         *            permission
         */
        public void checkPermission(Permission permission)
        {
            // allow
        }


        /**
         * Allows normal permissions.
         * 
         * @param permission
         *            permission
         * @param context
         *            context
         */
        public void checkPermission(Permission permission, Object context)
        {
            // allow
        }


        /**
         * Blocks System.exit.
         * 
         * @param status
         *            exit status
         */
        public void checkExit(int status)
        {
            throw new SecurityException("Blocked System.exit");
        }
    }
}
