public class guessbig extends Lottery3D{
    boolean big=true;
    int winsum=0;
    public guessbig(String winnumber){
        super(winnumber);
    }

    @Override
    public void setUserNumber(String userInput) {
        if(userInput.equals("big")) big=true;
        else big=false;
    }

    @Override
    public boolean isAvailable(String s) {
        if(s.equals("big")||s.equals("small")) return true;
        return false;
    }

    @Override
    public int getWins() {
        for(int i=0;i<3;++i){
            winsum+=winnumber[i];
        }
        if(winsum<=8&&!big) {
            return 6;
        }
        if(winsum>=19&&big) {
            return 6;
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了guessbig模式");
        if(showdoc){
            System.out.println("买big，开出和值在19-27之间=>6");
            System.out.println("买small，开出和值在0-8之间=>6");
        }
        System.out.println("请输入big或small");
    }

}