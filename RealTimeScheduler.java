///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Title:            p3
// Files:            RealTimeScheduler.java, CircularQueue.java, 
//					 PriorityQueue.java, ProcessGenerator.java,
//					 IncorrectConfigFormatException.java,
//					 ConfigReader.java
//
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
* This class gets the configuration file as its only command line argument. 
* It then determines whether the set of tasks and compute resources described
* in the configuration can be run without missing any deadlines
*/
public class RealTimeScheduler
{     
/**
* The main method of the RealTimeScheduler
*/
    public static void main(String[] args)
    {
    	//The file used to get all the process information
    	ConfigReader file;
    	
        if(args.length != 1)
        {
            System.out.println("Incorrect command line arguments");
            return;
        }
        
        try
        {
            file = new ConfigReader(args[0]);
        }
        
        catch (IncorrectConfigFormatException e)
        {
            printPrereqs();
            return;
        } 
        
        ArrayList<Process> processes = file.getProcesses();
        int maxTime = file.getMaxTime();
        int circularQueueSize = file.getCircularQueueCap();
        int priorityQueueSize = file.getPriorityQueueCap();
        
        //The main task comparator
        TaskComparator taskComparator = new TaskComparator();
        //The main priority queue
        PriorityQueue<Task> priorityQueue =
        new PriorityQueue<Task>(taskComparator, priorityQueueSize);
        //The main resource generator
        ComputeResourceGenerator resourceGen =
        new ComputeResourceGenerator(maxTime);
        //The main circular queue
        CircularQueue<ComputeResource> circularQueue =
        new CircularQueue<ComputeResource>(circularQueueSize);
        //The main process generator
        ProcessGenerator processGenerator = new ProcessGenerator();
        
        //The variable that holds the deadline
        int deadline = 1;
        
        for(int i = 0; i < processes.size(); i++)
        {
        	Process process = processes.get(i);
            processGenerator.addProcess(process.getPeriod(), process.getComputeTime());
            deadline = lcm(deadline, process.getPeriod());
        }
        
        for(int i = 0; i <= deadline; i++)
        {
        	ArrayList<ComputeResource> resourceArray = new ArrayList<ComputeResource>();
            for(int c = 0; c < resourceArray.size(); c++)
            {
            	ComputeResource computeResource = resourceArray.get(c);
                try
                {
                    circularQueue.enqueue(computeResource);
                }
                
                catch (FullQueueException e)
                {
                    break;
                }
            }
            
            for(Task task : processGenerator.getTasks(i))
            {
                try
                {
                    priorityQueue.enqueue(task);
                }
                
                catch (FullQueueException e)
                {
                    System.out.println("Deadline missed at timestep "
                    + (i - 1));
                    return;
                }
            }
            
            //Variable that holds all the tasks
            ArrayList<Task> tasks = new ArrayList<Task>();
            
            while(!circularQueue.isEmpty() && !priorityQueue.isEmpty())
            {
                try
                {
                    ComputeResource resource = circularQueue.dequeue();
                    Task priorityTask = priorityQueue.dequeue();
                    
                    priorityTask.updateProgress(resource.getValue());
                    
                   if(!priorityTask.isComplete())
                        tasks.add(priorityTask);
                }
                
                catch (EmptyQueueException e)
                {
                    System.out.println("Empty queue");
                    return;
                }
            }
            
            for(int j = 0; j < tasks.size(); j++)
            {
            	Task task = tasks.get(j);
                try
                {
                    priorityQueue.enqueue(task);
                }
                
                catch (FullQueueException e)
                {
                 System.out.println("Full queue");
                 return;
                }
            }
            
            try
            {
                Task highestPriorityTask = priorityQueue.peek();
                
                if(highestPriorityTask.missedDeadline(i))
                {
                    System.out.println("Deadline missed at timestep " +
                    i);
                    return;
                }
            }
            
            catch (EmptyQueueException e)
            {
            	System.out.println("Empty queue");
            	return;
            }
            
        }
        
        System.out.println("Scheduling complete after "
        + deadline + " timesteps.");
        
    }
    
    private static int lcm (int a, int b)
    {
        return (a * b) / gcd(a, b);
    }
    

    private static int gcd(int a, int b)
    {
        if(a < 0 || b < 0)
        {
            throw new IllegalArgumentException();
        }
        
        if(b == 0)
        {
            return a;
        }
        
        return gcd(b, a % b);
    }
    private static void printPrereqs()
    {
    	System.out.println("Incorrect configuration file format");
    	return;
    }
}

