package day16.view; //day16 폴더의 view 폴더/패키지에 위치, MemberView에서 로그인시 넘어오고 로그아웃,회원정보수정,회원탈퇴,게시판 메뉴

import day16.controller.BoardController;
import day16.controller.MemberController; //day16 폴더의 controller폴더/패키지의 MemberController 클래스 불러오기
import day16.model.DTO.BoardDTO;
import day16.model.DTO.ReplyDTO;
// logOut() 함수 사용을 위해

import java.util.ArrayList;
import java.util.Scanner; // JAVA의 util 라이브러리의 Scanner 클래스 불러오기 : 키보드 입력 받기 위해

public class BoardView { // BoardView 클래스 시작

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성
    public static BoardView bView = new BoardView();

    //멤버변수 : 입력객체 생성 및 주소값을 scan 변수명으로 저장
    Scanner scan = new Scanner(System.in); // static은 프로그램 실행 시 바로 실행되어 메소드 메모리에 저장, 다른 class에서 호출가능
    ArrayList<BoardDTO> bDTOList;
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
                else if (ch==4){ //ch=4일시 게시판 전체출력
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
        System.out.println("======================= 게시판 ======================="); // 게시판 형식 콘솔 출력?
        System.out.println("글번호    작성자ID    제목        작성일                조회수");
        bDTOList = BoardController.getInstance().boardPrint();
        if (bDTOList != null) {
            bDTOList.forEach(bDTO -> {System.out.printf("%d\t\t%s\t\t%s\t\t%s\t\t%d\n", // 리스트객체명.foreEach(반복대입변수명 -> {실행문;});
                    bDTO.getBno(), bDTO.getMid(), bDTO.getBtitle(), bDTO.getBdate(), bDTO.getBview() );
            });
        }
        System.out.print(">>0.글쓰기 1~.개별글조회 : "); int ch = scan.nextInt();
        if (ch == 0){ boardWrite();}
        else if (ch >= 1) { boardView(ch);}
    } // boardPrint() 함수 끝

    //5. 게시물 쓰기 함수
    public void boardWrite(){
        scan.nextLine();
        System.out.print(">>제목을 입력해주세요 : "); String bTitle = scan.nextLine();
        System.out.print(">>내용을 입력해주세요 : "); String bContent = scan.nextLine();
        BoardDTO bDTO = new BoardDTO();
        bDTO.setBtitle(bTitle); bDTO.setBcontent(bContent);
        if (BoardController.getInstance().boardWrite(bDTO)){
            System.out.println(">>작성 완료.");
        } else {
            System.out.println(">>작성 실패.");}
    }
    //6. 게시물 개별조회 함수
    public void boardView(int bNo){
        BoardDTO result = BoardController.getInstance().boardView(bNo); // 게시물 BoardDTO 객체로 가져오기
        if (result != null) { // 해당 bNo를 가진 게시물이 있다
            String mName = MemberController.getMemberName(result.getMno()); // 작성자 이름 가져오기
            if (mName.equals("deletedUser")) {mName = "탈퇴한 사용자";} // 작성자가 탈퇴한 회원일 시 표현
            while (true) {
                System.out.println("제목 : " + result.getBtitle());
                System.out.print("작성자 : " + mName + " | ");
                System.out.println("조회수 : " + result.getBview());
                System.out.println("작성일 : " + result.getBdate());
                System.out.println("내용 : " + result.getBcontent());
                // -------- 댓글 출력 ------------
                System.out.println("============== 댓글 ===============");
                System.out.println("회원ID    회원이름    댓글내용        작성일");
                replyPrint(bNo);
                // -------- /댓글 출력 ------------
                System.out.print(">>1.돌아가기 2.댓글쓰기 | 권한필요 : 3.글삭제 4.글수정 5.댓글삭제 6.댓글수정 : ");
                int ch = scan.nextInt();
                if (ch == 1) { // 개별 글 메뉴
                    boardPrint();
                } else if (ch == 2){
                    replyWrite(bNo);
                } else if (ch == 3) {
                    boardDelete(bNo);
                } else if (ch == 4) {
                    boardEdit(bNo);
                } else if (ch == 5) {
                    System.out.println(">>삭제할 댓글을 선택해주세요 : "); int rNo = scan.nextInt();
                    replyDelete(bNo, rNo);
                } else if (ch == 6) {
                    System.out.println(">>수정할 댓글을 선택해주세요 : "); int rNo = scan.nextInt();
                    replyEdit(bNo, rNo);
                } else {
                    System.out.println(">>입력이 잘못되었습니다.");
                }
            }
        }
        System.out.println(">>글 번호를 찾을 수 없습니다.");
        boardPrint();
    }

    //7. 게시물 삭제 함수
    public void boardDelete(int bNo){
        if (BoardController.getInstance().boardDelete(bNo)){
            System.out.println(">>글 삭제 완료.");
            boardPrint();
        } else {
            System.out.println(">>글 삭제 권한이 없습니다.");
        }
    }
    //8. 게시물 수정 함수
    public void boardEdit(int bNo) {
        if(BoardController.getInstance().boardEditCheck(bNo)){
            scan.nextLine();
            System.out.print(">>새로운 글 제목 : "); String newTitle = scan.nextLine();
            System.out.print(">>새로운 글 내용 : "); String newContent = scan.nextLine();
            BoardDTO bDTO = new BoardDTO();
            bDTO.setBtitle(newTitle); bDTO.setBcontent(newContent);
            if (BoardController.getInstance().boardEdit(bNo, bDTO)){
                System.out.println(">>글 수정 완료.");
                boardPrint();}
        } else {System.out.println(">>글 수정 권한이 없습니다.");}
    }
    //9. 댓글 출력 함수
    public void replyPrint(int bNo){ // 현재 보고 있는 글 번호를 매개변수로
        ArrayList<ReplyDTO> replyList = BoardController.getInstance().replyPrint(bNo); // ReplyDTO 리스트로 댓글을 받는다
        if (replyList != null && !replyList.isEmpty()) { // null이 아니거나 비어있지 않으면 댓글 출력
            for (ReplyDTO replyDTO : replyList) {
                String mName = MemberController.getMemberName(replyDTO.getMno()); // 작성자 이름 가져오기
                if (mName.equals("deletedUser")) {mName = "탈퇴한 사용자";}
                System.out.printf("%s\t\t%s\t\t%s\t\t%s\n",
                        replyDTO.getMid(), mName,
                        replyDTO.getRcontent(), replyDTO.getRdate());
            }
        }
    }
    //10. 댓글 쓰기 함수
    public void replyWrite(int bNo){ // 현재 보고 있는 글 번호를 매개변수로
        //오픈형 게시판일 때 (로그인 후 댓글쓰기가 아닐 때)
            //로그인 상태 확인 후 댓글 쓰기 진행
        //if (!MemberController.memController.loginState();)
        //BoardController로 ReplyDTO로 포장한 댓글 보내기
        scan.nextLine(); // 스캐너에 남아있을 수 있는 \n 개행문자를 제거
        System.out.print(">>댓글 내용을 입력해 주세요 : "); String reply = scan.nextLine(); // 공백도 포함해서 댓글 체크
        ReplyDTO rDTO = new ReplyDTO();
        rDTO.setRcontent(reply); rDTO.setBno(bNo);
        if(BoardController.getInstance().replyWrite(rDTO)){ // 댓글 작성 성공/실패 boolean 리턴값
            System.out.println(">>댓글 작성 완료.");
        } else {
            System.out.println(">>댓글 작성 오류 발생.");
        }
    }
    // 11. 댓글 삭제 함수
    private void replyDelete(int bNo, int rNo) {
        ReplyDTO rDTO = new ReplyDTO();
        rDTO.setBno(bNo); rDTO.setRno(rNo);
        if(BoardController.getInstance().replyDelete(rDTO)){ // 댓글 작성 성공/실패 boolean 리턴값
            System.out.println(">>댓글 작성 완료.");
        } else {
            System.out.println(">>댓글 작성 오류 발생.");
        }
    }
    // 12. 댓글 수정 함수
    private void replyEdit(int bNo, int rNo) {
        ReplyDTO rDTO = new ReplyDTO();
        rDTO.setBno(bNo); rDTO.setRno(rNo);
        if (BoardController.getInstance().replyEditCheck(rDTO)) {
            scan.nextLine();
            System.out.println(">>새 댓글 내용을 입력해주세요 : "); String newReply = scan.nextLine();
            rDTO.setRcontent(newReply);
            if (BoardController.getInstance().replyEdit(rDTO)) { // 댓글 작성 성공/실패 boolean 리턴값
                System.out.println(">>댓글 수정 완료.");
            } else {
                System.out.println(">>댓글 수정 오류 발생.");
            }
        }
    }
} // BoardView 클래스 끝
