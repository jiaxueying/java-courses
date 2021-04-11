import java.util.Random;
import java.util.Scanner;

public class Game2 extends Game{
    Game2Actor actor;
    Game2Actor computer;
    private class Tom extends Game2Actor{
        Tom(){
            super("Tom");
            Random random=new Random();
            int r=random.nextInt(10)+10;
            step=r;
            stepsize=5;
        }
    }
    private class Jerry extends Game2Actor{
        Jerry(){
            super("Jerry");
            Random random=new Random();
            int r=random.nextInt(20)+10;
            step=r;
            stepsize=10;

        }
    }
    Game2(){
        super();
        System.out.println("welcome to game 2~");
        System.out.println("                                ");
        setActor();
    }
    public void play(){
        Random random=new Random();
        int t=random.nextInt();
        int k=0;
        System.out.println("the first line is your character");
        System.out.println("                                ");
        draw();
        all:while(true){
            System.out.println("\nhey "+actor.getName()+", please choose your action, f for forward & b for backward");
            Scanner sc=new Scanner(System.in);
            String c=sc.next();
            t=random.nextInt(20);
            switch(c){
                case "f":actor.forward(t);break;
                case "b":computer.backward(t);break;
            }
            System.out.println("random step is "+t);
            draw();
            if(actor.getStep()>100) {
                System.out.println(actor.getName()+" Wins!");
                draw();
                break all;
            }
            if(computer.getStep()<0){
                System.out.println(actor.getName()+" Lose!");
                draw();
                break all;
            }
            t=random.nextInt(20);
            switch (t%2){
                case 0:actor.backward(t);
                     System.out.println(computer.getName()+"'s choice is backward");
                     break;
                case 1:computer.forward(t);
                       System.out.println(computer.getName()+"'s choice is forward");
                       break;
            }
            if(computer.getStep()>80) {
                System.out.println(computer.getName()+" Wins!");
                draw();
                break all;
            }
            if(actor.getStep()<0){
                System.out.println(computer.getName()+" Loses!");
                draw();
                break all;
            }
            System.out.println("random step is "+t);
            draw();
        }
    }
    public void draw(){
        if(actor.getName()=="Tom"){
            System.out.print("TOM   ฅ^•ﻌ•^ฅ    "+actor.getStep()+" ");
            int i=0;
            while(i++<actor.getStep()) System.out.print("-");
            System.out.println("             ");
            System.out.println("             ");

            System.out.print("JERRY   ˙Ⱉ˙      "+computer.getStep()+" ");
            int j=0;
            while(j++<computer.getStep()) System.out.print("-");
        }else{
            System.out.print("JERRY   ˙Ⱉ˙      "+actor.getStep()+" ");
            int j=0;
            while(j++<actor.getStep()) System.out.print("-");
            System.out.println("             ");
            System.out.print("TOM   ฅ^•ﻌ•^ฅ    "+computer.getStep()+" ");
            int i=0;
            while(i++<computer.getStep()) System.out.print("-");
        }
        System.out.println("                 ");
        System.out.println("                 ");
        System.out.println("**************************************");
        System.out.println("                 ");
        System.out.println("                 ");

    }
    private void setActor() {
        Random random=new Random();
        Scanner sc=new Scanner(System.in);
        System.out.println("please choose your character");
        System.out.println("T for Tom");
        System.out.println("J for Jerry");
        System.out.println("R for random");
        String cha=sc.next();
        switch(cha){
            case "T": actor=this.new Tom();
                computer=this.new Jerry();
                break;
            case "J": actor=this.new Jerry();
                computer=this.new Tom();
                break;
            default:int t=random.nextInt();
                if(t%2==1) {
                    actor=this.new Tom();
                    computer=this.new Jerry();
                }
                else {
                    actor=this.new Jerry();
                    computer=this.new Tom();
                }
        }

    }
}
