package bitcmap.java89.ems;

import java.util.Scanner;


public class EduApp {
  public static void main(String[] args) {
    System.out.println("비트캠프 관리 시스템에 오신걸 환영합니다.");

    //여러명의 학생정보를 입력하기위한 레퍼런스 배열문듬
    Class[] classes = new Class[100];
    int length = 0;

    Scanner keyScan = new Scanner(System.in);
    Class s1 = null;


    while (length < classes.length){
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

      classes[length++] = s1;

      System.out.print("계속 입력하시겠습니까?(y/n)");
      if(!keyScan.nextLine().equals("y"))
        break;
    }

  }


  static void pirntClassList(Class[] classes, int length) {
    Class c1 = null;
    for(int i =0 ; i <length ; i++) {
      c1 = classes[i];
      System.out.printf("%s,%s,%s,%s,%s,%s,%s\n",
        c1.subject,
        c1.period,
        c1.time,
        c1.limit,
        c1.place,
        c1.target,
        c1.content);
    }
  }
}
