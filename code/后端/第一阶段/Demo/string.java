package Demo;

public class string  {

        public static void main(String[] args) {
            String str = "Hello";
            System.out.println("Before method call: " + str); // 输出 "Hello"
            changeString(str);
            System.out.println("After method call: " + str); // 输出 "Hello"
        }

        public static void changeString(String s) {
           s+="world";
            
            System.out.println("Inside method: " + s); // 输出 "Hello World"
        }

}
