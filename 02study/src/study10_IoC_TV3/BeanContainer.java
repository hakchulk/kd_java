package study10_IoC_TV3;

public class BeanContainer {

	public BeanContainer() {
	}

	public Object getBean(String id) {
		
		if (id.equals("lg")) {
			return new LgTV();
		} else if (id.equals("samsung")) {
			return new SamsungTV();
		}
		return null;
	}
}
