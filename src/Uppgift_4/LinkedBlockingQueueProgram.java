package Uppgift_4;



import java.util.concurrent.LinkedBlockingQueue;

public class LinkedBlockingQueueProgram {

    private static LinkedBlockingQueue<String> lbq = new LinkedBlockingQueue<String>();

    //Producer class that will item in LinkedBlockingQueue object
    class Producer implements Runnable {
        @Override public void run() {
            try {
                int i = 1;
                while(i <= 50){

                    //add item
                    lbq.put("A" + i);
                    System.out.println("A"+i+" added.  Queues size is " + lbq.size() );
                    i++;
                    Thread.sleep(500);
                } // while end

            } // try end

            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    class Consumer implements Runnable {
        @Override public void run() {
            try {
                int i = 1;
                while(i <= 50){
                    //removes the item
                    String s=lbq.take();

                    System.out.println(s + " removed. Queues size is " + lbq.size());
                    i++;
                    Thread.sleep(1000);
                }
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    //main method to start thread
    public static void main(String... args) {

        new Thread(new LinkedBlockingQueueProgram().new Producer()).start();
        new Thread(new LinkedBlockingQueueProgram().new Consumer()).start();
    }
}