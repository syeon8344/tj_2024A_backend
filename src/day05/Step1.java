package day05;

public class Step1 {
    
    public static void main(String[] args) {
        
        // p94
        int age = 7;
        if (age >= 8) {
            System.out.println("학교에 다닙니다.");
        }
        
        // p97
        int age2 = 9;
        int charge;
        if (age2 < 8) { charge = 1000;
            System.out.println("취학 전 아동입니다"); }
        else if (age2 < 14) { charge = 2000;
            System.out.println("초등학생입니다"); }
        else if (age2 < 20) { charge = 2500;
            System.out.println("중 고등학생입니다"); }
        else { charge = 3000;
            System.out.println("일반인입니다"); }
        System.out.println("입장료는 " + charge +"원입니다");
        
        // p102
        int ranking = 1;
        char medalColor;
        
        switch (ranking) {
            case 1:
                medalColor = 'G';
                System.out.println("case1");
                break;
            case 2:
                medalColor = 'S';
                System.out.println("case2");
                break;
            case 3:
                medalColor = 'B';
                System.out.println("case3");
                break;
            default:
                medalColor = 'A';
                System.out.println("caseD");
        }

        System.out.println("메달 색깔은 " + medalColor + "입니다");

        String medalColor2 = "Gold";
        switch (medalColor2) {
            case "Gold" :
                System.out.println("금메달입니다");
                break;
            case "Silver" :
                System.out.println("은메달입니다");
                break;
            case "Bronze" :
                System.out.println("동메달입니다");
                break;
        }



    }
}
