package day01;

public class Step3 { // class start

    public static void main(String[] args) { // main start
        // 1. 정수 자료형
        // [1] byte : -128 ~ 127 ( 0까지 포함해서) int -> byte
        byte b1 = -128;         System.out.println("b1 : " +  b1);
        byte b2 = 127;          System.out.println("b2 = " + b2); // soutv + enter 가장 가까운 변수 표시
        // byte b3 = 200; // 저장가능한 허용범위 벗어남
        
        // [2] short : -32,768 ~ 32,767     ~3만정도 int -> short
        short s1 = 32000;       System.out.println("s1 = " + s1);
        short s2 = -32000;      System.out.println("s2 = " + s2);
        // short s3 = 40000; // 저장가능한 허용범위 벗어남

        // [3] int : ~ +- 21.47억, 자바 정수 기본 자료형*
        int i1 = 2100000000;    System.out.println("i1 = " + i1);
        int i2 = -2100000000;   System.out.println("i2 = " + i2);

        // [4] long : 21억 이상  -2^63 ~ 2^63-1    int 범위 값을 벗어날 때만 L 붙이기
        long l1 = 3000000000L;  System.out.println("l1 = " + l1);
        long l2 = 30000;        System.out.println("l2 = " + l2);

        // 2. 문자 자료형
        // [5] 문자 1개 저장, *'' 작은따옴표 사용*
        char c1 = 'A';          System.out.println("c1 = " + c1);
        int i3 = 'A';           System.out.println("i3 = " + i3);
        char c2 = '가';         System.out.println("c2 = " + c2);
        int i4 = '가';          System.out.println("i4 = " + i4);
        // char c3 = '안녕'; // char 문자열 불가

        // [6] String 클래스, 기본자료형이 아닌 *클래스를 사용하므로 첫글자 대문자 String
        String str1 = "안녕하세요";  System.out.println("str1 = " + str1);

        // 3. 논리 자료형
        // [7] boolean : true 혹은 false 만 저장
        boolean bool1 = true;   System.out.println("bool1 = " + bool1);
        boolean bool2 = false;  System.out.println("bool2 = " + bool2);

        // 4. 실수 자료형
        // [8] double : 소수점 제외 17자리까지 표현, 자바 실수 기본 자료형*
        double d1 = 0.12345678901234567;    System.out.println("d1 = " + d1);

        // [9] float : 소수점 제외 8자리까지 표현
        float f1 = 0.12345678f;        System.out.println("f1 = " + f1);

    } // main end
} // class end
