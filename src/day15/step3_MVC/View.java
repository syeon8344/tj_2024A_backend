package day15.step3_MVC;

import java.util.ArrayList;
import java.util.Scanner;

public class View {
    // 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 변수
    static View view = new View();
    // 입력객체
    Scanner scan = new Scanner(System.in);

    // 1. 메인페이지 함수
    public void mainView(){

        for (;;) {
            System.out.println("========== 메인화면 ==========");
            System.out.print(">>1.등록 2.출력 3.수정 4.삭제");
            try{
                int ch = scan.nextInt();

                if(ch == 1){ // 1. 등록페이지 함수
                    signupView(); 
                }
                else if (ch == 2){ // 2. 출력페이지 함수
                    printView();
                }
                else if (ch == 3){ // 3. 수정페이지 함수
                    updateView();
                }
                else if (ch == 4){ // 4. 삭제페이지 함수
                    deleteView();
                }
                else {
                    System.out.println(">>번호 입력이 잘못되었습니다.");
                }
            } 
            catch (Exception e) {
                System.out.println(">>잘못된 입력입니다.");
                scan = new Scanner(System.in); // 잘못 입력받은 값을 가진 객체를 초기화
            }

        }// for

    }// mainView

    //1.
    public void signupView(){
        System.out.println(">>등록페이지");
        System.out.print(">>[저장] 이름 : "); String name = scan.next();
        boolean result = Controller.controller.signupCtrl(name);
        if (result) {
            System.out.println(">>등록성공");
        } else {
            System.out.println(">>등록실패");
        }
    }

    //2.
    public void printView(){
        System.out.println(">>출력페이지");
        ArrayList<String> resultList = Controller.controller.printCtrl();
        for (String s : resultList) {
            System.out.println(s);
        }
    }

    //3.
    public void updateView(){
        System.out.println(">>수정페이지");
        System.out.print(">>[수정] 원래 이름 : "); String oldName = scan.next();
        System.out.print(">>[수정] 새 이름 : "); String newName = scan.next();
        boolean result = Controller.controller.updateCtrl(oldName, newName);
        if (result) {
            System.out.println(">>수정성공");
        } else {
            System.out.println(">>수정실패");
        }
    }

    //4.
    public void deleteView(){
        System.out.println(">>삭제페이지");
        System.out.print(">>[삭제] 이름 : "); String name = scan.next();
        boolean result = Controller.controller.deleteCtrl(name);
        if (result) {
            System.out.println(">>삭제성공");
        } else {
            System.out.println(">>삭제실패");
        }
    }

}
