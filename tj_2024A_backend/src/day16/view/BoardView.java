package day16.view;

import java.util.Scanner;

public class BoardView {

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성
    public static BoardView bView = new BoardView();

    //멤버변수 : 입력객체
    Scanner scan = new Scanner(System.in);

    //0. 초기화면 함수
    public void index(){
        while(true){
            System.out.print(">>1.글 작성 2.글 전체출력 3.글 삭제 4.글 수정 5.돌아가기 : ");
            try {
                int ch = scan.nextInt();
                if (ch==1){ //글 작성

                }
                else if (ch==2){ //글 전체출력

                }
                else if (ch==3){ //글 삭제


                }
                else if (ch==4){ //글 수정

                }
                else if (ch==5){
                    break;
                }
                else { System.out.println(">>기능이 없는 번호입니다"); }
            } catch (Exception e){
                System.out.println(">>잘못된 입력입니다");
                scan = new Scanner(System.in);
            }
        }
    }
}
