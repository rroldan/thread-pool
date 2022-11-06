package org.example;

public class ThreadPoolMain {
    public static void main(String[] args) throws Exception {

        ThreadPool threadPool = ThreadPool.createThreadPool(3);

        for(int i=0; i<10; i++) {

            int taskNo = i;
            threadPool.run( () -> {
                String message =
                        Thread.currentThread().getName()
                                + ": Task " + taskNo ;
                System.out.println(message);
            });
        }

        threadPool.terminate(true);
        threadPool.terminate(false);

    }
}
