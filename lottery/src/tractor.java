public class tractor extends Lottery3D{
    public tractor(String winnernum){
        super(winnernum);
    }
    public int getWins(){
        if(winnumber[0]==winnumber[1]+1&&winnumber[1]==winnumber[2]+1||
        winnumber[0]==winnumber[1]-1&&winnumber[1]==winnumber[2]-1||
        winnumber[0]==8&&winnumber[1]==9&&winnumber[2]==0||
        winnumber[0]==0&&winnumber[1]==9&&winnumber[2]==8||
        winnumber[0]==9&&winnumber[1]==0&&winnumber[2]==1||
        winnumber[0]==1&&winnumber[1]==0&&winnumber[2]==9
        ) {
            return 65;
        }
        return 0;
    }

    @Override
    public void prompt(boolean showdoc) {
        System.out.println("您选择了tractor模式");
        if(showdoc){
            System.out.println("开出拖拉机=>65");
        }
    }
}
