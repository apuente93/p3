///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             CircularQueue.java
// Semester:         CS302 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * The CircularQueue class that represents a circular ArrayList queue
 *
 * <p>Bugs: None
*
* @author Alejandro Puente
*/
public class CircularQueue<E> implements QueueADT<E>
{
	//Initial array size
	private static final int INITSIZE = 10;
	//The items in the queue
	private E[] items;
	//The number of items in the queue
	private int numItems;
	//The position of the last element
	private int rearIndex;
	//The position of the first element
	private int frontIndex;

	/**
	* The constructor of the CircularQueue() class, that initializes all private
	* variables to their respective starting values
	*/
	public CircularQueue() 
	{
		items = (E[])(new Object[INITSIZE]);
		frontIndex = rearIndex = numItems = 0;
	}  
	
	/**
	* Creates an empty queue using the specified capacity.
	* 
	* @param maxCapacity the integer representation of the max size 
	* of the circular array queue
	*/
	public CircularQueue(int maxCapacity) {
		items = (E[])(new Object[maxCapacity]);
		frontIndex = rearIndex = numItems = 0;
	}
	
	/**
	* Checks if the queue is empty.
	* @return true if the queue is empty; otherwise false
	*/
	public boolean isEmpty() 
	{
		if (numItems == 0)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	* Checks if the queue is full.
	* @return true if the queue is full; otherwise false
	*/
	public boolean isFull() 
	{
		if (items.length == numItems)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	* Returns the front item of the queue without removing it.
	* @return the front item of the queue
	* @throws EmptyQueueException
	*/
	public E peek() throws EmptyQueueException 
	{
		if (this.isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			return items[frontIndex];
		}
	}

	/**
	* Removes and returns the front item of the queue.
	* 
	* @return the first item in the queue
	* @throws EmptyQueueException if the queue is empty
	*/
	public E dequeue() throws EmptyQueueException 
	{
		if (this.isEmpty())
		{
			throw new EmptyQueueException();
		}
		else
		{
			E itemHolder = items[frontIndex];
			items[frontIndex] = null;
			//Use auxiliary method to increment front index with wraparound
			frontIndex = incrementIndex(frontIndex);
			numItems--;
			return itemHolder;
		}
	}

	/**
	* Inserts the item at the rear of the queue.
	* 
	* @param item The item to add to the queue.
	* @throws FullQueueException if the queue is full
	*/
	public void enqueue(E item) throws FullQueueException 
	{
		//Check for full array and expand if necessary
	    if (this.isFull()) 
	    {
	        throw new FullQueueException();
	    }

	    //Use auxiliary method to increment rear index with wraparound
	    rearIndex = incrementIndex(rearIndex);

	    //Insert new item at rear of queue
	    items[rearIndex] = item;
	    numItems++;
	}

	/**
	* Returns the number of items the queue can hold
	* 
	* @return the number of items the queue can hold
	*/
	public int capacity() 
	{
		return items.length;
	}

	/**
	* Returns the number of items in the queue
	* 
	* @return the number of items in the queue
	*/
	public int size() 
	{
		return numItems;
	}
	
	/**
	* Returns a string representation of the queue (for printing).
	* 
	* @return an ordered string representation of the queue
	*/
	public String toString()
	{
		String queue = "";
		for (int i = frontIndex; i < items.length; i++)
		{
			queue += items[i] + " ";
		}
		if (frontIndex != 0)
		{
			for (int i = 0; i < rearIndex; i++)
			{
				queue += items[i] + " ";
			}
		}
		return queue;
	}

	private int incrementIndex(int index) 
	{
	    if (index == items.length-1) 
	    {
	        return 0;
	    }
	    else 
	    {
	        return index + 1;
	    }
	}
}
