public class guessodd extends Lottery3D{
    boolean odd=false;
    public guessodd(String winnumber){
        super(winnumber);
    }

    @Override
    public boolean isAvailable(String s) {
        if(s.equals("odd")||s.equals("even")) return true;
        return false;
    }

    @Override
    public void setUserNumber(String userInput) {
        if(userInput.equals("odd")) odd=true;
    }

    @Override
    public int getWins() {
        int evennum=0;
        int oddnum=0;
        for(int i=0;i<3;++i){
            if(winnumber[i]%2==0) evennum++;
            else oddnum++;
        }
        if(evennum==3&&!odd||oddnum==3&&odd) {
            return 8;
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了guessOdd模式");
        if(showdoc){
            System.out.println("买odd，开奖号码为1、3、5、7、9的任意组合即中奖=>8");
            System.out.println("买even，开奖号码为0、2、4、6、8的任意组合即中奖=>8");
        }
        System.out.println("请输入odd或even");
    }
}
