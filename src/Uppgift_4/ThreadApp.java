package Uppgift_4;

// Ett program som loppar så länge den andra tråden lever (dvs ingen "stop" har inträffats)
public class ThreadApp {
    public static void main (String[] args) {
        DataBuffer<Integer> db = new DataBuffer<>(5);
        Producer producer = new Producer(db, 50);
        Consumer consumer = new Consumer(db, producer);

        producer.start();
        consumer.start();
    }

}