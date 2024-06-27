package day16;

import day16.view.BoardView;
import day16.view.MemberView;
import java.util.Scanner;

public class AppStart {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        while (true)
            try {
                System.out.print(">>1.회원정보 2.게시판 3.종료 : ");
                int ch = scan.nextInt();
                if (ch == 1){
                    MemberView.mView.index();
                }
                else if (ch == 2) {
                    BoardView.bView.index();
                }
                else if (ch == 3) {
                    System.out.println(">>프로그램을 종료합니다.");
                    break;
                }
                else {
                    System.out.println(">>숫자 1, 2, 3 중 하나를 입력해야 합니다.");
                }
            } catch (Exception e) {
                System.out.println(">>숫자 1, 2, 3 중 하나를 입력해야 합니다.");
                scan = new Scanner(System.in);
            }
    }
}
