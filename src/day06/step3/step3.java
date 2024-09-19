package day06.step3;

public class step3 {

    public static void main(String[] args) {
        // 1. 객체 생성
        Elevator e1 = new Elevator();
            // 1. 클래스명
            // 2. 변수명
            // 3.  = 대입
            // 4. new 연산자
            // 5. 생성자명(); 생성자명과 클래스명 동일

        // 1. 두번째 객체 생성
        Elevator e2 = new Elevator();

        // 2. 객체의 멤버(필드/메소드) 접근/참조하기
            // 객체 안에 들어가서 객체가 가지고 있는 것들을 사용
        e1.model = "OTIS";
        e1.maxWeight = 1000;
        e1.currentWeight = 300;
        e1.speed = 40;
        e1.pressedFloor = 5;

        System.out.println("e1.model = " + e1.model);
        System.out.println("e1.maxWeight = " + e1.maxWeight);
        System.out.println("e1.currentWeight = " + e1.currentWeight);
        System.out.println("e1.speed = " + e1.speed);
        System.out.println("e1.pressedFloor = " + e1.pressedFloor);

        System.out.println("e1 currentWeight = " + e1.getCurrentWeight()); // currentWeight 반환 함수

        e2.model = "OTIS";
        e2.maxWeight = 500;
        e2.currentWeight = 120;
        e2.speed = 46;
        e2.pressedFloor = 7;

        System.out.println("e2.model = " + e2.model);
        System.out.println("e2.maxWeight = " + e2.maxWeight);
        System.out.println("e2.currentWeight = " + e2.currentWeight);
        System.out.println("e2.speed = " + e2.speed);
        System.out.println("e2.pressedFloor = " + e2.pressedFloor);

        System.out.println("e2 currentWeight = " + e2.getCurrentWeight());
    }
}
