package day06.step8;

import java.util.Random;

public class Calc {

    // 함수 정의 : 클래스 { } 안에서 | 멤버 함수 혹은 메서드
    // 함수 : 상자 속의 수 -> 상자 속의 코드
        // 쓰는 이유 : 미리 만든 코드 -> 재사용하기 위해, 코드 정리, ...
    // 변수 (값 저장) vs 함수 (실행문 저장)
    
    // 자바의 함수 선언방법
        // 반환타입 함수명(타입 매개변수명 1 , 타입 매개변수명 2, ...){
        //      다양한 로직, 실행문...
        //      return 반환값;
        //  }
    
    // 1. 반환타입 : return 문에 넣어준 값의 자료형/타입
        // return문에 넣어준 값이 없으면 void
    // 2. 함수명 : 임의, 카멜표기법
    // 3. 매개변수 : 함수 호출시 함수 안으로 넣어주는 값 ( = 인수 [들어가는 수])
    // 4. return 값;
        // 1. 함수 종료 2. 함수 종료후 호출 위치로 값을 반환하기 ( 함수 내 지역변수는 함수 종료시 사라진다)
    
    
    // 1. 매개변수가 있고 반환값이 있는 함수
    int sumMethod1(int x, int y){
        return x + y; // int + int = int
    }
    // 2. 매개변수가 없고 반환값이 있는 함수
    long sumMethod2(){
        // new Random().nextInt(); : int형 표현범위내 난수 랜덤생성
        return new Random().nextLong();
    }
    // 3. 매개변수가 없고 반환값도 없는 함수
    void sumMethod3(){
        System.out.println("sumMethod3()");
    }
    // 4. 매개변수가 있고 반환값이 없는 함수
    void sumMethod4(int x, int y){
        //soutp
        System.out.println("x = " + x + ", y = " + y);
    }
}
