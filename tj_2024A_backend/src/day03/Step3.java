package day03;

import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {


        Scanner scan = new Scanner(System.in);
//        [ 제어문/반복문 없이 풀이 ]
//        문제1 : 하나의 정수형으로  입력받아 7의 배수 이면 'O' 아니면 'X' 출력 하시오.

        System.out.println("정수 입력"); int num1 = scan.nextInt();
        System.out.println(num1 % 7 == 0 ? 'O' : 'X');

//
//        문제2 : 하나의 정수형으로  입력받아 홀수 이면 'O' 아니면 'X' 출력 하시오.

        System.out.println("정수 입력"); int num2 = scan.nextInt();
        System.out.println(num2 % 2 == 0 ? 'X' : 'O');

//
//        문제3 : 하나의 정수형으로  입력받아 7의 배수 이면서 짝수 이면 'O' 아니면 'X' 출력 하시오.

        System.out.print("정수 입력: ");
        int num3 = scan.nextInt();
        System.out.println(num3 % 7 != 0 ? 'X' : num3 % 2 == 0 ? 'O' : 'X');

//
//        문제4 : 하나의 정수형으로  입력받아 11의 배수 이거나 짝수 이면 'O' 아니면 'X' 출력 하시오.
//
        int num;
        System.out.print("수 입력 : ");
        num = scan.nextInt();
        System.out.println(num % 11==0 ? "o": num % 2==0 ? "o":"x");
//        문제5 : 두개의 정수형으로 입력받아 더 큰수 출력 하시오.
//
        int num5 = scan.nextInt();
        int num5a = scan.nextInt();
        System.out.println(num5 > num5a ? num5 : num5a);

//       문제6 : 정수형으로 반지름을 입력받아 원 넓이 출력 하시오. 소수점 둘째 자리 까지 출력하시오.
//       계산식) 원 넓이 공식 => 반지름 * 반지름 * 원주율[3.14]

        System.out.print("반지름: "); int 반지름=scan.nextInt();
        float 넓이=반지름*반지름*3.14F;
        System.out.printf("원 넓이: %.2f\n",넓이);
//
//        문제7 : 실수형으로 두번 입력받아 앞 실수의 값이 뒤의 값의 몇% 인지 소수점 첫째 자리까지 출력하시오.
//        예) 54.5   84.3 실수 2개입력시 결과는   64.285714%

        System.out.println("실수1을 입력하세요.");
        double value1 = scan.nextDouble(); // 실수1 저장
        System.out.println("실수2를 입력하세요.");
        double value2 = scan.nextDouble(); // 실수2 저장
        double result = value1 / value2 * 100; // 결과 저장
        System.out.printf("%.1f\n", result); // 소수점 첫째 자리까지 출력
//
//                문제8 : 사다리꼴 넓이 구하기[윗변과 밑변 높이를 입력받아 출력하기 , 소수점 첫째 자리까지 출력하시오.
//                계산식) 사다리꼴 계산식 = > (윗변 + 밑변) * 높이 / 2
        System.out.println(">> 윗변 : "); int num81 = scan.nextInt();
        System.out.println(">> 밑변 : "); int num82 = scan.nextInt();
        System.out.println(">> 높이 : "); int num83 = scan.nextInt();
        float area = ((num81+num82)*num83)/2;
        System.out.printf("\n>> 넓이 : %.1f", area);
//
//        문제9 : 키를 정수를 입력받아 표준체중 출력하기 , 정수형으로 출력하시오.
//            계산식) 표준체중 계산식 = > (키 - 100) * 0.9
        System.out.print(" >> 키 입력 : ");
        int height = scan.nextInt();
        int weight = (int)((height - 100) * 0.9) ;
        System.out.println(" >> 표준 체중 : " + weight);
        System.out.println(" >> 계산식 : (" + height + " - 100) * 0.9 = " + weight + "kg");
//
//        문제10 : 키와 몸무게를 입력받아 BMI 출력하기 , 소수점 둘째 자리 까지 출력하시오.
//        계산식) BMI 계산식 = > 몸무게 / ((키 / 100) * (키 / 100))
        System.out.println(" >> 키 입력 : ");
        int height2 = scan.nextInt();
        System.out.println(" >> 몸무게 입력 : ");
        int weight2 = scan.nextInt();
        double bmi = weight2 / ((height2 / 100) * (height2 / 100));
        System.out.printf("\n >> BMI : %.2f", bmi);
//
//        문제11 : inch 를 입력받아 cm 로 변환하기  , 소수점 둘째 자리까지 출력하시오.
//                계산식) 1 inch -> 2.54cm
//
//        문제12:  중간고사, 기말고사, 수행평가를 입력받아 반영비율별 계산하여 소수 둘째자리까지 점수 출력하시오
//        계산식 반영비율)  중간고사 반영비율 => 30 %  / 기말고사 반영비율 => 30 %   / 수행평가 반영비율 => 40 %
//              %.2f
//                문제13 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
//        int x = 10;
//        int y = x-- + 5 + --x;
//        printf(" x의 값 : %d , y의값 :  %d ", x, y)
//
//        문제14 : 나이를 입력받아 나이가 10세이상이면 학생 , 20세이상이면 성인 , 40세이상이면 중년 으로 출력하기
//                  age >= 40 ? "중년" : age >= 20 ? "청년" : age >= 10 ? "학생" : "undefined"
//        문제15 : 국어 , 영어 , 수학 점수를 입력받아 각 변수에 저장하고 총점(소수점 0자리) 출력 , 평균(소수점 2자리 까지) 출력
//
//        문제16 : 3개의 정수형으로 입력받아 가장 큰수 출력 1 2 3 3 2 1 1 3 2  2 3 1
        // 정수1 : a   2 : b   3 : c
        //System.out.println(a > b && a > c ? a : b > c ? b : c); 
//

//        문제17 : 아이디[문자열] 와 비밀번호[문자열] 를 입력받아 아이디가 'admin' 이고 비밀번호가 '1234' 와 일치하면 '로그인성공' 아니면 '로그인실패' 출력 
        
        // 문자열 (String)은 비교연산자 사용 불가능 (객체라서) // inputID == "admin" 불가능

        // 객체 비교 메소드 : 객체.equals("비교 문자열")
        System.out.println("아이디 : "); String inputId = scan.next();
        System.out.println("비밀번호 : "); String inputPw = scan.next();
        String id = "admin"; String pw = "1234";
        System.out.println(inputId.equals(id) && inputPw.equals(pw) ? "로그인성공" : "로그인실패");


        //문제5 : 두개의 정수형으로 입력받아 더 큰수 출력 하시오.
        System.out.println(">> 정수 1: "); int i1 = scan.nextInt();
        System.out.println(">> 정수 2: "); int i2 = scan.nextInt();
        System.out.println(i1 == i2 ? ">> 두 정수가 서로 같음" : i2 > i1 ? ">> 정수 2가 더 큼 : " + i2 : ">> 정수 1이 더 큼 : " + i1);
//        if (i1 < i2) {
//            System.out.println(">> 정수 2가 더 큼 : " + i2);
//        } else if (i2 < i1) {
//            System.out.println(">> 정수 1이 더 큼 : " + i1);
//        } else {
//            System.out.println(">> 두 정수가 서로 같음");
//        }


        //문제13 :  연산 순서 나열 하고 printf() 에 출력되는 x 와 y 값을 예측하시오.
        //        int x = 10;
        //        int y = x-- + 5 + --x;
        //        printf(" x의 값 : %d , y의값 :  %d ", x, y)

//        int x = 10;
//        int y =
//        x-- + 5 = 15, x = 9
//        15 + --x, x = 8, y = 23
//        x = 8;
//        System.out.printf(" x의 값 : %d , y의값 :  %d ", x, y);
    }
}
