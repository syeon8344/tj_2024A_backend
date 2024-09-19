package day09.step1;

public class Step1 {
    public static void main(String[] args) {
        Student studentJames = new Student("james", 5000);
        Student studentThomas = new Student("thomas", 10000);

        Bus bus100 = new Bus(100);
        studentJames.takeBus(bus100);
        System.out.println(studentJames.toString());
        System.out.println(bus100.toString());

        Subway subwayGreen = new Subway("2호선");
        studentThomas.takeSubway(subwayGreen);
        System.out.println(studentThomas.toString());
        System.out.println(subwayGreen);

        // [4]. 180[, Edward 학생이 늦잠자서 택시를 타고 감; 요금 10000원

        Taxi taxi100가 = new Taxi("100가1000");
        Student studentEdward = new Student("edward", 12000);

        studentEdward.takeTaxi(taxi100가);
        System.out.println(studentEdward);
        System.out.println(taxi100가);
    }
}
