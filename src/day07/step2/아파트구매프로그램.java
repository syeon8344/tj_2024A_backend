package day07.step2;

public class 아파트구매프로그램 {
    public static void main(String[] args) {
        아파트설계도 유재석집 = new 아파트설계도("초코파이");
        System.out.println("유재석집 = " + 유재석집);
        //유재석집 = day07.step2.아파트설계도@41629346 : 객체가 존재하는 메모리 주소
        System.out.println(유재석집.음식꺼내기("1234"));
        아파트설계도 강호동집 = new 아파트설계도("쓰레기");
        System.out.println("강호동집 = " + 강호동집);
        //강호동집 = day07.step2.아파트설계도@404b9385 : 객체가 존재하는 메모리 주소
        System.out.println(강호동집.음식꺼내기("1234"));

        //클래스의 메서드 : 객체들이 공유한다 (객체 변수명으로 구분되므로)
        // => 각 객체가 저장하고 있는 것들: 멤버변수들 (메서드 X)
    }
}
