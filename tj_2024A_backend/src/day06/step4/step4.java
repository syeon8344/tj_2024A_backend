package day06.step4;

import java.util.Scanner;

public class step4 {

    public static void main(String[] args) {
        
        // 클래스 사용처 : 1. 객체 설계도, 2. main함수를 가지고 있는 클래스
        
        // 1. 입력객체
        Scanner scanner = new Scanner(System.in);

        int speed = 0; // 속도 변수 선언하고 0 초기화
        
        // 2. 무한루프
        while(true){
            // 출력함수
            System.out.println("=============================");
            System.out.println(">>> 1. 가속 2. 감속 3. 중지 : ");
            
            // 입력함수 이용해서 입력받은 값을 정수형으로 반환해서 변수에 저장
            int ch = scanner.nextInt();
            
            // 제어/조건문
            if(ch == 1){
                speed++; System.out.println("> 가속 | speed = " +speed);
            }
            else if(ch == 2){
                if (speed >= 1)
                    speed--;
                else
                    System.out.println("감속 불가!");
                System.out.println("> 감속| speed = " +speed);
            }
            else if(ch == 3){
                speed = 0; System.out.println("> 중지"); break;
            }
            else{
                System.out.println("> 알 수 없는 명령");
            }

        }

        
    }
}
