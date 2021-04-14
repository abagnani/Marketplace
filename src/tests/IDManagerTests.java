package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

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
	
	@Test
	void testGetIDs() {
		ItemManager itemManagerBob = new ItemManager("Bob");
		ItemManager itemManagerJoe = new ItemManager("Joe");
		IDManager accountsManager = new IDManager();
		accountsManager.addNewUser(itemManagerBob);
		accountsManager.addNewUser(itemManagerJoe);
		
		Set<String> IDs = accountsManager.getIDs();
		Set<String> correctSet = new HashSet<String>();
		correctSet.add("Bob");
		correctSet.add("Joe");
		assertEquals(IDs, correctSet);
	}

}
