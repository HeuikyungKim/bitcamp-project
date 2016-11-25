package bitcamp.java89.ems.server.dao;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import bitcamp.java89.ems.server.vo.TextBook;

public class TextBookDao extends AbstractDao<TextBook> {
  static TextBookDao obj;

  public static TextBookDao getInstance() throws Exception {
    if (obj == null) {
      obj = new TextBookDao();
      obj.load();
    }
    return obj;
  }

  private TextBookDao() throws Exception {
    super("contact-V1.9.data");

  }


  public ArrayList<TextBook> getList() {
    return this.list;
  }

  public ArrayList<TextBook> getListByName(String title) {
    ArrayList<TextBook> results = new ArrayList<>();
    for (TextBook textBook : list) {
      if (textBook.getTitle().equals(title)) {
        results.add(textBook);
      }
    }
    return results;
  }

  synchronized public void insert(TextBook textBook) {
    list.add(textBook);
    try {this.save();} catch (Exception e) {}
  }

  synchronized public void update(TextBook textBook) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTitle().equals(textBook.getTitle())) {
        list.set(i, textBook);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }

  synchronized public void delete(String title) {
    for (int i = 0; i < list.size(); i++) {
      if (list.get(i).getTitle().equals(title)) {
        list.remove(i);
        try {this.save();} catch (Exception e) {}
        return;
      }
    }
  }

  public boolean existTitle(String title) {
    for (TextBook textBook : list) {
      System.out.println(textBook.getTitle()+"   "+title);
      if (textBook.getTitle().toLowerCase().equals(title.toLowerCase())) {
        return true;
      }
    }
    return false;
  }
}