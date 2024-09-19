package day09.step3;

import java.util.Scanner;

public class 제품CRUD_배열버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String[] prodCode = new String[]{"","",""};
        String[] prodName = new String[]{"","",""};
        int[] prodPrice = new int[3];
        
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
                else if (!inputCode.equals("") && prodName[0].equals("") && prodPrice[0] == 0){
                    prodCode[0] = inputCode; prodName[0] = inputName; prodPrice[0] = inputPrice;
                }
                else if (!inputCode.equals("") && prodName[1].equals("") && prodPrice[1] == 0){
                    prodCode[1] = inputCode; prodName[1] = inputName; prodPrice[1] = inputPrice;
                }
                else if (!inputCode.equals("") && prodName[2].equals("") && prodPrice[2] == 0){
                    prodCode[2] = inputCode; prodName[2] = inputName; prodPrice[2] = inputPrice;
                }
                else
                    System.out.println("[경고] 제품 등록 자리가 부족합니다");
            }
            else if (ch == 2){
                System.out.println("=========== 제품목록 ===========");
                if (!prodCode[0].equals("") && !prodName[0].equals("") && prodPrice[0] != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode[0], prodName[0], prodPrice[0]);
                }
                if (!prodCode[1].equals("") && !prodName[1].equals("") && prodPrice[1] != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode[1], prodName[1], prodPrice[1]);
                }
                if (!prodCode[2].equals("") && !prodName[2].equals("") && prodPrice[2] != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodCode[2], prodName[2], prodPrice[2]);
                }
            }
            else if (ch == 3){
                System.out.print("수정할 제품코드 : "); String updateCode = scanner.next();
                if (updateCode.equals(prodCode[0]) && !prodName[0].equals("") && prodPrice[0] != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName[0] = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice[0] = newPrice;}
                }
                else if (updateCode.equals(prodCode[1]) && !prodName[1].equals("") && prodPrice[1] != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName[1] = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice[1] = newPrice;}
                }
                else if (updateCode.equals(prodCode[2]) && !prodName[2].equals("") && prodPrice[2] != 0){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodName[2] = newName;}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodPrice[2] = newPrice;}
                }
                else
                    System.out.println("[경고] 존재하지 않는 코드입니다.");
            }
            else if (ch == 4){
                System.out.print("삭제할 제품 코드 : "); String delCode = scanner.next();
                if (delCode.equals(prodCode[0]) && !prodName[0].equals("") && prodPrice[0] != 0){
                    prodName[0] = ""; prodPrice[0] = 0;}
                else if (delCode.equals(prodCode[1]) && !prodName[0].equals("") && prodPrice[0] != 0){
                    prodName[1] = ""; prodPrice[1] = 0;}
                else if (delCode.equals(prodCode[2]) && !prodName[0].equals("") && prodPrice[0] != 0){
                    prodName[2] = ""; prodPrice[2] = 0;}
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
