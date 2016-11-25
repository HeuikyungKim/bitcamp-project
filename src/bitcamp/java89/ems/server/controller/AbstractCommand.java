package bitcamp.java89.ems.server.controller; 

import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.Command;
 
public abstract class AbstractCommand implements Command {

  public abstract String getCommandString(); 
  
  @Override
  public void service(HashMap<String,String> paramMap, PrintStream out) {
    try{
      doResponse(paramMap, out);
    }catch (Exception e) {
      out.println("작업중 예외가 발생하였습니다");
      e.printStackTrace();
    }
  }

  protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
    System.out.println("작업을 준비중입니다.");
  }
}


