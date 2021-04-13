package project;

import java.util.ArrayList;

public class ItemManager {

	private ArrayList<Item> items;
	private String ID;
	
	public ItemManager(String ManagerID) {
		this.ID = ManagerID;
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
	
	public String listItemManager() {
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
	
	public String getID() {
		return this.ID;
	}
	
	
}
