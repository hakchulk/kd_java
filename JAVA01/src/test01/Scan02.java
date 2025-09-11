package test01;

import java.util.Scanner;

public class Scan02 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("1. 콜라, 2. 사이다, 3. 커피");
        System.out.print("음료 번호를 입력하세요:");
        int menu = scan.nextInt();

        if (menu == 1){
            System.out.println("2000원 입니다.");
        } else if (menu == 2) {
            System.out.println("1900원 입니다.");
        } else if (menu == 3) {
            System.out.println("1800원 입니다.");
        } else {
            System.out.println("올바른 값을 입력 하세요.");
        }
        scan.close();
    }
}
