package study09_interface;

public class Block {

    // 인스턴스 초기화 블록 (IIB)
    {
        System.out.println("2. 인스턴스 초기화 블록(IIB) 실행됨.");
    }
    
    // 정적 블록 (Static Block)
    static {
        System.out.println("1. 정적 블록(Static Block) 실행됨 (클래스 로딩 시 1회).");
    }

    // 생성자
    public Block() {
        System.out.println("3. 생성자 실행됨.");
    }

    public static void main(String[] args) {
        System.out.println("--- 첫 번째 인스턴스 생성 ---");
        Block obj1 = new Block();

        System.out.println("--- 두 번째 인스턴스 생성 ---");
        Block obj2 = new Block();
    }

}
