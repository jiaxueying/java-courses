public class group extends Lottery3D {
    int[] isShow=new int[10];
    boolean pattern3=true;

    public group(String winnumber){
        super(winnumber);
    }
    public group(String winnumber,String userinput){
        super(winnumber,userinput);
    }

    public boolean isAvailable(String s) {
        int cnt=0;
        if(s.indexOf('*')!=-1||s.length()!=3) {
            System.out.println("输入中应仅为数字且至少有两个不同的数字，如123");
            return false;
        }
        for (int i=0;i<s.length();++i){
            if(isShow[s.charAt(i)-'0']==0) cnt++;
            isShow[s.charAt(i)-'0']++;
        }
        if(cnt<2) {
            System.out.println("输入中应仅为数字且至少有两个不同的数字，如123");
            for (int i=0;i<10;++i){
                isShow[i]=0;
            }
            return false;
        }
        else if(cnt<=2) {
            pattern3 = false;
        }
        return true;
    }

    @Override
    public void setUserNumber(String s) {
        super.setUserNumber(s);
    }

    public int getWins(){
        for(int i=0;i<3;++i){
            isShow[winnumber[i]]--;
        }
        for(int i=0;i<10;++i){
            if(isShow[i]!=0) {
                return 0;
            }
        }
        if(!pattern3) return 346;
        return 173;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了Group模式");
        if(showdoc){
            System.out.println("买112，开112、121、211=>346");
            System.out.println("买123，开123、132、213、231、312、321=>173");
        }
        System.out.println("请输入三个数字，输入中应仅为数字且至少有两个不同的数字，如123");

    }
}
