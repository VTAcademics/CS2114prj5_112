package prj5;

import java.util.ArrayList;

// Project 5 Spring 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Santiago Gonzalez-Zunino (906693577)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

/**
 * // -------------------------------------------------------------------------
 * /** Stores identity information for one social media influencer and a list of
 * their monthly PeriodData record
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 20, 2026
 */
public class InfluencerData
{
    private String username;
    private String channelName;
    private String country;
    private String topic;
    private ArrayList<PeriodData> periods;

    private static final String[] FIRST_QUARTER =
        { "january", "feburary", "march" };

    /**
     * Creates a new InfluencerData object.
     * 
     * @param username
     *            the influencer's username
     * @param channelName
     *            the influencer's channel name
     * @param country
     *            the influencer's country
     * @param topic
     *            the influencer's main topic
     */
    public InfluencerData(
        String username,
        String channelName,
        String country,
        String topic)
    {
        this.username = username;
        this.channelName = channelName;
        this.country = country;
        this.topic = topic;
        this.periods = new ArrayList<PeriodData>();
    }


    /**
     * Returns the username.
     * 
     * @return username
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * Returns the channel name.
     *
     * @return channelName
     */
    public String getChannelName()
    {
        return channelName;
    }


    /**
     * Returns the country.
     *
     * @return country
     */
    public String getCountry()
    {
        return country;
    }


    /**
     * Returns the main topic.
     *
     * @return topic
     */
    public String getTopic()
    {
        return topic;
    }


    /**
     * Adds a PeriodData record for this influencer.
     *
     * @param data
     *            the PeriodData to add
     */
    public void addPeriodData(PeriodData data)
    {
        periods.add(data);
    }


    /**
     * Returns the PeriodData for a given month, or null if not found.
     *
     * @param month
     *            the month to look up (case-insensitive)
     * @return PeriodData for that month, or null
     */
    public PeriodData getPeriodData(String month)
    {
        for (PeriodData pd : periods)
        {
            if (pd.getMonth().equalsIgnoreCase(month))
            {
                return pd;
            }
        }
        return null;
    }


    /**
     * Returns true if this month is part of the first quarter.
     *
     * @param month
     *            month string to check
     * @return true if January, February, or March
     */
    private boolean isFirstQuarter(String month)
    {
        for (String q : FIRST_QUARTER)
        {
            if (q.equalsIgnoreCase(month))
            {
                return true;
            }
        }
        return false;
    }


    /**
     * Calculates the traditional engagement rate for the first quarter.
     * Formula: ((total comments + total likes) / march followers) * 100 Uses
     * only March followers (end of quarter). Returns -1 if data is missing or
     * denominator is zero.
     *
     * @return traditional engagement rate, or -1 if N/A
     */
    public double getTraditionalEngagement()
    {
        long totalLikes = 0;
        long totalComments = 0;
        int marchFollowers = 0;
        boolean hasMarch = false;

        for (PeriodData pd : periods)
        {
            if (isFirstQuarter(pd.getMonth()))
            {
                totalLikes += pd.getLikes();
                totalComments += pd.getComments();
                if (pd.getMonth().equalsIgnoreCase("march"))
                {
                    marchFollowers = pd.getFollowers();
                    hasMarch = true;
                }
            }
        }

        if (!hasMarch || marchFollowers == 0)
        {
            return -1;
        }

        return ((double)(totalComments + totalLikes) / marchFollowers) * 100;
    }


    /**
     * Calculates the reach engagement rate for the first quarter. Formula:
     * ((total comments + total likes) / total views) * 100 Uses total views
     * across all first-quarter months. Returns -1 if total views is zero.
     *
     * @return reach engagement rate, or -1 if N/A
     */
    public double getReachEngagement()
    {
        long totalLikes = 0;
        long totalComments = 0;
        long totalViews = 0;

        for (PeriodData pd : periods)
        {
            if (isFirstQuarter(pd.getMonth()))
            {
                totalLikes += pd.getLikes();
                totalComments += pd.getComments();
                totalViews += pd.getViews();
            }
        }

        if (totalViews == 0)
        {
            return -1;
        }

        return ((double)(totalComments + totalLikes) / totalViews) * 100.0;

    }

}
