public class guesssame extends Lottery3D{

    public guesssame(String winnumber){
        super(winnumber);
    }

    @Override
    public int getWins() {
        if(winnumber[0]==winnumber[1]&&winnumber[1]==winnumber[2])
        {
            return 104;
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了guessSame模式");
        if(showdoc){
            System.out.println("开出豹子号=>104");
        }
    }
}
