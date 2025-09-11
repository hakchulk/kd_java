package test01;

public class For01 {
    public static void main(String[] args) {
        // int dan = 5;
        // for (int i = 1; i < 10; i++) {
        //     System.out.println(String.format("%d dan %d = %d", dan, i, i * dan));
        // }

        int n = 5;
        for (int i=1; i<= n; i++){
            for (int j=1; j <= i; j++){
                System.out.print("*");
            }
            System.out.println("");
        }

    }
}
