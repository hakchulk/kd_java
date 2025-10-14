package study05_extends;

public class ElecCar extends Car {
	int battery;

	public ElecCar() {
		// TODO Auto-generated constructor stub
	}

	public ElecCar(int speed, String name, int battery) {
		super(speed, name);
		this.battery = battery; 
		// TODO Auto-generated constructor stub
	}
	
	public void charge(int amount) {
		battery += amount;
	}

	@Override
	public String toString() {
		return "ElecCar [battery=" + battery + ", speed=" + speed + ", name=" + name + "]";
	}

	
}
