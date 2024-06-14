package 과제;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level2 {
    public static void main(String[] args) {
        // Level2_1
        System.out.println("\n >> Level2_1 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");

        Scanner scanner = new Scanner(System.in);
        for(;;){
            System.out.print(" 음악 재생 중, 종료하려면 [x]를 누르세요 : "); char input1 = scanner.next().charAt(0);
            if (input1 == 'x') {
                System.out.println(">> 음악종료"); break;
            }
        }


        // Level2_2
        System.out.println("\n >> Level2_2 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");

        int result = 3; // DAO 메소드로 결과를 받아옴
        if (result == 1)
            System.out.println("<<회원가입 성공>>");
        else if (result == 2)
            System.out.println("<<사용중인 아이디>>");
        else if (result == 3)
            System.out.println("<<입력이 안 된 정보가 있습니다>>");
        else
            System.out.println("<<데이터베이스 오류>>");

        // Level2_3
        System.out.println("\n >> Level2_3 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        int kor = 89; int eng = 49; int math = 72;
        int sum = kor + eng + math;
        float avg = sum/3;
        boolean x3 = sum % 3 == 0 ? true : false;
        boolean x8 = sum % 8 == 0 ? true : false;
        String oddEven = sum % 2 == 1 ? "홀수" : "짝수";
        String success = sum >= 65 ? "합격" : "탈락";
        System.out.printf("---------------------------------------------------------------------\n국어\t\t영어\t\t수학\t\t합계\t\t평균\t\t3배수\t8배수\t홀짝\t\t결과\n%d\t\t%d\t\t%d\t\t%d\t\t%.1f\t%b\t%b\t%s\t\t%s", kor, eng, math, sum, avg, x3, x8, oddEven, success);

        // Level2_4
        System.out.println("\n >> Level2_4 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");

        Random random = new Random();
        System.out.print("가위 바위 보 선택 : "); String playerInput = scanner.next();
        int player = 0;

        if (playerInput.equals("가위") || playerInput.equals("바위") || playerInput.equals("보")) {
            player = (playerInput.equals("가위") ? 0 : playerInput.equals("바위") ? 1 : 2);
        } else {
            System.out.println("입력이 잘못되었습니다.");
        }

        int computer = random.nextInt(3);
        String comran = computer == 0 ? "가위" : computer == 1 ? "바위" : "보";

            // 플레이어 승리조건 : 가위 : 보 , 바위 : 가위, 보 : 바위 -> 0 : 2, 1: 0, 2: 1 -> 빼기 결과 -2 또는 1
        System.out.println("comran) " + comran);
        if (player - computer == -2 || player - computer == 1)
            System.out.println("result) player 승리");
        else {
            System.out.println("result) com 승리");
        }


    }

}
