package day12.step1;

public class Customer {
    // 멤버변수 - 객체내 속성 값
        // 접근제한자.txt
        // public : 다른 클래스로부터 접근 가능, 호출 가능
        // private : 다른 클래스로부터의 접근을 제한, 현재 클래스에서만 사용가능
        // 정적변수
        // static : 메소드영역(데이터 영역)에 저장되는 변수, 객체가 없어도 사용이 가능
    protected int customerID;
    protected String customerName;
    protected String customerGrade;
    int bonusPoint;
    double bonusRatio;

    // 생성자 - (new) 객체 생성시 사용되는 메서드, 반환타입이 없다
        // 오버로딩 : 생성자명은 동일하지만 매개변수 개수, 타입, 선언순서가 다르면 여러개 가능
        // 클래스 내 생성자가 한개도 없으면 default 기본 생성자 제공
            // 한 개 이상 존재하면 기본 생성자 자동 생성 X
            // 객체 생성시 멤버변수 초기화 또는 유효성검사 진행시 사용
    public Customer(){
        customerGrade = "SILVER";
        bonusRatio = 0.01;
    }

    // 메서드 : 함수, 객체의 사용방법/행위/행동
        // 접근제한자.txt static 반환타입 함수명(매개변수들)

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerGrade() {
        return customerGrade;
    }

    public void setCustomerGrade(String customerGrade) {
        this.customerGrade = customerGrade;
    }

    public int calcPrice(int price){
        this.bonusPoint += price * this.bonusRatio;
        return price;
        // this : 매개변수와 멤버변수 구분하기 위해 / 해당 함수를 실행한 객체 구분용

    }
    public String showCustomerInfo(){
        return customerName + " 님의 등급은 " + customerGrade + "이며, 보너스 포인트는 " + bonusPoint + "포인트입니다.";
    }
}
