package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public interface ThreadPool {
    public BlockingQueue taskQueue = null;
    public List<PoolThreadRunnable> runnables = new ArrayList<>();
    public boolean isStopped = false;
    void run(Runnable runnable) throws Exception;
    void terminate(boolean waitPendingTasks);
    static ThreadPool createThreadPool(int threadCount) {
        return (ThreadPool) new MyThreadPool(threadCount, 5,taskQueue,runnables, isStopped);

    }


}




