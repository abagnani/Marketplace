package project;

import java.util.ArrayList;

public class Seller {

	private ArrayList<Item> items;
	private String ID;
	
	public Seller(String sellerID) {
		this.ID = sellerID;
		this.items = new ArrayList<Item>();
	}
	
	public void addItem(Item addMe) {
		this.items.add(addMe);
	}
	
	public void removeItem(Item removeMe) {
		this.items.remove(removeMe);
	}
	
	public void editItem(int editThisIndexItem, Item changedItem) {
		this.items.set(editThisIndexItem, changedItem);
	}
	
	public int getNumberOfItems() {
		return this.items.size();
	}
	
	/**
	 * Getter for item at a specific index. Implemented so Buyer can access items to favorite one of them
	 * @param indexOfItem index of item to get in Items list
	 * @return item at provided index
	 */
	public Item getItemAt(int indexOfItem) {
		return items.get(indexOfItem);
	}
	
	public String listItemsForSeller() {
		String itemList = "";
		for (int i =0; i < items.size(); i++) {
			if (i ==0) {
				int j = i+1;
				itemList = "(" + j + ")" + " " + items.get(i).getName();
			}
			else {
				int j = i+1;
				itemList = itemList + ", " + "(" + j + ")" + " " + items.get(i).getName();
			}
		}
		return itemList;
	}
	
	public String listItemsForSellerByCategory(String category) {
		String itemList = "";
		int listCount = 0;
		for (int i =0; i < items.size(); i++) {
			if (!items.get(i).getCategory().equals(category)) {
				continue;
			}
			listCount = listCount+1;
			if (listCount == 1) {
				itemList = "(" + listCount + ")" + " " + items.get(i).getName();
			}
			else {
				itemList = itemList + ", " + "(" + listCount + ")" + " " + items.get(i).getName();
			}
		}
		return itemList;
	}
	
	public String getID() {
		return this.ID;
	}
	
	
}
