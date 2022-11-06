package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.function.Consumer;


public interface ThreadPool  {
    public BlockingQueue taskQueue =  new ArrayBlockingQueue(5);
    public List<PoolThreadRunnable> runnables = new ArrayList<>();



    void run(Runnable runnable) throws Exception;
    void terminate(boolean waitPendingTasks);


    static ThreadPool createThreadPool(int threadCount) {
            for (int i = 0; i < threadCount; i++) {
                PoolThreadRunnable poolThreadRunnable =
                        new PoolThreadRunnable(taskQueue);

                runnables.add(new PoolThreadRunnable(taskQueue));
            }
            for (PoolThreadRunnable runnable : runnables) {
                new Thread(runnable).start();
            }
        return new ThreadPoolImpl();
        };
    }







