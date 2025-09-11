package test01;

public class FuncPerson {
    public static Person createPserson(String name, int age){
        Person result = new Person(name, age);
        return result;
    }
    public static void main(String[] args) {
        Person p = createPserson("홍길동", 21);
        System.err.println( "이름 : " + p.name + ", 나이 :" + p.age );
        
    }
}
