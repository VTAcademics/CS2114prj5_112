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

import java.util.ArrayList;

/**
 * // -------------------------------------------------------------------------
 * /** Handles doubly linked lists with setter, getter, sort, and conversion
 * methods
 * 
 * @param <T>
 *            the type of data stored in the list
 * @author Alejandro Trinidad
 * @version 2026.04.21
 */
public class DoublyLinkedList<T>
{
    // ~ Fields ................................................................
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // ~ Node Class ............................................................
    // -------------------------------------------------------------------------
    /**
     * Inner class that handles nodes
     * 
     * @param <T>
     *            the type of data stored in the node
     * @author Alejandro Trinidad
     * @version 2026.04.21
     */
    static class Node<T>
    {
        T data;
        Node<T> next;
        Node<T> prev;

        Node(T data)
        {
            this.data = data;
        }
    }

    // ~ Constructors ..........................................................
    /**
     * Creates a new doubly linked list of size 0 with sentinel head and tail
     * nodes
     */
    public DoublyLinkedList()
    {
        head = new Node<>(null); // sentinel
        tail = new Node<>(null); // sentinel
        head.next = tail;
        tail.prev = head;
        size = 0;
    }


    // ~ Public Methods ........................................................
    /**
     * Adds a new node to the list
     * 
     * @param data
     *            the new node to add
     */
    public void add(T data)
    {
        Node<T> newNode = new Node<>(data);

        Node<T> prevNode = tail.prev;

        prevNode.next = newNode;
        newNode.prev = prevNode;

        newNode.next = tail;
        tail.prev = newNode;

        size++;
    }


    /**
     * Removes a node from the list
     * 
     * @param data
     *            the node to be removed
     * @return true if data is found and removed, false otherwise
     */
    public boolean remove(T data)
    {
        Node<T> curr = head.next;

        while (curr != tail)
        {
            if ((data == null && curr.data == null)
                || (data != null && data.equals(curr.data)))
            {

                curr.prev.next = curr.next;
                curr.next.prev = curr.prev;
                size--;
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    /**
     * Finds a node in the list and returns if it exists or not
     * 
     * @param data
     *            the node to be found
     * @return true if found, false otherwise
     */
    public boolean contains(T data)
    {
        Node<T> curr = head.next;

        while (curr != tail)
        {
            if ((data == null && curr.data == null)
                || (data != null && data.equals(curr.data)))
            {
                return true;
            }
            curr = curr.next;
        }
        return false;
    }


    /**
     * Gets the size of the list
     * 
     * @returns the size of the list
     */
    public int getSize()
    {
        return size;
    }


    /**
     * Gets the head sentinel node
     * 
     * @return the head node
     */
    public Node<T> getHead()
    {
        return head;
    }


    /**
     * Gets the tail sentinel node
     * 
     * @return the tail node
     */
    public Node<T> getTail()
    {
        return tail;
    }


    /**
     * Sorts the list via insertion sort
     * 
     * @param cmp
     *            the comparator interface
     */
    public void insertionSort(Comparator<T> cmp)
    {
        if (size <= 1)
            return;

        Node<T> curr = head.next.next;

        while (curr != tail)
        {
            Node<T> keyNode = curr;
            Node<T> scan = curr.prev;

            curr = curr.next;

            keyNode.prev.next = keyNode.next;
            keyNode.next.prev = keyNode.prev;

            while (scan != head && cmp.compare(scan.data, keyNode.data) > 0)
            {
                scan = scan.prev;
            }

            keyNode.next = scan.next;
            keyNode.prev = scan;
            scan.next.prev = keyNode;
            scan.next = keyNode;
        }
    }


    /**
     * Converts the list to an ArrayList
     * 
     * @return the ArrayList output of the list
     */
    public ArrayList<T> toArrayList()
    {
        ArrayList<T> list = new ArrayList<>();
        Node<T> curr = head.next;

        while (curr != tail)
        {
            list.add(curr.data);
            curr = curr.next;
        }

        return list;
    }


    /**
     * Removes all items from the list
     */
    public void clear()
    {
        head.next = tail;
        tail.prev = head;
        size = 0;
    }


    /**
     * Checks if the list is empty or not
     * 
     * @return true if size = 0 (is empty), false otherwise
     */
    public boolean isEmpty()
    {
        return size == 0;
    }


    /**
     * Converts the list to a string
     * 
     * @return the string output of the list
     */
    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node<T> curr = head.next;

        while (curr != tail)
        {
            sb.append(curr.data);
            if (curr.next != tail)
            {
                sb.append(", ");
            }
            curr = curr.next;
        }

        sb.append("]");
        return sb.toString();
    }
}
