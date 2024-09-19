package day06.step3;

// 클래스 정의 : 추상적으로 생각한 것을 구체적(속성/행위)으로 설계도를 작성한 작업:
// 객체를 설계할 설계도
public class Elevator {
    // 멤버변수/필드
    String model;
    int maxWeight;
    int currentWeight;
    int speed;
    int currentFloor;
    int pressedFloor;
    // 메소드 : 올라가기, 멈추기, 내려가기, 문열기, 문닫기

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public void setMaxWeight(int maxWeight) {
        this.maxWeight = maxWeight;
    }

    public int getCurrentWeight() {
        return currentWeight;
    }
}
