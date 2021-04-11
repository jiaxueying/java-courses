import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        System.out.println("welcome to this smart game");
        Scanner sc=new Scanner(System.in);
        System.out.println("please enter the game type you want to play, 1 or 2");
        System.out.print("type here: ");
        int gameType=sc.nextInt();
        Game g=new Game();
        if(gameType==1) g=new Game1();
        else if(gameType==2) g=new Game2();
        else {
            System.out.println("I have told you just two, stupid man (- A -), see you in game 1");
            g=new Game1();
        }
        System.out.println(" ");
        g.play();
        System.out.println("-----------------------------------------------------------------");
        System.out.println("bye~ have a nice day!");

        /*
        Stream<String> stream1= Arrays.stream(new String[]{"A","B","C"});
        Stream<String> stream2= List.of("X","Y","Z").stream();
        stream1.forEach(System.out::println);
        stream2.forEach(System.out::println);
         */




    }
}
