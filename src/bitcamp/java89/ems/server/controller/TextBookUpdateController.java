package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.HashMap;

import bitcamp.java89.ems.server.AbstractCommand;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookUpdateController extends AbstractCommand {
  TextBookDao textBookDao;
  public void setTextBookDao(TextBookDao textBookDao) {
    this.textBookDao = textBookDao;
  }
  @Override
  public String getCommandString() {
    return "textBook/update";
  }

  @Override
  protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
      if (!textBookDao.existTitle(paramMap.get("email"))) {
        out.println("책을 찾지 못했습니다.");
      }

      TextBook textBook = new TextBook();
      textBook.setTitle(paramMap.get("title"));
      textBook.setAuthor(paramMap.get("author"));
      textBook.setPress(paramMap.get("press"));
      textBook.setReleaseDate(paramMap.get("releaseDate"));
      textBook.setLanguage(paramMap.get("language"));
      textBook.setDescription(paramMap.get("description"));

      textBookDao.update(textBook);
      out.println("변경 하였습니다.");
    
  }
}

