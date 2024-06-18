package 과제;

import 과제.level4.Guestbook;
import 과제.level4.Member;
import 과제.level4.Product;

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
        //          설계도 역할을 하는 클래스를 통해 만들어진 멤버 변수와 메서드를 가질 수 있으며
        //          인스턴스화해서 컴퓨터 메모리에 물리적으로 존재할 수 있는 것을 말한다.

        // 2. 클래스란 객체를 구현할 때 쓰는 설계도나 main함수를 실행하는 기반이며 자바의 파일 단위이기도 하고
        //          파일명과 같은 이름의 클래스가 반드시 들어 있어야 한다.

        // 3. 멤버변수란 어떤 객체의 고유한 특성을 뜻하고, JAVA에서는 객체가 인스턴스화/매모리에 구현될 때마다
        //          객체마다 고유하게 메모리에 같이 저장되는 값들이다.

        // 4. 지역변수는 함수 내에서 선언되어서 함수가 끝날 때 같이 사라지고, 멤버변수는 클래스 안에서 선언되어서
        //          객체가 인스턴스화되었을 때 같이 저장된 다음 객체가 GC에 의해 수거될 때 같이 사라진다.

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
        Member m1 = new Member("aaa", "1234", "아무개");
        Member m2 = new Member("bbb", "4321", "아무개1");

        System.out.printf("\n멤버 1 회원번호 : %d, 아이디 : %s, 비밀번호 : %s, 이름 : %s", m1.getNo(), m1.getId(), m1.getPw(), m1.getName());
        System.out.printf("\n멤버 2 회원번호 : %d, 아이디 : %s, 비밀번호 : %s, 이름 : %s", m2.getNo(), m2.getId(), m2.getPw(), m2.getName());

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

        Product p1 = new Product("콜라", 1200, "2024-06-06");
        Product p2 = new Product("사이다", 1250, "2024-06-12");

        System.out.printf("\n제품 1 제품코드 : %d, 제품명 : %s, 가격 : %d, 등록일 : %s", p1.getProductNo(), p1.getProductName(), p1.getPrice(), p1.getAddedDate());
        System.out.printf("\n제품 2 제품코드 : %d, 제품명 : %s, 가격 : %d, 등록일 : %s", p2.getProductNo(), p2.getProductName(), p2.getPrice(), p2.getAddedDate());

    }
}
