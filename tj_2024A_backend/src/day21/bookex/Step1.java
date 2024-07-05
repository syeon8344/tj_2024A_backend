package day21.bookex;

public class Step1 {
    public static void main(String[] args) {
        Book book1 = new Book(200, "개미");
        System.out.println(book1); // 객체 주소값 (클래스명@해시코드값)
        System.out.println(book1.toString()); // 객체 주소값

        String str = new String("abc");
        System.out.println(str);
        Integer i1 = new Integer(100);
        System.out.println(i1);

    }
}

class Book{
    int bookNumber;
    String bookTitle;
    Book(int bookNumber, String bookTitle){
        this.bookNumber = bookNumber;
        this.bookTitle = bookTitle;
    }
}


