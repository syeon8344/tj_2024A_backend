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
