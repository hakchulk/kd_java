package study01;

// 소스정리 : ctrl-sfift-f

public class TestClass02 {

	public static void main(String[] args) {
		String[] str = { "서울", "부산", "대구" };

		System.out.println(str.length);

		for (int i = 0; i < str.length; i++) {
			System.out.println("지역[" + i + "]" + str[i]);
		}

		// forEach
		for (String city : str) {
			System.out.println(city);
		}

		int[] num = { 2, 1, 3, 4, 5, 30 };

		int sum = 0;
		for (int i : num) {
			sum += i;
		}

		System.out.println(String.format("함계 : %d", sum));

		double avg = (double) sum / num.length;
		System.out.println(String.format("평균 : %s", avg));
		
		int min = num[0];
		for (int i : num) {
			if (min > i)
				min = i;
		}
		System.out.println(String.format("최소 : %d", min));
	}

}
