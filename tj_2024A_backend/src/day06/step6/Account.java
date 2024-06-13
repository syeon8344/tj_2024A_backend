package day06.step6;

public class Account {
    int balance;
    String number;

    public void addBalance(int num){
        balance += num;
        System.out.println("현재 잔액은 " + balance + "원 입니다");
    }

    public void subtractBalance(int num){
        if (balance < num) {
            System.out.println("현재 예금액을 초과하는 금액입니다!");
        } else {
            balance -= num;
            System.out.println("현재 잔액은 " + balance + "원 입니다");
        }
    }

    public int getBalance(){
        return balance;
    }

}
