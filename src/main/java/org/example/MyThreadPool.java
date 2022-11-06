package org.example;

import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyThreadPool {

    public MyThreadPool(int noOfThreads, int maxNoOfTasks, BlockingQueue taskQueue, List<PoolThreadRunnable> runnables){
        taskQueue = new ArrayBlockingQueue(maxNoOfTasks);

        for(int i=0; i<noOfThreads; i++){
            PoolThreadRunnable poolThreadRunnable =
                    new PoolThreadRunnable(taskQueue);

            runnables.add(new PoolThreadRunnable(taskQueue));
        }
        for(PoolThreadRunnable runnable : runnables){
            new Thread(runnable).start();
        }
    }

    public MyThreadPool(int threadCount, int maxNoOfTasks, Object taskQueue, Object runnables) {
    }
}