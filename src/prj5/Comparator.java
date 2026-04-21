// Project 4 Spring 2026
// Virginia Tech Honor Code Pledge:

//

// As a Hokie, I will conduct myself with honor and integrity at all times.

// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.

// -- Alejandro Trinidad (alextv5002)

// LLM Statement:

// I have not used any assistance for the assignment beyond course resources and
// staff.

package prj5;

/**
 * // -------------------------------------------------------------------------
 * /** Comparator interface that defines a strategy to compare two objects
 * 
 * @param <T>
 *            the type of object being compared
 * @author Alejandro Trinidad
 * @version 2026.04.21
 */
public interface Comparator<T>
{
    /**
     * Compares two objects
     * 
     * @param a
     *            the first object
     * @param b
     *            the second object
     * @return a positive integer if a > b, 0 if a = b, and negative if a < b
     */
    int compare(T a, T b);
}
