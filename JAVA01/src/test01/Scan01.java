package test01;
import java.util.Scanner;

public class Scan01 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("숫자를 입력하세요 :");
        // String strInput = scan.nextLine();
        // String strInput1 = scan.nextLine();
        // System.out.println("입력된 값" + strInput + "," + strInput1);
        
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.println(String.format("두수의 합은:%d", num1 + num2));
        
        scan.close();
    }
}
