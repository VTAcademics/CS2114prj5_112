package prj5;
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
 * Represents a data object containing a channel name and its corresponding
 * engagement rate.
 *
 * @author Jai Mylavarupu
 * @version 2026-04-22
 */
public class ChannelData {
    private String channelName;
    private Double engagementRate;

    /**
     * Creates a new ChannelData object with the specified channel name and
     * engagement rate.
     *
     * @param channelName
     *            the name of the channel
     * @param engagementRate
     *            the engagement rate associated with the channel
     */
    public ChannelData(String channelName, double engagementRate) {
        this.channelName = channelName;
        this.engagementRate = engagementRate;
    }


    /**
     * Returns the name of the channel.
     *
     * @return the channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Returns the engagement rate of the channel.
     *
     * @return the engagement rate
     */
    public Double getEngagementRate() {
        return engagementRate;
    }


    /**
     * Returns a string representation of the channel data.
     *
     * @return a formatted string containing the channel name and engagement
     *         rate
     */
    public String toString() {
        return channelName + ": " + engagementRate;
    }
}
