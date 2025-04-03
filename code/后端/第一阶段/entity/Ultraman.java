package entity;

public class Ultraman {
    public Ultraman(){

    }
    public Ultraman(String name){
        this.name=name;
    }



    public String name=null;
    private int HP=100;
    private int ATK=20;
    private int MP=10;
    private int Spell_Resistance=6;
    public int getHP(){
        System.out.println(this.HP);
        return HP;
    }
    public void changeHP(int hp){
        this.HP=hp;
    }
    public int getATK(){
        return ATK;
    }
    public void changeATK(int atk){
        this.ATK=atk;
    }
    public int getMp(){
       return this.MP;
    }
    public  void changeMP(int mp){
        this.MP=mp;
    }
    public int getSpell_Resistance(){
        return this.Spell_Resistance;
    }

}
