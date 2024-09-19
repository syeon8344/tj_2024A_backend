package day16.controller; // day 16 폴더의 controller 폴더/패키지에 있음

import day16.model.DAO.BoardDAO;
import day16.model.DTO.BoardDTO;
import day16.model.DTO.ReplyDTO;

import java.util.ArrayList;

import static day16.controller.MemberController.loginMno;

public class BoardController { // 현재 파일의 클래스명/제목
    // -------- 싱글톤 패턴 -------- //
        // 싱글톤 : 프로그램내 해당 클래스의 하나의 객체만 갖는 패턴
            // 1. static 변수에 해당 클래스의 객체 생성 및 대입, private
    private static BoardController bController = new BoardController();
            // 2. 해당 클래스 생성자를 private -> 다른 클래스에서 생성 불가
    private BoardController(){};
            // 3. 해당 싱글톤 객체를 외부에서 접근가능하도록 간접호출 메서드
    public static BoardController getInstance(){
        // 유효성 검사?
        return bController;
    };
    // ---------------------------- //

    // 게시판 글 전체출력
    public ArrayList<BoardDTO> boardPrint() {
        return BoardDAO.getInstance().boardPrint();
    }

    // 게시판 글 하나 상세출력
    public BoardDTO boardView(int bNo) {
        return BoardDAO.getInstance().boardView(bNo);
    }
    // 게시판 글쓰기
    public boolean boardWrite(BoardDTO bDTO) {
        bDTO.setMno(loginMno);
        return BoardDAO.getInstance().boardWrite(bDTO);
    }
    // 게시판 글 삭제
    public boolean boardDelete(int bNo) {
        return BoardDAO.getInstance().boardDelete(bNo, loginMno);
    }
    // 게시판 글 수정 권한 확인
    public boolean boardEditCheck(int bNo) {
        return BoardDAO.getInstance().boardEditCheck(bNo, loginMno);
    }
    // 게시판 글 수정
    public boolean boardEdit(int bNo, BoardDTO bDTO) {
        return BoardDAO.getInstance().boardEdit(bNo, bDTO);
    }
    // 개별 글당 댓글 출력
    public ArrayList<ReplyDTO> replyPrint(int bNo) {
        return BoardDAO.getInstance().replyPrint(bNo);
    }
    // 개별 글에서 댓글 달기
    public boolean replyWrite(ReplyDTO reply) {
        reply.setMno(loginMno); // 현재 로그인된 회원 정보 추가
        return BoardDAO.getInstance().replyWrite(reply);
    }
    // 댓글 삭제
    public boolean replyDelete(ReplyDTO rDTO) {
        rDTO.setMno(loginMno);
        return BoardDAO.getInstance().replyDelete(rDTO);
    }
    // 댓글 수정 권한 확인 (본인 여부)
    public boolean replyEditCheck(ReplyDTO rDTO) {
        rDTO.setMno(loginMno);
        return BoardDAO.getInstance().replyEditCheck(rDTO);
    }
    // 댓글 수정
    public boolean replyEdit(ReplyDTO rDTO) {
        return BoardDAO.getInstance().replyEdit(rDTO);
    }
    // 제목 찾기 함수
    public ArrayList<BoardDTO> titleSearch(String targetTitle) {
        return BoardDAO.getInstance().titleSearch(targetTitle);
    }
} // class 끝
