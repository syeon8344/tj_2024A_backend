package day03;

import java.util.Scanner;

public class Step2 {

    public static void main(String[] args) {
        
        // 예제 1: 작성자, 내용, 날짜 입력받아 형식에 맞춰 출력하기
        // 1. 입력객체
            // 1. Scanner 클래스 [자동완성 입력시 import 자동완성, 추천
                // - ㅑimport java.util.,server
        Scanner scanner = new Scanner(System.in);
        // 2. 입력받고 변수에 저장
        System.out.print("작성자 : "); String 작성자 = scanner.next();
        scanner.nextLine();
        System.out.print("방문록 : "); String 방문록 = scanner.nextLine();
        System.out.print("나이 : ");  int 나이 = scanner.nextInt();
        
        // 출력 println vs print vs printf
        System.out.printf(">> 작성자 : %s \t 나이 : %3d \n", 작성자, 나이);
        System.out.printf(">>방문록 : %s \n", 방문록);
            // VS
        System.out.println(">> 작성자 : "+작성자+ "\t 나이 : " + 나이);
        System.out.println(">> 방문록 : " + 방문록);

        // 예제2: 기본급과 수당을 정수로 입력받아 실수령액 계산해서 출력
            // 실수령액 계산식 : 기본급 + 수당 - 세금[기본급 10%]
        System.out.print(">기본급 : ");  int 기본급 = scanner.nextInt();
        System.out.print(">수당 : ");   int 수당 = scanner.nextInt();

        // 2. 계산, 강제형변환 생각하기
        int 실수령액 = 기본급 + 수당 - (int)(기본급*0.1); // 기본급 (int) * 0.1(double) = double이므로

        System.out.println("실수령액 = " + 실수령액);
    }
}
