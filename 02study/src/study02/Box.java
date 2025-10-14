package study02;

public class Box {
	int width;
	int length;
	int height;
	
	double getVolume() {
		return (double)width * length * height;
	}

	@Override
	public String toString() {
		return "Box [width=" + width + ", length=" + length + ", height=" + height + "]";
	}
	
	
}
