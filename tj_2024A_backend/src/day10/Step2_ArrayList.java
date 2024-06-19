package day10;

import java.util.ArrayList;
import java.util.Arrays;

public class Step2_ArrayList {

    public static void main(String[] args) {

        // [1] 문자열 10개 저장, 배열은 고정길이, 길이보다 커지거나 작아지면 복잡해진다.
        String[] strArray = new String[10];

        strArray[0] = "자바";
        strArray[1] = "파이썬";

        System.out.println(Arrays.toString(strArray));

        // [2] 문자열 N개 저장, 가변 길이
        // ArrayList<리스트에 저장되는 타입> 리스트.txt 변수명 = new ArrayList<>();
        ArrayList<String> strList = new ArrayList<>(); //기본값은 10개.

        strList.add("자바");
        strList.add("파이썬");

        System.out.println(strList);

        //[3] p.224

        ArrayList<Book> library = new ArrayList<>();

        library.add(new Book("태백산맥","조정래"));

        Book b2 = new Book ("데미안", "헤르만 헤세");
        library.add(b2);

        library.add(new Book("어떻게 살 것인가","유시민"));
        library.add(new Book("토지","박경리"));
        library.add(new Book("어린왕자","생텍쥐페리"));

        // 리스트.txt 순회하는 방법 1
        for (int i = 0; i < library.size(); i++)
            library.get(i).showBookInfo(); // System.out.println(bookName + ", " + author);

        // 리스트.txt 순회하는 방법 2 (향상된 for문)
        for (Book book : library){ // for(타입 반복변수명 : 리스트.txt){}, 리스트.txt 내 요소를 하나씩 변수에 대입
            book.showBookInfo();
        }

        // 리스트.txt 순회하는 방법 3 (forEach 함수 - 스트림 함수)
        library.forEach(book -> book.showBookInfo()); // 리스트명.forEach(반복변수명 -> 실행문);

        // 리스트.txt 전체 삭제
        library.clear();

        System.out.println(library);
    }
}
