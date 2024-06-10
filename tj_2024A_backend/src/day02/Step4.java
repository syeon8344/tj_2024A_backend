package day02;

import java.util.Arrays;

public class Step4 { //class s

    public static void main(String[] args) { // main s

        // [ 콘솔 출력 ]
        System.out.print("JAVA");
                // System : 시스템 기능 관련 제공 클래스
                    // out : 출력 관련 객체
                        // print(리터럴 / 변수명 / 연산식) : 출력 함수
                        // println() : 출력 함수 + 줄바꿈
                            // intelliJ 기준 sout + enter
                        // printf() : 출력 함수 + 형식문자 지원
                            // souf + enter
                            // 형식문자 = %c : 문자 | %s : 문자열 | %d : 정수 | %f : 실수
                            //           %숫자d -> 자릿수 (%6d : xx1500, xxx100, 120000...)
                            //           %-숫자d -> 자릿수 *왼쪽정렬 (%-6d : 1500xx, 100xxx, 120000...)
                            //           %0숫자d -> 자릿수 및 빈자리 0 (%06d : 001500, 000100, 120000...)
                            //           %10.5f -> 자릿수 10자리 차지(소수점포함) & 소수점 5자리 밑 반올림 (1.414544 -> xxx1.41454)
                            // 제어문자 = \ : backslash | \n : 줄바꿈 | \t : 들여쓰기 | \r : 개행(커서를 앞으로)
                            //          \n\r : 엔터 (줄바꿈 + 커서를 맨 앞으로) | \\ : '\' 백슬래시 출력
                            //          \', \" : 따옴표 출력
        System.out.println("JAVA2");
        System.out.println("JAVA3");

        System.out.printf("%c, %s, %d, %f", 'A', "JAVA4", 123, 3.14); // A, JAVA4, 123, 3.14
        
        System.out.print("제어문자 : \n 줄바꿈 \t 들여쓰기 \"\" 큰따옴표출력 \'\' 작은따옴표출력 \\ 백슬래시출력\n");

        int price = 1500;
        String name = "콜라";
        System.out.println("상품 가격: " + price + "원 입니다.");
        System.out.printf("상품 가격: %d원 입니다.\n" , price);

        System.out.printf("%s의 가격: %d원 입니다.\n", name, price);
        System.out.printf("%s의 가격: %6d원 입니다.\n", name, price);
        System.out.printf("%s의 가격: %-6d원 입니다.\n", name, price);
        System.out.printf("%s의 가격: %06d원 입니다.\n", name, price);
        System.out.printf("%s의 가격: %7.3f원 입니다.\n", name, 3.141592);
        
        // intelliJ 자동완성
        // 1. sout
        System.out.println();
        // 2. souf
        System.out.printf("");
        // 3. soutm : 현재 함수명 문자열로 출력
        System.out.println("Step4.main");
        // 4. soutp : 현재 함수의 매개변수 값을 출력
        System.out.println("args = " + Arrays.toString(args));
        // 5. soutv : 커서에서 가장 가까운 변수/상수의 값 출력
        System.out.println("name = " + name);

        // 실습1 : 개 모양 출력하기
        System.out.println("|\\_/|");
        System.out.println("|q p|   /}");
        System.out.println("( 0 )\"\"\"\\");
        System.out.println("|\"^\"`    |");
        System.out.println("||_/=\\\\__|");

        System.out.println("|\\_/|\n|q p|   /}\n( 0 )\"\"\"\\\n|\"^\"`    |\n||_/=\\\\__|");
        // [ 콘솔 입력 ]


    } // main e
} // class e
