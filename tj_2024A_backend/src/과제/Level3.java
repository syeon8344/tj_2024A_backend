package 과제;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Scanner;

public class Level3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Level3_1
        System.out.println("\n >> Level3_1 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        System.out.println("안녕하세요1");
        System.out.println("안녕하세요2");
        System.out.println("안녕하세요3");
        System.out.println("안녕하세요4");
        System.out.println("안녕하세요5");
        System.out.println("안녕하세요6");
        System.out.println("안녕하세요7");
        System.out.println("안녕하세요8");
        System.out.println("안녕하세요9");
        System.out.println("안녕하세요10");
        System.out.println("------------- for으로 출력 ------------");
        for (int i = 0; i < 10; i++)
            System.out.println("안녕하세요" + (i+1));


        // Level3_2
        System.out.println("\n >> Level3_2 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        String input;
        for (int i = 1;;i++){
            System.out.print(i + "회 입력 : "); input = scanner.nextLine();
            if (input.equals("end")) {
                System.out.println("안내) 프로그램 종료 합니다.[총 " + i + "회 입력]");break;
            }
        }


        // Level3_3
        System.out.println("\n >> Level3_3 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        System.out.println(" -------- 7월 매출액 -------- ");
        int[] july = new int[] {353, 912, 518, 1173};
        for (int i = 0; i < 4; i++){
            int graph = july[i]/100;
            System.out.print((i+1) + "주차 : ");
            for (int j = 0; j<graph; j++ ){
                System.out.print("■");
            }
            System.out.print(july[i] + "만원");
            System.out.println();
        }

        // Level3_4
        System.out.println("\n >> Level3_4 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        int input4;
        int sum = 0;
        for(;;){
            System.out.print("input : "); input4 = scanner.nextInt();
            sum += input4;

            if (sum >= 0) {
                for (int i = 0; i < sum; i++)
                    System.out.print("■ ");
                System.out.println();
            }
            else
                break;
        }

        // Level3_5
        System.out.println("\n >> Level3_5 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");

        String authNumber = "";

        for(int i=0; i<6; i++){
            int randNum = new Random().nextInt(10);
            authNumber += randNum;
        }
        System.out.println("본인확인 인증번호 : " + authNumber);

    }
}
