package study06_join;

public class StudentMember extends Member {
	String school;
	public StudentMember(String name, int age, String school) {
		super(name,age);
		this.school = school;
	}

	public void study() {
		System.out.println(name + "학생, 공부합니다.");
	}
	
	@Override 
	public void join() {
		System.out.println(name + "학생, 회원 가입이 완료되었습니다." + " school:" + school);
	}		
}
