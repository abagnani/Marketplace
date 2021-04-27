package project;

import java.util.ArrayList;

public class Buyer {
	
	private String ID;
	private ArrayList<Item> favorites;
	
	public Buyer(String IDtoSet) {
		this.ID = IDtoSet;
		favorites = new ArrayList<Item>();
	}
	
	public void favorite(Item itemToFavorite) {
		favorites.add(itemToFavorite);
	}

	public Item getFavoriteItem(int indexOfFavoritedItem) {
		return favorites.get(indexOfFavoritedItem);
	}

}
