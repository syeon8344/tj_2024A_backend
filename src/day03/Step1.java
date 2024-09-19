package day03;

import java.util.Scanner;

public class Step1 {

    public static void main(String[] args) {

        // System.out : 시스템 출력, console 출력창
        // System.in : 시스템 입력, 키보드

        // [1] 입력 함수 ( JS prompt() )
        // 입력 객체 만들기
            // 1. new Scanner();                Scanner 클래서 : 입력 관련된 객체 생성
            // 2. new Scanner( System.in );     System.in : 입력 장치는 키보드
            // 3. Scanner 타입으로 변수에 생성된 객체를 저장하기
            // 4. 입력객체의 메소드를 이용한 입력값 가져오기
        Scanner scan = new Scanner(System.in);

        /*
            1. .next();         : 키보드 입력받은 바이트/자료를 문자열(String)타입으로 반환
            2. .nextLine();     : next() 동일
               .next();     : 띄어쓰기 포함된 문자열 입력받기 불가        
               .nextLine(); : 띄어쓰기 포함된 문자열도 입력받기 가능
                    - 단 nextLine() 위에 입력관련 메소드가 존재하면 하나로 취급
                    - 개행(엔터) 기준으로 마침 처리, next() + nextLine() : 하나로 취급
                    - 해결방안: 의미없는 nextLine()을 두 메소드 사이에 포함
         */
        
        // 1.
        // scan.next();                       // 1. 입력
        String str1 = scan.next();            // 2. 저장
        System.out.println("str1 = " + str1); // 3. 출력

        
        // 2.
        scan.nextLine();                    //의미없는 입력메소드
        String str2 = scan.nextLine();
        System.out.println("str2 = " + str2);
        
        // 3. 논리
        boolean b1 = scan.nextBoolean();
        System.out.println("b1 = " + b1);
        
        // 4. byte : 허용범위 외 입력시 오류
        byte b2 = scan.nextByte();
        System.out.println("b2 = " + b2);

        short s1 = scan.nextShort();
        int i1 = scan.nextInt();
        long l1 = scan.nextLong();
        float f1 = scan.nextFloat();
        double d1 = scan.nextDouble();


    }
}
