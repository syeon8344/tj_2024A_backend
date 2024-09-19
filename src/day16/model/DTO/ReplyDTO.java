package day16.model.DTO;

public class ReplyDTO {
    // DATA TRANSFER OBJECT
    // MVC 구역별 데이터를 묶어서 구역 간 이동하는 객체
        // private 멤버변수, public 생성자, public getter & setter
    // 1. 멤버변수
    private String rcontent;
    private String rdate;
    private int mno;
    private int bno;
    private int rno;
    // 회원ID
    private String mid;

    public String getMid() {
        return mid;
    }

    public void setMid(String mid) {
        this.mid = mid;
    }
// 2. 생성자

    // 3. getter & setter
    public String getRcontent() {
        return rcontent;
    }

    public void setRcontent(String rcontent) {
        this.rcontent = rcontent;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getRno() {
        return rno;
    }

    public void setRno(int rno) {
        this.rno = rno;
    }
}
