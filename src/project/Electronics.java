package project;

public class Electronics implements Item {
	
	String name;
	double price;
	int quantity;
	
	public Electronics(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
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
	
	public String getCategory() {
        return "Electronics";
    }
}
