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

import student.TestCase;

/**
 * // -------------------------------------------------------------------------
 * /** Test class for DoublyLinkedList
 *
 * @author Alejandro Trinidad
 * @version 2026.04.23
 */
public class DoublyLinkedListTest
    extends TestCase
{
    // ~ Fields ................................................................
    private DoublyLinkedList<InfluencerData> list;
    private InfluencerData a;
    private InfluencerData b;
    private InfluencerData c;
    // ~ Constructors ..........................................................

    // ~Public Methods ........................................................
    /**
     * Sets up the DoublyLinkedList and different InfluencerData objects to be
     * tested
     */
    public void setUp()
    {
        list = new DoublyLinkedList<>();

        a = new InfluencerData("agamer206", "AGamer", "US", "Gaming");
        b = new InfluencerData("bobeatsfood", "Bob Eats Food", "UK", "Food");
        c = new InfluencerData("canadasport", "Canada Sport", "CA", "Sports");
    }

    /**
     * Tests the size() method
     */
    public void testSize()
    {
        list.add(a);
        list.add(b);

        assertEquals(2, list.getSize());
    }
    
    /**
     * Tests the isEmpty() method
     */
    public void testIsEmpty()
    {
        assertTrue(list.isEmpty());
        list.add(a);
        assertFalse(list.isEmpty());
    }

    /**
     * Tests the contains() method
     */
    public void testContains()
    {
        list.add(a);

        assertTrue(list.contains(a));
        assertFalse(list.contains(b));

        // different object
        InfluencerData copy =
            new InfluencerData("agamer206", "AGamer", "US", "Gaming");
        assertFalse(list.contains(copy));

        // null
        list.add(null);
        assertTrue(list.contains(null));
    }

    /**
     * Tests the remove() method
     */
    public void testRemove()
    {
        list.add(a);
        list.add(b);

        assertTrue(list.remove(a));
        assertFalse(list.contains(a));
        assertEquals(1, list.getSize());

        assertFalse(list.remove(c));

        // null
        list.add(null);
        assertTrue(list.remove(null));
    }

    /**
     * Tests the clear() method
     */
    public void testClear()
    {
        list.add(a);
        list.add(b);

        list.clear();

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
    }

    /**
     * Tests the toString() method
     */
    public void testToString()
    {
        list.add(a);
        list.add(b);

        String result = list.toString();

        assertTrue(result.startsWith("["));
        assertTrue(result.endsWith("]"));
        assertEquals(2, list.getSize());
    }
    
    /**
     * Tests the toArrayList() method
     */
    public void testToArrayList()
    {
        list.add(a);
        list.add(b);
        list.add(c);
        
        assertEquals(a, list.toArrayList().get(0));
        assertEquals(b, list.toArrayList().get(1));
        assertEquals(c, list.toArrayList().get(2));  
    }

    /**
     * Tests the getHead() method
     */
    public void testGetHead()
    {
        assertNotNull(list.getHead()); // sentinel
    }

    /**
     * Tests the getTail() method
     */
    public void testGetTail()
    {
        assertNotNull(list.getTail()); // sentinel
    }
    
    /**
     * Tests the insertionSort() method
     */
    public void testInsertionSort()
    {
        // size <= 1
        list.insertionSort((a, b) -> 0);

        assertTrue(list.isEmpty());
        assertEquals(0, list.getSize());
        
        // size > 1
        list.add(c);
        list.add(a);
        list.add(b);

        list.insertionSort(
            (x, y) -> x.getUsername().compareTo(y.getUsername()));

        assertEquals(a, list.toArrayList().get(0));
        assertEquals(b, list.toArrayList().get(1));
        assertEquals(c, list.toArrayList().get(2));
    }
}
