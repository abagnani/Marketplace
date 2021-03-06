package project;


import java.util.Scanner;
import java.util.Set;

public class Menu {
	private Scanner keyboardIn;
	private IDManager accountsManager;
	private buyerManager buyerManager;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
		accountsManager = new IDManager();
		buyerManager = new buyerManager();
	}
	
	public static void main(String[] args) {
		Menu marketplaceMenu = new Menu();
		marketplaceMenu.runMenu();
	}

	private void runMenu() {
		System.out.println("Welcome to Marketplace!");
		this.displayMainMenu();
		int selectedOption = this.getUserInput();
		while (selectedOption >= 4 || selectedOption < 1) {
			//Invalid Option; display choices again
			this.displayMainMenu();
			selectedOption = this.getUserInput();
		}
		this.processMainMenu(selectedOption);
	}

	private void processMainMenu(int selectedOption) {
		while (selectedOption == 1 || selectedOption ==  2) {
			if (selectedOption == 1) {
				Seller seller = processSellerID();
				this.displaySellerMenu(seller.getID());
				int sellerOption = this.getUserInput();
				while (sellerOption >= 5 || sellerOption < 1) {
					//Invalid Option; display choices again
					this.displaySellerMenu(seller.getID());
					sellerOption = this.getUserInput();
				}
				this.processSellerMenu(sellerOption, seller);
			} if (selectedOption == 2) {
				//Create our buyer
				Buyer buyer = processBuyerID();
				this.displayBuyerMenu(buyer.getID());
				int buyerOption = this.getUserInput();
				while (buyerOption >= 4 || buyerOption < 1) {
					//Invalid Option; display choices again
					this.displayBuyerMenu(buyer.getID());
					buyerOption = this.getUserInput();
				}
				this.processBuyerMenu(buyerOption, buyer);
			}
			this.displayMainMenu();
			selectedOption = this.getUserInput();
		}
		// Input a 3, exit
		System.out.println("Bye!");
		this.keyboardIn.close();
		return;
	}

	private Buyer processBuyerID() {
		System.out.println("What is your buyer ID?");
		String buyerID =keyboardIn.next();
		boolean isUniqueID = this.buyerManager.checkUserUnique(buyerID); //Will return true if unique
		if (isUniqueID == false) {
			System.out.println("Welcome, existing buyer");
			return this.buyerManager.getUserFromID(buyerID);
		} else {
			System.out.println("New buyer created");
			Buyer newBuyer = new Buyer(buyerID);
			this.buyerManager.addNewUser(newBuyer);
			return this.buyerManager.getUserFromID(buyerID);
		}
	}

	private Seller processSellerID() {
		System.out.println("What is your seller ID?");
		String sellerID =keyboardIn.next();
		boolean isUniqueID = this.accountsManager.checkUserUnique(sellerID); //Will return true if unique
		if (isUniqueID == false) {
			//System.out.println("Viewing postings by existing user: " + sellerID );
			System.out.println("Welcome, existing seller");
			return this.accountsManager.getUserFromID(sellerID);
		} else {
			System.out.println("New seller created");
			createNewSeller(sellerID);
			return this.accountsManager.getUserFromID(sellerID);
		}
	}

	private void createNewSeller(String sellerID) {
		System.out.println("Please provide a contact email or phone number to be used by buyers.");
		String sellerContactInfo = keyboardIn.next();;
		Seller newSeller = new Seller(sellerID, sellerContactInfo);
		this.accountsManager.addNewUser(newSeller);
	}

	private void processBuyerMenu(int buyerOption, Buyer buyer) {
		while (buyerOption == 1 || buyerOption == 2) {
			if (buyerOption == 1) {	//View items
				displayBuyerViewingOptionsMenu();
				int buyerViewingOption = this.getUserInput();
				while (buyerViewingOption >= 3 || buyerViewingOption < 1) {
					//Invalid Option; display choices again
					this.displayBuyerViewingOptionsMenu();
					buyerViewingOption = this.getUserInput();
				}
				processBuyerViewingOption(buyerViewingOption, buyer.getID());
			}
			else if (buyerOption == 2){	//Favorite items
				System.out.println("Favorited items!");
				System.out.println(buyer.listFavoriteItems());
			}
			this.displayBuyerMenu(buyer.getID());
			buyerOption = this.getUserInput();
		}
			//Exit
//			this.runMenu();
		return;
	}

	private void processBuyerViewingOption(int buyerViewingOption, String buyerID) {
		if (buyerViewingOption == 1) {
			//View by category
			displayCategoryOptions();
			int categoryOption = this.getUserInput();
			while (categoryOption >= 5 || categoryOption < 1) {
				//Invalid Option; display choices again
				this.displayCategoryOptions();
				categoryOption = this.getUserInput();
			}
			processCategoryOption(categoryOption);
			buyerItemSelection(buyerID);
		}
		
		else if (buyerViewingOption == 2) {
			//View all items
			System.out.println("List of all items for sale!");
			this.displayAllItems();
			buyerItemSelection(buyerID);
			
		}
	}

	private void buyerItemSelection(String buyerID) {
		Seller sellerOfInterest = getSellerOfInterest();
		if (sellerOfInterest == null) {
			return;
		}
		sellerOfInterest.listItemsForSeller();
		int buyerActionOption = getBuyerAction();
		if (buyerActionOption == 0) {
			return;
		}
		else {	//Buyer is interested in an item
			Item itemOfInterest = sellerOfInterest.getItemAt(buyerActionOption-1);
			displayItemInformation(itemOfInterest);
			displayBuyerItemOptions();
			int buyItemChoice = this.getUserInput();
			while (buyItemChoice >= 4 || buyItemChoice < 1) {
				//Invalid Option; display choices again
				this.displayCategoryOptions();
				buyItemChoice = this.getUserInput();
			}
			processBuyItemChoice(buyerID, sellerOfInterest, itemOfInterest, buyItemChoice);
		}
	}

	private void processBuyItemChoice(String buyerID, Seller sellerOfInterest, Item itemOfInterest, int buyItemChoice) {
		if (buyItemChoice == 1 ) {
			System.out.println("Contact info: ");
			System.out.println(sellerOfInterest.contactInfo());
		}
		if (buyItemChoice == 2 ) {
			Buyer interestedBuyer = this.buyerManager.getUserFromID(buyerID);
			interestedBuyer.favorite(itemOfInterest);
		}
		if (buyItemChoice == 3 ) {
			return;
		}
	}

	private void displayBuyerItemOptions() {
		System.out.println("Buyer Options:");
		System.out.println("(1) Contact Seller to purchase this item");
		System.out.println("(2) Favorite this item");
		System.out.println("(3) Back");
	}

	private void displayItemInformation(Item itemOfInterest) {
		System.out.println("Item Name: " + itemOfInterest.getName());
		System.out.println("Item Price: $" + itemOfInterest.getPrice());
		System.out.println("Item Quantity: " + itemOfInterest.getQuantity());
	}

	private int getBuyerAction() {
		System.out.println("Please give the number of an item to checkout or enter '0' to return to previous menu");
		int buyerActionOption = this.getUserInput();
		return buyerActionOption;
	}

	private Seller getSellerOfInterest() {
		System.out.println("Please give the seller ID of an item list to checkout or 'exit' to go back");
		String sellerIDOfInterest=keyboardIn.next();
		Seller sellerOfInterest = null;
		if (sellerIDOfInterest.equals("exit")) {
			return sellerOfInterest;
		}
		sellerOfInterest = accountsManager.getUserFromID(sellerIDOfInterest);
		return sellerOfInterest;
	}

	private void processCategoryOption(int categoryOption) {
		if (categoryOption == 1) {
			//Display only food
			System.out.println("List of food items for sale!");
			this.displayItemsByCategory("Food");
		}
		if (categoryOption == 2) {
			//Display only furniture
			System.out.println("List of furniture items for sale!");
			this.displayItemsByCategory("Furniture");
		}
		if (categoryOption == 3) {
			//Display only electronics
			System.out.println("List of electronic items for sale!");
			this.displayItemsByCategory("Electronics");
		}
		if (categoryOption == 4) {
			//Display only clothing
			System.out.println("List of clothing items for sale!");
			this.displayItemsByCategory("Clothing");
		}
	}

	private void displayCategoryOptions() {
		System.out.println("Please select the category you would like to see:");
		System.out.println("1. Food");
		System.out.println("2. Furniture");
		System.out.println("3. Electronics");
		System.out.println("4. Clothing");
	}

	private void displayBuyerViewingOptionsMenu() {
		System.out.println("1. See items by category");
		System.out.println("2. See all items");
	}

	private void displayAllItems() {
		Set<String> IDs = accountsManager.getIDs();
		if (IDs.size() == 0) {
			System.out.println("No sellers registered!");
		}
		for (String id : IDs) {
			displayItemsForSeller(accountsManager.getUserFromID(id), id);
		}
		
	}
	
	private void displayItemsByCategory(String category) {
		Set<String> IDs = accountsManager.getIDs();
		if (IDs.size() == 0) {
			System.out.println("No sellers registered!");
		}
		for (String id : IDs) {
			displayItemsForSellerByCategory(accountsManager.getUserFromID(id), id, category);
		}
		
	}

	private void displayItemsForSeller(Seller sellerFromID, String id) {
		System.out.println("Items for seller " + id);
		System.out.println(sellerFromID.listItemsForSeller());
	}
	
	private void displayItemsForSellerByCategory(Seller sellerFromID, String id, String category) {
		System.out.println(category + " items for seller " + id);
		System.out.println(sellerFromID.listItemsForSellerByCategory(category));
	}

	private void processSellerMenu(int sellerOption, Seller seller) {
		while (sellerOption>=1 && sellerOption <=3) {
			if (sellerOption == 1) {
				System.out.println("Current postings for seller " + seller.getID() + ":");
				System.out.println(seller.listItemsForSeller());
				//Grab the item manager for the person with that seller ID. List items function
			}
			else if (sellerOption == 2){
				processSellerChangeOption(seller);
			}
			else if (sellerOption == 3){ //Create posting
				displaySellerPostingOptions();
				int postOption = this.getUserInput();
				processSellerPostOption(seller, postOption);
			}
			this.displaySellerMenu(seller.getID());
			sellerOption = this.getUserInput();
		}
		if (sellerOption == 4) {
			//Exit
			return;
		}
	}
	
	private void processSellerChangeOption(Seller seller) {
		if (seller.getNumberOfItems() == 0) {
			System.out.println("You have no items yet!");
			return;
		}
		System.out.println("Would you like to: ");
		System.out.println("1. Change an item");
		System.out.println("2. Remove an item");
		int option =  this.getUserInput();
		if (option == 1) {
			changeItemOption(seller);
		}
		if (option == 2) {
			removeItemOption(seller);
		}
	}

	private void processSellerPostOption(Seller seller, int postOption) {
		while (postOption >= 5 || postOption < 1) {
			//Invalid Option; display choices again
			this.displaySellerPostingOptions();
			postOption = this.getUserInput();
		}
		if (postOption ==1) {
			Food itemToBeAdded = processFoodPosting();
			seller.addItem(itemToBeAdded);
		} else if (postOption ==2 ) {
			Clothing itemToBeAdded = processClothingPosting();
			seller.addItem(itemToBeAdded);
		} else if (postOption ==3) {
			Furniture itemToBeAdded = processFurniturePosting();
			seller.addItem(itemToBeAdded);
		} else {
			Electronics itemToBeAdded = processElectronicsPosting();
			seller.addItem(itemToBeAdded);
		}
	}
	
	private Item processChangedItem(String category, String name, double price, int quantity) {
		Item itemToChange = new Clothing(name, price, quantity);
		if (category == "Food") {
			itemToChange = new Food(name, price, quantity);
		}
		if (category == "Furniture") {
			itemToChange = new Furniture(name, price, quantity);
		}
		if (category == "Electronics") {
			itemToChange = new Electronics(name, price, quantity);
		}
		if (category == "Clothing") {
			itemToChange = new Clothing(name, price, quantity);
		}
		return itemToChange;
	}
	
	private void changeItemOption(Seller seller) {
		System.out.println("Select number of item to edit:");
		System.out.println(seller.listItemsForSeller());
		int itemIndex =  this.getUserInput() - 1;
		while (itemIndex >= seller.getNumberOfItems() || itemIndex < 0) {
			//Invalid Option; display choices again
			System.out.println("Select number of item to edit:");
			System.out.println(seller.listItemsForSeller());
			itemIndex =  this.getUserInput() - 1;
		}
		System.out.println("Change name to:");
		String newName = keyboardIn.next();
		System.out.println("Change price to:");
		double newPrice = keyboardIn.nextDouble();
		System.out.println("Change quantity to:");
		int newQuantity =  this.getUserInput();
		String itemCategory = seller.getItemAt(itemIndex).getCategory();
		Item changedItem = processChangedItem(itemCategory, newName, newPrice, newQuantity);
		seller.editItem(itemIndex, changedItem);
	}
	
	private void removeItemOption(Seller seller) {
		System.out.println("Select number of item to remove:");
		System.out.println(seller.listItemsForSeller());
		int itemIndex =  this.getUserInput() - 1;
		while (itemIndex >= seller.getNumberOfItems() || itemIndex < 0) {
			//Invalid Option; display choices again
			System.out.println("Select number of item to remove:");
			System.out.println(seller.listItemsForSeller());
			itemIndex =  this.getUserInput() - 1;
		}
		Item itemToRemove = seller.getItemAt(itemIndex);
		seller.removeItem(itemToRemove);
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

	private void displayBuyerMenu(String buyerID) {
		System.out.println("Buyer " + buyerID + ", what would you like to do?");
		System.out.println("1. See list of items for sale");
		System.out.println("2. See favorited items");
		System.out.println("3. Back");
	}

	private void displaySellerMenu(String sellerID) {
		System.out.println("Seller " + sellerID + ", what would you like to do?");
		System.out.println("1. View current postings");
		System.out.println("2. Edit current postings");
		System.out.println("3. Create new posting");
		System.out.println("4. Back");
	}
	
	private void displayMainMenu() {
		System.out.println("Please select an option: ");
		System.out.println("1. Enter as a seller");
		System.out.println("2. Enter as a buyer");
		System.out.println("3. Exit Marketplace");
	}
	
	private int getUserInput() {
		return keyboardIn.nextInt();
	}
}
