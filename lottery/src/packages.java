public class packages extends Lottery3D{
    String winString;
    public packages(String winnumber){
        super(winnumber);
        winString=winnumber;
    }
    public packages(String winnumber, String userinput){
        super(winnumber,userinput);
        winString=winnumber;
    }
    public int getWins(){
        int[] a={0,0,0,0,0,0,0,0,0,0};
        int cnt=0;
        for(int i=0;i<3;++i){
            if(a[winnumber[i]]==0) cnt++;
            a[winnumber[i]]++;
        }
        if(cnt==0) return 0;
        if(cnt==3){
            single s=new single(winString);
            s.isAvailable(userInput);
            s.setUserNumber(userInput);
            if(s.getWins()>0) {
                System.out.print("包选六全中模式\t");
                return 606;
            }
            group g=new group(winString);
            g.isAvailable(userInput);
            g.setUserNumber(userInput);
            if(g.getWins()>0) {
                System.out.print("包选六组中模式\t");
                return 86;
            }
        }else if(cnt==2){
            single s=new single(winString);
            s.isAvailable(userInput);
            s.setUserNumber(userInput);
            if(s.getWins()>0) {
                System.out.print("包选三全中模式\t");
                return 693;
            }
            group g=new group(winString);
            g.isAvailable(userInput);
            g.setUserNumber(userInput);
            if(g.getWins()>0) {
                System.out.print("包选三组中模式\t");
                return 173;
            }
        }
        return 0;
    };

    public boolean isAvailable(String s){
        if(s.length()!=3){
            System.out.println("请输入一个三位数且其中最多两位相同");
            return false;
        }
        int b[]={0,0,0,0,0,0,0,0,0,0};
        for(int i=0;i<3;++i){
            b[s.charAt(i)-'0']++;
        }
        for(int i=0;i<10;++i){
            if(b[i]>=3) {
                System.out.println("请输入一个三位数且其中最多两位相同");
                return false;
            }
        }
        return true;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了package模式");
        if(showdoc){
            System.out.println("买011，开011=>693");
            System.out.println("买011，开101、110=>173");
            System.out.println("买123，开123=>606");
            System.out.println("买123，开132、213、231、312、321=>86");
        }
        System.out.println("请输入三个数字");
    }
}
