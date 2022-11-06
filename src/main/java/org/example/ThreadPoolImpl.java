package org.example;

public class ThreadPoolImpl  implements ThreadPool{

    private boolean isStopped = false;

    public void run(Runnable runnable) throws Exception {
        if(this.isStopped) throw
                new IllegalStateException("ThreadPool is stopped");

        this.taskQueue.offer(runnable);
    }


    public void terminate(boolean waitPendingTasks) {
        if (waitPendingTasks) {
            waitUntilAllTasksFinished();
        } else {
            stop();
        }
    }

    private synchronized void stop(){
        this.isStopped = true;
        for(PoolThreadRunnable runnable : runnables){
            runnable.doStop();
        }
    }

    private synchronized void waitUntilAllTasksFinished() {
        while (this.taskQueue.size() > 0) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
