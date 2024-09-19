package day10;


import java.util.ArrayList;

public class Student {
    int studentID;
    String studentName;
    ArrayList<Subject> subjectList;

    public Student(int studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.subjectList = new ArrayList<>();
    }

    public void addSubject(String name, int score){
        Subject s = new Subject();
        s.setName(name); s.setScore(score);
        subjectList.add(s);
    }

    public void showStudentInfo(){
        int sum = 0;
        for (Subject s : subjectList){
            sum += s.getScore();
            System.out.println("학생 " + studentName + "의 " + s.getName() + "과목 성적은 " + s.getScore() + "점 입니다.");
        }
        System.out.println("학생 " + studentName + "의 총점은 " + sum + "점 입니다.");
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentID=" + studentID +
                ", studentName='" + studentName + "'}";
    }
}
