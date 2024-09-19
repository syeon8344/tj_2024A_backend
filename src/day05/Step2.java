package day05;

public class Step2 {

    public static void main(String[] args) {

        // 조건문을 왜? > 판단의 흐름을 제어
        // 반복문 왜? 동일한 실험을 반복으로 실행

        // 1.
        int num = 1;
        num = num + 2;
        num = num + 2;
        num = num + 3;
        num = num + 4;
        num = num + 5;
        num = num + 6;
        num = num + 7;
        num = num + 8;
        num = num + 9;
        num = num + 10;
        System.out.println(num);

        int num3 = 1;
        for (int i = 2; i <= 10; i++) {
            num3 = num3 + i;
        }
        System.out.println(num3);

        // 2.
        int num4 = 1;
        int i1 = 2;
        while (num4 <= 10) {
            num4 = num4 + i1;
            i1++;
        }
        System.out.println(num4);

        // *연산하거나 그 값을 가져다 쓰려면 변수에 값을 가지고 있어야 한다.


        // int sum; 불가
        int sum = 0;
        sum = sum + 3;

        // 무한반복 : ex) 24시간 웹서버
        //while (true) {
        //    System.out.println(">>loop<<");
        //}
        // for (;;) {}

        //do-while
        int num5 = 1;
        int sum2 = 0; // sum2에 연산하기 위해 초기값으로 초기화
        do {
            sum2 += num5;
            num5++;
        } while (num5 <= 10);
        System.out.println(sum2);

        // vs for
        sum2 = 0;
        for  (int num6 = 1; num6 <= 10 ; num6++) {sum2 += num6;}
        System.out.println(sum2); // 55

        // 관례
            // while : 무한루프 구현할 때 while(true){]
            // do-while : 반드시 한번 이상 수행해야할 때
            // for : 일반적인 경우

        // for문 중첩
        for (int dan = 2; dan <= 9; dan++) {
            System.out.printf("\n>> %d단 <<", dan);
            for (int times = 1; times <= 9; times++) {
                System.out.printf("\n%d X %d = %2d", dan, times, dan* times);
            }
        }
        System.out.println();

        // continue : 이후 문장을 수행하지 않고 다음 루프로 넘김
            // 특정 조건 하에서 건너뛰기할 때 주로 쓰인다
        int total = 0;
        for(int numa = 1; numa <=100; numa++) {
            // numa 짝수이면 continue
            if (numa % 2 == 0) {continue;}
            total += numa;
        }
        System.out.println(total);

        // break
        int sum_b = 0;
        int num_b = 0;
        for (num_b = 0; sum_b < 100; num_b++) {
            sum_b += num_b;
        }
        System.out.println("1. num_b : " + num_b);
        System.out.println("1. sum_b : " + sum_b);

        sum_b = 0; num_b = 0;

        for (num_b = 0; ; num_b++) {
            sum_b += num_b;
            if (sum_b >= 100)
                break;
        }
        System.out.println("2. num_b : " + num_b);
        System.out.println("2. sum_b : " + sum_b);

        // p123 문제
        // 1.
        int num1 = 10;
        int num2 = 2;
        int result1 = 0;
        char operator = '+';
        if (operator == '+')
            result1 = num1 + num2;
        else if (operator == '-')
            result1 = num1 - num2;
        else if (operator == '*')
            result1 = num1 * num2;
        else if (operator == '/')
            result1 = num1 / num2;

        switch (operator) {
            case '+' :
                result1 = num1 + num2;
                break;
            case '-' :
                result1 = num1 - num2;
                break;
            case '*' :
                result1 = num1 * num2;
                break;
            case '/' :
                result1 = num1 / num2;
                break;

        }

        // 문제 2.
        for (int dan = 2; dan <= 9; dan++) {
            if (dan % 2 == 1)
                continue;
            System.out.println(">> " + dan + "단 <<");
            for (int i = 1; i <= 9; i++) {
                System.out.println(dan + " X " + i + " = " + (dan*i));
            }
        }

        // 문제 3.
        for (int i = 2; i <= 9; i++) {
            System.out.println(">> " + i + "단 <<");
            for (int j = 1; j <= 9; j++ ) {
                if (i < j)
                    break;
                System.out.println(i + " X " + j + " = " + (i*j));
            }
        }


    }
}
