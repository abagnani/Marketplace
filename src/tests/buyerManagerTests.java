package tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;

import project.Buyer;
import project.Clothing;
import project.Food;
import project.buyerManager;

class buyerManagerTests {

	@Test
	void testAddNewuser() {
		Buyer buyerForTest = new Buyer("UniqueID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		buyerForTest.favorite(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		buyerForTest.favorite(itemForTest2);
		buyerManager buyerManager = new buyerManager();
		buyerManager.addNewUser(buyerForTest);
		Buyer buyerFromIDManager = buyerManager.getUserFromID("UniqueID");
		assertTrue(buyerFromIDManager.equals(buyerForTest));
	}
	
	@Test
	void testCheckUserUnique() {
		Buyer buyerForTest = new Buyer("UniqueID");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		buyerForTest.favorite(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		buyerForTest.favorite(itemForTest2);
		buyerManager buyerManager = new buyerManager();
		buyerManager.addNewUser(buyerForTest);
		boolean isUnique = buyerManager.checkUserUnique("Sophia");
		boolean isUnique1 = buyerManager.checkUserUnique("UniqueID");
		assertTrue(isUnique == true);
		assertTrue(isUnique1 == false);
	}
	
	@Test
	void testGetIDs() {
		Buyer buyerBob = new Buyer("Bob");
		Buyer buyerJoe = new Buyer("Joe");
		buyerManager buyerManager = new buyerManager();
		buyerManager.addNewUser(buyerBob);
		buyerManager.addNewUser(buyerJoe);
		
		Set<String> IDs = buyerManager.getIDs();
		Set<String> correctSet = new HashSet<String>();
		correctSet.add("Bob");
		correctSet.add("Joe");
		assertEquals(IDs, correctSet);
	}
}
