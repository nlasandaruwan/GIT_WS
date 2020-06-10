package lambda.custom;

public class Car {

	private String brand;
	private long price;

	public Car() {
	}

	public Car(String brand, long price) {
		this.brand = brand;
		this.price = price;

	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public long getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}
}
