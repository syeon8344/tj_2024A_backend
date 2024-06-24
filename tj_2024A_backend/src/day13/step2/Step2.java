package day13.step2;

class 상위클래스{

}

class 하위클래스 extends 상위클래스{

    // 생성자
    하위클래스(){
        super(); // 상위 클래스에 생성자 코드가 따로 없으면 상위 클래스의 디폴트 생성자 자동 호출
    }
}

class 상위클래스B {
    상위클래스B(int a, int b){ // 직접 작성한 생성자가 있으면 디폴트 생성자 X

    }
}

class 하위클래스B extends 상위클래스B{
    하위클래스B(){
        super(1, 2); // 상위 클래스 생성자에 필요한 매개변수가 있는 super() 필요
    }
}

class 상위클래스C {
    // 생성자 2개 : 오버로딩, 매개변수의 순서, 개수, 타입 따라 생성자 여러개 구현 가능
    상위클래스C(){};
    상위클래스C(boolean a, int b){};
    상위클래스C(int b, boolean a){};
}

class 하위클래스C extends 상위클래스C{
    하위클래스C(){}; //상위클래스의 디폴트 생성자가 있으므로 super() 자동 생성
}
// ======================================================
class A{}                   // 부모 :  , 자식 : B,C 자손 : D,E
class B extends A{}         // 부모 : A, 자식 : D
class C extends A{}         // 부모 : A, 자식 : E
class D extends B{}         // 부모 : B, 자식 :
class E extends C{}         // 부모 : C, 자식 :
public class Step2 {
    public static void main(String[] args) {
        B b = new B();      C c = new C();
        D d = new D();      E e = new E();
        // 묵시적/자동 타입변환
        A a1 = b;       A a2 = c;       // 부모타입 <--- 자식타입
        A a3 = d;       A a4 = e;       // 부모타입 <--- 부모타입 <--- 자식타입
        // 불가능
        // B b1 = c;                    // 형제관계, 오류
        // C c1 = d;                    // 상하관계 X, 오류

        // 강제 타입변환
        B b1 = (B)a1;                   // a1은 원래 B였으므로 강제 타입변환 가능
        E e1 = (E)a4;                   // a4는 원래 E였으므로 강제 타입변환 가능

        //E e2 = (E)a1;                   // 실행하면 오류 : ClassCastException, E는 B를 상속받지 않으므로 오류
        //D d2 = (D)a2;                   // D는 C를 상속받지 않으므로 오류

        // 본래 태생/타입 찾기
            // 객체 instanceof 타입 : 해당 객체가 타입으로 포함되는지 여부, true / false 반환됨
        boolean result1 = a1 instanceof A;
        System.out.println(result1);
        boolean res2 = a1 instanceof B;
        System.out.println(res2);
        boolean res3 = a1 instanceof C;
        System.out.println(res3);
        boolean res4 = a1 instanceof D;
        System.out.println(res4);

    }
}
