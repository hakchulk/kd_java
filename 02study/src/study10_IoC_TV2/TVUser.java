package study10_IoC_TV2;

public class TVUser {

	public TVUser() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		TV tv = new LgTV();
		tv.powerOn();
		tv.volumeUp();
		tv.volumeDown();
		tv.powerOff();

	}

}
