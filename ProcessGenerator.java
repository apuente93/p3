///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             ProcessGenerator.java
// Semester:         CS367 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////
import java.util.ArrayList;

/**
* The ProcessGenerator class that contains all the processes and respective tasks
* needed to be done
*
* <p>Bugs: None
*
* @author Alejandro Puente
*/
public class ProcessGenerator 
{
	//A list of all the processes that run in the system
	private ArrayList<Process> processes;
	
	/**
	* Creates an empty ProcessGenerator. No private fields are needed
	*/
	public ProcessGenerator()
	{
		processes = new ArrayList<Process>();
	}
	
	/**
	* This method adds a Process with period p and computation time 
	* c to the ProcessGenerator. 
	* 
	* @param p
	* @param c
	*/
	public void addProcess(int p, int c)
	{
		Process newProcess = new Process (p, c);
		processes.add(newProcess);
	}
	
	/**
	* Each Process that has been added to the ProcessGenerator has a
	* Task created if t is a multiple of the period of the Process. Such a task 
	* has a deadline equal to the time t plus the period of the corresponding
	* Process. This method gathers up all the tasks and returns them.
	* 
	* @param t the time wanted for these tasks to generate
	* @return all the tasks that will need to be sorted
	*/
	public ArrayList<Task> getTasks(int t)
	{
		ArrayList<Task> tasks = new ArrayList<Task>();
		for (int i = 0; i < this.processes.size(); i++)
		{
			if (t % processes.get(i).getPeriod() == 0)
			{
				Task task = new Task(processes.get(i), t);
				tasks.add(task);
			}
		}
		return tasks;
	}

}
