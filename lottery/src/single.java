public class single extends Lottery3D{
    public single(String winnumber){
        super(winnumber);
    }
    public single (String winnumber, String userInput){
            super(winnumber, userInput);
    }
    public int getWins(){
        if(userNumber[0]==winnumber[0]&&userNumber[1]==winnumber[1]&&userNumber[2]==winnumber[2]){
            return 1040;
        }
        return 0;
    }

    @Override
    public boolean isAvailable(String s) {
        if(s.indexOf('*')!=-1||s.length()!=3) {
            System.out.println("请输入三个数字");
            return false;
        }
        return true;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了Single模式");
        if(showdoc){
            System.out.println("买456开456=>1040");
        }
        System.out.println("请输入三个数字");
    }
}
