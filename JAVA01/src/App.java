public class App {
    public static void main(String[] args) throws Exception {
        // 정수 -> 실수 : 자동
        // 실수 -> 정수 : 명시적
        
        // double * int = double
        // long * int = long

        int num = 10;
        float floatNum = num;
        System.out.println(floatNum);
        System.out.println((int)floatNum);

        short sNum = 200;
        System.out.println(sNum);
        byte byteNUm = (byte)sNum;
        System.out.println(byteNUm);
        System.out.println(Integer.toBinaryString(sNum));
        System.out.println(Integer.toBinaryString(byteNUm));

        char myChar = 'A';        
        System.err.println((int)myChar);
        System.err.println( Byte.BYTES);
        char myChar1 = 42;
        System.err.println(myChar1);

        String txt = "안녕하세요";
        System.err.println(txt);

    }
}
