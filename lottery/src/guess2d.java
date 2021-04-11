public class guess2d extends twod {
    int[] a={0,0,0,0,0,0,0,0,0,0};
    boolean same=false;
    public guess2d(String winnumber){
        super(winnumber);
    }
    public guess2d(String winnumber,String userInput){
        super(winnumber,userInput);
    }

    @Override
    public boolean isAvailable(String s) {
        if(s.length()!=2||s.charAt(0)-'0'<0||s.charAt(1)-'0'<0||s.charAt(1)-'0'>9||s.charAt(1)-'0'>9) {
            System.out.println("请输入两位数字，相同或不同均可");
            return false;
        }
        return true;
    }

    @Override
    public int getWins() {
        for(int i=0;i<3;++i){
            a[winnumber[i]]++;
        }
        for(int i=0;i<2;++i){
            if(userNumber[i]>=0) {
                a[userNumber[i]]--;
            }
        }
        if(userNumber[0]==userNumber[1]) same=true;

        int cnt=0;
        for(int i=0;i<10;++i){
            if(a[i]!=0) cnt++;
        }
        if(cnt!=1) {
            return 0;
        }
        if(same) {
            return 37;
        }
        return 19;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了guess2d模式");
        if(showdoc){
            System.out.println("买11，开出11*、1*1、*11=>37");
            System.out.println("买12，开12*、1*2、*12、*21、21*、2*1=>19");
        }
        System.out.println("请输入两位数字，相同或不同均可");

    }
}
