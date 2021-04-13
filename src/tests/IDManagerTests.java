package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;

import org.junit.jupiter.api.Test;

import project.Clothing;
import project.Food;
import project.IDManager;
import project.ItemManager;

class IDManagerTests {

	@Test
	void testAddNewuser() {
		ItemManager itemManagerForTest = new ItemManager("UniqueID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		itemManagerForTest.addItem(itemForTest2);
		IDManager accountsManager = new IDManager();
		accountsManager.addNewUser(itemManagerForTest);
		ItemManager managerFromIDManager = accountsManager.getItemManagerFromID("UniqueID");
		assertTrue(managerFromIDManager.equals(itemManagerForTest));
	}
	
	@Test
	void testCheckUserUnique() {
		ItemManager itemManagerForTest = new ItemManager("UniqueID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		itemManagerForTest.addItem(itemForTest2);
		IDManager accountsManager = new IDManager();
		accountsManager.addNewUser(itemManagerForTest);
		boolean isUnique = accountsManager.checkUserUnique("Sophia");
		System.out.println(isUnique);
		boolean isUnique1 = accountsManager.checkUserUnique("UniqueID");
		System.out.println(isUnique1);
		assertTrue(isUnique == true);
		assertTrue(isUnique1 == false);
	}

}
