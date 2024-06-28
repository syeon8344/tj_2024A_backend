package day16; // day16 폴더/패키지에 위치

import day16.view.MemberView; // day16 폴더의 view 폴더의 MemberView 클래스를 불러온다

public class AppStart { // class 시작
    public static void main(String[] args) { // main 함수 시작
        MemberView.mView.index(); // MemberView 클래스 내 static 객체 mView의 index() 함수를 불러온다 - 메인 화면으로
    } // main 함수 끝
} // class 끝
