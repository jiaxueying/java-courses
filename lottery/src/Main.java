import java.lang.reflect.Constructor;
import java.util.*;
import java.lang.String;
public class Main {

    public static void main(String[] args) throws InterruptedException {
        //随机生成winnumber
        String winnumber="";
        Random random=new Random();
        for(int i=0;i<3;++i){
            int t=random.nextInt(10);
            winnumber+=t;
        }
        //System.out.println(winnumber);
        Scanner data=new Scanner(System.in);
        int max=0;
        System.out.println("请您选择游戏过程中是否显示开奖号码，回答Y/N即可");
        String mode=data.next();
        boolean shownum=false;
        if(mode.equals("Y")){
            shownum=true;
        }
        System.out.println("请您选择游戏过程中是否显示对应开奖规则，回答Y/N即可");
        mode=data.next();
        boolean showdoc=false;
        if(mode.equals("Y")){
            showdoc=true;
        }


        all:while(true){
        System.out.println("请您选择福彩3D游戏模式");
        System.out.println("single");
        System.out.println("group");
        System.out.println("oned");
        System.out.println("guess1d");
        System.out.println("twod");
        System.out.println("guess2d");
        System.out.println("general");
        System.out.println("sum");
        System.out.println("packages");
        System.out.println("guessbig");
        System.out.println("guesssame");
        System.out.println("tractor");
        System.out.println("guessodd");
        System.out.println("输入exit退出");
        System.out.print("请输入:");
        mode=data.next();
        Lottery3D base=new Lottery3D(winnumber);
        /*switch(mode){
            case "single":
                base=new single(winnumber);
                base.prompt(showdoc);
                break;
            case "group":
                base=new group(winnumber);
                base.prompt(showdoc);
                break;
            case "oned":
                base=new oneD(winnumber);
                base.prompt(showdoc);
                break;
            case "guess1d":
                base=new guess1d(winnumber);
                base.prompt(showdoc);
                break;
            case "twod":
                base=new twod(winnumber);
                base.prompt(showdoc);
                break;
            case "guess2d":
                base=new guess2d(winnumber);
                base.prompt(showdoc);
                break;
            case "general":
                base=new general(winnumber);
                base.prompt(showdoc);
                break;
            case "sum":
                base=new sum(winnumber);
                base.prompt(showdoc);
                break;
            case "package":
                base=new Package(winnumber);
                base.prompt(showdoc);
                break;
            case "guessbig":
                base=new guessbig(winnumber);
                base.prompt(showdoc);
                break;
            case "guesssame":
                base=new guessSame(winnumber);
                base.prompt(showdoc);
                break;
            case "tractor":
                base=new tractor(winnumber);
                base.prompt(showdoc);
                break;
            case "guessodd":
                base=new guessOdd(winnumber);
                base.prompt(showdoc);
                break;
            case "exit":break all;
            default:
                System.out.println("输入不合法亲");
                Thread.currentThread().sleep(1500);
                continue;

        }*/
            try {
                boolean findable=true;
                try{
                    Class.forName(mode);
                }catch(ClassNotFoundException e){
                    findable=false;
                    switch(mode){
                    case "exit":break all;
                    default:
                        System.out.println("输入不合法亲");
                        Thread.currentThread().sleep(1500);
                        continue;
                }
            }
                if(findable) {
                    Class<? extends Lottery3D> clazz = (Class<? extends Lottery3D>) Class.forName(mode);
                    base = clazz.getConstructor(String.class).newInstance(winnumber);
                    base.prompt(showdoc);
                }
            } catch (Exception e) {
                System.out.println(e);
            }



            if(!mode.equals("tractor")&&!mode.equals("guesssame")){

            String str=data.next();
            while(!base.isAvailable(str)){
                str=data.next();
            }
            base.setUserNumber(str);
            if(shownum==true) System.out.print("开奖数字为"+winnumber+",");
            System.out.print("您的选择为"+str+"\t" );
        }
        else {
            if(shownum==true) System.out.print("开奖数字为"+winnumber+"\t");

        }
        int temp=base.getWins();
        if(temp>0){
            System.out.print("您中奖啦\t");
            System.out.println("中奖金额为"+temp);
        }
        else{
            System.out.println("您未中奖");

        }
        System.out.println("------------------------------------------------------");
        Thread.currentThread().sleep(1500);
    }
        System.out.println("byebye~");
    }


}
