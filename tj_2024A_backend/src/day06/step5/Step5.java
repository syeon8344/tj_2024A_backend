package day06.step5;

import java.util.Scanner;

public class Step5 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // 정의한 Car 클래스로 객체 생성
        Car c1 = new Car(); //객체 생성
        c1.color = "Blue";  // 객체 내 멤버변수/필드에 값 대입
        c1.speed = 0;
        c1.carNumber = "122나1111";

        Car c2 = new Car();
        c2.color = "Black";
        c2.speed = 0;
        c2.carNumber = "211가4554";


        // 2. 무한루프 vs for(;;){}
        while(true){
            // 출력함수
            System.out.println("=============================");
            System.out.println(">>> 1. 가속 2. 감속 3. 중지 : ");

            // 입력함수 이용해서 입력받은 값을 정수형으로 반환해서 변수에 저장
            int ch = scanner.nextInt();

            // 제어/조건문
            if(ch == 1){
                c1.speed++; System.out.println("> 가속 | speed = " +c1.speed);
            }
            else if(ch == 2){
                if (c1.speed >= 1)
                    c1.speed--;
                else
                    System.out.println("감속 불가!");
                System.out.println("> 감속| speed = " +c1.speed);
            }
            else if(ch == 3){
                c1.speed = 0; System.out.println("> 중지"); break;
            }
            else{
                System.out.println("> 알 수 없는 명령");
            }

        }


    }
}
