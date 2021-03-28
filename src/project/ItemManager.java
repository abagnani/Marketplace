package project;

import java.util.ArrayList;

public class ItemManager {

	private ArrayList<Item> items;
	
	public ItemManager() {
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
	
}
