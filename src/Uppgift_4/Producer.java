package Uppgift_4;

import java.util.Random;

public class Producer extends Thread {
    private volatile DataBuffer<Integer> dataBuffer;
    private int count = 0;
    private Random gen = new Random();
    private int nTimes;

    public Producer(DataBuffer<Integer> data, int n) {
        dataBuffer = data;
        this.nTimes = n;
    }

    public void run() {
        while(count < nTimes){
            DataBuffer<Integer> bb = dataBuffer;
            dataBuffer.enqueue(count);
            int i = gen.nextInt(10) * 100;
            System.out.println("Size of buffer: " + dataBuffer.getSize() + "      :   " + bb + "      Sleep: " + i + "    "+count);
            count++;
            try {
                sleep(i);
            } catch( InterruptedException e){ e.printStackTrace(); }
        }
        System.out.println("Producer exit");
    }

}


