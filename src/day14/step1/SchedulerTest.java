package day14.step1;

import java.io.IOException; //Scanner 와 같은 역할

public class SchedulerTest {
    public static void main(String[] args) throws IOException{
        System.out.println("전화 상담 할당 방식을 선택하세요.");
        System.out.println("R : 한명씩 차례로 할당");
        System.out.println("L : 쉬고 있거나 대기가 가장 적은 상담원에게 할당");
        System.out.println("P : 우선순위가 높은 고객 먼저 할당");

        int ch = System.in.read();
        Scheduler scheduler = null; //Scheduler scheduler; 이렇게 선언해도 상관 없음. //기본값을 roundrobin 이여도 상관없음


        if(ch == 'R' || ch == 'r') { //R을 입력받으면 RoundRobin 클래스를 생성
            scheduler = new RoundRobin();
        }
        else if (ch == 'L' || ch == 'l'){ //L을 입력받으면 RoundRobin 클래스를 생성
            scheduler = new LeastJob();
        }
        else if (ch == 'P' || ch == 'p') { //P을 입력받으면 RoundRobin 클래스를 생성
            scheduler = new PriorityAllocation();
        }
        else {
            System.out.println("지원되지 않는 기능입니다.");
            return; //함수종료
        }

        scheduler.getNextCall(); //각 클래스에 포함된 메소드 print 출력
        scheduler.sendCallToAgent(); //각 클래스에 포함된 메소드 print 출력
    }
}

//추상메소드 : 형체가 없는 구현코드/실행문실행구역 가 없다 .
//공통적 : 실질적인 구현을 하는것이아니라 명세와 약속을 하는곳이라서.
//실질적인 기능 : class
//class에서 implements(구현) override(덮어씌우기) 구현을 안하면 오류뜸 구현을 안했으니까
//extends 는 override 선택 () implements 는 필수
//override 메소드 재정의
//인터페이스란 : 사용설명서 , 서로다른 클래스를 하나의 변수가 (관리,조작) ,클래스 중복을 줄이기위한 기능의 모음 [상속과 비슷]
//클래스설계 하다 공통의 기능이보이면 인터페이스 생성
//동일한 목적의 형태를 표현한것 : 다형성 (밥먹기)
//오버라이딩 + 타입변환 : 자바의특징이며 주로 인터페이스에서 사용된다.
