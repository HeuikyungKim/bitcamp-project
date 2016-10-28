package bitcamp.java89.ems;
import java.util.Scanner;


public class EduApp {
  public static void main(String[] args) {
    System.out.println("비트캠프 관리 시스템에 오신걸 환영합니다.");
    System.out.println("원하는 작업을 입력하세요.add/view/list");

    Class[] classes = new Class[100];
    int length = 0;

    Scanner keyScan = new Scanner(System.in);
    Class s1 = null;


    loop:
    while (true){
      System.out.print("명령> ");
      String command = keyScan.nextLine().toLowerCase();

      switch (command) {
       case "add":
         add(classes, length++);
         break;
       case "list":
         printClassList(classes, length);
         break;
       case "view":
         listView(classes, length);
         break;
       case "quit":
         System.out.println("Good bye!!");
         break loop;
       default:
        System.out.println("지원하지 않는 명령어입니다.");
      }
    }
  }


  static void add(Class[] classes, int length){
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
    classes[length] = c1;

  }

  static void printClassList(Class[] classes, int length) {
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

  static void listView(Class[] classes, int length) {
    Scanner keyScan = new Scanner(System.in);

    System.out.print("강좌명? : ");
    String view = keyScan.nextLine();
    for(int i=0; i<length ; i++){
      if(view.equals(classes[i].subject)){
       System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
       System.out.printf("강좌명 : %s,\n", classes[i].subject);
       System.out.printf("기간 : %s,\n", classes[i].period);
       System.out.printf("시간 : %s,\n", classes[i].time);
       System.out.printf("정원 : %s,\n", classes[i].limit);
       System.out.printf("장소 : %s,\n", classes[i].place);
       System.out.printf("대상 : %s,\n", classes[i].target);
       System.out.printf("상세 : %s,\n", classes[i].content);
       System.out.println();
       break;
      }
    }

  }

}
