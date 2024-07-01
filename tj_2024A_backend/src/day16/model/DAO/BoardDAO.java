package day16.model.DAO; //day16 폴더의 model 폴더의 DAO 폴더/패키지 위치, 게시판 글 관련 DB 처리

import day16.model.DTO.BoardDTO;

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

            String sql = "select * from board;";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){ // rs에 들어있는 테이블 데이터를 레코드마다 boardDTO로 포장해 ArrayList에 담기
                BoardDTO bDTO = new BoardDTO();
                bDTO.setBtitle(rs.getString("btitle")); bDTO.setBcontent(rs.getString("bcontent"));
                bDTO.setBdate(rs.getString("bdate")); bDTO.setBview(rs.getInt("bview"));
                bDTO.setBno(rs.getInt("bno")); bDTO.setMno(rs.getInt("mno"));
                bDTOList.add(bDTO);
            }
            return bDTOList;
        } catch (Exception e) {
            System.out.println(">>bPrint() 오류 발생 : " + e);
        }
        return null; // 글이 없을 때
    }

    // 6. 게시글 개별조회 함수
    public BoardDTO boardView(int bNo) {
        try {
            String sql = "select * from board where bno = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1, bNo); // 와일드카드("?") 위치 채우기
            rs = ps.executeQuery(); // SQL로 질의하기
            if (rs.next()){ // 처음 포인터 : 열 이름, next()가 있다(true) = 첫번째 행이 있다 = 결과를 찾았다
                // 조회수 1 증가
                sql = "update board set bview = ? where bno = ?";
                ps = conn.prepareStatement(sql);
                ps.setInt(1, rs.getInt("bview") + 1); ps.setInt(2, rs.getInt("bno"));
                ps.executeUpdate();

                // 리턴 BoardDTO 객체 형성
                BoardDTO bDTO = new BoardDTO();
                bDTO.setBtitle(rs.getString("btitle")); bDTO.setBcontent(rs.getString("bcontent"));
                bDTO.setBdate(rs.getString("bdate")); bDTO.setBview(rs.getInt("bview"));
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
            String sql = "select mno from board where bno = ?";
            ps = conn.prepareStatement(sql); ps.setInt(1, bNo);
            rs = ps.executeQuery();
            int wroteNo = 0;
            if (rs.next()) {
                wroteNo = rs.getInt("mno");
                if (wroteNo == loginMno) {
                    sql = "delete from board where bno = ? and mno = ?";
                    ps = conn.prepareStatement(sql); ps.setInt(1, bNo); ps.setInt(2, loginMno);
                    int count = ps.executeUpdate();
                        if (count == 1){
                            return true;
                        }
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
} // BoardDAO 끝
