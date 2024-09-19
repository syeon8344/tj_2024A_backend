package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Step5_학생성적 {
    public static void main(String[] args) {
//        Student studentLee = new Student(1001, "Lee");
//        studentLee.addSubject("국어", 100);
//        studentLee.addSubject("수학", 50);
//
//        Student studentKim = new Student(1002, "Kim");
//        studentKim.addSubject("국어", 70);
//        studentKim.addSubject("수학", 85);
//        studentKim.addSubject("영어", 100);
//
//        studentLee.showStudentInfo();
//        System.out.println("=====================================");
//        studentKim.showStudentInfo();


        /*

            학생목록 리스트 만들기
            [학생등록] 1. 학번과 이름 입력받아 학생 객체 생성, 학생목록 리스트에 저장
            [점수등록]
                1. 학번 입력받아 동일한 학번이 있으면
                2. 과목명과 점수 입력받아 해당 학번 학생의 점수리스트에 점수 저장하기
            [점수확인]
                1. 학번 입력받아 동일한 학번이 있으면
                2. 해당 학번 학생의 모든 점수리스트 출력
         */

        Scanner scanner = new Scanner(System.in);
        ArrayList<Student> sList = new ArrayList<>();

        while (true){
            System.out.println("현재 리스트 : " + sList);
            System.out.print(">>1.학생등록 2.점수등록 3.점수확인 4.학생삭제 5.종료 선택 : "); int ch = scanner.nextInt();
            if ( ch == 1 ){
                System.out.print(">>학번을 입력해주세요 : "); int newID = scanner.nextInt();
                for (Student s : sList){ // 학번 중복검사
                    if (s.studentID == newID){
                        System.out.println(">>학번이 이미 존재합니다");
                        break;
                    }
                }
                System.out.print(">>학생 이름을 입력해주세요 : "); String studentName = scanner.next();
                Student s = new Student(newID, studentName);
                sList.add(s);

            }

            else if ( ch == 2 ){
                System.out.print(">>학번을 입력해주세요 : "); int editID = scanner.nextInt();
            }

            else if ( ch == 3 ){

            }

            else if ( ch == 4 ){

            }

            else if ( ch == 5 ){
                System.out.println(">>프로그램을 종료합니다.");
                break;
            }

            else {
                System.out.println(">>입력이 잘못되었습니다.");
            }
        }

    }
}
