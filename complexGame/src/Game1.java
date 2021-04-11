import java.util.Random;
import java.util.Scanner;
import java.lang.Thread;
import java.util.*;

public class Game1 extends Game{

    private class Warrior extends Game1Actor {
        public Warrior(String username){
            super(100,username,30,1);
            System.out.println(name+" choose Warrior");
            bloodConsumeFor2attack=20;
        }
    }
    private class Master extends Game1Actor{
        Master(String name){
            super(50,name,30,4);
            System.out.println(name+" choose Master");
            bloodConsumeFor2attack=5;
        }
    }
    Game1Actor[] actors;
    int charNum;
    boolean show=true;
    Game1(){
        super();
        System.out.println("welcome to game 1~");
        System.out.println("choose the number of players");
        System.out.print("type here: ");
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        charNum=n;
        if(n==1) charNum=2;
        if(n>1) {
            actors=new Game1Actor[n];
            for(int i=0;i<n;++i){
                System.out.println(" ");
                System.out.println("this is the "+(i+1)+"th actor, "+"please enter your username");
                setActor(i);
            }
        }
        else {
            System.out.println("your choose to play with the computer, remember computer's name is AI");
            actors = new Game1Actor[2];
            System.out.println("this is your actor");
            Scanner sc = new Scanner(System.in);
            setActor();
        }
        System.out.println(" ");
        System.out.println("-----------------------------------------------");
        for(int i=0;i<charNum;++i){
          //  System.out.println(actors[i].toString(true));
            System.out.println("actor "+(i+1)+" : " +actors[i].getName()+" "+actors[i].getClass());
        }
        System.out.println("Do you want to know each other's blood amount when you make your decision, type 1 for yes, 2 for no");
        while(true){
            String ans=scn.next();
            if(ans.equals("2")){
                show=false;
                break;
            }
            else if(ans.equals("1")) {
                show=true;
                break;
            }
            else{
                System.out.println("please input 1 or 2");
            }

        }

        System.out.println("-----------------------------------------------");
    }
    public void play(){
        Random r=new Random();
        Scanner sc=new Scanner(System.in);
        String s="";
        int i=0;
        int round=1;
        game:while(true){
            System.out.println("this is round "+round);
            System.out.println("this is "+actors[i].getName()+"'s turn");
            System.out.println("the ones you could attack are as follows……, print * for defense");
            int num=0;
            for(int j=0;j<charNum;++j){
                if(i==j) continue;
                if(actors[j].getBlood()>0){
                    String str=actors[j].toString(show);
                    System.out.println(str);
                }else num++;
            }
            if(num==charNum-1)
            {
                System.out.println("wait, wow other people already game over");
                break game;
            }
            if(charNum==2 && i%2==1){
                int t=r.nextInt(2);
                switch(t){
                    case 0:s="*";
                        System.out.println("AI chooses *");
                        break;
                    case 1:s=actors[0].getName();
                }
            }
            else {
                s=sc.next();
            }
            if(s.equals("*")) {
                actors[i].defense();
                System.out.println("your defense factor is "+actors[i].getDefenseFactor());
            }
            else{
                for(int j=0;j<charNum;++j){
                    if(s.equals(actors[j].getName())){
                        if(charNum>2||i==0)actors[i].attack(actors[j],0,show);
                        else actors[i].attack(actors[j],1,show);
                        break;
                    }
                    if(j==charNum-1) System.out.println("your input is wrong, you lose your chance");
                }

            }
            while(actors[(++i)%charNum].getBlood()<=0);
            i=i%charNum;
            round++;
            System.out.println("*********************************************");
            try { Thread.sleep ( 2000 ) ;
            } catch (InterruptedException ie){}

        }
        for(int k=0;k<charNum;++k){
            if(actors[k].getBlood()>0) {
                System.out.println(actors[k].getName()+" wins the game!");
                for(int m=0;m<charNum;++m){
                    System.out.println(actors[m].getName()+" "+actors[m].getBlood());
                }
                break;
            }
        }
    }
    private void setActor(int i) {
        Scanner sc=new Scanner(System.in);
        String name=sc.next();
        System.out.println("please choose your character");
        System.out.println("w for warrior: with 100 blood + 50 attackNum + 1 defenseFactor");
        System.out.println("m for master : with  50 blood + 30 attackNum + 4 defenseFactor");
        in:while(true){
            String cha=sc.next();
            switch(cha){
                case "w": actors[i]=this.new Warrior(name);
                    break in;
                case "m": actors[i]=this.new Master(name);
                    break in;
                default:
                    System.out.println("just w or m, please");
                    continue;
            }
        }

    }
    private void setActor(){
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter your username");
        String name = sc.next();
        System.out.println("please enter your character");
        System.out.println("w for warrior: with 100 blood + 50 attackNum + 2 defenseFactor");
        System.out.println("m for master : with  50 blood + 30 attackNum + 4 defenseFactor");
        String cha = sc.next();
        switch (cha) {
            case "w":
                actors[0] = this.new Warrior(name);
                actors[1]=this.new Master("AI");
                break;
            case "m":
                actors[0] = this.new Master(name);
                actors[1]=this.new Warrior("AI");
                break;
        }

    }
}
