package day16.view;

import day16.AppStart;
import day16.controller.MemberController;
import day16.model.DTO.MemberDTO;

import java.util.ArrayList;
import java.util.Scanner;

public class MemberView {

    // 해당 클래스 함수들을 다른 데서 호출할 수 있도록 static 객체 생성
    public static MemberView mView = new MemberView();

    //멤버변수 : 입력객체
    Scanner scan = new Scanner(System.in);

    //0. 초기화면 함수
    public void index(){
        while(true){
            System.out.print(">>1.회원가입 2.로그인 3.아이디찾기 4.비밀번호찾기 5.뒤로가기 : ");
            try {
                int ch = scan.nextInt();
                if (ch==1){ //회원가입
                    signUp();
                }
                else if (ch==2){ //로그인
                    login();
                }
                else if (ch==3){ //ID 찾기
                    findID();

                }
                else if (ch==4){ //PW 찾기
                    findPW();
                }
                else if (ch==5){
                    break;
                }
                else { System.out.println(">>기능이 없는 번호입니다"); }
            } catch (Exception e){
                System.out.println(">>잘못된 입력입니다");
                scan = new Scanner(System.in);
            }
        }
    }

    //1. 회원가입 화면 함수
    public void signUp(){
        // 1. 입력
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next();
        System.out.print(">>비밀번호를 입력해주세요 : "); String pw = scan.next();
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next();
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next();
        // 2. 객체화
        MemberDTO memberDTO = new MemberDTO(id, pw, name, phone);
        boolean result = MemberController.memController.signUp(memberDTO);
        if (result){
            System.out.println(">>회원가입 성공");
        } else {
            System.out.println(">>회원가입 실패");
        }
    }

    //2. 로그인 화면
    public void login(){
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next();
        System.out.print(">>비밀번호를 입력해주세요 : "); String pw = scan.next();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(id); memberDTO.setMpw(pw);
        if (MemberController.memController.login(memberDTO)){
            System.out.println(">>로그인 성공");
        } else {
            System.out.println(">>로그인 실패");
        }
    }

    //3. 아이디찾기
    public void findID(){
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next();
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMname(name); memberDTO.setMphone(phone);
        ArrayList<String> foundID = MemberController.memController.findID(memberDTO);
        if (foundID.isEmpty()){
            System.out.println(">>해당 입력과 일치하는 아이디가 없습니다.");
        } else {
            String id = "";
            for (String s : foundID){
                id += (s +" ");
            }
            System.out.println(">>아이디는 " + id + "입니다.");

        }
    }

    //4. 비밀번호찾기
    public void findPW(){
        System.out.print(">>아이디를 입력해주세요 : "); String id = scan.next();
        System.out.print(">>이름를 입력해주세요 : "); String name = scan.next();
        System.out.print(">>연락처를 입력해주세요 : "); String phone = scan.next();
        MemberDTO memberDTO = new MemberDTO();
        memberDTO.setMid(id); memberDTO.setMname(name); memberDTO.setMphone(phone);
        String foundPW = MemberController.memController.findPW(memberDTO);
        if (foundPW.isEmpty()){
            System.out.println(">>비밀번호를 찾을 수 없습니다.");
        } else {
            System.out.println(">>비밀번호는 " + foundPW + " 입니다.");
        }
    }
}
