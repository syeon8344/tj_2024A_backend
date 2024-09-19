package day15.step2_JDBC;

import java.sql.*;

public class Step1 {
    public static void main(String[] args) throws SQLException {
        // 1.
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 인터페이스 타입의 변수 선언
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");

            String sql = "insert into table01 values ('유재석')";
            // SQL statement 기재 준비, .prepareStatement(): sql을 문자열로 매개변수로 전달, sql 조작문 구현체를 반환
            PreparedStatement ps = conn.prepareStatement(sql);
            // update 실행하기
            ps.executeUpdate();

            String sql1 = "insert into table01 values ('강호동')";
            // SQL statement 기재 준비, .prepareStatement(): sql을 문자열로 매개변수로 전달, sql 조작문 구현체를 반환
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            // update 실행하기
            ps1.executeUpdate();

            System.out.println("JDBC 연동 성공");
        } catch (Exception e) {
            System.out.println("JDBC 연동 실패!" + e);
        }

    }
}
