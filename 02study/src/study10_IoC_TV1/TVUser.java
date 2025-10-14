package study10_IoC_TV1;

public class TVUser {

	public TVUser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		SamsungTV tv = new SamsungTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
