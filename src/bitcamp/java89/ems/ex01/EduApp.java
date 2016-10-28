package bitcamp.java89.ems.ex01;
import java.util.Scanner;


public class EduApp {
  public static void main(String[] args) {
    System.out.println("비트캠프 관리 시스템에 오신걸 환영합니다.");


  Scanner keyScan = new Scanner(System.in);

  Class c1 = new Class();
  System.out.print("강좌명 : ");
  c1.subject = keyScan.nextLine();
  System.out.print("기간 : ");
  c1.period = keyScan.nextLine();
  System.out.print("시간 : ");
  c1.time = keyScan.nextLine();
  System.out.print("정원 : ");
  c1.limit = Integer.parseInt(keyScan.nextLine());
  System.out.print("장소 : ");
  c1.place = keyScan.nextLine();
  System.out.print("대상 : ");
  c1.target = keyScan.nextLine();
  System.out.print("과정내용 : ");
  c1.content = keyScan.nextLine();

  System.out.printf("강좌명 : %s\n", c1.subject);
  System.out.printf("기간 : %s\n", c1.period);
  System.out.printf("시간 : %s\n", c1.time);
  System.out.printf("정원 : %s\n", c1.limit);
  System.out.printf("장소 : %s\n", c1.place);
  System.out.printf("대상 : %s\n", c1.target);
  System.out.printf("과정내용 : %s\n", c1.content);


  }

}
