import java.util.Comparator;

///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             PriorityQueue.java
// Semester:         CS302 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * The PriorityQueue class that represents a priority queue implemented as an
 * array based min-heap
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente
 */
public class PriorityQueue<E> implements QueueADT<E>
{   
	//Variable that holds the ComparableTask object that is used to prioritize
	//tasks
	private ComparableTask<E> comparator;
	//Variable that holds the max capacity of the priority queue
	private int maxCapacity;
	/**
	* Creates a priority queue using the specified capacity.
	* 
	* @param maxCapacity the integer representation of the max size 
	* of the circular array queue
	*/
	public PriorityQueue(ComparableTask<E> comparator, int maxCapacity)
	{
		this.comparator = comparator;
		this.maxCapacity = maxCapacity;
	}

	/**
	* Checks if the queue is empty.
	* @return true if the queue is empty; otherwise false
	*/
	public boolean isEmpty() 
	{
		return false;
	}

	/**
	* Checks if the queue is full.
	* @return true if the queue is full; otherwise false
	*/
	public boolean isFull() 
	{
		return false;
	}

	/**
	* Returns the front item of the queue without removing it.
	* @return the front item of the queue
	* @throws EmptyQueueException
	*/
	public E peek() throws EmptyQueueException 
	{
		return null;
	}

	/**
	* Removes and returns the front item of the queue.
	* 
	* @return the first item in the queue
	* @throws EmptyQueueException if the queue is empty
	*/
	public E dequeue() throws EmptyQueueException 
	{
		return null;
	}

	/**
	* Inserts the item at the rear of the queue.
	* 
	* @param item The item to add to the queue.
	* @throws FullQueueException if the queue is full
	*/
	public void enqueue(E item) throws FullQueueException 
	{
		
	}

	/**
	* Returns the number of items the queue can hold
	* 
	* @return the number of items the queue can hold
	*/
	public int capacity() 
	{
		return 0;
	}

	/**
	* Returns the number of items in the queue
	* 
	* @return the number of items in the queue
	*/
	public int size() 
	{
		return 0;
	}
	
	/**
	* Returns a string representation of the queue (for printing).
	* 
	* @return an ordered string representation of the queue
	*/
	public String toString()
	{
		return null;
	}

}
