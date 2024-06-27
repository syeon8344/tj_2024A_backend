package day15.step3_MVC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DAO {
    // 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 객체
    static DAO dao = new DAO();
    //1. 멤버변수
    Connection conn;
    PreparedStatement ps;
    ResultSet rs;
    ArrayList<String> strList;
    String sql;

    // 2. 생성자
    DAO(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");
        } catch (Exception e){
            System.out.println("연동실패" + e);
        }
    };

    // 각 기능별 함수 구현
    public boolean signupCtrl(String name){
        String sql = "insert into table01 values ('"+name+"');";
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("입력" + e);
        }
        return false;
    }

    //2. 출력 제어 함수, 매개변수 : X, 리턴 : 회원목록 ArrayList<String>
    public ArrayList<String> printCtrl(){
        sql = "select * from table01";
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            strList = new ArrayList<>();
            while (rs.next()){ // 레코드 한줄씩
                strList.add(rs.getString("name"));
            }
        } catch (Exception e) {
            System.out.println("출력" + e);
        }
        return strList;

    }

    //3. 수정 제어 함수, 매개변수 : 기존 이름 & 새 이름, 리턴 : 수정성공여부 boolean
    public boolean updateCtrl(String oldName, String newName){
        sql = "update table01 set name = '"+newName+"' where name = '"+oldName+"';";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("수정" + e);
        }
        return false;
    }

    //4. 삭제 제어 함수, 매개변수 : 삭제할 이름, 리턴 : 삭제성공여부 boolean
    public boolean deleteCtrl(String deleteName){
        sql = "delete from table01 where name = '"+deleteName+"';";
        System.out.println(sql);
        try {
            ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            System.out.println("삭제" + e);
        }
        return false;
    }
}
