package day03;

import java.util.Scanner;

public class Step4 {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
//        [ 반복문 없이 풀이하는 입출력과 조건문 문제 ]
//        문제1 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 '합격' 아니면 '불합격' 출력 하시오.
        int question1 = scan.nextInt();
        if (question1 >= 90) {
            System.out.println("합격");
        } else {
            System.out.println("불합격");
        }

//
//        문제2 : 점수를 정수형으로 입력받아 점수가 90점 이상이면 'A등급', 80점 이상이면 'B등급', 70점 이상이면 'C등급', 그외 '재시험' 으로 출력 하시오.
//      if >= 90 A else if >= 80 B else if >= 70 C else 재시험
        int q2 = scan.nextInt();
        if (q2 >= 90)
            System.out.println("A등급");
        else if (q2 >= 80)
            System.out.println("B등급");
        else if (q2 >= 70)
            System.out.println("C등급");
        else
            System.out.println("재시험");
//        문제3 : 각 3개의 정수형으로 수를 입력받아 가장 큰 수를 출력 하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
//
        int q3a = scan.nextInt(); int q3b = scan.nextInt(); int q3c = scan.nextInt();
        if (q3a > q3b && q3a > q3c)
            System.out.println("가장 큰 수는 " + q3a);
        else if (q3b > q3c)
            System.out.println("가장 큰 수는 " + q3b);
        else
            System.out.println("가장 큰 수는 " + q3c);

//        문제4 : 각 3개의 정수형으로 수를 입력받아 오름차순 순서대로 출력하시오. [ 전제조건 : 각 정수는 서로 다른 정수값 ]
        int q4a = scan.nextInt(); int q4b = scan.nextInt(); int q4c = scan.nextInt();
        // 오름차순 : 1, 2, 3
        if (q4a == q4b || q4a == q4c || q4b == q4c) { // SWAP
            System.out.println("서로 같은 정수값이 있습니다");
        }
        if (q4a > q4b) {int temp = q4a; q4a = q4b; q4b = temp;}
        if (q4b > q4c) {int temp = q4b; q4b = q4c; q4c = temp;}
        if (q4a > q4b) {int temp = q4a; q4a = q4b; q4b = temp;}

        System.out.printf("\n정수의 순서는 %d, %d, %d", q4a, q4b, q4c);

//
//        문제5 : 가위바위보 게임 구현하기.
//                - 가위가 '0' 이고 바위가 '1' 이고 보가 '2' 일때 플레이어1와 플레이어2 가 있습니다.
//                - 승리자 판단과 무승부 경우의수를 출력하시오.
//      [입력 조건] 플레이어1 과 플레이어2 에게 각각 입력을 받습니다.
//     [출력 조건] 플레이어1 이기면 ' 플레이어1 승리 ', 플레이어2 이기면 ' 플레이어2 승리 ' 무승부 이면 '무승부' 출력 하시오.
//
        System.out.println("첫번째 플레이어 : "); int p1 = scan.nextInt();
        System.out.println("두번째 플레이어 : "); int p2 = scan.nextInt();

        if (p1 == p2)
            System.out.println("무승부");
        else if (p1 - p2 == -2 || p1 - p2 == 1)
            System.out.println("플레이어 1 승리");
        else
            System.out.println("플레이어 2 승리");
//        문제6 : 윤년/평년 판단하기
//                [ 입력조건 ] 하나의 연도를 입력 받습니다.
//   [ 윤년/평년 조건 ]
//        -연수가 4로 나누어 떨어지는 해는 윤년으로 한다. 3
//        -연수가 4, 100으로 나누어 떨어지는 해는 평년으로 한다. 2
//        -연수가 4, 100, 400으로 나누어 떨어지는 해는 윤년으로 둔다. 1번째로 확인
//   [ 출력조건] '입력한 OOOO년 은' 윤년 입니다.  혹은 평년 입니다 로 출력하시오.
        System.out.println("연도를 입력하세요 : "); int year = scan.nextInt();
        if (year%4 == 0 && year%100 == 0 && year%400 == 0) {
            System.out.printf("입력한 %4d는 윤년입니다", year);
        } else if (year%4 == 0 && year%100 == 0) {
            System.out.printf("입력한 %4d는 평년입니다", year);
        } else if (year%4 == 0) {
            System.out.printf("입력한 %4d는 윤년입니다", year);
        }


//
//                문제7 : 주차 사용요금 계산하기
//                [ 선언 변수 조건 ] 입차시간이 9시30분 입니다.
//        - int 시 = 9;  int 분 = 30; 이와 같이 변수를 먼저 선언해주세요.
//   [ 출차시간 입력 조건 ] 출차시간의 시 와 분을 각 입력받아 각 변수에 저장하시오.
//   [ 처리출력 조건 ] 1분당 1000원으로 계산하여 사용요금' 0000원' 을 출력하시오,
//        - 단 입차 시간 이전 으로 입력 할 경우에는 '출차시간 오류' 출력하시오.
//
        int inHour = 9; int inMinute = 30;
        System.out.println(">> 출차시간_시간 : "); int outHour = scan.nextInt();
        System.out.println(">> 출차시간_분 : ");   int outMinute = scan.nextInt();
        int passedTime = (outHour*60 + outMinute) - (inHour*60 + inMinute);
        if (passedTime < 0) {
            System.out.println("출차시간 오류");
        } else {
            System.out.printf("\n사용요금 %4d원", passedTime * 1000);
        }
//                문제8 : 로그인 처리
//   [입력 조건] 아이디[문자열] 와 비밀번호[문자열] 를 입력받기
//   [처리출력 조건]
//        1. 아이디가 'admin' 이고 비밀번호가 '1234' 모두 동일하면 '로그인성공'
//        2. 아이디가 다르면 '아이디 정보가 일치하지 않습니다.'
//        3. 아이디는 일치하고 비밀번호가 다르면 '비밀번호 정보가 일치하지 않습니다'
//
        System.out.println("아이디 : "); String id = scan.nextLine();
        System.out.println("비밀번호 : "); String pw = scan.nextLine();

        if (!id.equals("admin")) {
            System.out.println("아이디 정보가 일치하지 않습니다.");
        } else if (!pw.equals("1234")) {
            System.out.println("비밀번호 정보가 일치하지 않습니다.");
        } else {
            System.out.println("로그인성공");
        }
//        문제9 : 당첨번호 개수  찾기
//                [ 선언 변수 조건 ] int 공1 = 14 ; int 공2 = 21 ; int 공3 = 9; 이와 같이 변수를 먼저 선언해주세요.
//   [ 입력 조건 ] 세개의 정수를 입력받아 각 변수에 저장하시오.
//   [ 출력 조건 ] 입력받은 세 정수 중에서 공1~공3 까지 동일한 번호 가 몇개 인지 출력하시오.
        int 공1 = 14; int 공2 = 21; int 공3 = 9;

        System.out.println("첫 번째 숫자 : "); int num9a = scan.nextInt();
        System.out.println("두 번째 숫자 : "); int num9b = scan.nextInt();
        System.out.println("세 번째 숫자 : "); int num9c = scan.nextInt();

        int match = 0;
        if (num9a == 공1 || num9a == 공2 || num9a == 공3) {
            match++;
        }
        if (num9b == 공1 || num9b == 공2 || num9b == 공3) {
            match++;
        }
        if (num9c == 공1 || num9c == 공2 || num9c == 공3) {
            match++;
        }
        System.out.println("동일한 번호는 : " + match + "개입니다");

    }
}
