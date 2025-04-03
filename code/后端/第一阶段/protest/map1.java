package protest;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
class Car{
    String type;
    String color;

    public Car(String type, String color) {
        this.type = type;
        this.color = color;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", color='" + color + '\'' +
                '}';
    }
}



public class map1 {


    public static void p1(){
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");


        System.out.println("for增强输出map的value");
        for (String i:map.values()
        ) {
            System.out.println(i);
        }
        System.out.println("使用迭代器输出value");
        Iterator<Map.Entry<Integer,String>> iterator=map.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry=iterator.next();
            System.out.println(entry.getValue());
        }
    }


    public static void p2(){
        Car xiaomi=new Car("xiaomi","blue");
        Car tesla =new Car("tesla","white");
        Car e300 =new Car("e300","black");
        Map<Car,Integer>  car=new HashMap<>();
        car.put(xiaomi,27);
        car.put(tesla,16);
        car.put(e300,30);
        System.out.println("使用keyset遍历");
        for (Car i:car.keySet()
             ) {
            System.out.println("key: "+i+" value:"+car.get(i));
        }
        System.out.println("使用entryset遍历");
        Iterator<Map.Entry<Car,Integer>> iterator=car.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<Car,Integer> entry=iterator.next();
            System.out.println("key: "+entry.getKey()+" value: "+entry.getValue());
        }
    }

    public static void   p3(){
        Map<Integer,String> map = new HashMap<Integer, String>();
        map.put(1, "张三丰");
        map.put(2, "周芷若");
        map.put(3, "汪峰");
        map.put(4, "灭绝师太");

        for (Integer key:map.keySet()
        ) {
            System.out.println("number: "+key+" name:"+map.get(key));
        }
        map.put(5,"李晓红");
        map.remove(1);
        map.replace(2,"周林");
        for (Integer key:map.keySet()
        ) {
            System.out.println("number: "+key+" name:"+map.get(key));
        }
    }
    public static void p4(){
        String[] provinces = {"黑龙江省", "浙江省", "江西省", "广东省", "福建省"};
        String[] cities = {"哈尔滨", "杭州", "南昌", "广州", "福州"};

        // 创建 HashMap 存储省份和城市
        Map<String, String> provinceCityMap = new HashMap<>();

        // 遍历数组，将 key（省份）和 value（城市）存入 Map
        for (int i = 0; i < provinces.length; i++) {
            provinceCityMap.put(provinces[i], cities[i]);
        }

        // 输出 Map 内容
        System.out.println(provinceCityMap);
    }
    public static void main(String[] args) {
    p1();
    p2();
    p3();
    p4();

    }

}
