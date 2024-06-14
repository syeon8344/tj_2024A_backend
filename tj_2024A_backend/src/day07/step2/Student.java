package day07.step2;

// public : (다른 클래스로부터, 외부) 공개용
    // public class 클래스명(){}
// private : (외부) 비공개용
    // public/private 아니면 (default) 멤버변수
    // public/private 반환타입 함수명(){}
// default (접근제어자 없을 때) 같은 패키지/폴더 내 클래스에게만 공개됨
public class Student {
    // 1. 멤버변수/필드
    int studentID;
    private String studentName;
    int grade;
    String address;
    // 2. 생성자

    // 3. 메소드

    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentName() {
        return studentName;
    }
}
