public class guess1d extends Lottery3D{
    int userNumber;
    public guess1d(String winnumber){
        super(winnumber);
    }
    public guess1d(String winnumber,String userInput){
        super(winnumber);
        userNumber=userInput.charAt(0)-'0';
    }
    //正确输入格式，一个数字
    public void setUserNumber(String userInput){
        userNumber=userInput.charAt(0)-'0';
    }
    public boolean isAvailable(String s){
        //System.out.println(s.length());
        if(s.length()!=1||s.charAt(0)-'0'>9||s.charAt(0)-'0'<0){
            System.out.println("输入一个0-9内的整数即可");
            return false;
        }
        return true;
    }
    public int getWins(){
        int cnt=0;
        for(int i=0;i<3;++i){
            if(userNumber==winnumber[i]) cnt++;
        }
        if(cnt==0) {
            return 0;
        }
        else if(cnt==1) {
            return 2;
        }
        else if(cnt==2) {
            return 12;
        }
        return 230;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了Guess1D模式");
        if(showdoc){
            System.out.println("买1开出1**、*1*、1**=>2");
            System.out.println("买1开出11*、1*1、*11=>12");
            System.out.println("买1开出111=>230");
        }
        System.out.println("请输入一个数字，输入一个0-9内的整数即可");
    }
}
