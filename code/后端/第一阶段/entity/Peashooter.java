package entity;

/**
 * 豌豆射手
 */
public class Peashooter extends Plant {

    //射程
    int range= 1;

    //射击间隔
    double shejijiange = 1.4;
    private int Hp=200;
    private int Atk=40;
    @Override
    public void attack(Zombie zombie) {
        super.attack(zombie);
        System.out.println(getClass().getName()+"射出豌豆");
        zombie.setHp(zombie.getHp()-getAtk());

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
