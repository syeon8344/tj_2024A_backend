package day09.step3;

import java.util.Scanner;

public class 제품CRUD_변수버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String prodCode1=""; String prodName1=""; int prodPrice1=0;
        String prodCode2=""; String prodName2=""; int prodPrice2=0;
        String prodCode3=""; String prodName3=""; int prodPrice3=0;

        // 제품 메모리 설계

        while(true){ // 무한반복
            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5. 종료 선택 >>");
            int ch = scanner.nextInt();

            if (ch == 1){
                System.out.print("제품코드 입력 : "); String inputCode = scanner.next();
                System.out.print("제품명 입력 : "); String inputName = scanner.next();
                System.out.print("제품가격 입력 : "); int inputPrice = scanner.nextInt();
                if (inputPrice <= 0)
                    System.out.println("[경고] 제품가격이 잘못되었습니다.");
                else if (!inputCode.equals("") && prodName1.equals("") && prodPrice1 == 0){
                    prodCode1 = inputCode; prodName1 = inputName; prodPrice1 = inputPrice;
                }
                else if (!inputCode.equals("") && prodName2.equals("") && prodPrice2 == 0){
                    prodCode2 = inputCode; prodName2 = inputName; prodPrice2 = inputPrice;
                }
                else if (!inputCode.equals("") && prodName3.equals("") && prodPrice3 == 0){
                    prodCode3 = inputCode; prodName3 = inputName; prodPrice3 = inputPrice;
                }
                else
                    System.out.println("[경고] 제품 등록 자리가 부족합니다");
            }
            else if (ch == 2){
                System.out.println("=========== 제품목록 ===========");
                if (!prodCode1.equals("") && !prodName1.equals("") && prodPrice1 != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode1, prodName1, prodPrice1);
                }
                if (!prodCode2.equals("") && !prodName2.equals("") && prodPrice2 != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode2, prodName2, prodPrice2);
                }
                if (!prodCode3.equals("") && !prodName3.equals("") && prodPrice3 != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode3, prodName3, prodPrice3);
                }
            }
            else if (ch == 3){
                System.out.print("수정할 제품코드 : "); String updateCode = scanner.next();
                if (updateCode.equals(prodCode1) && !prodName1.equals("") && prodPrice1 != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName1 = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice1 = newPrice;}
                }
                else if (updateCode.equals(prodCode2) && !prodName2.equals("") && prodPrice2 != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName2 = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice2 = newPrice;}
                }
                else if (updateCode.equals(prodCode3) && !prodName3.equals("") && prodPrice3 != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName3 = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice3 = newPrice;}
                }
                else
                    System.out.println("[경고] 존재하지 않는 코드입니다.");
            }
            else if (ch == 4){
                System.out.print("삭제할 제품 코드 : "); String delCode = scanner.next();
                if (delCode.equals(prodCode1) && !prodName1.equals("") && prodPrice1 != 0){
                    prodName1 = ""; prodPrice1 = 0;}
                else if (delCode.equals(prodCode2) && !prodName1.equals("") && prodPrice1 != 0){
                    prodName2 = ""; prodPrice2 = 0;}
                else if (delCode.equals(prodCode3) && !prodName1.equals("") && prodPrice1 != 0){
                    prodName3 = ""; prodPrice3 = 0;}
                else
                    System.out.println("[경고] 존재하지 않는 코드입니다.");
            }
            else if (ch == 5){
                System.out.println("[안내] 프로그램을 종료합니다."); break;
            }
            else {
                System.out.println("[안내] 알 수 없는 번호입니다.");
            }
        }


    }
}
