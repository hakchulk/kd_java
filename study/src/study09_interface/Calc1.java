package study09_interface;

public class Calc1 implements Calc {

	@Override
	public String getString()
	{
		return "calc1";
	}
	
	public static void main(String[] args) {
		Calc c = new Calc1();
		
	}
	
}
