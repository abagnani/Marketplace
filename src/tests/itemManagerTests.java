package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.Clothing;
import project.Electronics;
import project.Food;
import project.Furniture;
import project.ItemManager;

class itemManagerTests {

	@Test
	void testAddItemToManager() {
		ItemManager itemManagerForTest = new ItemManager("ID");
		Clothing itemForTest = new Clothing("Shoes", 19.99, 3);
		assertTrue(itemManagerForTest.getNumberOfItems() == 0);
		itemManagerForTest.addItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 1);	
	}
	
	@Test
	void testRemoveItemToManager() {
		ItemManager itemManagerForTest = new ItemManager("ID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 1);
		itemManagerForTest.removeItem(itemForTest);
		assertTrue(itemManagerForTest.getNumberOfItems() == 0);	
	}
	
	@Test
	void testListItemManager() {
		ItemManager itemManagerForTest = new ItemManager("ID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		itemManagerForTest.addItem(itemForTest2);
		Furniture itemForTest3 = new Furniture("Chair", 10.00, 2);
		itemManagerForTest.addItem(itemForTest3);
		Electronics itemForTest4 = new Electronics("Airpods", 200.00, 1);
		itemManagerForTest.addItem(itemForTest4);
		String functionOutputList = itemManagerForTest.listItemManager();
		String expectedList = "Dress, Peach, Chair, Airpods";
		assertTrue( expectedList.equals(functionOutputList));
	}
	
	

}
