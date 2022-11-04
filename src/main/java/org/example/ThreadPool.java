package org.example;

    public interface ThreadPool {
        void run(Runnable runnable);
        void terminate(boolean waitPendingTasks);
        static ThreadPool createThreadPool(int threadCount) {
           return..
        }
    }

