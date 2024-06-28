package day16.controller; // day16폴더의 controller 폴더/클래스, MemberView 뷰와 MemberDAO DAO간의 연결부 & 현재 로그인값 저장

import day16.model.DAO.MemberDAO; // day16폴더의 model 폴더의 DAO 폴더/패키지의 MemberDAO클래스를 불러온다 -> DAO쪽으로 데이터를 주고받는다
import day16.model.DTO.MemberDTO; // day16폴더의 model 폴더의 DAO 폴더/패키지의 MemberDTO클래스를 불러온다 : 데이터 "포장" 역할을 하는 객체

public class MemberController { // MemberController class 시작
    //2-1. 로그인 성공한 회원의 번호 저장하는 멤버변수
    // - 글쓰기, 댓글쓰기할때 현재 로그인된 회원을 식별하기 위해서
    // - 초기값 : 0, 비로그인상태, 1~ : 로그인 된 회원번호
    public static int loginMno = 0;
    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성 및 memController 변수명으로 주소값 저장
    public static MemberController memController = new MemberController();

    //1. 회원가입 화면 함수
    public boolean signUp(MemberDTO memberDTO){
        return MemberDAO.mDAO.signUp(memberDTO);
    }
    // MemberDAO의 signUp() 함수에 (MemberView에서 보낸) memberDTO 객체를 전달해주고 - 회원가입 성공/실패 true/false boolean 값을 받아온다
    // 그 boolean값을 그대로 (MemberView 클래스로) 반환해준다.

    //2-1. 로그아웃 함수
    public void logOut() { // logOut() 시작
        loginMno = 0; //현재 로그인한 회원의 mno값을 갖는 static변수에 0 대입 = 초기값인 비로그인상태로
    } // logOut() 함수 끝

    //2. 로그인 화면
    public boolean login(MemberDTO memberDTO){ // login() 시작
        int result = MemberDAO.mDAO.login(memberDTO);
        // MemberDAO의 login() 함수에 (MemberView에서 보낸) memberDTO 객체를 전달해주고 - 로그인 성공시 현재 회원의 mno, 실패시 0을 리턴값으로 받는다
        loginMno = result;
        // DAO의 login()함수 결과값 (mno 또는 0)을 loginMno static 변수에 대입한다
        // 로그인 실패시 0을 대입 -> 계속 로그아웃된 상태, mno값 대입 -> 현재 로그인된 회원의 mno값
        return result!=0;
        // result가 0이 아니다 = true 리턴, result가 0이다 = false 리턴
        // result가 0이 아니면 mno값이 대입된 것이므로 로그인 성공 (true), result가 계속 0일시 로그인 실패이므로 (false)
    } // login()함수 끝

    //3. 아이디찾기
    public String findID(MemberDTO memberDTO){ // findID() 시작
        return MemberDAO.mDAO.findID(memberDTO);
        // MemberDAO의 findID() 함수에 (MemberView에서 보낸) memberDTO 객체를 전달해주고
        // 찾은 ID값이 있으면 찾은 ID를 String으로, 찾은 ID가 없으면 null을, 예외처리가 되었으면 ""을 DAO에서 받아 그대로 (MemberView 클래스로) 반환
    } // findID() 끝

    //4. 비밀번호찾기
    public String findPW(MemberDTO memberDTO){ // findPW() 시작
        return MemberDAO.mDAO.findPW(memberDTO);
        // MemberDAO의 findPW() 함수에 (MemberView에서 보낸) memberDTO 객체를 전달해주고
        // 찾은 비밀번호 값이 있으면 String 타입으로, 찾은 비밀번호가 없거나 예외처리가 되었으면 ""을 DAO에서 받아 그대로 (MemberView 클래스로) 반환
    }// findPW() 끝

    //5. 회원탈퇴
    public boolean memberDelete(String pw){ // memberDelete() 시작
        if (MemberDAO.mDAO.memberDelete(pw, loginMno)){
            // MemberDAO의 memberDelete() 함수에 (MemberView에서 보낸) memberDTO 객체와
            // 현재 로그인된 회원 코드인 static변수 loginMno 값을 전달해주고 DAO에서 탈퇴처리가 성공하면 true, 아니면 false값을 리턴받는다
            // 회원 탈퇴가 성공했으면(if(true)) 로그아웃처리를 해주고 true boolean값을 (MemberView 클래스로) 반환, 탈퇴 실패시 false값을 반환
            loginMno = 0; // 로그아웃처리 : loginMno = 0
            return true; // if(true)이므로 회원 탈퇴 성공했음을 MemberView에 전달
        } else {return false;} // if(false)이므로 회원 탈퇴 실패했음을 전달
    } // memberDelete() 끝

    //6. 회원수정
    public boolean memberUpdate(String newName, String newPhone) { // memberUpdate() 시작
        return MemberDAO.mDAO.memberUpdate(newName,newPhone,loginMno);
        // MemberDAO의 memberUpdate() 함수에 (MemberView에서 보낸) 새 이름 newName, 새 연락처 newPhone 매개변수값과
        // 현재 로그인된 회원 코드인 static변수 loginMno 값을 전달해주고 DAO에서 수정 성공하면 true, 아니면 false값을 리턴받는다
        // 회원 정보 수정이 성공했으면 true boolean값을 (MemberView 클래스로) 반환, 수정 실패시 false값을 반환
    } // memberUpdate() 끝

} // MemberController 클래스 끝
