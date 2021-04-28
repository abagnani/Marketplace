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
		Seller sellerForTest = new Seller("Bob","908-405-5822");
		Clothing shoesForTest = new Clothing("Shoes", 19.99, 3);
		sellerForTest.addItem(shoesForTest);
		
		Buyer buyerForTest = new Buyer("Joe");
		buyerForTest.favorite(sellerForTest.getItemAt(0));
		assertEquals(buyerForTest.getFavoriteItem(0), shoesForTest);
	}
	
	@Test
	void testFavoritedItemList() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		sellerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		sellerForTest.addItem(itemForTest2);
		Furniture itemForTest3 = new Furniture("Chair", 10.00, 2);
		sellerForTest.addItem(itemForTest3);
		Electronics itemForTest4 = new Electronics("Airpods", 200.00, 1);
		sellerForTest.addItem(itemForTest4);
		
		Buyer buyerForTest = new Buyer("Joe");
		buyerForTest.favorite(sellerForTest.getItemAt(0));
		buyerForTest.favorite(sellerForTest.getItemAt(3));
		
		
		String functionOutputList = buyerForTest.listFavoriteItems();;
		System.out.println(functionOutputList);
		String expectedList = "(1) Dress, (2) Airpods";
		System.out.println(expectedList);

		assertTrue( expectedList.equals(functionOutputList));
	}
	
	
}
