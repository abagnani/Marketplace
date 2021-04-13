package project;

import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	private IDManager accountsManager;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		accountsManager = new IDManager();
	}
	
	public static void main(String[] args) {
		Menu marketplaceMenu = new Menu();
		marketplaceMenu.runMenu();
	}

	private void runMenu() {
		this.displayMainMenu();
		int selectedOption = this.getUserInput();
		while (selectedOption >= 3 || selectedOption < 1) {
			//Invalid Option; display choices again
			runMenu();
			selectedOption = this.getUserInput();
		}
		this.processMainMenu(selectedOption);
		this.keyboardIn.close();
	}

	private void processMainMenu(int selectedOption) {
		if (selectedOption == 1) {
			ItemManager sellerItemManager = processSellerID();
			this.displaySellerMenu();
			int sellerOption = this.getUserInput();
			while (sellerOption >= 5 || sellerOption < 1) {
				//Invalid Option; display choices again
				this.displaySellerMenu();
				sellerOption = this.getUserInput();
			}
			this.processSellerMenu(sellerOption, sellerItemManager);
			this.processMainMenu(selectedOption); //Takes you back to seller menu once seller is done
		} else {
			this.displayBuyerMenu();
			int buyerOption = this.getUserInput();
			while (buyerOption >= 4 || buyerOption < 1) {
				//Invalid Option; display choices again
				this.displayBuyerMenu();
				buyerOption = this.getUserInput();
			}
			this.processBuyerMenu(buyerOption);
		}
	}

	private ItemManager processSellerID() {
		System.out.println("What is your seller ID?");
		String sellerID =keyboardIn.next();
		boolean isUniqueID = this.accountsManager.checkUserUnique(sellerID); //Will return true if unique
		if (isUniqueID == false) {
			System.out.println("Viewing postings by existing user: " + sellerID );
			return this.accountsManager.getItemManagerFromID(sellerID);
		} else {
			ItemManager newItemManager = new ItemManager(sellerID);
			System.out.println("Viewing postings by new user: " + sellerID );
			this.accountsManager.addNewUser(newItemManager);
			return this.accountsManager.getItemManagerFromID(sellerID);
		}
	}

	private void processBuyerMenu(int buyerOption) {
		if (buyerOption == 1) {
			System.out.println("List of items for sale!");
		}
		else if (buyerOption == 2){
			System.out.println("Favorited items!");
		}
		else {
			//Exit
			this.runMenu();
		}
	}

	private void processSellerMenu(int sellerOption, ItemManager sellerItemManager) {
		if (sellerOption == 1) {
			System.out.println("View current postings!");
			System.out.println(sellerItemManager.listItemManager());
			//Grab the item manager for the person with that seller ID. List items function
		}
		else if (sellerOption == 2){
			processSellerChangeOption(sellerItemManager);
		}
		else if (sellerOption == 3){ //Create posting
			displaySellerPostingOptions();
			int postOption = this.getUserInput();
			processSellerPostOption(sellerItemManager, postOption);
		}
		else {
			//Exit
			this.runMenu();
		}
	}

	private void processSellerPostOption(ItemManager sellerItemManager, int postOption) {
		while (postOption >= 5 || postOption < 1) {
			//Invalid Option; display choices again
			this.displaySellerPostingOptions();
			postOption = this.getUserInput();
		}
		if (postOption ==1) {
			Food itemToBeAdded = processFoodPosting();
			sellerItemManager.addItem(itemToBeAdded);
		} else if (postOption ==2 ) {
			Clothing itemToBeAdded = processClothingPosting();
			sellerItemManager.addItem(itemToBeAdded);
		} else if (postOption ==3) {
			Furniture itemToBeAdded = processFurniturePosting();
			sellerItemManager.addItem(itemToBeAdded);
		} else {
			Electronics itemToBeAdded = processElectronicsPosting();
			sellerItemManager.addItem(itemToBeAdded);
		}
	}
	
	private void processSellerChangeOption(ItemManager sellerItemManager) {
		System.out.println("Select number of item to edit:");
		System.out.println(sellerItemManager.listItemManager());
		int itemIndex =  this.getUserInput() - 1;
		System.out.println("Change name to:");
		String newName = keyboardIn.next();
		System.out.println("Change price to:");
		double newPrice = keyboardIn.nextDouble();
		System.out.println("Change quantity to:");
		int newQuantity =  this.getUserInput();
		Food changedItem = new Food(newName, newPrice, newQuantity);
		sellerItemManager.editItem(itemIndex, changedItem);
	}

	private Electronics processElectronicsPosting() {
		System.out.println("What is the name of the electronic item?");
		String name = keyboardIn.next();
		System.out.println("What is the price?");
		double price = keyboardIn.nextDouble();
		System.out.println("Quantity?");
		int quantity =  this.getUserInput();
		Electronics itemToBeAdded = new Electronics(name, price, quantity);
		return itemToBeAdded;
	}

	private Furniture processFurniturePosting() {
		System.out.println("What is the name of the furniture item?");
		String name = keyboardIn.next();
		System.out.println("What is the price?");
		double price = keyboardIn.nextDouble();
		System.out.println("Quantity?");
		int quantity =  this.getUserInput();
		Furniture itemToBeAdded = new Furniture(name, price, quantity);
		return itemToBeAdded;
	}

	private Clothing processClothingPosting() {
		System.out.println("What is the name of the clothing item?");
		String name = keyboardIn.next();
		System.out.println("What is the price?");
		double price = keyboardIn.nextDouble();
		System.out.println("Quantity?");
		int quantity =  this.getUserInput();
		Clothing itemToBeAdded = new Clothing(name, price, quantity);
		return itemToBeAdded;
	}

	private Food processFoodPosting() {
		System.out.println("What is the name of the food item?");
		String name = keyboardIn.next();
		System.out.println("What is the price?");
		double price = keyboardIn.nextDouble();
		System.out.println("Quantity?");
		int quantity =  this.getUserInput();
		Food itemToBeAdded = new Food(name, price, quantity);
		return itemToBeAdded;
	}

	private void displaySellerPostingOptions() {
		System.out.println("What would you like to post: ");
		System.out.println("1. Food");
		System.out.println("2. Clothing");
		System.out.println("3. Furniture");
		System.out.println("4. Electronics");
	}

	private void displayBuyerMenu() {
		System.out.println("1. See list of items for sale");
		System.out.println("2. See favorited items");
		System.out.println("3. Back");
	}

	private void displaySellerMenu() {
		System.out.println("1. View current postings");
		System.out.println("2. Edit current postings");
		System.out.println("3. Create new posting");
		System.out.println("4. Back");
	}
	
	private void displayMainMenu() {
		System.out.println("Welcome to Marketplace!");
		System.out.println("Please select an option:: ");
		
		System.out.println("1. Enter as a seller");
		System.out.println("2. Enter as a buyer");
	}
	
	private int getUserInput() {
		return keyboardIn.nextInt();
	}
}
