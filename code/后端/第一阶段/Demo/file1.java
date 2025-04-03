package Demo;

import java.io.File;

public class file1 {
    public static void main(String[] args) {
        File file=new File("d:\\21013051");
        File[] files=file.listFiles();
        readfile(files);

    }
    public static void readfile(File[] files) {
        if (files!=null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    System.out.println("目录：" + file.getAbsolutePath());
                    File[] files1=file.listFiles();
                    readfile(files1);
                } else { // 如果是文件，直接输出文件名称
                    System.out.println("文件：" + file.getAbsolutePath());
                }
            }
        }

    }
}
