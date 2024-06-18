package day09.step3;

import java.util.Scanner;

public class 제품CRUD_함수활용객체와배열버전 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product[] prodArray = new Product[3];

        prodArray[0] = new Product("","",0);
        prodArray[1] = new Product("","",0);
        prodArray[2] = new Product("","",0);

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
                else if (prodArray[0].getProdCode().equals("") && prodArray[0].getProdName().equals("") && prodArray[0].getProdPrice() == 0){
                    prodArray[0].setProdCode(inputCode); prodArray[0].setProdName(inputName); prodArray[0].setProdPrice(inputPrice);
                }
                else if (prodArray[1].getProdCode().equals("") && prodArray[1].getProdName().equals("") && prodArray[1].getProdPrice() == 0){
                    prodArray[1].setProdCode(inputCode); prodArray[1].setProdName(inputName); prodArray[1].setProdPrice(inputPrice);
                }
                else if (prodArray[2].getProdCode().equals("") && prodArray[2].getProdName().equals("") && prodArray[2].getProdPrice() == 0){
                    prodArray[2].setProdCode(inputCode); prodArray[2].setProdName(inputName); prodArray[2].setProdPrice(inputPrice);
                }
                else
                    System.out.println("[경고] 제품 등록 자리가 부족합니다");
            }
            else if (ch == 2){
                System.out.println("=========== 제품목록 ===========");
                if (!prodArray[0].getProdCode().equals("") && !prodArray[0].getProdName().equals("") && prodArray[0].getProdPrice() != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodArray[0].getProdCode(), prodArray[0].getProdName(), prodArray[0].getProdPrice());
                }
                if (!prodArray[1].getProdCode().equals("") && !prodArray[1].getProdName().equals("") && prodArray[1].getProdPrice() != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodArray[1].getProdCode(), prodArray[1].getProdName(), prodArray[1].getProdPrice());
                }
                if (!prodArray[2].getProdCode().equals("") && !prodArray[2].getProdName().equals("") && prodArray[2].getProdPrice() != 0){
                    System.out.printf("\t %s \t %s \t\t %d\n", prodArray[2].getProdCode(), prodArray[2].getProdName(), prodArray[2].getProdPrice());
                }
            }
            else if (ch == 3){
                System.out.print("수정할 제품코드 : "); String updateCode = scanner.next();
                if (prodArray[0].getProdCode().equals(updateCode) && !(prodArray[0].getProdName().equals("") && prodArray[0].getProdPrice() == 0)){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodArray[0].setProdName(newName);}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodArray[0].setProdPrice(newPrice);}
                }
                else if (prodArray[1].getProdCode().equals(updateCode) && !(prodArray[1].getProdName().equals("") && prodArray[1].getProdPrice() == 0)){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodArray[1].setProdName(newName);}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodArray[1].setProdPrice(newPrice);}
                }
                else if (prodArray[2].getProdCode().equals(updateCode) && !(prodArray[2].getProdName().equals("") && prodArray[2].getProdPrice() == 0)){
                    System.out.print("새로운 제품명 : "); String newName = scanner.next();
                    if (!newName.equals("")) {prodArray[2].setProdName(newName);}
                    System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                    if (newPrice >= 0){prodArray[2].setProdPrice(newPrice);}
                }
                else
                    System.out.println("[경고] 존재하지 않는 코드입니다.");
            }
            else if (ch == 4){
                System.out.print("삭제할 제품 코드 : "); String delCode = scanner.next();
                if (prodArray[0].getProdCode().equals(delCode) && !(prodArray[0].getProdName().equals("") && prodArray[0].getProdPrice() == 0)){
                    prodArray[0].setProdName(""); prodArray[0].setProdPrice(0);}
                else if (prodArray[1].getProdCode().equals(delCode) && !(prodArray[1].getProdName().equals("") && prodArray[1].getProdPrice() == 0)){
                    prodArray[1].setProdName(""); prodArray[1].setProdPrice(1);}
                else if (prodArray[2].getProdCode().equals(delCode) && !(prodArray[2].getProdName().equals("") && prodArray[2].getProdPrice() == 0)){
                    prodArray[2].setProdName(""); prodArray[2].setProdPrice(0);}
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
