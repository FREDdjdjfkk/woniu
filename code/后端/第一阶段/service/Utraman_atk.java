package service;

import entity.Monster;
import entity.Ultraman;

public class Utraman_atk {
    public void attack_Monster(Ultraman a, Monster b){
        b.changeHP(b.getHP() - a.getATK());
    }

    public void reduceATK(Ultraman a, Monster b){
        if(a.getMp()>b.getSpell_Resistance()){
            a.changeMP(a.getMp()-b.getSpell_Resistance());
            b.changeATK(b.getATK()-5);
        }else{
            System.out.println("蓝量不足,剩余蓝量："+a.getMp());
        }
    }
}
