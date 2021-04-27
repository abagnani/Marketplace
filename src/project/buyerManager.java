package project;

import java.util.HashMap;
import java.util.Set;

public class buyerManager {
	
	private HashMap<String, Buyer> buyerManager;
	
	public buyerManager() {
		this.buyerManager = new HashMap<>();
	}
	
	public boolean checkUserUnique(String IDToCheck) {
		return !(this.buyerManager.containsKey(IDToCheck));
	}
	
	public void addNewUser(Buyer newBuyerToAdd) {
		this.buyerManager.put(newBuyerToAdd.getID(), newBuyerToAdd);
	}
	
	public Buyer getUserFromID(String IDofUserToGet) {
		return this.buyerManager.get(IDofUserToGet);
	}
	
	public Set<String> getIDs() {
		return buyerManager.keySet();
	}
}
