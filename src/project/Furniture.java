package project;

public class Furniture implements Item {
	
	String name;
	double price;
	int quantity;
	
	public Furniture(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public String getName() {
		return this.name;
	}

	public double getPrice() {
		return this.price;
	}

	public int getQuantity() {
		return this.quantity;
	}
	
	public String getCategory() {
        return "Furniture";
    }

}
