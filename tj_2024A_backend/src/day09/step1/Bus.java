package day09.step1;

public class Bus {
    int busNumber;
    int passengerCount;
    int money;

    // alt insert + 생성자 + 멤버변수 선택

    public Bus(int busNumber) {
        this.busNumber = busNumber;
    }

    public void take( int money){
        this.money += money;
        passengerCount++;
    }

    // 생성 -> toString()
    //그냥 객체.toString() = 객체의 주소값
    @Override
    public String toString() {
        return "Bus{" +
                "busNumber=" + busNumber +
                ", passengerCount=" + passengerCount +
                ", money=" + money +
                '}';
    }
}
