package project;

import java.util.HashMap;
import java.util.Set;

public class IDManager {
	
	private HashMap<String, Seller> IDManager;
	
	public IDManager() {
		this.IDManager = new HashMap<>();
	}
	
	
	public boolean checkUserUnique(String IDToCheck) {
		return !(this.IDManager.containsKey(IDToCheck));
	}
	
	public void addNewUser(Seller newManagerToAdd) {
		this.IDManager.put(newManagerToAdd.getID(), newManagerToAdd);
	}
	
	public Seller getUserFromID(String IDofUserToGet) {
		return this.IDManager.get(IDofUserToGet);
	}
	
	public Set<String> getIDs() {
		return IDManager.keySet();
	}
	

}
