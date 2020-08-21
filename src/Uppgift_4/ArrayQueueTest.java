package Uppgift_4;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ArrayQueueTest {
	ArrayQueue<Integer> queue_1 = new ArrayQueue<Integer>();
	ArrayQueue<Integer> queue_2 = new ArrayQueue<Integer>();
	ArrayQueue<String> queue_3 = new ArrayQueue<String>();
	int[] test;

	@Before
	public void setUp() {
		queue_1.enqueue(1);
		queue_1.enqueue(2);
		queue_1.enqueue(3);
		queue_1.enqueue(4);

		queue_2 = queue_1.reverse();
		test = new int[] {4, 3, 2, 1};
	}

	@Test
	public void printQueueTest() {
		queue_1.printQueue();
		assertEquals(true, true);
	}

	@Test
	public void reverseTest() {
		int k = 1;
		for(int i = 0; i < 4; i++) {
			if(test[i] == queue_1.dequeue()) {
				k = 0;
			}
		}
		assertEquals("Check if k has been set to 0 (false)", 1, k);
	}
	
	@Test
	public void toStringTest() {
		assertEquals("Check if it works", "[ 1, 2, 3, 4 ]", queue_1.toString());
	}

}	
