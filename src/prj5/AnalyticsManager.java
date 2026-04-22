package prj5;

import java.util.ArrayList;
import java.util.Comparator;
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
 * Manages analytics operations on influencer data, including filtering,
 * sorting, and calculating engagement metrics.
 *
 * @author Jai Mylavarupu
 * @version 2026-04-22
 */
public class AnalyticsManager {
    private DoublyLinkedList<InfluencerData> records;

    /**
     * Creates a new AnalyticsManager with the provided records. If the records
     * are null an empty list is initialized.
     *
     * @param records
     *            the list of influencer data records
     */
    public AnalyticsManager(DoublyLinkedList<InfluencerData> records) {
        if (records == null) {
            this.records = new DoublyLinkedList<InfluencerData>();
        }
        else {
            this.records = records;
        }
    }


    /**
     * Filters influencer data based on the specified period and engagement
     * formula returning a list of channel data.
     *
     * @param period
     *            the time period to filter data by
     * @param formulaType
     *            the engagement formula to use
     * @return a list of ChannelData objects containing computed engagement
     *         rates
     */
    public DoublyLinkedList<ChannelData> getFilteredData(
        Period period,
        EngagementFormula formulaType) {
        DoublyLinkedList<ChannelData> result =
            new DoublyLinkedList<ChannelData>();

        ArrayList<InfluencerData> list = records.toArrayList();

        for (InfluencerData record : list) {
            double rate;

            if (formulaType == EngagementFormula.REACH) {
                rate = calculateReachRate(record, period);
            }
            else {
                rate = calculateTraditionalRate(record, period);
            }

            result.add(new ChannelData(record.getChannelName(), rate));
        }

        return result;
    }


    /**
     * Sorts the provided channel data using the given comparator.
     *
     * @param data
     *            the list of channel data to sort
     * @param c
     *            the comparator used to determine ordering
     */
    public void sortData(
        DoublyLinkedList<ChannelData> data,
        Comparator<ChannelData> c) {
        if (data == null || c == null || data.getSize() <= 1) {
            return;
        }

        ArrayList<ChannelData> list = data.toArrayList();

        for (int i = 1; i < list.size(); i++) {
            ChannelData key = list.get(i);
            int j = i - 1;

            if (c instanceof EngagementComparator) {
                while (j >= 0 && c.compare(list.get(j), key) < 0) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            }
            else {
                while (j >= 0 && c.compare(list.get(j), key) > 0) {
                    list.set(j + 1, list.get(j));
                    j--;
                }
            }

            list.set(j + 1, key);
        }

        data.clear();
        for (ChannelData item : list) {
            data.add(item);
        }
    }


    /**
     * Calculates the traditional engagement rate for a given influencer record
     * and period.
     *
     * @param record
     *            the influencer data record
     * @param period
     *            the period to calculate the rate for
     * @return the traditional engagement rate or -1 if invalid data is present
     */
    public double calculateTraditionalRate(
        InfluencerData record,
        Period period) {
        if (record == null || period == null) {
            return -1;
        }

        if (period == Period.FIRST_QUARTER) {
            long totalLikes = 0;
            long totalComments = 0;

            PeriodData january = record.getPeriodData("January");
            PeriodData february = record.getPeriodData("February");
            PeriodData march = record.getPeriodData("March");

            if (january != null) {
                totalLikes += january.getLikes();
                totalComments += january.getComments();
            }

            if (february != null) {
                totalLikes += february.getLikes();
                totalComments += february.getComments();
            }

            if (march == null || march.getFollowers() == 0) {
                return -1;
            }

            totalLikes += march.getLikes();
            totalComments += march.getComments();

            return ((double)(totalLikes + totalComments) / march.getFollowers())
                * 100.0;
        }

        PeriodData data = record.getPeriodData(periodToString(period));

        if (data == null || data.getFollowers() == 0) {
            return -1;
        }

        return ((double)(data.getLikes() + data.getComments()) / data
            .getFollowers()) * 100.0;
    }


    /**
     * Calculates the reach based engagement rate for a given influencer record
     * and period.
     *
     * @param record
     *            the influencer data record
     * @param period
     *            the period to calculate the rate for
     * @return the reach engagement rate or -1 if invalid data is present
     */
    public double calculateReachRate(InfluencerData record, Period period) {
        if (record == null || period == null) {
            return -1;
        }

        if (period == Period.FIRST_QUARTER) {
            long totalLikes = 0;
            long totalComments = 0;
            long totalViews = 0;

            PeriodData january = record.getPeriodData("January");
            PeriodData february = record.getPeriodData("February");
            PeriodData march = record.getPeriodData("March");

            if (january != null) {
                totalLikes += january.getLikes();
                totalComments += january.getComments();
                totalViews += january.getViews();
            }

            if (february != null) {
                totalLikes += february.getLikes();
                totalComments += february.getComments();
                totalViews += february.getViews();
            }

            if (march != null) {
                totalLikes += march.getLikes();
                totalComments += march.getComments();
                totalViews += march.getViews();
            }

            if (totalViews == 0) {
                return -1;
            }

            return ((double)(totalLikes + totalComments) / totalViews) * 100.0;
        }

        PeriodData data = record.getPeriodData(periodToString(period));

        if (data == null || data.getViews() == 0) {
            return -1;
        }

        return ((double)(data.getLikes() + data.getComments()) / data
            .getViews()) * 100.0;
    }


    /**
     * Converts a Period enum value to its corresponding string representation.
     *
     * @param period
     *            the period to convert
     * @return the string representation of the period
     */
    private String periodToString(Period period) {
        if (period == Period.JANUARY) {
            return "January";
        }
        if (period == Period.FEBURARY) {
            return "February";
        }
        if (period == Period.MARCH) {
            return "March";
        }
        return "";
    }
}
