package study07_arraylist;

public class Menu {
	String name;
	int price;

	public Menu(String name, int price) {
		this.name = name;
		this.price = price;
	}

	@Override
	public String toString() {
		return name + " : " + price + "원";
	}

	public void setName(String name) {
		this.name = name;
	}
}
