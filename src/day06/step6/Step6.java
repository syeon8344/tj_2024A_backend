package day06.step6;

import java.util.Scanner;

public class Step6 {
    /*
        실습 [요구사항]
        1. 기능 무한반복으로 구현
            - 종료 버튼/입력 시 종료
        2. 기능 : 예금, 출금, 잔고확인, 종료
            예금 : 입력받은 금액을 예금액에 더한다
            출금 : 입력받은 금액을 예금액에서 뺀다
            잔고확인 : 현재 예금액을 확인
            종료 : 무한반복을 종료한다
         3. 메뉴 : 1. 예금 2. 출금 3. 잔고확인 4. 종료
         4. 설계
            Account 클래스 정의
                - balance : 예금액
                - number  : 계좌번호
     */
    public static void main(String[] Args) {
        Account acc1 = new Account();

        acc1.balance = 0;
        acc1.number = "111-222-3333";

        Scanner input = new Scanner(System.in);

        for(;;){
            System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("메뉴를 선택해 주세요: 1.예금 2.출금 3.잔고확인 4.종료"); int sel = input.nextInt();
            System.out.println("입력한 값 : " + sel);
            if (sel == 1) {
                System.out.println("금액을 입력해 주세요 : ");
                int add = input.nextInt();
                acc1.addBalance(add);

            }
            else if (sel == 2) {
                System.out.println("금액을 입력해 주세요 : ");
                int sub = input.nextInt();
                acc1.subtractBalance(sub);
            }
            else if (sel == 3) {
                System.out.println("현재 잔액은 " + acc1.getBalance() + "원 입니다");
            }
            else if (sel == 4) {
                System.out.println("메뉴를 종료합니다.");
                break;
            }
            else {
                System.out.println("알 수 없는 메뉴 입력입니다!");}

        }
    }


}
//package day06.step6;
//
//import java.util.Scanner;
//
//public class Step6 { // class c
//    public static void main(String[] args) { // main s
//
//        // 1. 입력 객체 : 입력기능( .next() )을 사용할려고
//        // .next() 관련된 기능을 scanner 객체가 가지고 있으니까
//
//        Scanner scanner = new Scanner(System.in);
//
//        // 1. 객체 생성
//        Account myAccount = new Account();
//
//        // 2. 객체내 필드/멤버변수 에 값 대입
//        myAccount.balance = 0;
//        myAccount.number = "123-123";
//
//        while (true) { // w s : 무한반복
//            // 출력
//            System.out.println("==============================");
//            System.out.print("1.예금 2.출금 3.잔고 4.종료 : ");
//            // 입력
//            int ch = scanner.nextInt();
//            System.out.println("ch = " + ch);
//            // 3. 입력값에 따른 서로 다른 로직 처리 ( 조건문 )
//            if (ch == 1) {
//                System.out.println("예금처리");
//                System.out.print("예금할 금액 입력 : ");
//                int money = scanner.nextInt();
//                myAccount.balance += money;
//            } // 만약에 내가 입력한 값이 1 이면 예금처리
//            else if (ch == 2) {
//                System.out.println("출금처리");
//                System.out.print("출금할 금액 입력 : ");
//                int money = scanner.nextInt();
//                myAccount.balance -= money;
//            }  // 만약에 내가 입력한 값이 2 이면 출금처리
//            else if (ch == 3) {
//                System.out.println("잔고확인처리");
//                System.out.println("balance = " + myAccount.balance);
//            } // 만약에 내가 입력한 값이 3 이면 잔고확인처리
//            else if (ch == 4) {
//                System.out.println("종료");
//                break;
//            } // 만약에 내가 입력한 값이 4 이면 종료
//            else {
//                System.out.println("알수없는 번호 입니다.");
//            } // 그외
//        } // w end
//    } // main e
//} // class e