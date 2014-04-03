///////////////////////////////////////////////////////////////////////////////
//                   ALL STUDENTS COMPLETE THESE SECTIONS
// Main Class File:  RealTimeScheduler.java
// File:             ConfigReader.java
// Semester:         CS367 Spring 2014
//
// Author:           Alejandro Puente
// Email:            apuente@wisc.edu
// CS Login:         alejandr
// Lecturer's Name:  Jim Skrentny
// Lab Section:      Lecture 1
//////////////////////////// 80 columns wide //////////////////////////////////

import java.io.*;
import java.util.*;

/**
* This class is used to read in a configuration file with process information
*/
public class ConfigReader
{
	//Variable that holds the configuration file
    private File configFile;
    //Variable that holds all the processes
    private ArrayList<Process> processes;
  //Variable that holds the priority queue capacity
    private int priorityQueueCap;
    //Variable that holds the max compute time
    private int maxTime;
    //Variable that holds the circular queue capacity
    private int circularQueueCap;
    
/**
* Constructor of the configuration file
*/
    public ConfigReader(String configFile) throws IncorrectConfigFormatException
    {
        this.configFile = new File(configFile);
        processes = new ArrayList<Process>();
        
        try
        {
        	//A list of the lines in the file
        	ArrayList<String> fileLines = scanFile();
            
            if(fileLines.size() < 3)
            {
            	throw new IncorrectConfigFormatException();
            }
            
            maxTime = Integer.parseInt(fileLines.get(0));
            circularQueueCap = Integer.parseInt(fileLines.get(1));
            priorityQueueCap = Integer.parseInt(fileLines.get(2));
            
            for(int i = 3; i < fileLines.size(); i++)
            {
                String[] processData = fileLines.get(i).split(" ");
                
                if(processData.length != 2)
                {
                	throw new IncorrectConfigFormatException();
                }
                
                int period = Integer.parseInt(processData[0]);
                int time = Integer.parseInt(processData[1]);
                
                Process newProcess = new Process(period, time);
                processes.add(newProcess);
            }
        }
        catch(NumberFormatException e)
        {
        	throw new IncorrectConfigFormatException();
        }
        catch(FileNotFoundException e)
        {
        	throw new IncorrectConfigFormatException();
        }
    }
/**
* Gets the capacity of the circular queue.
* @return the capacity
*/
    public int getCircularQueueCap()
    {
    	return circularQueueCap;
    }
/**
* Gets the max time from the config file.
* @return the max time
*/
    public int getMaxTime()
    {
        return maxTime;
    }
    
/**
* Gets the capacity of the priority queue.
* @return the capacity
*/
    public int getPriorityQueueCap()
    {
        return priorityQueueCap;
    }
    
/**
* Gets all processes given in the config file
* @return the processes
*/
    public ArrayList<Process> getProcesses()
    {
        return processes;
    }

/**
* Scans through the file
* @return the lines in the file
*/
    public ArrayList<String> scanFile() throws FileNotFoundException
    {
        ArrayList<String> lines = new ArrayList<String>();
        
        Scanner input = new Scanner(configFile);
        
        while(input.hasNextLine())
            lines.add(input.nextLine());
        
        input.close();
        
        return lines;
    }
}