public class twod extends Lottery3D{
    public twod(String winnumber){
        super(winnumber);
    }
    public twod(String winnumber, String userInput){
        super(winnumber,userInput);
    }
    public boolean isAvailable(String s){
        if(s.length()!=3) {
            System.out.println("输入形如12*的三位数即可");
            return false;
        }
        int cnt=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='*') cnt++;
        }
        if(cnt!=1) {
            System.out.println("输入形如12*的三位数即可");
            return false;
        }
        return true;
    }
    public int getWins(){
        for(int i=0;i<userNumber.length;++i){
            if(userNumber[i]>=0){
                if(userNumber[i]!=winnumber[i]) {
                    return 0;
                }
            }
        }
        return 104;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了TwoD模式");
        if(showdoc){
            System.out.println("买*12，开*12=>104");
        }
        System.out.println("输入形如12*的三个字符即可");
    }
}
