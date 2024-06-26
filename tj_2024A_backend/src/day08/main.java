package day08;

public class main {

    public static void main(String[] args) {

        축구 p1 =new 축구();
        p1.setNumber(1);
        p1.setAge(40);
        p1.setName("유재석");
        p1.setPosition("공격수");
        p1.setLocation("인천");

        축구 p2= new 축구(2 ,"박지성");
        p2.setAge(31);
        p2.setPosition("미드필더");
        p2.setLocation("인천");

        축구 p3= new 축구(3);
        p3.setAge(31);
        p3.setName("손흥민");
        p3.setPosition("공격수");
        p3.setLocation("토트넘");

        축구 p4= new 축구(4);
        p4.setAge(25);
        p4.setName("이강인");
        p4.setPosition("미드필더");
        p4.setLocation("파리");

        축구 p5= new 축구(5);
        p5.setAge(28);
        p5.setName("김민재");
        p5.setPosition("수비수");
        p5.setLocation("독일");


        축구 p6= new 축구(6);
        p6.setAge(21);
        p6.setName("서장훈");
        p6.setPosition("공격수");
        p6.setLocation("서울");

        System.out.print(p1.getNumber() +",\t" + p1.getName() + ",\t" +p1.getAge() +",\t" + p1.getPosition()+ ",\t" + p1.getLocation()+"\n");
        System.out.print(p2.getNumber()+",\t" + p2.getName() + ",\t" +p2.getAge() +",\t" + p2.getPosition()+ ",\t" + p2.getLocation()+"\n");
        System.out.print(p3.getNumber()+",\t" + p3.getName() + ",\t" +p3.getAge() +",\t" + p3.getPosition()+ ",\t" + p3.getLocation()+"\n");
        System.out.print(p4.getNumber()+",\t" + p4.getName() + ",\t" +p4.getAge() +",\t" + p4.getPosition()+ ",\t" + p4.getLocation()+"\n");
        System.out.print(p5.getNumber()+",\t" + p5.getName() + ",\t" +p5.getAge() +",\t" + p5.getPosition()+ ",\t" + p5.getLocation()+"\n");
        System.out.print(p6.getNumber()+",\t" + p6.getName() + ",\t" +p6.getAge() +",\t" + p6.getPosition()+ ",\t" + p6.getLocation()+"\n");




    }
}
