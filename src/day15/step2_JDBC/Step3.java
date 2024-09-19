package day15.step2_JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Step3 {
    public static void main(String[] args) {
        //DB 연동
        Connection conn = null; // 아래 for문에서도 사용하기 위해 전역변수로 선언
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day05", "root", "1234");
            System.out.println("DB 연동 성공.");
        } catch (Exception e) {
            System.out.println("DB 연동 실패. " + e);
        }
        Scanner scan = new Scanner(System.in);
        // ArrayList<String> nameList = new ArrayList<>(); // 여러개 String객체(문자열)을 저장하는 리스트 객체

        for (;;){
            System.out.print(">>1.등록 2.출력 3.수정 4.삭제");
            try{
                int ch = scan.nextInt();

                if(ch == 1){
                    // 1. 입력받기
                    System.out.print(">>[저장] 이름 : "); String name = scan.next();
                    // 2. 저장
                    String sql = "insert into table01 values ('"+name+"');";
                    System.out.println(sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();

                }
                else if (ch == 2){
                    // DB SQL 레코드 전체 검색
                    String sql = "select * from table01";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ResultSet rs = ps.executeQuery(); //반환타입 : ResultSet, 주로 결과물 조작할때
                    while(rs.next()){ // .next(): 값이 있는지 없는지 true/false -> 다음 값이 없을 때까지 루프
                        System.out.println(rs.getString("name"));
                    }
                }
                else if (ch == 3){
                    System.out.print(">>[수정] 원래 이름 : "); String oldName = scan.next();
                    System.out.print(">>[수정] 새 이름 : "); String newName = scan.next();
                    String sql = "update table01 set name = '"+newName+"' where name = '"+oldName+"';";
                    System.out.println(sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                }
                else if (ch == 4){
                    System.out.print(">>[삭제] 이름 : "); String name = scan.next();
                    // 2. DB SQL 레코드 삭제
                    String sql = "delete from table01 where name = '"+name+"';";
                    System.out.println(sql);
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.executeUpdate();
                }
                else {
                    System.out.println(">>번호 입력이 잘못되었습니다.");
                }
            } catch (InputMismatchException e){
                System.out.println(">>잘못된 입력입니다. " + e);
                scan = new Scanner(System.in); // 잘못 입력받은 값을 가진 객체를 초기화
            } catch (SQLException e){
                System.out.println(">>SQL 구문이 잘못되었습니다. " + e);
            }


        }
    }
}
