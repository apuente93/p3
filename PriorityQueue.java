///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             PriorityQueue.java
// Semester:         CS367 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.Comparator;

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
	private Comparator<E> comparator;
	//The items in the priority queue
	private E[] items;
	//The number of items in the queue
	private int numItems;
	
	/**
	* Creates a priority queue using the specified capacity.
	* 
	* @param maxCapacity the integer representation of the max size 
	* of the circular array queue
	*/
	public PriorityQueue(Comparator<E> comparator, int maxCapacity)
	{
		this.comparator = comparator;
		items = (E[])(new Object[maxCapacity + 1]);
		numItems = 0;
	}

	/**
	* Checks if the priority queue is empty.
	* @return true if the priority queue is empty; otherwise false
	*/
	public boolean isEmpty() 
	{
		return numItems == 0;
	}

	/**
	* Checks if the priority queue is full.
	* @return true if the priority queue is full; otherwise false
	*/
	public boolean isFull() 
	{
		return items.length == numItems;
	}

	/**
	* Returns the item with the highest priority of the queue
	* @return the item with the highest priority of the queue
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
			return items[1];
		}
	}

	/**
	* Removes and returns the front item of the queue. Then reorders the heap.
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
			//Variable used to hold the front item
			E priority = items[1];
			items[1] = items[numItems];
			items[numItems] = null;
			
			numItems--;
			heapifyDown(1);
			
			return priority;
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
			items[numItems + 1] = item;
			numItems++;
			heapifyUp(numItems);
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
		String priorityQueue = "";
		for (int i = 1; i < numItems + 1; i++)
		{
			priorityQueue = priorityQueue + items[i].toString() + " ";
		}
		return priorityQueue;
	}
	
	/**
	* Method that orders the priority queue from top to bottom
	* 
	* @param root the  position of the root of the priority queue
	*/
	private void heapifyDown(int root)
	{
        if (2 * root > numItems)
        {
            return;
        }
        
        //The left child of the heap
        int leftChild = 2 * root;
        //The right child of the heap
        int rightChild = leftChild + 1;
        //Variable used to determine the highest priority
        int higherPriority;
        
        if(rightChild > numItems)
        {
            higherPriority = leftChild;
        }
        
        else
        {
            higherPriority = comparator.compare(items[leftChild], items[rightChild]) < 0
            ? leftChild : rightChild;
        }
        
        if(comparator.compare(items[higherPriority], items[root]) < 0)
        {
        	if(root < 0 || root > numItems
            || higherPriority < 0 || higherPriority > numItems)
        	{
        		throw new IndexOutOfBoundsException();
        	}
        	//A holder for swapping
        	E holdValueIndex1 = items[root];
	        items[root] = items[higherPriority];
            items[higherPriority] = holdValueIndex1;
            heapifyDown(higherPriority);
        }
	}
	
	 private void heapifyUp(int rightMostLeaf)
	    {
		 	//The parent of the rightMostLeaf
		    int parent = rightMostLeaf / 2;
	        if(rightMostLeaf <= 1)
	        {
	            return;
	        }
	        if(comparator.compare(items[rightMostLeaf], items[parent]) < 0)
	        {
	        	if(rightMostLeaf < 0 || rightMostLeaf > numItems
	        			|| parent < 0 || parent > numItems)
	        	{
	        		throw new IndexOutOfBoundsException();
	        	}
	        	//A holder for swapping
	        	E holdValueIndex1 = items[rightMostLeaf];
		        items[rightMostLeaf] = items[parent];
                items[parent] = holdValueIndex1;
	            heapifyUp(parent);
	            heapifyDown(rightMostLeaf);
	        }
	    }
}