package project;

import java.util.HashMap;
import java.util.Set;

public class IDManager {
	
	private HashMap<String, ItemManager> IDManager;
	
	public IDManager() {
		this.IDManager = new HashMap<>();
	}
	
	
	public boolean checkUserUnique(String IDToCheck) {
		return !(this.IDManager.containsKey(IDToCheck));
	}
	
	public void addNewUser(ItemManager newManagerToAdd) {
		this.IDManager.put(newManagerToAdd.getID(), newManagerToAdd);
	}
	
	public ItemManager getItemManagerFromID(String IDofManagerToGet) {
		return this.IDManager.get(IDofManagerToGet);
	}
	
	public Set<String> getIDs() {
		return IDManager.keySet();
	}
	

}
