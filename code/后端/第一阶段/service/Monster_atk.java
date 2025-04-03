package service;

import entity.Monster;
import entity.Ultraman;

public class Monster_atk {
    public void attack_Utraman(Ultraman a, Monster b){
        b.changeHP(a.getHP() - b.getATK());
    }
    public void reduceATK(Ultraman a, Monster b){
        if(b.getMp()>a.getSpell_Resistance()){
            b.changeMP(b.getMp()-a.getSpell_Resistance());
            a.changeATK(a.getATK()-3);
        }else{
        System.out.println("蓝量不足,剩余蓝量："+b.getMp());
    }
    }
}
