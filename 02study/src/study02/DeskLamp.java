package study02;

public class DeskLamp {
	private boolean isOn;
	String color;
	
	public void turnOn() {
		isOn = true;	
	}
	
	public void turnOff() {
		isOn = false;
	}

	@Override
	public String toString() {
		return "DeskLamp [isOn=" + isOn + ", color=" + color + "]";
	}

	
}
