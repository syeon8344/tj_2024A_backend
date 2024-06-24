package day13.step4;

class Parent{ //부모 상위클래스
    //1. 멤버변수
    protected String field1;
    //2. 생성자
    //3. 메소드
    public void method1(){
        System.out.println("Parent.method1"); // soutm 현재 메소드 출력
    }
    public void method2(){
        System.out.println("Parent.method2");
    }
}

class Child extends Parent{ //자식 하위클래스
    protected String field2;
    public void method3(){
        System.out.println("Child.method3");
    }
    // 오버라이딩 : 상속받은 메소드의 로직 재정의

    @Override
    public void method1() {
        System.out.println("Child.method1");
    }

    @Override
    public void method2() {
        System.out.println("Child.method2");
    }
}

public class Step4 {
    public static void main(String[] args) {

        Child child = new Child();
        child.method1(); // 자식은 상속받은 메소드 사용가능  //Child.method1
        child.method2();                                 //Child.method2
        System.out.println(child.field1);

        System.out.println(child.field2);
        child.method3();                                //Child.method3
        //=================================================
        Parent parent = child; //자식타입 --> 부모타입
        parent.method1();                               //Parent.method1 // Child.method1 (오버라이드됨)
        parent.method2();                               //Parent.method2 // Child.method2 (오버라이드됨)
        System.out.println(parent.field1);

        //System.out.println(parent.field2); //자식의 멤버변수, 메서드는 부모타입에서 사용불가
        //parent.method3();

        Child child1 = (Child) parent; //다운캐스팅, 자식 --> 부모 --> 자식 타입변환
        System.out.println(child1.field2);
        child1.method3();                               //Child.method3
    }
}
