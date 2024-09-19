package day07.step1;

    // 클래스의 사용처
        // 1. 객체의 설계도
        // 2. main 함수 가지고 있는 실행클래스

// [1. 사람 객체의 설계도]
public class Person {
        // 1. 멤버변수 / 필드
        String name;
        float height;
        float weight;
        // 2. 생성자
                // 1. 생성자명은 클래스명과 동일
                // 2. 반환/return이 없으므로 반환타입이 생략된다
                // 3. 디폴트/기본 생성자는 컴파일/실행시 자동 생성
                        // 클래스 내 생성자가 없을 때만

        // 1. 기본 생성자
        Person(){}
        // 2. 매개변수 1개 사용 생성자
        Person(String pname) {
                name = pname;
                        // name : 멤버변수
                        // pname : 매개변수
        }
        Person(String pname, float pheight, float pweight){
                name = pname;
                height = pheight;
                weight = pweight;
        }
        // 3. 메소드 / 함수
        void person_() {}

}
