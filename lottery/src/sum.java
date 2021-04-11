public class sum extends Lottery3D{
    int[] prize={1040,345,172,104,69,49,37,29,23,19,16,15,15,14};
    int sum;
    public sum(String winnumber){
        super(winnumber);
    }
    public sum(String winnumber,String userInput){
        super(winnumber, userInput);
    }
    public boolean isAvailable(String s){
        int i=Integer.parseInt(s);
        if(i<0||i>27) {
            System.out.println("请输入一个和数即可");
            return false;
        }
        return true;
    }
    public void setUserNumber(String s){
        sum= Integer.parseInt(s);
    }

    public int getWins(){
        int winSum=0;
        for(int i=0;i<3;++i){
            winSum+=winnumber[i];
        }
        if(sum==winSum){
            int index=sum%27<(27-sum)%27?sum%27:(27-sum)%27;
            return prize[index];
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了Sum模式");
        if(showdoc){
            System.out.println("买和2，开002、020、200、011、101、110=>14-1040");
        }
        System.out.println("请输入一个和数即可");
    }
}
