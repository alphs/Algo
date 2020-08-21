package Uppgift_4;

import java.io.*;

public class DataBuffer<E> extends ArrayQueue<E> {
    private int capacity;
    private String string = "";
    private String sto = "";

    public DataBuffer(int c) {
        super(c);
        this.capacity = c;
    }

    public boolean isFull(){
        return getSize() == capacity;
    }

    private void writeFile(int x, String name) {
        try {
            DataOutputStream stream = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(name)));
            System.out.println(this + " :writefile  " + x);
            string += x + " ";
            stream.writeBytes(string);
            stream.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void enqueue(E x) {
        if (isFull()) {
            System.out.println("enqueue 1 " + this);
            writeFile((int) x, "tempDataBuffer.txt");
            return;
        }
        back = increment(back);
        theArray[back] = x;
        currentSize++;
    }


    @Override
    public E dequeue() {
        E returnValue = theArray[front];
        if(isEmpty()) {
            throw new UnderflowException( "Uppgift_4.ArrayQueue dequeue" );
        }
        writeFile((int) returnValue, "resultDataBuffer.txt");
        currentSize--;
        front = increment(front);

        return returnValue;
    }

}
