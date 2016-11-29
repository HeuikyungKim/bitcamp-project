package bitcamp.java89.ems.server.controller;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import bitcamp.java89.ems.server.AbstractCommand;
import bitcamp.java89.ems.server.dao.TextBookDao;
import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookListController extends AbstractCommand {
  TextBookDao textBookDao;
  public void setTextBookDao(TextBookDao textBookDao) {
    this.textBookDao = textBookDao;
  }
  @Override
  public String getCommandString() {
    return "textBook/list";
  }

  @Override
  protected void doResponse(HashMap<String,String> paramMap, PrintStream out) throws Exception {
      ArrayList<TextBook> list = textBookDao.getList();
      for (TextBook textBook : list) {
        out.printf("%s,%s,%s,%s\n",
            textBook.getTitle(),
            textBook.getAuthor(),
            textBook.getPress(),
            textBook.getReleaseDate(),
            textBook.getLanguage(),
            textBook.getDescription());
      }
    

  }
}


