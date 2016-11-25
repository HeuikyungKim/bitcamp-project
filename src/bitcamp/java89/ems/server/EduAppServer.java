package bitcamp.java89.ems.server;

import java.io.File;
import java.net.ServerSocket;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.controller.AbstractCommand;

public class EduAppServer {
  // Command 구현체 보관소
  // => HashMap<명령문자열,요청처리객체> commandMap
  HashMap<String,Command> commandMap = new HashMap<>();

  public EduAppServer() {
    ArrayList<Class> classList = new ArrayList<>();
    ReflectionUtil.getCommandClasses(new File("./bin"),classList);
    for(Class c : classList) {
      //클라이언트 요청을 처리할 command 객체 등록
      
      try {
      AbstractCommand command =(AbstractCommand) c.newInstance();
      } catch (Exception e) {}
    }
    // 클라이언트 요청을 처리할 Command 구현체 준비
    /*
    commandMap.put("contact/list", new ContactListController());
    commandMap.put("contact/view", new ContactViewController());
    commandMap.put("contact/add", new ContactAddController());
    commandMap.put("contact/delete", new ContactDeleteController());
    commandMap.put("contact/update", new ContactUpdateController());
    
    commandMap.put("textBook/add", new TextBookAddController());
    commandMap.put("textBook/list", new TextBookListController());
    commandMap.put("textBook/view", new TextBookViewController());
    commandMap.put("textBook/delete", new TextBookDeleteController());
    commandMap.put("textBook/update", new TextBookUpdateController());
    */
  }

  private void service() throws Exception {
    ServerSocket ss = new ServerSocket(8888);
    System.out.println("서버 실행 중...");

    while (true) {
      new RequestThread(ss.accept(), commandMap).start();
    }
    //ss.close();
  }

  public static void main(String[] args) throws Exception {
    EduAppServer eduServer = new EduAppServer();
    eduServer.service();
  }
}
