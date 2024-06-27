package day16.controller;


import day16.model.DAO.MemberDAO;
import day16.model.DTO.MemberDTO;

import java.util.ArrayList;

public class MemberController {

    public static MemberController memController = new MemberController();

    //1. 회원가입 화면 함수
    public boolean signUp(MemberDTO memberDTO){
        return MemberDAO.mDAO.signUp(memberDTO);
    }

    //2. 로그인 화면
    public boolean login(MemberDTO memberDTO){
        return MemberDAO.mDAO.login(memberDTO);
    }

    //3. 아이디찾기
    public ArrayList<String> findID(MemberDTO memberDTO){
        return MemberDAO.mDAO.findID(memberDTO);
    }

    //4. 비밀번호찾기
    public String findPW(MemberDTO memberDTO){
        return MemberDAO.mDAO.findPW(memberDTO);
    }
}
