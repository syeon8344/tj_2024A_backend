package day10;

import java.util.Scanner;


public class Step1_제품CRUD객체버전 {

//    5. 제품CRUD_기능별함수버전
//    - [메모리 설계] 외 모든 조건이 동일합니다.
//            [ 메모리 설계 ]
//            - 최대 제품 개수는 [!!!]제한없음
//        - 제품의 속성은 제품코드 , 제품명 , 제품가격 3개
//        - 배열은 1개 선언 가능 합니다.
//            - 제품 클래스를 선언하고 객체를 활용 하시오.
//            - 제품 등록시 제품객체는 생성되므로 while문 밖에 미리 배열내 객체를 임의로 생성하지 마시오.
//            - 반복문을 최대한 활용하여 코드을 줄이시오.
//        - 제품 클래스의 모든 멤버변수는 private 사용 합니다.
//            - 제품 객체 생성시 매개변수가 3개인 생성자를 활용 합니다.
//            [추가]
//            - main 함수내 1,2,3,4 입력시 실행되는 실행문들을 함수로 구현하여
//    함수 호출를 호출하는 방식으로 기능별로 함수화 를 하시오.

    private static Product[] pList = new Product[0];

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (true) { // 무한반복
            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5.종료 선택 >> "); // 무한출력
            int ch = scanner.nextInt(); // 무한입력
            if (ch == 1) {
                System.out.print(">>제품 코드 : "); String newCode = scanner.next();
                System.out.print(">>제품명 : "); String newName = scanner.next();
                System.out.print(">>제품가격 : "); int newPrice = scanner.nextInt();
                addList(newCode, newName, newPrice);
            } else if (ch == 2) {
                showList();
            } else if (ch == 3) {
                System.out.print(">>제품 코드 : "); String updateCode = scanner.next();
                updateList(updateCode);
            } else if (ch == 4) {
                System.out.print(">>제품 코드 : "); String deleteCode = scanner.next();
                deleteList(deleteCode);
            } else if (ch == 5) {
                System.out.println("안내] 프로그램 종료합니다.");
                break;
            } else {
                System.out.println("안내] 알수없는 번호 입니다.");
            }

        }
    }

    private static void addList(String newCode, String newName, int newPrice) {
        //배열에 새로운 제품 추가, 공간이 없다면 늘리고 추가
        Product p = new Product(newCode, newName, newPrice); // 새로운 객체
        for (int i = 0; i <=pList.length; i++){ // 배열에 빈 곳이 있는지? 아니면 늘리고 넣기
            if (i == pList.length){ // 빈 곳이 없음 = 늘려서 넣기
                Product[] tempList = new Product[pList.length + 1]; // 한 칸 더 긴 임시 배열
                for (int j = 0; j < pList.length; j++){ // 원래 배열 내용을 복사
                    tempList[j] = pList[j];
                }
                tempList[pList.length] = p;
                pList = tempList;
                System.out.println(">>제품 추가 완료");
                break;
            }
            if (pList[i] == null){ // 빈 곳이 있음 = 바로 넣기
                pList[i] = p;
                System.out.println(">>제품 추가 완료");
                break;
            }
        }
    }

    private static void showList(){
        // null값이 아니면 출력하기
        System.out.println("====================== 제품 목록 ======================");
        for (int i = 0; i < pList.length; i++){
            if (pList[i] != null){
                System.out.printf("%s\t\t%s\t\t%d\n", pList[i].getpCode(), pList[i].getpName(), pList[i].getpPrice());
            }
        }
    }

    private static void updateList(String updateCode){
        // 제품 코드가 맞으면 수정해주기
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i <= pList.length; i++){
            if (i == pList.length){
                System.out.println(">>제품 코드를 찾을 수 없습니다.");
                break;
            }
            if (pList[i].getpCode().equals(updateCode)){
                System.out.print(">>새 제품명 : "); String updateName = scanner.next();
                System.out.print(">>새 제품가격 : "); int updatePrice = scanner.nextInt();
                pList[i].setpName(updateName); pList[i].setpPrice(updatePrice);
                System.out.println(">>수정 완료");
                break;
            }
        }
    }

    private static void deleteList(String deleteCode){
        // 제품 코드가 맞으면 null로 만들기
        for (int i = 0; i <= pList.length; i++){
            if (i == pList.length){
                System.out.println(">>제품 코드를 찾을 수 없습니다.");
                break;
            }
            if (pList[i].getpCode().equals(deleteCode)){ // 삭제할 인덱스 다음 인덱스부터 앞으로 한칸씩 당기고 새로운 배열로 만들어 이름 바꾸기 [1,2,3] > [1,3,3] > [1,3]
                for (int j = i; j < pList.length-1; j++) {
                    pList[j] = pList[j + 1];
                }
                Product[] newPList = new Product[pList.length - 1];
                for (int j = 0; j < newPList.length; j++){
                    newPList[j] = pList[j];
                }
                pList = newPList;
                System.out.println(">>삭제 완료");
                break;
            }
        }
    }
}




