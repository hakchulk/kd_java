package study02;

public class StudentTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student lee = new Student();
		lee.studentName = "이순신";
		lee.address = "서울";
		
		Student han = new Student();
		han.studentName = "한석봉";
		han.address = "부산";
		
		lee.ShowInfo();
		han.ShowInfo();
		
		// 참조 변수 : 메모리에 생성된 인스턴스를 가리키는 변수
		System.out.println(han); // 참조 값 : 생성된 인스턴스의 메모리 주소 값
	}

}
