package Uppgift_4;

public class Consumer extends Thread {

    private volatile DataBuffer<Integer> dataBuffer;
    private Thread tt;
    private int o = 0;

    public Consumer(DataBuffer<Integer> data, Thread thread) {
        dataBuffer = data;
        this.tt = thread;
    }

    public void run() {
        while(tt.isAlive()) {
            if (dataBuffer.isFull()) {
                for (int i = 0; i < dataBuffer.getSize(); i++) {
                    //System.out.println("aaaaaaaaa" + ++o);
                    int a = dataBuffer.dequeue();
                    int s = (a + "").length();
                    System.out.println("\nEmptying queue: " + a + "  " + dataBuffer.getSize() + ( s == 1 ? " ":"") + "  :   " + dataBuffer);
                    try {
                        sleep(300);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                o = 0;
            }
        }
        System.out.println("Consumer exit");
    }


}