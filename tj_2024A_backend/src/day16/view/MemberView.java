package day16.view; // day 16 폴더의 view 폴더(패키지)에 위치, 회원가입,로그인,아이디찾기,비밀번호찾기 메뉴

import day16.controller.MemberController; // day 16 폴더의 controller 폴더/패키지의 MemberController 클래스 가져오기
import day16.model.DTO.MemberDTO; // day 16 폴더의 model 폴더의 DTO 폴더/패키지의 MemberDTO 클래스 가져오기
// DTO 데이터 전송 객체로 매개변수들을 "포장"해서 전달할 수 있다

import java.util.Scanner; // JAVA의 util 라이브러리의 Scanner 클래스 불러오기 : 키보드 입력 받기 위해

public class MemberView { // class start // MemberView 클래스명, 파일 이름과 같다

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성 및 mView 변수명으로 저장
    public static MemberView mView = new MemberView(); // static은 프로그램 실행 시 바로 실행되어 메소드 메모리에 저장, 다른 class에서 호출가능

    //멤버변수 : Scanner 클래스 입력객체를 새로 만들어 주소값을 scan 변수명으로 저장
    Scanner scan = new Scanner(System.in); // Scanner(System.in) : 키보드 입력값을 받을 수 있는 Scanner 객체

    //0. 초기화면 함수
    public void index(){ //무한루프로 메뉴를 띄워주고 scan Scanner 객체로 입력을 받는다
        while(true){ // while 무한루프 시작, while(true) 혹은 for(;;)일 시 조건문이 항상 true이므로 무한루프
            System.out.print(">>1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 : "); // 콘솔 메뉴 출력
            try { // try-catch, Exception 예외 발생시 catch 부분 코드 블록 실행
                int ch = scan.nextInt(); // Scanner 객체 scan으로 사용자 입력을 int형으로 받음, 타입 오류시 InputMismatchException -> catch
                if (ch==1){ //1 입력시 회원가입
                    signUp(); // 아래 signUp() 함수 호출, 함수 내에서 scan객체를 쓰고 print까지 이루어지므로 매개변수 X
                } // if (ch==1) 끝
                else if (ch==2){ //2 입력시 로그인
                    login(); // 아래 login() 함수 호출
                } // if (ch==2) 끝
                else if (ch==3){ //3 입력시 ID 찾기
                    findID(); // 하단 findID() 함수 호출
                } // if (ch==3) 끝
                else if (ch==4){ //4 입력시 PW 찾기
                    findPW(); // 하단 findPW() 함수 호출
                } // if (ch==4) 끝
                else { System.out.println(">>기능이 없는 번호입니다"); } // 1234 외 숫자 입력시 Exception은 아니므로 따로 안내를 출력해주는 코드
            } catch (Exception e){ // try 내에서 예외 발생시 (int에 String이 대입되는 등) 발생한 예외 클래스를 e에 할당하고 아래 코드블록 실행
                System.out.println(">>잘못된 입력입니다 : " + e); // 잘못된 입력임을 출력함
                scan = new Scanner(System.in); // 기존 Scanner 객체에 잘못된 입력값이 들어 있어 진행이 안 되므로 새로운 객체를 scan에 할당해 새 입력 받기
            } // catch 코드블록 끝
        } // while 무한루프 끝
    } // index() 끝

    //1. 회원가입 화면 함수
    public void signUp(){ //콘솔로 바로 출력해주므로 반환하는 값은 없다
        // 1. 입력
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next(); //엔터를 누를 때 다음 공백까지의 입력된 값을 각 필드명으로, 각자 정해진 타입으로 받는다
        System.out.print(">>비밀번호를 입력해주세요 : "); String pw = scan.next(); //String값 받기 : Scanner객체.next();
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next();
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next();
        // 2. DTO 객체화
        MemberDTO memberDTO = new MemberDTO(id, pw, name, phone); // id, pw, name, phone 변수를 DTO 객체를 생성해서 각각 대입 ("포장")
        // 3. DTO 객체를 MemberController 클래스 객체의 signUp() 함수의 매개변수로 보내주고 boolean 리턴값을 받아 result변수명에 저장
        boolean result = MemberController.memController.signUp(memberDTO);
        // Controller의 signUp() 함수에 memberDTO를 매개변수로 전달 -> DAO의 signUp()에 똑같이 전달되고 getter로 값을 추출해 signUp()실행
        // DAO에서 signUp() 성공시 DAO->Controller->View로 true 리턴값이 반환되고, signUp() 실패시 false 반환됨
        // Controller에서 보내오는 boolean 리턴값을 result 변수명으로 저장
        if (result){ // result가 true일 때 : DAO에서 signUp() 함수가 문제 없이 동작했다 - 회원가입 성공
            System.out.println(">>회원가입 성공"); // 회원가입 성공했음을 출력
        } else { // result가 false일 때 : Controller나 DAO에서 오류가 발생해 회원가입이 실패했다
            System.out.println(">>회원가입 실패"); // 회원가입 실패했음을 출력
        } // else문 끝
    } // signUp() 함수 끝

    //2. 로그인 함수
    public void login(){ // login() 함수 시작, 콘솔로 바로 출력하므로 리턴값 없음 - void
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next(); //키보드 입력값을 String 타입으로 id 변수명으로 저장
        System.out.print(">>비밀번호를 입력해주세요 : "); String pw = scan.next();//키보드 입력값을 String 타입으로 pw 변수명으로 저장
        MemberDTO memberDTO = new MemberDTO(); // DTO 객체로 포장해서 Controller에 전달하기 위해 기본 생성자로 객체 생성
        memberDTO.setMid(id); memberDTO.setMpw(pw); // 생성된 DTO 객체의 멤버변수에 id pw 변수를 대입 ("포장")
        if (MemberController.memController.login(memberDTO)){
            // MemberController의 login()함수는 DAO의 login()함수의 성공/실패결과인 boolean 값을 받아 똑같이 boolean 값으로 리턴
            // 해주므로 함수 결과값을 바로 if문에 대입하면 true/false 값을 대입하는 것과 같다
            System.out.println(">>로그인 성공"); // true 값일시 DAO의 login()함수가 성공했다는 것이므로 성공을 출력
            BoardView.bView.index(); //로그인 성공시 로그인된 메뉴로 이동 = bView static 객체의 index() 함수 실행
        } else { // DAO에서 login()함수가 실패해서 리턴값이 false일 시
            System.out.println(">>로그인 실패"); // 로그인 실패 결과를 출력해준다.
        } // else 끝
    } // login() 함수 끝

    //3. 아이디 찾기 함수
    public void findID(){ //findID() 함수 시작
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next(); //엔터를 눌렀을 때 첫번째 공백까지의 키보드 입력값을 String 타입 name 변수명으로 받아와 저장
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next(); //키보드 입력을 String 타입 phone 변수명으로 받아와 저장
        MemberDTO memberDTO = new MemberDTO(); // DTO 객체로 포장해서 보내기 위해 MemberDTO 객체 생성 및 memberDTO 변수명으로 주소값 저장
        memberDTO.setMname(name); memberDTO.setMphone(phone); //name 변수와 phone 변수의 값을 각각 memberDTO의 멤버변수에 대입 - private 멤벼변수들이므로 setter
        String foundID = MemberController.memController.findID(memberDTO);
        // Controller의 findID() 함수에 memberDTO를 매개변수로 전달 -> DAO의 findID()에 똑같이 전달되고 getter로 값을 추출해 findID()실행
        // findID() 성공시 찾은 ID가 DAO->Controller->View로 String형태로 전달되고, 찾은 ID가 없으면 null, findID() 실패시 "" 빈 String으로 전달됨
        // Controller에서 보내오는 String 타입 리턴값을 foundID 변수명으로 저장
        if (foundID == null || foundID.isEmpty()){ // null : 찾은 ID가 없다, isEmpty() : ""가 반환되었으므로 findID() 함수에 오류가 있었다 -> 실패
            System.out.println(">>아이디를 찾을 수 없습니다."); // ID를 찾을 수 없음을 알림
        } else { // null이 아니고 ""가 아님 : ID값이 존재해서 String으로 입력받았다
            System.out.println(">>아이디는 " + foundID + "입니다."); // ID를 출력해줌
        } // else 끝
    } //findID() 함수 끝

    //4. 비밀번호 찾기 함수
    public void findPW(){ // findPW()함수 시작
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next(); //엔터 입력시 첫번째 공백 전까지의 입력되어있는 내용을 String 타입으로 id 변수명으로 저장
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next(); // 키보드 입력값을 String 타입으로 name 변수명으로 저장
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next(); // 키보드 입력값을 String 타입으로 phone 변수명으로 저장
        MemberDTO memberDTO = new MemberDTO(); // "포장"해서 Controller의 findPW()함수로 넘겨주기 위해 MemberDTO 새 객체 생성해서 주소값을 memberDTO 변수명에 저장
        memberDTO.setMid(id); memberDTO.setMname(name); memberDTO.setMphone(phone); // id name phone 변수들 값을 setter로 memberDTO 매개변수들에 대입 (매개변수가 private이므로 외부 접근 X)
        String foundPW = MemberController.memController.findPW(memberDTO);
        // Controller의 findPW() 함수에 memberDTO를 매개변수로 전달 -> DAO의 findPW()에 매개변수를 통해 그대로 전달되고 getter로 값을 추출해 findPW()실행
        // findPW() 성공시 찾은 비밀번호가 DAO->Controller->View로 String형태로 전달되고, 찾은 비밀번호가 없거나(if(rs.next())) findPW() 실패시 "" (빈 String)으로 전달됨
        // Controller에서 보내오는 String 타입 리턴값을 foundPW 변수명으로 저장
        if (foundPW.isEmpty()){ // foundPW가 ""일 때 : 비밀번호가 없거나 DAO의 findPW()에서 예외처리가 생김 -> 실패
            System.out.println(">>비밀번호를 찾을 수 없습니다."); // 비밀번호 찾기 실패를 콘솔로 알림
        } else { // foundPW가 ""가 아닐 때 : 비밀번호 찾기 성공
            System.out.println(">>비밀번호는 " + foundPW + " 입니다."); // 찾은 비밀번호를 콘솔에 띄워준다
        } // else문 끝
    } // findPW()함수 끝
} // MemberView class 끝
