package study02;

public class CircleTest {
	public static void main(String[] args) {	
		Circle obj = new Circle();
		obj.radius = 100;

		double area = obj.getArea();
		System.out.println(area);
	}
}
