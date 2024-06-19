package 과제;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Level1 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Level1_1
        System.out.println(" >> Level1_1 answer >>");
        System.out.println();

        boolean bool1 = true;
        System.out.println("boolean : " + bool1);

        byte b1 = 100;
        System.out.println("byte : " + b1);

        char c1 = 'a';
        System.out.println("char : " + c1);

        short s1 = 30000;
        System.out.println("short : " + s1);

        int i1 = 2000000000;
        System.out.println("int : " + i1);

        long l1 = 40000000000L;
        System.out.println("long : " + l1);

        float f1 = 3.1231232f;
        System.out.println("float : " + f1);

        double d1 = 3.123123123;
        System.out.println("double : " + d1);

        // Level1_2
        System.out.println("\n >> Level1_2 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>");
        System.out.println();

        boolean bool2 = true;
        byte b2 = 100;
        char c2 = 'A';
        short s2 = 30000;
        int i2 = 2000000000;
        long l2 = 40000000000L;
        float f2 = 3.123f;
        double d2 = 3.12312312;

        System.out.println("type                   value                             range");
        System.out.println("--------------------------------------------------------------");
        System.out.printf("boolean\t\t\t  %10s\t\t\t\t\t true or false\n", bool2);
        System.out.printf("byte\t\t\t  %10d\t\t\t\t\t   - 128 ~ 127\n", b2);
        System.out.printf("char\t\t\t  %10s\t\t\t0~65535[ character 1 ]\n", c2);
        System.out.printf("short\t\t\t  %10d\t\t\t\t\t-32768 ~ 32767\n", s2);
        System.out.printf("int\t\t\t\t  %10d\t\t\t\t\t-+2000 million\n", i2);
        System.out.printf("long\t\t\t %10d\t\t\t -+2000 million Excess\n", l2);
        System.out.printf("float\t\t\t\t   %.3f\t\t\t\t  8 decimal places\n", f2);
        System.out.printf("double\t\t\t  %.8f\t\t\t\t 17 decimal places\n", d2);

        // Level1_3
        System.out.println("\n >> Level1_3 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>");

        System.out.print("\ninput boolean : "); boolean bool3 = scanner.nextBoolean();
        System.out.print("\ninput byte : "); byte b3 = scanner.nextByte();
        System.out.print("\ninput char : "); char c3 = scanner.next().charAt(0);
        System.out.print("\ninput short : "); short s3 = scanner.nextShort();
        System.out.print("\ninput int : "); int i3 = scanner.nextInt();
        System.out.print("\ninput long : "); long l3 = scanner.nextLong();
        System.out.print("\ninput float : "); float f3 = scanner.nextFloat();
        System.out.print("\ninput double : "); double d3 = scanner.nextFloat();

        System.out.print("\noutput boolean : " + bool3);
        System.out.print("\noutput byte : " + b3);


        // Level1_4
        System.out.println("\n >> Level1_4 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        String answer = "          ,r'\"7\nr`-_   ,`  ,/\n \\. \". L_r`\n   `~\\/\n      |\n      |\n";
        System.out.println(answer);


        // Level1_5
        System.out.println("\n >> Level1_5 answer >>\n");
        byte b5 = 100; short bs5 = b5; System.out.println("byte -> short : " + bs5);
        short s5 = 30000; int si5 = s5; System.out.println("short -> int : " + si5);
        int i5 = 2000000000; long il5 = i5; System.out.println("int -> long : " + il5);
        long l5 = 40000000000L; float lf5 = l5; System.out.println("long -> float : " + lf5);
        float f5 = 3.1231231689453125f; double fd5 = f5; System.out.println("float -> double : " + fd5);


        // Level1_6
        System.out.println("\n >> Level1_6 answer >>\n");
        short s6 = 48; byte sb6 = (byte)s6; System.out.println("byte <- short : " + sb6);
        int i6 = -27648; short is6 = (short)i6; System.out.println("short <- int : " + is6);
        long l6 = 1345294336L; int li6 = (int)l6; System.out.println("int <- long : " + li6);
        float f6 = 3.123123f; long fl6 = (long)f6; System.out.println("long <- float : " + fl6);
        double d6 = 3.123123168945; float df6 = (float)d6; System.out.println("float <- double : " + df6);

        // Level1_7
        System.out.println("\n >> Level1_7 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");
        //System.out.print("input byte : "); byte b3 = scanner.nextByte();
        System.out.print("회원명 String : "); String str7 = scanner.next();
        System.out.print("상태 boolean : "); boolean bool7 = scanner.nextBoolean();
        System.out.print("회원번호 byte : "); byte b7 = scanner.nextByte();
        System.out.print("성별 char : "); char c7 = scanner.next().charAt(0);
        System.out.print("나이 short : "); short s7 = scanner.nextShort();
        System.out.print("포인트 int : "); int i7 = scanner.nextInt();
        System.out.print("예금액 long : "); long l7 = scanner.nextLong();
        System.out.print("키 float : "); float f7 = scanner.nextFloat();
        System.out.print("몸무게 double : "); double d7 = scanner.nextDouble();

        System.out.printf("==========회원 개인정보=============\n");
        System.out.printf("|\t\t회원명 : %s\t\t\t |\n", str7);
        System.out.printf("|\t\t상태 : %b\t\t\t\t |\n", bool7);
        System.out.printf("|\t\t회원번호 : %d\t\t\t |\n", b7);
        System.out.printf("|\t\t성별 : %c\t\t\t\t\t |\n", c7);
        System.out.printf("|\t\t나이 : %d\t\t\t\t |\n", s7);
        System.out.printf("|\t\t포인트 : %d\t\t\t |\n", i7);
        System.out.printf("|\t\t예금액 : %d\t\t\t |\n", l7);
        System.out.printf("|\t\t키 : %.1f\t\t\t\t |\n", f7);
        System.out.printf("|\t\t몸무게 : %.2f\t\t\t |\n", d7);
        System.out.printf("==================================");



        // Level1_8
        System.out.println("\n >> Level1_8 answer >>");
        System.out.println(" >> answer time : " + LocalDateTime.now() + " >>\n");

        String header = "\n============방문록===============\n번호\t\t 작성자 \t\t방문록\n";
        String boardlist = "";
        String footer = "================================\n";
        String output = "";


        /* 문제풀이 위치 */
        System.out.print("[1]작성자 : "); output = scanner.next(); boardlist += ("1\t\t " +output);
        scanner.nextLine();
        System.out.print("[1]방문록 : "); output = scanner.nextLine(); boardlist += ("\t\t" + output + "\n");
        System.out.println(header + boardlist + footer);

        System.out.print("[2]작성자 : "); output = scanner.next(); boardlist += ("2\t\t " +output);
        scanner.nextLine();
        System.out.print("[2]방문록 : "); output = scanner.nextLine(); boardlist += ("\t\t" + output + "\n");
        System.out.println(header + boardlist + footer);

        System.out.print("[3]작성자 : "); output = scanner.next(); boardlist += ("3\t\t " +output);
        scanner.nextLine();
        System.out.print("[3]방문록 : "); output = scanner.nextLine(); boardlist += ("\t\t" + output + "\n");
        System.out.println(header + boardlist + footer);

        System.out.print("[4]작성자 : "); output = scanner.next(); boardlist += ("4\t\t " +output);
        scanner.nextLine();
        System.out.print("[4]방문록 : "); output = scanner.nextLine(); boardlist += ("\t\t" + output + "\n");
        System.out.println(header + boardlist + footer);

        System.out.print("[5]작성자 : "); output = scanner.next(); boardlist += ("5\t\t " +output);
        scanner.nextLine();
        System.out.print("[5]방문록 : "); output = scanner.nextLine(); boardlist += ("\t\t" + output + "\n");
        System.out.println(header + boardlist + footer);
        /* ----------- */





    }
}
