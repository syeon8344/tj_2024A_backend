package day09.step3;

import java.util.Scanner;
import java.util.Arrays;

public class 제품CRUD_객체와가변길이배열버전 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product[] prodArray = new Product[0];

        while(true){ // 무한반복
            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5. 종료 선택 >>");
            int ch = scanner.nextInt();

            if (ch == 1){
                System.out.print("제품코드 입력 : "); String inputCode = scanner.next();
                System.out.print("제품명 입력 : "); String inputName = scanner.next();
                System.out.print("제품가격 입력 : "); int inputPrice = scanner.nextInt();

                if (inputPrice > 0 && !inputCode.equals("") && !inputName.equals("")){
//[p0]
                    for(int i = 0; ; i++){
                        if (i == prodArray.length) {
                            Product[] newArray = new Product[i+1];
                            System.out.println("newArray = " + Arrays.toString(newArray));
                            Product p = new Product(inputCode, inputName, inputPrice);
                            newArray[i] = p;
                            prodArray = newArray;
                            System.out.println("newProdArray = " + Arrays.toString(prodArray));
                            System.out.println(i + "= i " + prodArray[i].getProdCode() + prodArray[i].getProdName() + prodArray[i].getProdPrice());
                            break;
                        }

                        if (prodArray[i] == null){
                            Product p = new Product(inputCode, inputName, inputPrice);
                            prodArray[i] = p;
                            break;
                        }
                    }
                }
                else{
                    System.out.println("입력이 잘못되었습니다.");
                }

            }
            else if (ch == 2){
                System.out.println("=========== 제품목록 ===========");
                for (int i = 0; i < prodArray.length; i++) {
                    //if (!prodArray[i].getProdCode().equals("") && !prodArray[i].getProdName().equals("") && prodArray[i].getProdPrice() != 0){
                        //System.out.printf("\t %s \t %s \t\t %d\n", prodArray[i].getProdCode(), prodArray[i].getProdName(), prodArray[i].getProdPrice());
                    System.out.println(prodArray[i].getProdName());
                    //}
                }
            }
            else if (ch == 3){
                System.out.print("수정할 제품코드 : "); String updateCode = scanner.next();
                for (int i = 0; i <= prodArray.length; i++){
                    if (i == prodArray.length){
                        System.out.println("[경고] 존재하지 않는 코드입니다.");
                        break;
                    }
                    if (prodArray[i].getProdCode().equals(updateCode) && !(prodArray[i].getProdName().equals("") && prodArray[i].getProdPrice() == 0)){
                        System.out.print("새로운 제품명 : "); String newName = scanner.next();
                        if (!newName.equals("")) {prodArray[i].setProdName(newName);}
                        System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                        if (newPrice >= 0){prodArray[i].setProdPrice(newPrice);}
                        break;
                    }
                }
            }
            else if (ch == 4){
                System.out.print("삭제할 제품 코드 : "); String delCode = scanner.next();
                for (int i = 0; i <= prodArray.length; i++) {
                    if (i == prodArray.length){
                        System.out.println("[경고] 존재하지 않는 코드입니다.");
                        break;
                    }
                    if (prodArray[i].getProdCode().equals(delCode) && !(prodArray[i].getProdName().equals("") && prodArray[i].getProdPrice() == 0)){
                        prodArray[i].setProdName(""); prodArray[i].setProdPrice(0);}


                }
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
