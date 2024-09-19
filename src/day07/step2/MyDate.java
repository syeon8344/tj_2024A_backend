package day07.step2;

public class MyDate {
    private int day;
    private int month;
    private int year;
    private boolean isValid = true;

    // 생성자 : 객체 생성시 객체의 멤버변수 초기화할 때 사용
        // 객체내 멤버변수와 생성자의 매개변수명이 동일할 때
        // 1. 변수명을 다르게 하기. 만일 다르면 코드 작성시 가독성 떨어짐
        // 2. 가독성 위해 변수명 동일할 때 this 키워드 이용해 구분하기
            // this.멤버변수 : 현재 객체의 멤버변수 호출하기
    MyDate(int pday, int pmonth, int pyear) {
        // 저장과 유효성 검사 한번에 하기
        if (pday < 1 || pday > 31) isValid = false;
        if (pmonth < 1 || pmonth > 12) isValid = false;
        if (pyear < 1900 || pyear > 9999) isValid = false;
        if ((pyear % 4 == 0 && pyear % 100 != 0) || pyear % 400 == 0)
            if (pmonth == 2 && pday > 28)
                isValid = false;
        this.day = pday;
        this.month = pmonth;
        this.year = pyear;
    }

    public String isValid(){
        if (!isValid) {
            return "유효하지 않은 날짜입니다.";
        }
        else {
            return "유효한 날짜입니다.";
        }
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
