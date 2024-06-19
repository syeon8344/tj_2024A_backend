package day10;

import day10.Product;

import java.util.Arrays;
import java.util.Scanner;

public class 제품CRUD_객체와가변길이배열버전 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Product[] prodArray = new Product[0];

        while(true){ // 무한반복
            System.out.println(">>현재 배열 : " + Arrays.toString(prodArray));
            System.out.print("1.등록(C) 2.출력(R) 3.수정(U) 4.삭제(D) 5. 종료 선택 >>");
            int ch = scanner.nextInt();

            if (ch == 1){
                System.out.print("제품코드 입력 : "); String inputCode = scanner.next();
                System.out.print("제품명 입력 : "); String inputName = scanner.next();
                System.out.print("제품가격 입력 : "); int inputPrice = scanner.nextInt();

                if (inputPrice > 0 && !inputCode.equals("") && !inputName.equals("")){ // 유효성 검사
                    for(int i = 0; ; i++){
                        if (i == prodArray.length) { // 비어있는 공간이 없어서 배열을 한 칸 늘리고 늘린 칸에 객체 저장
                            Product p = new Product(inputCode, inputName, inputPrice);
                            Product[] newArray = new Product[prodArray.length+1];
                            for (int j=0; j< prodArray.length; j++)
                                newArray[j] = prodArray[j];
                            prodArray = newArray;
                            prodArray[i] = p;
                            System.out.println(i + "번째 인덱스에 저장 완료");
                            break;
                        }

                        if (prodArray[i] == null){
                            Product p = new Product(inputCode, inputName, inputPrice);
                            prodArray[i] = p;
                            System.out.println(i + "번째 인덱스에 저장 완료");
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
                    if (prodArray[i] != null){ // 빈 공간은 제외
                        System.out.printf("\t %s \t %s \t\t %d\n", prodArray[i].getpCode(), prodArray[i].getpName(), prodArray[i].getpPrice());
                    }
                }
            }
            else if (ch == 3){
                System.out.print("수정할 제품코드 : "); String updateCode = scanner.next();
                for (int i = 0; i <= prodArray.length; i++){
                    if (i == prodArray.length){
                        System.out.println("[경고] 존재하지 않는 코드입니다.");
                        break;
                    }
                    if (prodArray[i].getpCode().equals(updateCode)){
                        System.out.print("새로운 제품명 : "); String newName = scanner.next();
                        if (!newName.equals("")) {prodArray[i].setpName(newName);}
                        System.out.print("새로운 제품 가격 : "); int newPrice = scanner.nextInt();
                        if (newPrice >= 0){prodArray[i].setpPrice(newPrice);}
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
                    if (prodArray[i].getpCode().equals(delCode)){ // 삭제할 인덱스 다음 인덱스부터 앞으로 한칸씩 당기고 새로운 배열로 만들어 이름 바꾸기 [1,2,3] > [1,3,3] > [1,3]
                        for (int j = i; j < prodArray.length-1; j++) {
                            prodArray[j] = prodArray[j + 1];
                        }
                        Product[] newProdArray = new Product[prodArray.length - 1];
                        for (int j = 0; j < newProdArray.length; j++){
                            newProdArray[j] = prodArray[j];
                        }
                        prodArray = newProdArray;
                        break;
                    }
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
