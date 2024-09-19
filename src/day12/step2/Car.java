package day12.step2;

public class Car {
    // 멤버변수
    public int speed;

    // 생성자

    // 메서드
    public void speedUp(){this.speed += 1;}
    public void stop(){this.speed = 0;}
}

class SportCar extends Car { // extends : 상속
    // 상속 : 빠른 개발 - 기존에 있던 설계도를 물려받아 커스터마이징으로 새로운 설계도 제작
    public int power;

}
