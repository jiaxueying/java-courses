import java.util.Random;
import java.util.Scanner;

public class Game1Actor extends Actor  implements CanPlay{
    int blood;
    int attackNum;
    int bloodConsumeFor1attack;
    int bloodConsumeFor2attack;
    int defenseFactor;//默认为1，即无用
    int defensetime;


    public Game1Actor(int blood,String username,int attacknum,int defensefactor){
        super(username);
        this.attackNum=attacknum;
        this.defenseFactor=defensefactor;
        this.blood=blood;
        bloodConsumeFor1attack=10;
        bloodConsumeFor2attack=0;
        defensetime=0;
    }

    public void attack(Game1Actor a,int mode,boolean show){
        int n;
        Random r=new Random();
        if(show)System.out.println(a.getName()+"'s blood is "+a.getBlood());
        System.out.println("choose (1)general attack or (2)double attack");
        in:while(true){
            if(mode==0){
                Scanner sc=new Scanner(System.in);
                n=sc.nextInt();
            }else{
                n=r.nextInt(2)+1;
                System.out.println("AI choose "+n);
            }
            switch(n){
                case 1: this.generalattack(a);
                    this.blood-=this.getBloodConsumeFor1attack();
                    break in;
                case 2:this.doubleattack(a);
                    this.blood-=this.getBloodConsumeFor2attack();
                    break in;
                default:
                    System.out.println("please 1 or 2");
            }

        }
        if(this.blood<=0) {
            System.out.println("Oops! you die first hahaha");
            return;
        }
        System.out.println("my blood is "+this.blood);
        if(a.getBlood()<=0) System.out.println("KO "+a.getName());
        else System.out.println(a.getName()+"'s blood is "+a.getBlood());
    }

    public int getBloodConsumeFor1attack(){
        return bloodConsumeFor1attack;
    }

    public int getBloodConsumeFor2attack(){
        return 0;
    }

    public void generalattack(Game1Actor a){
        this.defenseFactor=1;
        int blood=a.getBlood();
        blood-=attackNum/a.getDefenseFactor();
        a.setBlood(blood);
    }

    public void doubleattack(Game1Actor a){
        this.defenseFactor=1;
        int blood=a.getBlood();
        blood-=attackNum*2/a.getDefenseFactor();
        a.setBlood(blood);
    }

    public int getBlood() {
        return this.blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public void defense(){
        if(defensetime<3){
            defenseFactor*=2;
            defensetime++;
        }

    }

    public int getDefenseFactor() {
        return this.defenseFactor;
    }

    public String toString(boolean show){
        String s="";
        s="----->"+this.getName();
        if(show) s=s+"'s blood: "+this.getBlood();
        return s;
    }




}
