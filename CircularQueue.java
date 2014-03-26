///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             CircularQueue.java
// Semester:         CS367 Spring 2014
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
		return numItems == 0;
	}

	/**
	* Checks if the queue is full.
	* @return true if the queue is full; otherwise false
	*/
	public boolean isFull() 
	{
		return items.length == numItems;
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
			frontIndex = (frontIndex + 1) % items.length;
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
	    if (this.isFull()) 
	    {
	        throw new FullQueueException();
	    }
	    else
	    {
	    	items[rearIndex] = item;
	    	//Use auxiliary method to increment rear index with wraparound
	    	rearIndex = (rearIndex + 1) % items.length;
	    	numItems++;
	    }
	    
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
		for (int i = 0; i < items.length; i++)
		{
			queue += "[" + items[i] + "]";
		}
		return queue;
	}
	
	/*
	///////////////////////////////TESTING BOX ////////////////////////////////
	public static void main (String[] args)
	{
		CircularQueue<Integer> circularQueue = new CircularQueue<Integer>(5);

		try
		{
			
			System.out.println("Initial Queue = " + circularQueue.toString());
			System.out.println("Front Index = " + circularQueue.frontIndex);
			System.out.println("Rear Index = " + circularQueue.rearIndex);
			circularQueue.enqueue(1);
			circularQueue.enqueue(2);
			circularQueue.enqueue(3);
			circularQueue.enqueue(4);
			circularQueue.enqueue(5);
			System.out.println("Initial Queue enqueue(3) = " + circularQueue.toString());
			System.out.println("Front Index = " + circularQueue.frontIndex);
			System.out.println("Rear Index = " + circularQueue.rearIndex);
			circularQueue.dequeue();
			circularQueue.dequeue();
			circularQueue.dequeue();
			System.out.println("After dequeue(3) Queue = " + circularQueue.toString());
			System.out.println("Front Index = " + circularQueue.frontIndex);
			System.out.println("Rear Index = " + circularQueue.rearIndex);
			circularQueue.enqueue(900);
			circularQueue.enqueue(901);
			circularQueue.enqueue(902);
			System.out.println("After enqueue(3) Queue = " + circularQueue.toString());
			System.out.println("Front Index = " + circularQueue.frontIndex);
			System.out.println("Rear Index = " + circularQueue.rearIndex);
		}
		catch(FullQueueException e)
		{
			System.out.println("Queue is Full");
		}
		catch(EmptyQueueException e2)
		{
			System.out.println("Queue is Empty");
		}

	} */
}
