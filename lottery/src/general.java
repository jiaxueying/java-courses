public class general extends Lottery3D{
    public general(String winnumber) {
        super(winnumber);
    }
    public general(String winnumber, String userInput){
        super(winnumber, userInput);
    }

    @Override
    public int getWins() {
        int cnt=0;
        for(int i=0;i<3;++i){
            if(winnumber[i]==userNumber[i]) cnt++;
        }
        if(cnt==2) {
            return 21;
        }
        if(cnt==3) {
            return 470;
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了general模式");
        if(showdoc){
            System.out.println("买456开456=>470");
            System.out.println("买123，开12*、1*3、*23=>21");
        }
        System.out.println("请输入三个数字");
    }
}
