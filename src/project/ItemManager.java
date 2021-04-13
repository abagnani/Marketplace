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
	
	public int getNumberOfItems() {
		return this.items.size();
	}
	
	public String listItemManager() {
		String itemList = "";
		for (int i =0; i < items.size(); i++) {
			if (i ==0) {
				itemList = items.get(i).getName();
			}
			else {
				itemList = itemList + ", " + items.get(i).getName();
			}
		}
		return itemList;
	}
	
}
