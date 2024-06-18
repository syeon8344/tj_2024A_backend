package day09.step1;

public class Taxi {
    String taxiNumber;
    int money;
    int passengerCount;

    public Taxi(String taxiNumber) {
        this.taxiNumber = taxiNumber;
    }

    public void take(int money){
        this.money += money;
        passengerCount++;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "taxiNumber='" + taxiNumber + '\'' +
                ", money=" + money +
                ", passengerCount=" + passengerCount +
                '}';
    }
}
