package tests;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import project.Buyer;
import project.Clothing;
import project.Electronics;
import project.Food;
import project.Furniture;
import project.IDManager;
import project.Item;
import project.Seller;

class BuyerTest {
	@Test
	void favoriteAnItem() {
		Seller sellerForTest = new Seller("Bob");
		Clothing shoesForTest = new Clothing("Shoes", 19.99, 3);
		sellerForTest.addItem(shoesForTest);
		
		Buyer buyerForTest = new Buyer("Joe");
		buyerForTest.favorite(sellerForTest.getItemAt(0));
		assertEquals(buyerForTest.getFavoriteItem(0), shoesForTest);
	}
	
	void printFavorites() {
		
	}
	
	
}
