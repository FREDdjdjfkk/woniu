package entity;

import java.util.Random;

public class Main {
    public static void pk1v1(Plant[] plant,Zombie zombie){
        Random random = new Random();
        int randomIndex = random.nextInt(plant.length);
        Plant plant1=plant[randomIndex];
        System.out.println("战斗开始：" + plant1.getClass().getName() + " vs " + zombie.getClass().getName());
        while(zombie.getHp() > 0&& plant1.getHp() > 0){
            int turn = random.nextInt(2);
            if (turn == 0) {
                plant1.attack(zombie);
                System.out.println(zombie.getClass().getName()+"剩余Hp："+zombie.getHp());
            } else {
                zombie.attack(plant1);
                System.out.println(plant1.getClass().getName()+"剩余Hp："+plant1.getHp());
            }
        }
        if (plant1.getHp()>0){
            System.out.println(plant1.getClass().getName()+"战胜了zombie");
        }else{
            System.out.println(zombie.getClass().getName()+"战胜了"+plant1.getClass().getName());
        }
    }
    public static void main(String[] args) {
        Zombie zombie=new Zombie();
        CherryBomb cherryBomb=new CherryBomb();
        Peashooter peashooter=new Peashooter();
        Plant[] plant={cherryBomb,peashooter};
        pk1v1(plant,zombie);


    }
}
