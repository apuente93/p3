///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             TaskComparator.java
// Semester:         CS367 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////

/**
 * The TaskComparator class that compares two given tasks to prioritize
 *
 * <p>Bugs: None
 *
 * @author Alejandro Puente
 */
public class TaskComparator<E> implements Comparator<Task>
{
	/**
	* Creates an empty TaskComparator. No private fields are needed
	*/
	public TaskComparator ()
	{
		
	}

	/**
	* Compares Task priorities
	* @param e1 the first task you want to compare
	* @param e2 the second task you want to compare
	* @return -1 if e1 has an earlier deadline than e2, 0 if they come at the
	* same time and 1 if e1 has a later deadline than e2
	*/
	public int compare(Task e1, Task e2) 
	{
		if (e1.getDeadline() < e2.getDeadline())
		{
			return -1;
		}
		else if (e1.getDeadline() > e2.getDeadline())
		{
			return 1;
		}
		else
		{
			return 0;
		}
	}
	
}
