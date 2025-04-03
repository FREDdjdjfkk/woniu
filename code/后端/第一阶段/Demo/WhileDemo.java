package Demo;

public class WhileDemo {
    public static  void main(String[] args){
        int i=100;
        while (i<1000){
            int a=i/100;
            int b=(i%100)/10;
            int c=i%10;
            if (i==(a*a*a+b*b*b+c*c*c)){
                System.out.println(i);
            }
            i++;
        }
    }
}
