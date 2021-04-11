public class oned extends Lottery3D{
    char[] userNumber;
    public oned(String winnernumber){
        super(winnernumber);
    }
    public oned(String winnernumber, String userinput){
        super(winnernumber,userinput);
    }

    public boolean isAvailable(String s) {
        if(s.length()!=3) {
            System.out.println("请选择其中一位投注，并将其余位数设置为*");
            return false;
        }
        int c=0;
        for(int i=0;i<s.length();++i){
            if(s.charAt(i)=='*') c++;
        }
        if(c!=2) {
            System.out.println("请选择其中一位投注，并将其余位数设置为*");
            return false;
        }
        return true;
    }

    @Override
    public void setUserNumber(String userinput) {
        userNumber=userinput.toCharArray();
    }

    @Override
    public int getWins() {
        for(int i=0;i<3;++i){
            if(userNumber[i]!='*'){
                if(userNumber[i]-'0'==winnumber[i]) {
                    return 10;
                }
            }
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了OneD模式");
        if(showdoc){
            System.out.println("买*1*，开*1*=>10");
        }
        System.out.println("请选择其中一位投注，并将其余位数设置为*");
    }
}
