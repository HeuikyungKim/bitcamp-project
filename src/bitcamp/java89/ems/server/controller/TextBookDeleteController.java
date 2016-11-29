package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.AbstractCommand;
import bitcamp.java89.ems.server.dao.TextBookDao;

public class TextBookDeleteController extends AbstractCommand {
  TextBookDao textBookDao;
  public void setTextBookDao(TextBookDao textBookDao) {
    this.textBookDao = textBookDao;
  }
  @Override
  public String getCommandString() {
    return "textBook/delete";
  }

  @Override
  protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {

    if (!textBookDao.existTitle(paramMap.get("title"))) {
      out.println("해당 데이터가 없습니다.");
      return;
    }

    textBookDao.delete(paramMap.get("title"));
    out.println("해당 데이터를 삭제 완료하였습니다.");
   
  }
}


