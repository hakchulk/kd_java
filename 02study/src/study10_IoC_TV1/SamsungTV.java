package study10_IoC_TV1;

public class SamsungTV {

	public SamsungTV() {
		System.out.println("SamsungTV 생성");
	}

	public void powerOn()
	{
		System.out.println("SamsungTV powerOn");		
	}	
	public void powerOff()
	{
		System.out.println("SamsungTV powerOff");		
	}
	public void volumeUp()
	{
		System.out.println("SamsungTV volumeUp");		
	}	
	public void volumeDown()
	{
		System.out.println("SamsungTV volumeDown");		
	}
}
