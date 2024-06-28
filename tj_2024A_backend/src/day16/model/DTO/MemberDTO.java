package day16.model.DTO; // day16 폴더의 model폴더의 DTO 폴더/패키지 위치, Member MVC 간의 자료 전달 객체

public class MemberDTO { //데이터 이동 객체 Data Transfer Object
    // 1. 멤버변수 = DB필드와 동일
    private String mid;
    private String mpw;
    private String mname;
    private String mphone;
    private String mdate;
    private int mno;
    // 기본생성자
        // Overloading : 매개변수의 타입, 순서, 갯수가 다를 때 생성자 여러개 생성가능
        //               매개변수의 타입, 순서, 갯수가 같고 이름만 다르면 오버로딩 X
    public MemberDTO(){};
    // 전체생성자
    public MemberDTO(String mid, String mpw, String mname, String mphone, String mdate, int mno) {
        this.mid = mid;
        this.mpw = mpw;
        this.mname = mname;
        this.mphone = mphone;
        this.mdate = mdate;
        this.mno = mno;
    }
    //회원가입용 생성자
    public MemberDTO(String id, String pw, String name, String phone) {
        this.mid = id;
        this.mpw = pw;
        this.mname = name;
        this.mphone = phone;
    }
    // 3. 메소드 : 1.getter setter 2.toString

    // Alt + Insert -> toString()
    @Override // 기본 객체.toString()은 객체의 주소값을 불러온다 -> 함수를 덮어쓰기해서 대신 객체 정보를 보여준다
    public String toString() { // 오버라이드된 toString() 시작
        return "MemberDTO{" +
                "mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    } // toString() 끝

    // 각 매개변수들의 getter와 setter들 : 매개변수들이 private 상태이므로 외부에서 직접 접근이 불가능하므로
    // 클래스 내부의 getter setter 함수들로 간접적으로 접근할 수밖에 없다.
    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
    // this.변수명 : 객체마다의 스스로의 매개변수, 멤버변수와 함수의 매개변수가 이름이 같아 헛갈릴 수 있을 때 확인용

    public String getMpw() {
        return mpw;
    }

    public void setMpw(String mpw) {
        this.mpw = mpw;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public String getMphone() {
        return mphone;
    }

    public void setMphone(String mphone) {
        this.mphone = mphone;
    }

    public String getMdate() {
        return mdate;
    }

    public void setMdate(String mdate) {
        this.mdate = mdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }
}
