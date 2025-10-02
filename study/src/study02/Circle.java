package study02;

public class Circle {
	int radius;
	String color;

	double getArea() {
		return 3.14 * radius * radius;
	}

	void outCircumference() {
		System.out.println("원의 둘레는" + 2 * radius * 3.14);
	}
}
