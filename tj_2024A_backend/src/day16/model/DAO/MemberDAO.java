package day16.model.DAO;

import day16.model.DTO.MemberDTO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class MemberDAO {

    public static MemberDAO mDAO = new MemberDAO();
    ArrayList<String> foundID;
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;

    MemberDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/day06", "root", "1234");
        } catch (Exception e) {
            System.out.println(">>연동 실패 : " + e);
        }
    };

    //1. 회원가입 화면 함수 : SQL 작성 (w/ ? 와일드카드), 기재(? 와일드카드), 실행, 결과 받고 반환
    public boolean signUp(MemberDTO memberDTO){
        // String sql = "insert into member(mid, mpw, mname, mphone) values('"+id+"', '"+pw+"', '"+name+"', '"+phone+"')";
        String sql = "insert into member(mid, mpw, mname, mphone) values(?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMpw()); ps.setString(3, memberDTO.getMname()); ps.setString(4, memberDTO.getMphone());
            int result = ps.executeUpdate();
            if (result == 1)
                return true;
        } catch (Exception e) {
            System.out.println(">>회원가입 오류 : " + e);
        }
        return false;
    }

    //2. 로그인 화면
    public boolean login(MemberDTO memberDTO){
        String sql = "select mid, mpw from member where mid = ? and mpw = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMpw());
            rs = ps.executeQuery();
            if (rs.next())

                return true;
        } catch (Exception e) {
            System.out.println(">>로그인 오류 : " + e);
        }
        return false;
    }

    //3. 아이디찾기
    public ArrayList<String> findID(MemberDTO memberDTO){
        String sql = "select mid from member where mname = ? and mphone = ?";
        foundID = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDTO.getMname()); ps.setString(2, memberDTO.getMphone());
            rs = ps.executeQuery();
            while (rs.next())
                foundID.add(rs.getString("mid"));
            return foundID;
        } catch (Exception e) {
            System.out.println(">>아이디 찾기 오류 : " + e);
        }
        return foundID;
    }

    //4. 비밀번호찾기
    public String findPW(MemberDTO memberDTO){
        String sql = "select mpw from member where mid = ? and mname = ? and mphone = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMname()); ps.setString(3, memberDTO.getMphone());
            rs = ps.executeQuery();
            if (rs.next())
                return rs.getString("mpw");
        } catch (Exception e) {
            System.out.println(">>비밀번호 찾기 오류 : " + e);
        }
        return "";
    }

}
