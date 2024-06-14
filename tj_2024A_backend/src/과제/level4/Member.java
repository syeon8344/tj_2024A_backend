package 과제.level4;

public class Member {
    private int no = 10000;
    private String id;
    private String pw;
    private String name;
    private int count = 0;

    public Member(String id, String pw, String name) {
        this.id = id;
        this.pw = pw;
        this.name = name;
        this.no = no + count;
        count++;
    }

    public int getNo() {
        return no;
    }

    public String getId() {
        return id;
    }

    public String getPw() {
        return pw;
    }

    public String getName() {
        return name;
    }

}
