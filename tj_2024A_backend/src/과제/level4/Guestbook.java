package 과제.level4;

public class Guestbook {
    //Level4_2
    private int recordNum;
    private String content;
    private String date;
    private String writer;
    private int count = 0;


    public Guestbook (String writer, String date, String content){
        this.writer = writer;
        this.date = date;
        this.content = content;
        this.recordNum = count;
        count++;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getRecordNum() {
        return recordNum;
    }

}
