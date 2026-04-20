package prj5;

import java.util.ArrayList;

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
     * 
     */
    public String getUsername()
    {
        return username;
    }


    /**
     * 
     */
    public String getChannelName()
    {
        return channelName;
    }


    /**
     * 
     */
    public String getCountry()
    {
        return country;
    }


    /**
     * 
     */
    public String getTopic()
    {
        return topic;
    }


    /**
     * 
     */
    public void addPeriodData(PeriodData data)
    {
        periods.add(data);
    }


    /**
     * 
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
    // not complete

}
