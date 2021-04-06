package project;

import java.util.Scanner;

public class Menu {
	private Scanner keyboardIn;
	
	public Menu() {
		keyboardIn = new Scanner(System.in);
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
			this.displaySellerMenu();
			int sellerOption = this.getUserInput();
			while (sellerOption >= 5 || sellerOption < 1) {
				//Invalid Option; display choices again
				this.displaySellerMenu();
				sellerOption = this.getUserInput();
			}
			this.processSellerMenu(sellerOption);
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

	private void processSellerMenu(int sellerOption) {
		if (sellerOption == 1) {
			System.out.println("View current positings!");
		}
		else if (sellerOption == 2){
			System.out.println("Edit current postings!");
		}
		else if (sellerOption == 3){
			System.out.println("Create new posting!");
		}
		else {
			//Exit
			this.runMenu();
		}
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
