package Demo;

import java.util.ArrayList;
import java.util.List;

public class LIst {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Integer a=Integer.valueOf(5);
        list.remove(a);
        for (Integer i:list
             ) {
            System.out.println(i);
        }
    }
}
