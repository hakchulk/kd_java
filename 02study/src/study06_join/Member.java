package study06_join;

public class Member {
	String name;
	int age;
	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return "Member [name=" + name + ", age=" + age + "]";
	}
	
	public void showInfo() {
		System.out.println(toString());
	}
	
	public void join() {
		System.out.println(name + "님, 회원 가입이 완료되었습니다.");
	}
}
