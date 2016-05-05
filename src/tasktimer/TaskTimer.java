package tasktimer;

import static java.lang.System.out;

import java.util.Scanner;
import java.io.*;
import java.util.function.IntConsumer;
import java.util.function.Consumer;
import java.util.concurrent.atomic.*;  // hack, using AtomicInteger as accumulator

/**
 * Time how long it takes to perform some tasks
 * using different programming constructs.
 * 
 * TODO Improve this code by restructuring it to eliminate duplicate code.
 */
public class TaskTimer
{
    public static void execAndPrint( Runnable task ) {
    	StopWatch watch = new StopWatch();
    	
    	//print description of task using toString
    	System.out.println( task.toString() );
    	
    	//compute start time
    	watch.start();
    	
    	//run the task
    	task.run();
    	
    	//compute stop time
    	watch.stop();
    	
    	//print elasped time
    	System.out.printf("Elapsed time is %f sec\n",watch.getElaspsed()*1.0E-9 );
    	
    	
    	
    }
        
    /** Run all the tasks. */
    public static void main(String [] args) {
    	
    	Runnable[] run = { new Task1(), new Task2(), new Task3(), new Task4(), new Task5(), new Task6() };
    	for ( Runnable r : run ) {
    		execAndPrint( r );
    	}
    	
    }
}
