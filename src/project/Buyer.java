package project;

import java.util.ArrayList;

public class Buyer {
	
	private String ID;
	private ArrayList<Item> favorites;
	
	public Buyer(String IDtoSet) {
		this.ID = IDtoSet;
		favorites = new ArrayList<Item>();
	}
	
	public String listFavoriteItems() {
		String favoriteItemList = "";
		for (int i =0; i < favorites.size(); i++) {
			if (i ==0) {
				int j = i+1;
				favoriteItemList = "(" + j + ")" + " " + favorites.get(i).getName();
			}
			else {
				int j = i+1;
				favoriteItemList = favoriteItemList + ", " + "(" + j + ")" + " " + favorites.get(i).getName();
			}
		}
		return favoriteItemList;
	}
	
	public void favorite(Item itemToFavorite) {
		favorites.add(itemToFavorite);
	}

	public Item getFavoriteItem(int indexOfFavoritedItem) {
		return favorites.get(indexOfFavoritedItem);
	}
	
	public String getID() {
		return this.ID;
	}
}
