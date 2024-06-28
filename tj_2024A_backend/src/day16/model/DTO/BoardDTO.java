package day16.model.DTO; // day16 폴더의 model 폴더의 DTO 폴더/패키지에 위치, Board MVC에서 데이터 전송시 "포장재"

public class BoardDTO { // class 시작
    private String btitle; //DB 테이블 열 필드명대로 멤버변수를 설정한다
    private String bcontent;
    private String bdate;
    private int bview;
    private int bno;
    private int mno;
} // class 끝
