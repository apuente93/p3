import java.util.ArrayList;

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
	* This should return an array list of tasks that are generated at time t. 
	* Each Process that has been added to the ProcessGenerator should have a 
	* Task created if t is a multiple of the period of the Process. Such a task 
	* should have a deadline equal to the time t plus the period of the corresponding
	* Process. The order does not matter. An example is provided below. 
	* 
	* @param t
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
