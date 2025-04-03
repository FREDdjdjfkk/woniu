package entity;

/**
 * 樱桃炸弹
 */
public class CherryBomb  extends Plant {

    //范围
    int fanwei = 200;

    //准备时间
    int readyTime = 10;
    private int Hp=100;
    private int Atk=1000;
    @Override
    public void attack(Zombie zombie) {
        super.attack(zombie);
        System.out.println(getClass().getName()+"爆炸，炸死周围僵尸");
        zombie.setHp(zombie.getHp()-getAtk());
        setHp(0);

    }

    @Override
    public int getHp() {
        return Hp;
    }

    @Override
    public int getAtk() {
        return Atk;
    }

    @Override
    public void setHp(int hp) {
        Hp = hp;
    }
}
