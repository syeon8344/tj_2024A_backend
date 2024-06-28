package day16.model.DAO; // day 16 폴더의 model 폴더의 DAO 폴더/패키지 위치
// 회원가입, 회원탈퇴, 로그인 ID/PW 확인, 이름&연락처로 ID 찾기,
// 아이디&이름&연락처로 PW 찾기, 로그인된 회원의 이름/연락처 수정 작업을 DB와 연동해서 처리

import day16.model.DTO.MemberDTO; // day 16 폴더의 model 폴더의 DAO 폴더/패키지 안의 MemberDTO 클래스 불러오기

import java.sql.Connection; // MySQL과 연동해서 MySQL DB 관련 작업을 할 수 있는 클래스들 불러오기
import java.sql.DriverManager; // DATABASE 폴더 내 mysql-connector-j-8.4.0.jar 파일을 외부 라이브러리로 불러와야 한다
import java.sql.PreparedStatement; // mysql-connector-j-8.4.0.jar 오른쪽 클릭후 라이브러리 추가 버튼
import java.sql.ResultSet;
// Connection : DB와 통신 세션 관련 인터페이스, .prepareStatement(String)
// PreparedStatement : DB에 적용할 수 있는 미리 준비된 SQL문 인터페이스, .executeUpdate() : insert update delete, .executeQuery() : update
// ResultSet : PreparedStatement.executeQuery() 함수로 반환되는 테이블 형식 데이터 인터페이스, .next(), .getString(필드명), .getInt(필드명) 등

public class MemberDAO { // MemberDAO 클래스 시작

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성 및 mDAO 변수명으로 저장
    public static MemberDAO mDAO = new MemberDAO();

    Connection conn; // MySQL DB와 연동하기 위해 관련 인터페이스 객체들 생성
    PreparedStatement ps; // DB로 보내는 명령문 인터페이스
    ResultSet rs; // DB에서 .executeQuery()로 받아오는 테이블 데이터 인터페이스

    MemberDAO(){ // MemberDAO() 생성자 시작, 상단에 static 객체 생성시 MySQL DB 연결을 위해 생성자 별도 지정해서 코드 실행
        try { // DB 연결 try-catch, 연결 실패시 Exception catch를 위해 필수
            Class.forName("com.mysql.cj.jdbc.Driver"); //MySQL JDBC Driver 클래스 로드
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/day06", "root", "1234");
            // DB에 연결, localhost : 현재 PC ip주소, 3306 : 일반적인 DB 포트, /day06 : DB명, root : 계정명, 1234 : 계정 비밀번호
        } catch (Exception e) { // DB 연동시 오류가 났을 시 해당 예외 클래스를 e 변수명으로 할당
            System.out.println(">>연동 실패 : " + e); // 연동 실패 알림 및 예외명 출력
        } // try-catch 끝
    } // MemberDAO() 생성자 끝

    //1. 회원가입 화면 함수 : SQL 작성 (w/ ? 와일드카드), 기재(? 와일드카드), 실행, 결과 받고 반환
    public boolean signUp(MemberDTO memberDTO){ // signUp() 함수 시작, 받는 매개변수 : MemberDTO 클래스 memberDTO 객체
        // String sql = "insert into member(mid, mpw, mname, mphone) values('"+id+"', '"+pw+"', '"+name+"', '"+phone+"')";
        String sql = "insert into member(mid, mpw, mname, mphone) values(?,?,?,?)"; // 상단 ++보다 편한 방법, sql문 작성
        try { // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 SQL문 sql변수를 PreparedStatement ps에 연결
            // sql문 "?" (와일드카드) 위치에 각각 값을 대입해주는 .setString( "?" 위치, 대입할 값) 함수들
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMpw());
            ps.setString(3, memberDTO.getMname()); ps.setString(4, memberDTO.getMphone());

            int result = ps.executeUpdate(); //SQL문 ps변수를 DB에 보내 적용하고 영향 받은 레코드(행) 숫자를 int로 반환한 것을 result에 저장
            if (result == 1)
                // executeUpdate() 반환값은 해당 SQL문으로 영향 받은 레코드의 숫자를 int로 반환하므로
                // result == 1은 한개의 레코드가 영향을 받았다 = 회원가입이 성공해서 member테이블에 레코드 하나가 추가되었다 = 회원가입 성공 true 반환
                return true;
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>회원가입 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return false; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> false값 반환
    } // signUp()함수 끝

    //2. 로그인 화면
    public int login(MemberDTO memberDTO){ // login() 함수 시작, 받는 매개변수 : MemberDTO 클래스 memberDTO 객체
        String sql = "select mno from member where mid = ? and mpw = ?";
        // sql : member 테이블에서 mid = ? 이고 mpw = ?인 레코드의 mno열 필드값을 보여달라
        try { // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 sql문을 .preparStatement() 함수로 PreparedStatement 인터페이스를 통해 ps 변수명으로 할당
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMpw());
            // 상단의 와일드카드 부분들을 .setString(위치, String)을 통해 값을 채워넣기
            rs = ps.executeQuery(); //SQL 질의값(select)을 전달하고 받은 테이블 형식의 ResultSet 클래스 형식 값을 rs에 대입
            if (rs.next()) // rs의 다음 포인터값이 있다 : rs 테이블이 빈 테이블이 아니다 : mno 값을 찾아왔다 : 찾은 회원 고유코드를 반환
                return rs.getInt("mno"); // rs 테이블의 mno 열의 값을 int 타입으로 가져와 반환한다
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>로그인 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return 0; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> 로그인 실패 -> loginMno 변수에 들어갈 0 반환
    } // login() 함수 끝

    //3. 아이디찾기
    public String findID(MemberDTO memberDTO){ // findID() 함수 시작, 받는 매개변수 : MemberDTO 클래스 memberDTO 객체
        String sql = "select mid from member where mname = ? and mphone = ?";
        // sql : member테이블에서 mname = ? 이고 mphone = ?인 레코드의 mid열 필드값을 보여달라
        try { // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 sql문을 .preparStatement() 함수로 PreparedStatement 인터페이스를 통해 ps 변수명으로 할당
            ps.setString(1, memberDTO.getMname()); ps.setString(2, memberDTO.getMphone());
            // 상단의 와일드카드 부분들을 .setString(위치, String)을 통해 값을 채워넣기
            rs = ps.executeQuery(); //SQL 질의값(select)을 전달하고 받은 테이블 형식의 ResultSet 클래스 형식 값을 rs에 대입
            if (rs.next()) // rs의 다음 포인터값이 있다 : rs 테이블이 빈 테이블이 아니다 : mid 값을 찾아왔다 : 찾은 아이디 값을 반환
                return rs.getString("mid"); // rs 테이블의 mid 열의 값을 String 타입으로 가져와 반환한다
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>아이디 찾기 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return ""; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> String "" 반환
    } // findID() 함수 끝

    //4. 비밀번호찾기
    public String findPW(MemberDTO memberDTO){ // findPW() 함수 시작, 받는 매개변수 : MemberDTO 클래스 memberDTO 객체
        String sql = "select mpw from member where mid = ? and mname = ? and mphone = ?";
        // sql : member테이블에서 mid = ? 이고 mname = ? 이면서 mphone = ?인 레코드의 mpw 필드를 보여달라
        try { // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 sql문을 .preparStatement() 함수로 PreparedStatement 인터페이스를 통해 ps 변수명으로 할당
            ps.setString(1, memberDTO.getMid()); ps.setString(2, memberDTO.getMname()); ps.setString(3, memberDTO.getMphone());
            // 상단의 와일드카드 부분들을 .setString(위치, String)을 통해 값을 채워넣기
            rs = ps.executeQuery(); //SQL 질의값(select)을 전달하고 받은 테이블 형식의 ResultSet 클래스 형식 값을 rs에 대입
            if (rs.next()) // rs의 다음 포인터값이 있다 : rs 테이블이 빈 테이블이 아니다 : mpw 값을 찾아왔다 : 찾은 비밀번호 값을 반환
                return rs.getString("mpw"); // rs 테이블의 mpw 열의 값을 String 타입으로 가져와 반환한다
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>비밀번호 찾기 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return ""; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> String "" 반환
    } // findPW()함수 끝

    //5. 회원탈퇴
    public boolean memberDelete(String pw, int loginMno) { // memberDelete() 함수 시작
        String sql = "delete from member where mno = ? and mpw = ?";
        // sql : member테이블에서 mno값이 ?이고 mpw값이 ?인 레코드를 삭제하겠다
        try { // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 sql문을 .preparStatement() 함수로 PreparedStatement 인터페이스를 통해 ps 변수명으로 할당
            ps.setInt(1, loginMno); ps.setString(2, pw);
            // 상단의 와일드카드 부분들을 .setInt(위치, int)와 .setString(위치, String)을 통해 값을 채워넣기
            if (ps.executeUpdate() == 1){ //.executeUpdate()로 영향 받은 레코드 갯수가 1개 : 회원 정보가 잘 삭제되었다 : 삭제 성공 true
                return true; // 삭제 성공 true 값을 MemberController로 반환
            } else {return false;} // 레코드 갯수가 1개가 아니다(0개 등) : 삭제 실패 - false
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>회원 탈퇴 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return false; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> false값 반환
    } // memberDelete() 함수 끝

    //6. 회원 정보 수정
    public boolean memberUpdate(String newName, String newPhone, int loginMno) { // memberUpdate() 함수 시작
        String sql = "update member set mname = ?, mphone = ? where mno = ?;";
        // sql문 : member 테이블에서 mno 값이 ?인 레코드의 mname 필드값을 ?, mphone 필드값을 ?로 업데이트하겠다
        try{ // MySQL DB 통신 부분 try-catch 시작
            ps = conn.prepareStatement(sql); // 미리 작성한 sql문을 .preparStatement() 함수로 PreparedStatement 인터페이스를 통해 ps 변수명으로 할당
            ps.setString(1, newName); ps.setString(2, newPhone); ps.setInt(3, loginMno);
            // 상단의 와일드카드 부분들을 .setString(위치, String)과 .setInt(위치, int)을 통해 값을 채워넣기
            if (ps.executeUpdate() == 1){ //.executeUpdate()로 영향 받은 레코드 갯수가 1개 : 회원 정보가 잘 수정되었다 : 수정 성공 true
                return true; // 수정 성공 true 값을 MemberController로 반환
            } else {return false;} // 레코드 갯수가 1개가 아니다(0개 등) : 수정 실패 - false
        } catch (Exception e) { // MySQL DB 통신 예외 발생시 예외 클래스명을 e 변수명으로 저장
            System.out.println(">>회원 수정 오류 : " + e); // 예외 종류를 오류 메시지와 함께 출력
        } // try-catch 끝
        return false; // try 코드블록에서 예외 발생시 예외로 인해 함수 실패 -> false값 반환
    } // memberUpdate() 함수 끝
}
