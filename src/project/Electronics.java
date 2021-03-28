package project;

public class Electronics implements Item {
	
	String name;
	int quantity;
	double price;
	
	public Electronics(String name, int quantity, double price) {
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	@Override
	public String getName() {
		return this.name;
	}

	@Override
	public double getPrice() {
		return this.price;
	}

	@Override
	public int getQuantity() {
		return this.quantity;
	}
}
