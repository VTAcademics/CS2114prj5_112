package prj5;

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
 * /** Stores the social media statistics for one influencer for one month
 * 
 * @author Santiago Gonzalez-Zunino
 * @version Apr 20, 2026
 */

public class PeriodData
{
    private String month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;

    /**
     * Creates a new PeriodData object
     * 
     * @param month
     *            the month this data belongs to
     * @param likes
     *            total likes for the month
     * @param posts
     *            total posts for the month
     * @param followers
     *            total followers at the end of month
     * @param comments
     *            total comments for the month
     * @param views
     *            total views for the month
     */
    public PeriodData(
        String month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views)
    {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    /**
     * Returns the month for this period
     */
    public String getMonth()
    {
        return month;
    }


    /**
     * Returns total likes for this period
     */
    public int getLikes()
    {
        return likes;
    }


    /**
     * Returns total points for this period
     */
    public int getPosts()
    {
        return posts;
    }


    /**
     * Returns total followers for this period
     */
    public int getFollowers()
    {
        return followers;
    }


    /**
     * Returns total Comments for this period
     */
    public int getComments()
    {
        return comments;
    }


    /**
     * Returns total views for this period
     */
    public int getViews()
    {
        return views;
    }
}
