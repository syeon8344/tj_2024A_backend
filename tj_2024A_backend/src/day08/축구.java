package day08;

public class 축구 {

    private int age;
    private int number;

    private String name;
    private String position;
    private String location;


    축구(){}

    축구(int number){
        this.number=number;
    }

    축구(int number, String name){
        this.number=number;
        this.name = name;
    }

    축구(int number, String name, int age){
        this.name=name;
    }

    축구(int number, String name, int age, String position){
        this.position=position;
    }

    public 축구(int age, int number, String name, String position, String location) {
        this.age = age;
        this.number = number;
        this.name = name;
        this.position = position;
        this.location = location;
    }

    public void showInfo(){
        System.out.print(getNumber() +",\t" + getName() + ",\t" +getAge() +",\t" + getPosition()+ ",\t" + getLocation()+"\n");
    }
    //getter and setter

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
