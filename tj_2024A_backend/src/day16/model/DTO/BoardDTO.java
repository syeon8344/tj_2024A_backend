package day16.model.DTO; // day16 폴더의 model 폴더의 DTO 폴더/패키지에 위치, Board MVC에서 데이터 전송시 "포장재"

public class BoardDTO { // class 시작
    private String btitle; //DB 테이블 열 필드명대로 멤버변수를 설정한다
    private String bcontent;
    private String bdate;
    private int bview;
    private int bno;
    private int mno;

    @Override
    public String toString() {
        return "BoardDTO{" +
                "btitle='" + btitle + '\'' +
                ", bcontent='" + bcontent + '\'' +
                ", bdate='" + bdate + '\'' +
                ", bview=" + bview +
                ", bno=" + bno +
                ", mno=" + mno +
                '}';
    }

    public String getBtitle() {
        return btitle;
    }

    public void setBtitle(String btitle) {
        this.btitle = btitle;
    }

    public String getBcontent() {
        return bcontent;
    }

    public void setBcontent(String bcontent) {
        this.bcontent = bcontent;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public int getBview() {
        return bview;
    }

    public void setBview(int bview) {
        this.bview = bview;
    }

    public int getBno() {
        return bno;
    }

    public void setBno(int bno) {
        this.bno = bno;
    }

    public int getMno() {
        return mno;
    }

    public void setMno(int mno) {
        this.mno = mno;
    }
} // class 끝
