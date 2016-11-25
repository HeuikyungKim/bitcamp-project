package bitcamp.java89.ems.server;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;

import bitcamp.java89.ems.server.controller.AbstractCommand;

public class ReflectionUtil {

  public static void getCommandClasses(File dir,ArrayList<Class> classList) {
    if (!dir.isDirectory()) {
      return;
    }

    File[] files = dir.listFiles(new FileFilter() {
      @Override
      public boolean accept(File pathname) {
        // TODO Auto-generated method stub
        if (pathname.isDirectory())
          return true;
        if (pathname.getName().endsWith(".class") && !pathname.getName().contains("$"))
          return true;
        return false;
      }

    });
    for (File file :files) {
      if (file.isDirectory()) {
        getCommandClasses(file, classList);

      }else {

        ///파일명에서 \\를 /로 바꿔서 OS간의 차이가 없도록 한다.
        String path = file.getAbsolutePath().replaceAll("\\\\","/").replaceAll(".class","" );
        int pos = path.indexOf("/bin/"); //패키지명 +클래스명 만 추출
        try {

          String classname = path.substring(pos + 5).replaceAll("/", ".");
          Class c = Class.forName(classname);

          Class superClass = c.getSuperclass();

          if (superClass == AbstractCommand.class) {
            //            System.out.println("===>" + c.getName());
            classList.add(c);
          }
        } catch (Exception e) {


        }
      }
    }

  }

}
