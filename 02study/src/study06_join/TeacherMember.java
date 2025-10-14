package study06_join;

public class TeacherMember extends Member {
	String subject;
	
	public TeacherMember(String name, int age, String subject) {
		super(name, age);	
		this.subject = subject;
	}


	public void teach() {
		System.out.println(name + "선생님, 가르치십니다.");
	}
	
	@Override 
	public void join() {
		System.out.println(name + "선생님, 회원 가입이 완료되었습니다." + " subject:" + subject);
	}		
}
