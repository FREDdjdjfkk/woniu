package Demo;

import java.io.*;

public class 字符流 {
    public static void main(String[] args) throws IOException {
        InputStream in=new FileInputStream("c:\\users\\李鹏程\\Pictures\\Saved Pictures\\22.PNG");//C:\Users\李鹏程\Pictures\Saved Pictures

        OutputStream out=new FileOutputStream("d:\\23.png");
        byte[] b=new byte[1024];
        int len=0;
        while (( len= in.read(b))!=-1){
            out.write(b,0,len);

        }
        in.close();
        out.close();
    }
}
