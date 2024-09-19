package day02; // 클래스파일이 위치한 패키지명(폴더명)

public class Step1 { // 모든 코드를 클래스 안에 작성해야 한다

    //main + 엔터 = main 함수, 실행할 코드를 모두 main 함수(스레드) 안에 작성
    // 지역변수 정의, 함수 호출
    public static void main(String[] args) {
        
        // p61. 상수 : 변하지 않는 수
        // final 예약어/키워드
        final int MAX_NUM = 100;
        System.out.println("MAX_NUM = " + MAX_NUM);
        
        // MAX_NUM = 1000; // 상수 값 변경 불가
        
        final int MIN_NUM;
        
        MIN_NUM = 0;
        System.out.println("MIN_NUM = " + MIN_NUM);
        // soutv + enter : 가장 가까운 변수 출력 함수 자동완성
        // 코드 실행 : 1. ctrl + shift + F10, 2. main함수 초록 화살표
    }
}
