package project;

import java.util.Scanner;

public class Menu {
	public static void main(String[] args) {
		System.out.println("Welcome to Marketplace!");
		System.out.println("Please select an option:: ");
		
		System.out.println("1. Enter as a seller");
		System.out.println("2. Enter as a buyer");
		
		Scanner keyboardIn = new Scanner(System.in);
		int selectedOption = keyboardIn.nextInt();
		
		if (selectedOption == 1) {
			System.out.println("1. View current postings");
			System.out.println("2. Edit current postings");
			System.out.println("3. Create new posting");
			int sellerOption = keyboardIn.nextInt();
		} else {
			System.out.println("1. See list of items for sale");
			System.out.println("2. See favorited items");
			int buyerOption = keyboardIn.nextInt();
		}
	}
}
