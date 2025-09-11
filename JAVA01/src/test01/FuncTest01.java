package test01;

public class FuncTest01 {
    public static void sayHello(String name, int year) {
        System.out.println(name + "님 안녕하세요. 당신의 나이는 " + year);
    }

    public static int add(int a, int b) {
        return a + b;
    }

    public static String add(String a) {
        return a;
    }

    public static void main(String[] args) {
        sayHello("홍길동", 21);
        
        int result = add(10,20);
        System.out.println("합은 : "+ result);

        String result1 = add("반갑습니다.");
        System.out.println(result1);
    }
}
