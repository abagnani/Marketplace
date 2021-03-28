package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.Clothing;
import project.ItemManager;

class itemManagerTests {

	@Test
	void testAddItemToManager() {
		ItemManager itemManagerForTest = new ItemManager();
		Clothing itemForTest = new Clothing("Shoes", 19.99, 3);
		assertTrue(itemManagerForTest.getNumberOfItems() == 0);
		itemManagerForTest.addItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 1);	
	}
	
	@Test
	void testRemoveItemToManager() {
		ItemManager itemManagerForTest = new ItemManager();
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 1);
		itemManagerForTest.removeItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 0);	
	}

}
