package day16.model.DAO; //day16 폴더의 model 폴더의 DAO 폴더/패키지 위치, 게시판 글 관련 DB 처리

import day16.model.DTO.BoardDTO;
import day16.model.DTO.ReplyDTO;

import java.sql.*;
import java.util.ArrayList;

public class BoardDAO { //BoardDAO 클래스 시작

    // 싱글톤 패턴
    private static BoardDAO bDAO = new BoardDAO(); // private static 객체 생성
    private BoardDAO(){}; // 다른 클래스에서 생성 막기
    public static BoardDAO getInstance(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/day06", "root", "1234"
            );
        } catch(Exception e){
            System.out.println(">>BoardDAO 오류 : " + e);
        }
        return bDAO;
    }; // private static 객체 불러오기 함수
    // /싱글톤 패턴

    // JDBC 인터페이스들
    static Connection conn; //.prepareStatement(string)
    PreparedStatement ps; // .executeQuery() .executeUpdate()
    ResultSet rs;

    // 4. 게시글 전체출력 함수
    public ArrayList<BoardDTO> boardPrint(){
        try {
            ArrayList<BoardDTO> bDTOList = new ArrayList<>();
            String sql = "select * from board b inner join member m on b.mno = m.mno order by bno desc;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){ // rs에 들어있는 테이블 데이터를 레코드마다 boardDTO로 포장해 ArrayList에 담기
                BoardDTO bDTO = new BoardDTO();
                bDTO.setBtitle(rs.getString("btitle")); bDTO.setBcontent(rs.getString("bcontent"));
                bDTO.setBdate(rs.getString("bdate")); bDTO.setBview(rs.getInt("bview"));
                bDTO.setBno(rs.getInt("bno")); bDTO.setMno(rs.getInt("mno"));
                bDTO.setMid(rs.getString("mid"));
                bDTOList.add(bDTO);
            }
            return bDTOList;
        } catch (Exception e) {
            System.out.println(">>bPrint() 오류 발생 : " + e);
        }
        return null; // 글이 없을 때
    }
    // 4-1. 제목 찾기 함수
    public ArrayList<BoardDTO> titleSearch(String targetTitle) {
        ArrayList<BoardDTO> bDTOList = new ArrayList<>();
        try {
            // String sql = "select * from board b inner join member m on b.mno = m.mno where btitle like ?;";
            String sql = "select * from board b inner join member m on b.mno = m.mno where btitle like CONCAT('%', ?, '%')";
            // CONCAT(문자열, 문자열, 문자열) = JAVA) str + str + str
            // sql like문 : '%제%' = O | '%?%' = X (파라미터 인식 X) | ?, %+param+% = O | '%"+targetTitle+"%' = O | %?% = X
            ps = conn.prepareStatement(sql);
            ps.setString(1, targetTitle);
            rs = ps.executeQuery();
            while (rs.next()){
                BoardDTO bDTO = new BoardDTO();
                bDTO.setBno(rs.getInt(5)); bDTO.setMid(rs.getString(7)); bDTO.setBtitle(rs.getString(1)); bDTO.setBdate(rs.getString(3)); bDTO.setBview(rs.getInt(4));
                bDTOList.add(bDTO);
            }
        } catch (Exception e){
            System.out.println(">>제목 검색 오류 : " +e);
            System.out.println("ps = " + ps.toString());
        }
        return bDTOList;
    }
    // 6. 게시글 개별조회 함수
    public BoardDTO boardView(int bNo) {
        try {
            // 유효성 검사 : 게시글 번호 확인
            String sql = "select * from board where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bNo); // 와일드카드("?") 위치 채우기
            rs = ps.executeQuery(); // SQL로 질의하기
            if (rs.next()){ // 처음 포인터 : 열 이름, next()가 있다(true) = 첫번째 행이 있다 = 결과를 찾았다
                // 조회수 1 증가
                sql = "update board set bview = bview + 1 where bno = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("bno"));
                ps.executeUpdate();

                // 조회수 증가한 레코드 재검색
                sql = "select * from board where bno = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, bNo); // 와일드카드("?") 위치 채우기
                rs = ps.executeQuery(); // SQL로 질의하기
                rs.next(); // 레코드 칸으로 포인터 옮기기

                // 리턴 BoardDTO 객체 형성
                BoardDTO bDTO = new BoardDTO();
                bDTO.setBtitle(rs.getString("btitle")); bDTO.setBcontent(rs.getString("bcontent"));
                bDTO.setBdate(rs.getString("bdate")); bDTO.setBview(rs.getInt("bview")); // 조회수 1 증가된 숫자로 띄우기
                bDTO.setBno(rs.getInt("bno")); bDTO.setMno(rs.getInt("mno"));
                return bDTO; // 완성된 bDTO 반환
            }
        } catch (SQLException e) {
            System.out.println(">>게시글 개별조회 오류 : " + e);
        }
        return null;
    }
    // 글 작성 함수
    public boolean boardWrite(BoardDTO bDTO) {
        try{
            String sql = "insert into board(btitle, bcontent, mno) values(?,?,?);";
            ps = conn.prepareStatement(sql);
            ps.setString(1, bDTO.getBtitle()); ps.setString(2, bDTO.getBcontent()); ps.setInt(3, bDTO.getMno());
            int result = ps.executeUpdate(); //executeUpdate : 변화된 레코드 숫자 반환 (int)
            if (result == 1){
                return true;
            }
        }catch(Exception e){
            System.out.println(">>글 작성 오류 : " + e);
        }
        return false;
    }
    // 게시판 글 삭제
    public boolean boardDelete(int bNo, int loginMno) {
        try {
            // 유효성 검사 (글을 작성한 회원 코드 == 현재 로그인한 회원 코드?)
            String sql = "select mno from board where bno = ?";
            int wroteNo = 0;
            ps = conn.prepareStatement(sql); ps.setInt(1, bNo);
            rs = ps.executeQuery();
            rs.next(); //레코드 값으로 포인터 전진
            wroteNo = rs.getInt("mno");
            if (wroteNo == loginMno) { // 로그인한 회원이 작성한 글이 맞다
                sql = "delete from board where bno = ? and mno = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, bNo);
                ps.setInt(2, loginMno);
                int count = ps.executeUpdate();
                if (count == 1) {
                    return true;
                }
            }
        } catch (Exception e){
            System.out.println(">>글 삭제 오류 : " +e);
        }
        return false;
    }
    // 게시판 글 수정 권한 확인
    public boolean boardEditCheck(int bNo, int loginMno) {
        try {
            String sql = "select mno from board where bno = ?";
            ps = conn.prepareStatement(sql); ps.setInt(1, bNo);
            rs = ps.executeQuery();
            int wroteNo = 0;
            if (rs.next()) { // 해당 bno 레코드의 mno 찾기
                wroteNo = rs.getInt("mno");
                if (wroteNo == loginMno) { // 레코드의 mno와 loginMno가 같다 = 권한 있음
                    return true;
                }
            }
        } catch (Exception e){
            System.out.println(">>글 수정 오류 : " +e);
        }
        return false;
    }
    // 게시판 글 수정
    public boolean boardEdit(int bNo, BoardDTO bDTO) {
        try {
            String sql = "update board set btitle = ?, bcontent = ? where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1, bDTO.getBtitle()); ps.setString(2, bDTO.getBcontent()); ps.setInt(3, bNo);
            int count = ps.executeUpdate();
            if (count == 1){
                return true;
            }
        } catch (Exception e){
            System.out.println(">>글 수정 오류 : " +e);
        }
        return false;
    }
    // 게시판 댓글 출력
    public ArrayList<ReplyDTO> replyPrint(int bNo) {
        try {
            ArrayList<ReplyDTO> replyList = new ArrayList<>();
            //String sql = "select * from reply where bno = ?";
            String sql = "select * from reply r inner join member m on r.mno = m.mno where r.bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bNo);
            rs = ps.executeQuery();
            while(rs.next()){ // rs 테이블 데이터의 처음 포인터는 실제 레코드줄 전에 있어서 next() 필요
                ReplyDTO reply = new ReplyDTO();
                reply.setRcontent(rs.getString("rcontent"));
                reply.setRdate(rs.getString("rdate"));
                reply.setMno(rs.getInt("mno"));
                reply.setBno(rs.getInt("bno"));
                reply.setRno(rs.getInt("rno"));
                reply.setMid(rs.getString(6));
                replyList.add(reply);
            }
            return replyList;
        } catch (Exception e){
            System.out.println(">>댓글 출력 오류 : " +e);
        }
        return null;
    }
    // 게시판 댓글 작성
    public boolean replyWrite(ReplyDTO reply) {
        try {
            String sql = "insert into reply (rcontent, mno, bno) values (?,?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1, reply.getRcontent()); ps.setInt(2, reply.getMno()); ps.setInt(3, reply.getBno());
            int result = ps.executeUpdate();
            if (result == 1){
                return true;
            }
        } catch (Exception e){
            System.out.println(">>댓글 출력 오류 : " +e);
        }
        return false;
    }
    // 댓글 삭제 함수
    public boolean replyDelete(ReplyDTO rDTO) {
        try {
            String sql = "delete from reply where rno = ? and bno = ? and mno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rDTO.getRno()); ps.setInt(2, rDTO.getBno()); ps.setInt(3, rDTO.getMno());
            int result = ps.executeUpdate();
            if (result == 1){
                return true;
            }
        } catch (Exception e){
            System.out.println(">>댓글 삭제 오류 : " +e);
        }
        return false;
    }
    // 댓글 수정 권한 확인 함수
    public boolean replyEditCheck(ReplyDTO rDTO) {
        try {
            // rno와 bno로 검색한 레코드의 mno와 현재 loginMno를 비교 -> 작성자가 로그인 상태인지 확인가능.
            String sql = "select mno from reply where rno = ? and bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, rDTO.getRno()); ps.setInt(2, rDTO.getBno());
            rs = ps.executeQuery();
            if (rs.next()){
                if (rs.getInt("mno") == rDTO.getMno()){
                    return true;
                }
            }
        } catch (Exception e){
            System.out.println(">>댓글 권한 확인 오류 : " +e);
        }
        return false;
    }
    // 권한 확인후 댓글 수정 함수
    public boolean replyEdit(ReplyDTO rDTO) {
        try {
            String sql = "update reply set rcontent = ? where rno = ? and bno = ?";
            ps = conn.prepareStatement(sql);
            ps. setString(1, rDTO.getRcontent()); ps.setInt(2, rDTO.getRno()); ps.setInt(3, rDTO.getBno());
            int result = ps.executeUpdate();
            if (result == 1){
                return true;
            }
        } catch (Exception e){
            System.out.println(">>댓글 수정 오류 : " +e);
        }
        return false;
    }


} // BoardDAO 끝
