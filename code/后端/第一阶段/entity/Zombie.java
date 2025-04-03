package entity;

public class Zombie {
    private int Hp=100;
    private int Atk=20;

    public int getHp() {
        return Hp;
    }

    public void setHp(int hp) {
        Hp = hp;
    }

    public int getAtk() {
        return Atk;
    }

    public void setAtk(int atk) {
        Atk = atk;
    }

    public void attack(Plant plant) {
        System.out.println("僵尸攻击：");
        System.out.println(getClass().getName()+"攻击"+plant.getClass().getName());
        plant.setHp(plant.getHp()-getAtk());

    }


}
