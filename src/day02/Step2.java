package day02;

public class Step2 { 
    
    public static void main(String[] args) {
        
        //형변환
        // 1. 묵시적/자동 형변환 : 메모리 크기가 큰 쪽으로, 더 정밀한 쪽으로
            // 데이터 손실이 없다
            // byte > short, char > int > long > float > double
        byte byteValue = 10;
        int intValue = byteValue; // byte > int 묵시적 형변환
        System.out.println("intValue = " + intValue);

        char charValue = '가';
        intValue = charValue; // char > int (2byte -> 4byte)
        System.out.println("intValue = " + intValue);
        
        intValue = 50;
        long longValue = intValue;
        System.out.println("longValue = " + longValue);

        longValue = 1000;
        float floatValue = longValue; // long > float (8byte -> 4byte) 부동소수점의 표현 단위가 더 큼, 더 정밀하므로 가능

        floatValue = 100.5F;
        double doubleValue = floatValue;

        // - 연산 중 묵시적 형변환
        // 1. byte, short -> int | 2. int, int -> int | 3. long + int -> long | 4. float + float -> float | 5. double + float -> double

        byte b1 = 10; byte b2 = 20;
        int result1 = b1 + b2; // byte + byte -> int, result1 자료형 : int

        byte b3 = 30; long l1 = 1000;
        long result2 = b3 + l1;

        char c1 = 'A'; char c2 = 'B';
        int result3 = c1 + c2; // char + char = int

        int i1 = 10; double d1 = 4.0;
        double result4 = i1 + d1;


        // 2. 명시적/강제 형변환 : 메모리 크기가 작은 쪽으로, 덜 정밀한 쪽으로
            // 데이터 손실 가능
            // double > float > long > int > short, char > byte
        int intValue2 = 10;
        // byte byteValue2 = intValue2; // 오류 : 4바이트를 1바이트에 저장할 수 없다
        byte byteValue2 = (byte)intValue2; // 강제 형변환 (byte)
        System.out.println("byteValue2 = " + byteValue2);

        long longValue2 = 400;
        byte byteValue3 = (byte)longValue2;
        System.out.println("byteValue3 = " + byteValue3);
        
        int intValue3 = 55553;
        char charValue2 = (char)intValue3;
        System.out.println("charValue2 = " + charValue2);
        
        double doubleValue2 = 22.44;
        int intValue5 = (int)doubleValue2;
        System.out.println("intValue5 = " + intValue5);
        
        char ch1 = 'A';
        int intValue6 = ch1;
        System.out.println("intValue6 = " + intValue6);
        
        int ch2 = 75;
        char charValue3 = (char)ch2;
        System.out.println("charValue3 = " + charValue3);
        
        // p.69 연습문제
        // 1. 예
        // 2. 아니오 [자동 X]
        // 3. 부동소수점
        // 4.
        int value1 = 10; double value2 = 2.0;
        int result = (int)(value1 + value2);
        System.out.println("result = " + result);
        // 5.
        char val3 = '글';
        int val4 = val3;
        System.out.println("val4 = " + val4);
        char val5 = 44544;
        System.out.println("val5 = " + val5);
    }
}
