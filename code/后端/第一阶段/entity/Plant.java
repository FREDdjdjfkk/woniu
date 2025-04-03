package entity;

/**
 * 植物类
 */
public class Plant extends ShengWu {

    //耐久
   private int naijiu = 300;

    //临界点
   public int linjie = 20;

    //攻击
    int gongji = 1800;

    int price = 100;

    //冷却时间
    double cd = 7.5;
    private int Hp;
    private int Atk;

    public int getHp() {
        return Hp;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public  void attack(Zombie zombie){
        System.out.println("植物攻击：");
    }

}
