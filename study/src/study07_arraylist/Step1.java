package study07_arraylist;

import java.util.ArrayList;

public class Step1 {

	public Step1() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> fruits = new ArrayList<>();
		fruits.add("사과");
		fruits.add("바나나");
		fruits.add("딸기");
		fruits.add("토마토");
		
		System.out.println(fruits);
		System.out.println(fruits.size());
		System.out.println(fruits.get(0));
		System.out.println(fruits.set(1, "자두")); // 교체
		System.out.println(fruits);
		
		System.out.println(fruits.remove(0));
		System.out.println(fruits.remove("딸기"));
		System.out.println(fruits);
		
		for(int i=0; i<fruits.size(); i++)
		{
			System.out.println(i + ":" + fruits.get(i));
		}
		int i = 0;
		for(String item: fruits)
		{			
			System.out.println(i++ + ":" + item);
		}
	}

}
