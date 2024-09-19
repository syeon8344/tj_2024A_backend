package day07.step2;

public class 아파트설계도 {

    // 멤버변수
    private String 냉장고;
    private String 패스워드 = "1234";
    // 생성자
    아파트설계도 (String 초기음식){
        if (초기음식.equals("쓰레기")){}
        else { this.냉장고 = 초기음식;}
    }
    // 메서드
        //getter
    public String 음식꺼내기(String 입력패스워드) {
        if (입력패스워드.equals("1234")) {
            return 냉장고;
        } else {return "";}
    }
        //setter
    public void 음식저장(String 음식) {
        if (!(음식.equals("쓰레기"))) {
            냉장고 = 음식;
        }
    }
}
