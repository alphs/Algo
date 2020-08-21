package Uppgift_4;

import java.util.LinkedList;

public class RandomQueue {
	private LinkedList<Object> test;
	private int size;
	private int front;
	private int back;

	public RandomQueue() {
		test = new LinkedList<>();
		front = 0;
		back = -1;
		size = 0;
	}

	public boolean isEmpty() {
		return size == 0; 
	}

	public void enQueue(Object o) {
		test.add(o);
		front++;
		size++;
		back++;
	}

	public Object deQueue() {
		int r = (int)(Math.random()*size);
		front--;
		back--;
		size--;
		return test.remove(r);
	}
	
	public static void main(String[] args) {
		
	}
}
