package bitcamp.java89.ems.ex01;
import java.util.Scanner;


public class EduApp {
  static Scanner keyScan = new Scanner(System.in);

  public static void main(String[] args) {
    System.out.println("비트캠프 관리 시스템에 오신걸 환영합니다.");
    System.out.println("원하는 작업을 입력하세요.add/view/list");

    ClassController.keyScan = keyScan;
  //  Class s1 = null;


    loop:
    while (true){
      System.out.print("명령> ");
      String command = keyScan.nextLine().toLowerCase();

      switch (command) {
       case "add": ClassController.add(); break;
       case "list": ClassController.printClassList(); break;
       case "view": ClassController.listView(); break;
       case "quit":
         System.out.println("Good bye!!");
         break loop;
       default:
        System.out.println("지원하지 않는 명령어입니다.");
      }
    }
  }

}
