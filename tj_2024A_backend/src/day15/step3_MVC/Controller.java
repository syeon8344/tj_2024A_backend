package day15.step3_MVC;

import java.util.ArrayList;

public class Controller {
    // 외부 클래스로부터 내부 메소드를 사용할 수 있도록 만든 static 객체
    static Controller controller = new Controller();

    //1. 등록 SQL 처리 함수, 매개변수 : 저장할 값 String, 리턴 : 등록성공여부 boolean
    public boolean signupCtrl(String name){
        boolean result = DAO.dao.signupCtrl(name);
        return result;
    }

    //2. 출력 SQL 처리 함수, 매개변수 : X, 리턴 : 회원목록 ArrayList<String>
    public ArrayList<String> printCtrl(){
        ArrayList<String> list = DAO.dao.printCtrl();
        return list;
    }

    //3. 수정 SQL 처리 함수, 매개변수 : 기존 이름 & 새 이름, 리턴 : 수정성공여부 boolean
    public boolean updateCtrl(String oldName, String newName){
        boolean result = DAO.dao.updateCtrl(oldName, newName);
        return result;
    }

    //4. 삭제 SQL 처리 함수, 매개변수 : 삭제할 이름, 리턴 : 삭제성공여부 boolean
    public boolean deleteCtrl(String deleteName){
        boolean result = DAO.dao.deleteCtrl(deleteName);
        return result;
    }
}
