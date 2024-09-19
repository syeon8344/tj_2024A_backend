package day10;

import java.util.ArrayList;
import java.util.Scanner;


public class Step4_기능별함수버전 {

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

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayList<Product> pList = new ArrayList<>();

        while (true) { // 무한반복
            System.out.println("리스트상태 : " + pList);
            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5.종료 선택 >> "); // 무한출력
            int ch = scanner.nextInt(); // 무한입력
            if (ch == 1) {
                System.out.print(">>제품 코드 : "); String newCode = scanner.next();
                System.out.print(">>제품명 : "); String newName = scanner.next();
                System.out.print(">>제품가격 : "); int newPrice = scanner.nextInt();
                Product p = new Product(newCode, newName, newPrice);
                pList.add(p);
                System.out.println(">>제품 추가 완료");
            } else if (ch == 2) {
                System.out.println("=== 제품코드  제품명  제품가격 =======");
                for (int i = 0; i < pList.size(); i++){
                    Product p = pList.get(i);
                    System.out.printf("%s\t\t%s\t\t%d\n", p.getpCode(), p.getpName(), p.getpPrice());
                }
            } else if (ch == 3) {
                System.out.print(">>제품 코드 : "); String updateCode = scanner.next();
                for (int i = 0; i < pList.size(); i++){
                    if(pList.get(i).getpCode().equals(updateCode)){
                        System.out.print(">>새 제품명 : "); String updateName = scanner.next();
                        System.out.print(">>새 제품가격 : "); int updatePrice = scanner.nextInt();
                        Product p = new Product(updateCode, updateName, updatePrice);
                        pList.set(i, p);
                        System.out.println(">>수정 완료");
                        break;
                    }
                }
                System.out.println(">>제품 코드를 찾을 수 없습니다.");
            } else if (ch == 4) {
                System.out.print(">>제품 코드 : "); String deleteCode = scanner.next();
                for (int i = 0; i < pList.size(); i++){
                    if(pList.get(i).getpCode().equals(deleteCode)) {
                        pList.remove(i); // 해당 인덱스의 요소 삭제, 뒷부분은 한칸씩 당긴다
                        System.out.println(">>삭제 완료");
                        break;
                    }
                }
                System.out.println(">>제품 코드를 찾을 수 없습니다.");
            } else if (ch == 5) {
                System.out.println("안내] 프로그램 종료합니다.");
                break;
            } else {
                System.out.println("안내] 알수없는 번호 입니다.");
            }

        }
    }
}




