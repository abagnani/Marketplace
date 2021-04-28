package project;

import java.util.ArrayList;

public class Seller {

	private ArrayList<Item> items;
	private String ID;
	private String contactInfo;
	
	public Seller(String sellerID, String contactInfo) {
		this.ID = sellerID;
		this.items = new ArrayList<Item>();
		this.contactInfo=contactInfo;
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
	
	public String contactInfo() {
		return this.contactInfo;
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
		if (items.size()==0) {
			return "No items posted!";
		}
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
		int listcount=0;
		for (int i =0; i < items.size(); i++) {
			int j=i+1;
			if (!items.get(i).getCategory().equals(category)) {
				continue;
			}
			if (listcount == 0) {
				itemList = "(" + j + ")" + " " + items.get(i).getName();
			}
			else {
				itemList = itemList + ", " + "(" + j + ")" + " " + items.get(i).getName();
			}
			listcount=listcount+1;
		}
		if (listcount==0) {
			return "No "+ category + " items posted!";
		}
		return itemList;
	}
	
	public String getID() {
		return this.ID;
	}
	
	
}
