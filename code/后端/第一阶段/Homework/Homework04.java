package Homework;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Homework04 {
    public static String inttoString(int[] a) {
        if (a == null)
            return "null";

        int iMax = a.length - 1;
        if (iMax == -1)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0;i<a.length ; i++) {
            b.append(String.valueOf(a[i]));
            if (i == iMax)
                return b.append(']').toString();
            b.append(", ");
        }
        return null;
    }

    public static void reverseString(String a){
        char[] chars=a.toCharArray();
        for (int i = chars.length-1; i >=0 ; i--) {
            System.out.print(chars[i]);
        }
    }
    public static void changetoChinese(){
        Scanner scanner=new Scanner(System.in);
        Integer integer;
        while (true) {
            String a=scanner.nextLine();
            if (a.length()<7&&a.matches("^[1-9].*")) {
                integer=Integer.parseInt(a);
                System.out.println(integer);
                break;
            }else {
                System.out.println("请重新输入");
            }
        }
        String str=integer.toString();

        StringBuilder b = new StringBuilder();
        int l=str.length();
        for (int i = 0; i <l; i++) {
            switch (str.charAt(i)){
                case '1': b.append('壹');
                    break;
                case '2':b.append('贰');
                    break;
                case '3':b.append('叁');
                    break;
                case '4':b.append('肆');
                    break;
                case '5':b.append('伍');
                    break;
                case '6':b.append('陆');
                    break;
                case '7':b.append('柒');
                    break;
                case '8':b.append('捌');
                    break;
                case '9':b.append('玖');
                    break;
                default:
                    break;
            }
        }
        for (int j =0 ; j <7-l ; j++) {
            b.insert(0,'零');
        }
        char[] danwei={'佰','拾','万','仟','佰','拾','元'};
        for (int j = 0; j < 7; j++) {
            b.insert((j*2+1),danwei[j]);
        }
        System.out.println(b);
    }

    public static void changeNumber(){
        Scanner scanner=new Scanner(System.in);
        String telephoneNumber=scanner.nextLine();
        String maskedNumber= telephoneNumber.replaceAll("(\\d{3})\\d{4}(\\d{4})","$1****$2");
        System.out.println(maskedNumber);
    }

    public static void getBirthday(){
        Scanner scanner=new Scanner(System.in);
        String id=scanner.nextLine();//511324200304270072
        String birthday= id.substring(6,14);
        SimpleDateFormat sdf =   new SimpleDateFormat( "yyyyMMdd" );
        try {
            Date date = sdf.parse(birthday);
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            String formattedDate = outputFormat.format(date);

            System.out.println("出生日期：" + formattedDate);
        } catch (ParseException e) {
            System.out.println("日期解析失败");
        }

    }
    public static void main(String[] args) {
    getBirthday();

    }
}
