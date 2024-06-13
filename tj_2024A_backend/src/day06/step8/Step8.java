package day06.step8;

public class Step8 {

    public static void main(String[] args) {

        // 1. 함수 호출
        Calc c = new Calc(); // 객체 생성

        // 2. 객체내 함수 호출, 매개변수 3, 5
        int result1 = c.sumMethod1(3,5);
        System.out.println("result1 = " + result1);

        // 2. 객체내 함수 호출
        long result2 = c.sumMethod2();
        System.out.println("result2 = " + result2);

        // 2. 함수 호출
        c.sumMethod3();

        c.sumMethod4(5,5);
    }
}
