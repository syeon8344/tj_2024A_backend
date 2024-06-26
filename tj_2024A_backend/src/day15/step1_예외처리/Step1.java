package day15.step1_예외처리;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Step1 {
    public static void main(String[] args){

        // [1] 일반 예외 : 발생할 수도 있고 안 할 수도 있다, 컴파일러가 무조건 예외처리 검사
        try {
            // 예외 발생할 것 같은 코드 ==========
            Class.forName("java.lang.String"); // .forName(클래스명) : 해당 클래스명이 존재하는지 확인
            Class.forName("java.lang.String2");
            // =================================

        } catch (ClassNotFoundException e) { // 예외클래스명 예외변수명
            // 예외 발생시 =========
            System.out.println(e);
            // ===================
        }
        // [2] 실행 예외 : 발생할 수도 있고 안 할 수도 있다
        try {
            String str1 = "ThisIsJava";
            System.out.println(str1.length()); // 문자열.length() : 문자열 길이

            String str2 = null;
            System.out.println(str2.length()); // 도트/접근연산자 "." : 객체 내 멤버변수 / 메소드 참조
            // java.lang.NullPointerException: Cannot invoke "String.length()" because "str2" is null
        } catch (NullPointerException e) { System.out.println(e); }

        //
        String str3 = "100";
        String str4 = "Lee";
        int result1 = Integer.parseInt(str3); // Integer 클래스 : int형 관련 클래스, .parseInt(문자열) -> 정수형 타입으로 변환
                            // .parseInt() : static 함수, 객체 없이도 쓸 수 있다
        System.out.println(result1);

        try {
            int result2 = Integer.parseInt(str4);
            System.out.println(result2);
        } catch (NumberFormatException e){
            System.out.println(e);
        }

        //
        int[] intArray = {1, 2, 3};
        try{
        System.out.println(intArray[1]);
        System.out.println(intArray[3]);
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println(e);
        }

        //
        Scanner scanner = new Scanner(System.in);
        try {
        int ch = scanner.nextInt(); // 만약에 문자 입력시 예외발생, java.util.InputMismatchException
        } catch (InputMismatchException e) {
            System.out.println(e);
        }

        // try 다중 catch
        try {
            String str5 = "1aa";
            int result3 = Integer.parseInt(str5);
            System.out.println(result3);
            intArray = new int[3];
            intArray[0] = 1;
            intArray[5] = 5;
        } catch (NumberFormatException e){ // 다중 catch : 위에서부터 순차적으로 예외 처리 체크
            System.out.println("NumberFormatException");
        } catch (ArrayIndexOutOfBoundsException e){
            System.out.println("ArrayIndexOutOfBoundsException");
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            System.out.println("여기는 무조건 실행");
        }
    }

}
