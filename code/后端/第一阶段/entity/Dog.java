package entity;

public class Dog extends Animal{

    public void jiao(){
        System.out.println("汪汪叫");
    }


    @Override
    protected Animal test(int a,int b) {
        return null;
    }
}
