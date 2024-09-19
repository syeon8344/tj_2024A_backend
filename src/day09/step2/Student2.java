package day09.step2;

public class Student2 {
    // 필드
    //1. 정적변수/클래스변수
    private static int serialNum = 1000;
    //2. 멤버변수
    public int studentID;
    public String studentName;

    public Student2() {
        serialNum++;
        this.studentID = serialNum;
    }

    public String getStudentName() {
        return studentName;
    }

    public static int getSerialNum() {
        // static 함수 내에서는 멤버변수 사용불가
        return serialNum;
    }

    public static void setSerialNum(int serialNum) {
        Student2.serialNum = serialNum;
    }

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
