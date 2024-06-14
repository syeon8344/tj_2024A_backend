package 과제;

import 과제.level4.Guestbook;

import java.time.LocalDateTime;

public class Level4 {
    public static void main(String[] args) {
        // Level4_1
        System.out.println("\n >> Level4-1 answer >>");

            // 용어 정의하기
            /*
                1. 객체란?

                2. 클래스란?

                3. 멤버변수/필드/속성/특성 이란?

                4. 지역변수와 멤버변수의 차이점을 서술하시오.

             */

        // 1. 객체란 추상적으로는 눈에 보이는/ 보이지 않는, 고유 속성이나 행동을 가진 모든 것이고,
        //          설계도 역할을 하는 클래스를

        // Level4_2
        System.out.println("\n >> Level4_2 answer >>");

            // "방문록" 설계하고 만들기
            /*
                [클래스 생성]
                멤버변수/필드 : 방문록번호, 내용, 작성일, 작성자
                        - 위 필드를 적절한 자료형을 선택하여 설계하시오.

                [ 객체 생성 ]
                임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.

             */

        Guestbook g1 = new Guestbook("아무개1", "2024-06-06", "안녕하세요");
        Guestbook g2 = new Guestbook("아무개2", "2024-06-08", "안녕하세요1");
        System.out.printf("\n방명록 g1 작성자 : %s, 날짜 : %s, 내용 : %s", g1.getWriter(), g1.getDate(), g1.getContent());
        System.out.printf("\n방명록 g2 작성자 : %s, 날짜 : %s, 내용 : %s", g2.getWriter(), g2.getDate(), g2.getContent());

        // Level4_3
        System.out.println("\n >> Level4_3 answer >>");

            // "회원" 설계하고 만들기
            /*
                [ 클래스 생성 ]
	            멤버변수/필드 : 회원번호 , 아이디 , 비밀번호 , 이름
		        - 위 필드을 적절한 자료형을 선택하여 설계하시오.

	            [ 객체 생성 ]
	            임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.

             */


        // Level4_4
        System.out.println("\n >> Level4_4 answer >>");

            // "제품" 설계하고 만들기
            /*
                [ 클래스 생성 ]
	            멤버변수/필드 : 제품코드 , 제품명 , 가격 , 등록일
		        - 위 필드을 적절한 자료형을 선택하여 설계하시오.

	            [ 객체 생성 ]
	            임의의 데이터를 입력하여 2개의 객체를 생성하고 출력하는 코드를 작성하시오.
             */



    }
}
