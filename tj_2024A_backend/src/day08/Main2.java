package day08;

import java.util.Arrays;
import java.util.Scanner;

public class main2 {
    public static void main(String[] args) {

        Scanner scanner= new Scanner(System.in);
         축구[] array1=new 축구[100];

        while(true){
            System.out.println(Arrays.toString(array1));
           System.out.println("1.선수등록 2. 전체선수명단 선택");
           int ch= scanner.nextInt();
           if(ch==1){

               System.out.println("1");
               System.out.println("나이입력: "); int age=scanner.nextInt();
               System.out.println("번호입력: "); int number=scanner.nextInt();
               System.out.println("이름입력: "); String name =scanner.next();
               System.out.println("포지션입력: "); String position =scanner.next();
               System.out.println("소속팀입력: "); String location =scanner.next();

               축구 s= new 축구(age,number,name,position,location);

               for(int i=0; i<array1.length; i++) {
                   if(array1[i]==null) {
                       array1[i] = s;
                       break;
                   }
               }

           }else if(ch==2){
               System.out.println("2");
               for(int i=0; i<array1.length; i++){
                   if(array1[i] !=null){
                      array1[i].showInfo();
                   }
               }
            }else {
               System.out.println("없는 번호");
           }

        }


    }
}
