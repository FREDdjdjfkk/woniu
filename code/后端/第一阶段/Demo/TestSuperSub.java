package Demo;
class SuperClass {
    private int n;

    // 无参数构造器
    public SuperClass() {
        System.out.println("SuperClass()");
    }

    // 带参数构造器
    public SuperClass(int n) {
        System.out.println("SuperClass(int n):"+n);
        this.n = n;
    }
    protected void test(){
        System.out.println("superclass");
    }
}

// SubClass 类继承
class SubClass extends SuperClass {
    private int n;

    // 无参数构造器，自动调用父类的无参数构造器
    public SubClass() {
        System.out.println("SubClass()");
    }

    // 带参数构造器，调用父类中带有参数的构造器
    public SubClass(int n) {
        super(300);
        System.out.println("SubClass(int n): " + n);
        this.n = n;
    }


    @Override//加了这个必须满足重写要求
    public void test(){
        System.out.println("");
    }
}

// SubClass2 类继承
class SubClass2 extends SuperClass {
    private int n;

    // 无参数构造器，调用父类中带有参数的构造器
    public SubClass2() {
        super(300);
        System.out.println("SubClass2()");
    }

    // 带参数构造器，自动调用父类的无参数构造器
    public SubClass2(int n) {
        System.out.println("SubClass2(int n): " + n);
        this.n = n;
    }
}
public class TestSuperSub {
    public static void main(String[] args) {
        System.out.println("------SubClass 类继承------");
        SubClass sc1 = new SubClass();
        SubClass sc2 = new SubClass(100);

        System.out.println("------SubClass2 类继承------");
        SubClass2 sc3 = new SubClass2();
        SubClass2 sc4 = new SubClass2(200);
    }
}