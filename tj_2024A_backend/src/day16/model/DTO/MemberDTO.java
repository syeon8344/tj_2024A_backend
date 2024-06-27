package day16.model.DTO;

public class MemberDTO { //이동 객체
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


    @Override
    public String toString() {
        return "MemberDTO{" +
                "mid='" + mid + '\'' +
                ", mpw='" + mpw + '\'' +
                ", mname='" + mname + '\'' +
                ", mphone='" + mphone + '\'' +
                ", mdate='" + mdate + '\'' +
                ", mno=" + mno +
                '}';
    }

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }

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
