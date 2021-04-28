package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import project.Clothing;
import project.Electronics;
import project.Food;
import project.Furniture;
import project.Seller;

class SellerTests {

	@Test
	void testAddItemToSeller() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemForTest = new Clothing("Shoes", 19.99, 3);
		assertTrue(sellerForTest.getNumberOfItems() == 0);
		sellerForTest.addItem(itemForTest);
		assertTrue(sellerForTest.getNumberOfItems() == 1);	
	}
	
	@Test
	void testRemoveItemToSeller() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		sellerForTest.addItem(itemForTest);
		assertTrue(sellerForTest.getNumberOfItems() == 1);
		sellerForTest.removeItem(itemForTest);
		assertTrue(sellerForTest.getNumberOfItems() == 0);	
	}
	
	@Test
	void testEditItemToSeller() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemToChange = new Clothing("Dress", 15.99, 2);
		sellerForTest.addItem(itemToChange);
		int indexToChange = 0;
		Clothing itemWithChanges = new Clothing("Dress", 9.99, 2);
		sellerForTest.editItem(indexToChange, itemWithChanges);
		assertTrue(sellerForTest.getNumberOfItems() == 1);
		sellerForTest.removeItem(itemWithChanges);
		assertTrue(sellerForTest.getNumberOfItems() == 0);	
	}
	
	@Test
	void testListItemSeller() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		sellerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		sellerForTest.addItem(itemForTest2);
		Furniture itemForTest3 = new Furniture("Chair", 10.00, 2);
		sellerForTest.addItem(itemForTest3);
		Electronics itemForTest4 = new Electronics("Airpods", 200.00, 1);
		sellerForTest.addItem(itemForTest4);
		String functionOutputList = sellerForTest.listItemsForSeller();
		String expectedList = "(1) Dress, (2) Peach, (3) Chair, (4) Airpods";
		assertTrue( expectedList.equals(functionOutputList));
	}
	
	@Test
	void testlistItemsForSellerByCategory() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		Clothing itemForTest = new Clothing("Dress", 39.99, 1);
		sellerForTest.addItem(itemForTest);
		Food itemForTest2 = new Food("Peach", 5.00, 1);
		sellerForTest.addItem(itemForTest2);
		Furniture itemForTest3 = new Furniture("Chair", 10.00, 2);
		sellerForTest.addItem(itemForTest3);
		Electronics itemForTest4 = new Electronics("Airpods", 200.00, 1);
		sellerForTest.addItem(itemForTest4);
		String functionOutputListClothing = sellerForTest.listItemsForSellerByCategory("Clothing");
		String expectedListClothing = "(1) Dress";
		assertTrue( functionOutputListClothing.equals(expectedListClothing));
		String functionOutputListElectronics = sellerForTest.listItemsForSellerByCategory("Electronics");
		String expectedListElectronics = "(4) Airpods";
		assertTrue( expectedListElectronics.equals(functionOutputListElectronics));
		String functionOutputListFood = sellerForTest.listItemsForSellerByCategory("Food");
		String expectedListFood = "(2) Peach";
		assertTrue( expectedListFood.equals(functionOutputListFood));
		String functionOutputListFurniture = sellerForTest.listItemsForSellerByCategory("Furniture");
		String expectedListFurniture = "(3) Chair";
		assertTrue( expectedListFurniture.equals(functionOutputListFurniture));
	}
	
	@Test
	void testListItemSellerEmpty() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		String functionOutputList = sellerForTest.listItemsForSeller();
		String expectedList = "No items posted!";
		assertTrue( expectedList.equals(functionOutputList));
	}
	
	@Test
	void testlistItemsForSellerByCategoryEmpty() {
		Seller sellerForTest = new Seller("ID","908-405-5822");
		String functionOutputListClothing = sellerForTest.listItemsForSellerByCategory("Clothing");
		String expectedListClothing = "No Clothing items posted!";
		assertTrue( functionOutputListClothing.equals(expectedListClothing));
		String functionOutputListElectronics = sellerForTest.listItemsForSellerByCategory("Electronics");
		String expectedListElectronics = "No Electronics items posted!";
		assertTrue( expectedListElectronics.equals(functionOutputListElectronics));
		String functionOutputListFood = sellerForTest.listItemsForSellerByCategory("Food");
		String expectedListFood = "No Food items posted!";
		assertTrue( expectedListFood.equals(functionOutputListFood));
		String functionOutputListFurniture = sellerForTest.listItemsForSellerByCategory("Furniture");
		String expectedListFurniture = "No Furniture items posted!";
		assertTrue( expectedListFurniture.equals(functionOutputListFurniture));
	}
	
	

}
