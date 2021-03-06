package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import project.Clothing;
import project.Food;
import project.IDManager;
import project.Seller;

class IDManagerTests {

	@Test
	void testAddNewuser() {
		Seller itemManagerForTest = new Seller("UniqueID","908-405-5822");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		itemManagerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		itemManagerForTest.addItem(itemForTest2);
		IDManager accountsManager = new IDManager();
		accountsManager.addNewUser(itemManagerForTest);
		Seller managerFromIDManager = accountsManager.getUserFromID("UniqueID");
		assertTrue(managerFromIDManager.equals(itemManagerForTest));
	}
	
	@Test
	void testCheckUserUnique() {
		Seller itemManagerForTest = new Seller("UniqueID","908-405-5822");
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
		Seller itemManagerBob = new Seller("Bob","908-405-5822");
		Seller itemManagerJoe = new Seller("Joe","908-405-5822");
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
