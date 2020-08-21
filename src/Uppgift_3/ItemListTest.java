package Uppgift_3;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ItemListTest {

	private ItemList list_1;
	private ItemList list_2;
	private ItemList list_3;
	private Item item_1;
	private Item item_2;
	private Item item_3;
	private Item item_4;
	
	@Before
	public void setUp() {
		//  new list for every test case
		list_1 = new ItemList();
		list_2 = new ItemList();
		list_3 = new ItemList();
		item_1 = new Item("Klocka", "111111111111");
		item_2 = new Item("Klocka", "111111111112");
		item_3 = new Item("Cyckel", "22222222222221");
		item_4 = new Item("Gaffel", "1234");
		
	}

	@Test
	public void addTest() {

		assertEquals("Checks size before adding", 0, list_1.size());
		list_1.add(item_1);
		list_1.add(item_2);
		list_1.add(item_3);
		
		assertEquals("Add 2 obj test with size()", 3, list_1.size());
		
		list_1.add(item_4, 2);
		assertEquals("Checks with size if obj was added", 4, list_1.size());
		
	}

	@Test
	public void sizeTest() {
		assertEquals("Check that new list has size 0", 0, list_1.size());	
	}
	
	@Test
	public void countObjectsTest() {
		ItemList list_9 = new ItemList();
		list_9.add(item_4, 0);
		list_9.add(item_4, 1);
		list_9.add(item_2, 2);
		list_9.add(item_4, 3);
		list_9.add(item_3, 4);

		assertEquals("Checks if the method counts reaccuring obj", 3, list_9.countObjects("Gaffel"));
		System.out.println("x");
		assertEquals("Checks if the method returns 0 when given a non existing element", 0, list_2.countObjects("Simon"));
		assertEquals("Check if the method counts a singel obj once", 1, list_9.countObjects("Cyckel"));
	}
	
	@Test
	public void findTest() {
		list_3.add(item_4);
		assertFalse("Checks if find() returns false given non existing", list_3.find("000000000000000"));
		assertTrue("Checks if find() retruns true given existing id", list_3.find("1234"));
	}
	 
	@Test
	public void isEmptyTest() {
		list_1 = new ItemList();
		assertTrue("Check if new list is empty", list_1.isEmpty());
		list_1.add(item_1);
		assertFalse("Check if new list is not empty", list_1.isEmpty());
	}
	
	@Test
	public void removeTest() {
		list_1.add(item_1);
		list_1.add(item_2);
		list_1.add(item_3);
		list_1.add(item_4);
		
		list_1.remove("111111111111");
		list_2.remove("111111111112");

		assertTrue("Check if removed", list_1.find("111111111111"));
		assertFalse("Check if removed", list_1.find("09876543212345678"));
	}
}
