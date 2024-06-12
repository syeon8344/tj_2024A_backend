package day05;

import java.util.Scanner;

public class Step3 {

    public static void main(String[] args) {

//        // 문제 4.
//        // 3 1 , 2 3, 1 5, 0 7
//        int b = 3;
//        int s = 1;
//        for (int i = 0; i < 4; i++) {
//            for (int j = b; j > 0; j--) {
//                System.out.print(" ");
//            }
//            for (int k = s; k > 0; k--) {
//                System.out.print("*");
//            }
//            b--;
//            s += 2;
//            System.out.println();
//        }
//
//        System.out.println();
//        // 문제 5.
//        int b2 = 3;
//        int s2 = 1;
//        for (int i = 0; i < 7; i++) {
//
//            for (int j = b2; j > 0; j--) {
//                System.out.print(" ");
//            }
//
//            for (int k = s2; k > 0; k--) {
//                System.out.print("*");
//            }
//
//            if (i < 3) {
//                b2--;
//                s2 += 2;
//            } else {
//                b2++;
//                s2 -= 2;
//            }
//            System.out.println();
//        }
//
//
//        // [입력] 입력개체
        Scanner scanner = new Scanner(System.in);
//
//        // [1] 입력받은 수만큼 별 출력하기
//        System.out.println("[1] 별 개수 : ");
//        int star1 = scanner.nextInt();
//
//        for (int i = 1; i <= star1; i++) {
//            System.out.print("*");
//        }
//
//        // [2] 입력받은 수만큼 별 출력 / 3의 배수마다 줄바꿈
//        System.out.println("[2] 별 개수 : ");
//        int star2 = scanner.nextInt();
//
//        for (int i = 1; i <= star2; i++) {
//            System.out.print("*");
//            if (i % 3 == 0) {
//                System.out.println();
//            }
//        }
//
//        // [3] 변수 입력, 별을 하나의 변수에 입력받은 횟수만큼 추가후 최종 변수 출력
//        System.out.println("[3] 반복 횟수 : ");
//        int star3 = scanner.nextInt();
//        String starTotal = "";
//        for (int i = 1; i <= star3; i++) {
//            starTotal += "*";
//        }
//        System.out.println("starTotal = " + starTotal);

        // [4] 입력받은 줄만큼 *을 한개씩 늘려가며 출력
        System.out.println("[4] 줄 갯수 입력 : "); int star4 = scanner.nextInt();
        int temp = star4;
        for (int i = 0 ; i < star4; i++) {
            for (int j = 0 ; j < temp; j++) {
                System.out.print("*");
            }
            temp--;
            System.out.println();
        }
        System.out.println("====================");

        int temp2 = star4;
        for (int i = 0 ; i < star4; i++) {
            int blank = star4 - temp2;
            for (int j = 0 ; j < blank; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < temp2; j++){
                System.out.print("*");
            }
            temp2--;
            System.out.println();
        }

        System.out.println("====================");

        int temp3 = 1;
        for (int i = 0 ; i < star4; i++) {
            int blank3 = star4 - temp3;
            for (int j = 0 ; j < blank3; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < temp3; j++){
                System.out.print("*");
            }
            temp3++;
            System.out.println();
        }

        System.out.println("====================");

        int temp4 = star4;
        for (int i = 0 ; i < star4; i++) {
            int blank = star4 - temp4;
            for (int j = 0 ; j < blank; j++){
                System.out.print("*");
            }
            for (int j = 0; j < temp4; j++){
                System.out.print(" ");
            }
            temp4--;
            System.out.println();
        }

        System.out.println("====================");

        int temp5 = 1;
        int blank4 = star4-1;
        for (int i = 0 ; i < star4; i++){
            for (int j = 0; j < blank4; j++){
                System.out.print(" ");
            }
            for (int j = 0; j < temp5; j++){
                System.out.print("*");
            }
            blank4--;
            temp5 +=2;
            System.out.println();

        }

        System.out.println("====================");

        int temp6 = 2*star4 - 1;
        int blank6 = 0;
        for (int i = 0 ; i < star4; i++) {
            for (int j = 0; j < blank6; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < temp6; j++) {
                System.out.print("*");
            }
            blank6++;
            temp6 -= 2;
            System.out.println();
        }

        System.out.println("====================");

        int blank7f = 0;
        int blank7s = star4-2;
        boolean overHalf = false;
        for (int i = 0; i < star4; i++){
            for (int j = 0; j < blank7f; j++){
                System.out.print(" ");
            }
            System.out.print("*");
            for (int j = 0; j < blank7s; j++){
                System.out.print(" ");
            }
            if (blank7s >= 0) {
                System.out.print("*");
            }
            if (overHalf == false) {
                blank7f++;
                blank7s -= 2;
            } else { blank7f--; blank7s += 2;}
            if(i >= star4/2 - 1) {overHalf = true;}
            System.out.println();
        }
    }
}
