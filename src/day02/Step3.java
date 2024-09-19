package day02;

public class Step3 {

    public static void main(String[] args) {

        // 기본연산자
            // 연산자 : 연산에 사용되는 기호
            // 항 : 연산에 사용되는 값 : 단항 이항 삼항
            // 부호연산자 : +값 = 양수, -값 = 음수

        int x = 10;     int y = -3;
        // 1. 산술연산자 : + - * / % | 더하기 뺴기 곱하기 나누기(int => 몫) 나머지
        System.out.println(x + y);  // 7
        System.out.println(x - y);  // 13
        System.out.println(x * y);  // -30
        System.out.println(x / y);  // -3 | double일 떄 -3.33333...
        System.out.println(x % y);  // 1

        // 2. 연결연산자 : +연결연산자 (항에 문자/문자열이 포함된 경우)
        System.out.println("x + y = " + x + y); // x + y = 10-3
        System.out.println("x + y = " + (x+y)); // x + y = 7

        // 3. 비교연산자 : == 같다 != 같지 않다 > < >= <=
        System.out.println(x == y); // false
        System.out.println(x != y); // true
        System.out.println(x > y); // true
        System.out.println(x >= y); // true
        System.out.println(x < y); // false
        System.out.println(x <= y); // false

        // 4. 논리연산자 : && AND || OR ! NOT
        System.out.println(x > 5 && x < 20); // true
        System.out.println(y == -5 || y < 0);
        System.out.println(!(x >=20)); // !false -> true

        // 5. 복합대입연산자
            // = 대입연산자 : 오른쪽 값을 왼쪽에 대입한다
            // += -+ ^= /= %= : 오른쪽 값을 왼쪽값과 연산후 결과를 왼쪽에 대입
        int z = 30;

        // 6. 증감연산자 : ++변수 : 선위증가 | 변수++ : 후위증가

        System.out.println(z++); // 30 + 1 = 31 (hidden)
        System.out.println(++z); // 31 + 1 = 32, 33{hidden)

        z++; // 증감 우선순위는 하나의 ; 세미콜론 안에서 결정

        // 7. 삼항연산자 조건 >참 ? 거짓      조건1 ? 참1 :조건2 ? 참2 : 거짓
        char result4 = z >= 30 ? 'T' : 'F';
        System.out.println("result4 = " + result4);
        char result2 = z >= 50? 'T' : z >= 30? 'T' : 'F';

    }
}
