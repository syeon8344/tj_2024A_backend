package day16.view; //day16 폴더의 view 폴더/패키지에 위치, MemberView에서 로그인시 넘어오고 로그아웃,회원정보수정,회원탈퇴,게시판 메뉴

import day16.controller.MemberController; //day16 폴더의 controller폴더/패키지의 MemberController 클래스 불러오기
// logOut() 함수 사용을 위해

import java.util.Scanner; // JAVA의 util 라이브러리의 Scanner 클래스 불러오기 : 키보드 입력 받기 위해

public class BoardView { // BoardView 클래스 시작

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성
    public static BoardView bView = new BoardView();

    //멤버변수 : 입력객체 생성 및 주소값을 scan 변수명으로 저장
    Scanner scan = new Scanner(System.in); // static은 프로그램 실행 시 바로 실행되어 메소드 메모리에 저장, 다른 class에서 호출가능

    //0. 초기화면 함수
    public void index(){ // index() 함수 시작
        while(true){ // 무한루프 시작
            System.out.print(">>1.로그아웃 2.회원수정 3.회원탈퇴 4.게시판 : "); // 게시판 메뉴문구 출력
            try { // scan 객체 예외처리를 위한 try-catch 시작
                int ch = scan.nextInt(); // 키보드 입력으로 정수를 받아 ch 함수명에 저장
                if (ch==1){ //ch=1일시 로그아웃
                    logOut(); // MemberController 클래스에서 loginMno = 0 설정하는 함수 = 로그아웃
                    return; // 원래 위치로 이동 : MemberView의 무한루프 내부 : 메인메뉴로 돌아간다
                } // if (ch==1) 끝
                else if (ch==2){ //ch=2일시 회원수정
                    memberUpdate(); // 새 회원명, 새 회원 연락처를 받아 수정하는 함수
                } // else if (ch==2) 끝
                else if (ch==3){ //ch=3일시 회원탈퇴
                    if (memberDelete()){ //memberDelete() : 탈퇴 성공시 true, 실패시 false 반환하는 함수
                        return; // 탈퇴 성공 및 원래 위치로 이동 : MemberView의 무한루프 내부로 : 메인메뉴로 돌아간다
                    } // memberDelete() if문 끝
                } // else if (ch==3) 끝
                else if (ch==4){ //ch=4일시 게시판
                    boardPrint(); // 게시판 전체 출력 함수
                } // else if (ch==4) 끝
                else { System.out.println(">>기능이 없는 번호입니다"); } // 1234 외의 정수 입력시 else로 빠지며 문구 출력
            } catch (Exception e){ // 정수 외 입력시 InputMismatchException 예외 발생 -> e에 예외 클래스명 저장
                System.out.println(">>잘못된 입력입니다 : " + e); // 예외명과 오류메시지 출력
                scan = new Scanner(System.in); // 기존 Scanner 객체에 잘못된 입력값이 들어 있어 진행이 안 되므로 새로운 객체를 scan에 할당해 새 입력 받기
            } //try-catch 부분 끝
        } // while(true) 무한루프 끝
    } // index() 함수 끝

    //1. 로그아웃 함수
    public void logOut(){ // logOut() 함수 시작
        MemberController.memController.logOut(); //MemberController 클래스의 logOut()함수 실행
        System.out.println(">>로그아웃 성공, 초기메뉴로 돌아갑니다."); // 로그아웃 성공 안내
    } // logOut() 함수 끝

    //2. 회원수정 함수
    public void memberUpdate(){ // memberUpdate() 함수 시작
        System.out.print(">>회원정보 수정 중, 새로운 이름을 입력하세요 : "); // 새 이름 입력 안내문
        String newName = scan.next(); // 엔터를 치면 다음 공백까지의 문자열을 받아 String타입으로 newName 변수명으로 저장
        System.out.print(">>회원정보 수정 중, 새로운 연락처를 입력하세요 : "); // 새 연락처 입력 안내문
        String newPhone = scan.next(); // 엔터를 치면 다음 공백까지의 문자열을 받아 String타입으로 newPhone 변수명으로 저장
        if (MemberController.memController.memberUpdate(newName, newPhone)){
            // Controller의 memberUpdate() 함수에 String newName, newPhone을 매개변수로 전달 -> DAO의 memberUpdate()에 똑같이 전달
            // DAO에서 memberUpdate() 성공시 DAO->Controller->View로 true 리턴값이 반환되고, memberUpdate() 실패시 false 반환됨
            // if(true 혹은 false)형식으로 결과 구분됨, if(true) : 회원 수정 성공
            System.out.println(">>회원정보 수정이 완료되었습니다."); // 회원 수정 성공 출력
        } else { // if(false)일 때, 회원 수정 실패
            System.out.println(">>회원정보 수정이 잘못되었습니다."); // 회원 수정 실패 출력
        } // MemberController의 memberUpdate() if-else문 끝
    } // memberUpdate() 함수 끝

    //3. 회원탈퇴 함수
    public boolean memberDelete(){ // memberDelete() 함수 시작
        System.out.print(">>회원탈퇴를 위해 비밀번호를 다시 입력해주세요 : "); // 회원탈퇴시 필요한 비밀번호 입력 안내문 출력
        String pw = scan.next(); // 엔터를 치면 다음 공백까지의 문자열을 받아 String타입으로 pw 변수명으로 저장
        if (MemberController.memController.memberDelete(pw)){
            // Controller의 memberDelete() 함수에 String newName, newPhone을 매개변수로 전달 -> DAO의 memberDelete()에 똑같이 전달
            // DAO에서 memberDelete() 성공시 DAO->Controller->View로 true 리턴값이 반환되고, memberDelete() 실패시 false 반환됨
            // if(true 혹은 false)형식으로 결과 구분됨, if(true) : 회원정보 삭제 성공
            System.out.println(">>회원탈퇴 성공, 초기화면으로 돌아갑니다."); // 회원 탈퇴 성공 알림
            return true; // 원래 위치로 이동 (메인메뉴로 이동)할지에 대한 true/false 반환
        } else { // if(false)일 때, 회원 탈퇴 실패
            System.out.println(">>회원탈퇴 실패, 비밀번호를 다시 확인해주세요."); // 회원 탈퇴 성공 알림
            return false; // 원래 위치로 이동 (메인메뉴로 이동)할지에 대한 true/false 반환
        } // MemberController의 memberDelete() if-else문 끝
    } // memberDelete() 함수 끝

    //4. 게시판(게시글전체출력) 함수
    public void boardPrint(){ // boardPrint() 함수 시작
        System.out.println("=================== 게시판 ==================="); // 게시판 형식 콘솔 출력?

    } // boardPrint() 함수 끝
} // BoardView 클래스 끝
