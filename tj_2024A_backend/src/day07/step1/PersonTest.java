package day07.step1;

public class PersonTest {
    public static void main(String[] args) {

        // [1] 객체 만들기
            // 1. 타입/클래스명(설계도 선택) 작성
            // 2. 객체를 담을 임의변수명 작성
            // 3. 객체/인스턴스를 생성해서 변수에 담는다
            // new 생성자명();
        Person personLee = new Person();
        // 1      2            3
        personLee.name = "이강인";

        Person personKim = new Person("Kim");

        Person personPark = new Person("Kim", 175, 75);    }
}
