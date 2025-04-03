package test;

import java.util.ArrayList;
import java.util.List;

public class Collection {
    public static void main(String[] args) {
        List<Integer> list =new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        list.add(4);
        list.add(2);
        list.add(1);
        list.add(5);
        list.add(8);
        list.add(9);
        List<Integer> list2 =new ArrayList<Integer>();

        for (Integer i:list
             ) {
            boolean flag=true;
            for (Integer j:list2){
                if (i.equals(j)){
                    flag=false;
                }
            }
            if (flag) {
                list2.add(i);
            }
        }
        list=list2;
        for (Integer i:list){
            System.out.println(i);
        }

        list2.clear();


        list2.add(12);
        list2.add(45);
        list2.add(23);
        list2.add(44);
        list2.add(22);
        list2.add(56);
        list2.add(21);
        Integer max=list2.get(0);
        System.out.println("max:"+max);
        for (Integer i:list2
             ) {
            max=Integer.max(max,i);
        }

        System.out.println("max:"+max);


        }


    }
//
//                LinkedList<String> list = new LinkedList<>();
//                list.add("A");
//                list.add("B");
//                list.add("C");
//
//                // 序列化
//                ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("list.ser"));
//                oos.writeObject(list);
//                oos.close();
//
//                // 反序列化
//                ObjectInputStream ois = new ObjectInputStream(new FileInputStream("list.ser"));
//                LinkedList<String> deserializedList = (LinkedList<String>) ois.readObject();
//                ois.close();
//
//                System.out.println("反序列化后的 LinkedList: " + deserializedList);
