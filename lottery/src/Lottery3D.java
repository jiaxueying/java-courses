import java.util.stream.IntStream;

public class Lottery3D{

    Integer[] userNumber;
    Integer[] winnumber;
    String userInput;

    public Lottery3D(String winnumber){
            this.winnumber=StringtoArray(winnumber);
    }
    public Lottery3D(String winnumber,String userInput){
        if(isAvailable(userInput)){
            this.winnumber=StringtoArray(winnumber);
            this.userNumber=StringtoArray(userInput);
            this.userInput=userInput;
        }
    }
    public void setUserNumber(String userInput){
            this.userNumber=StringtoArray(userInput);
            this.userInput=userInput;
    }
    /*public Integer[] getUserNumber() {
        return userNumber;
    }*/
    public int getWins(){
        return 0;
    }
    Integer[] StringtoArray(String s){
        Integer[] ans=new Integer[s.length()];
        IntStream.range(0,s.length()).forEach(i->ans[i]=s.charAt(i)-'0');
        return ans;
    }
    public boolean isAvailable(String s){
        if(s.length()==3) return true;
        return false;
    }
    private void createObject(String clazzName,String winnumber)throws InstantiationException,IllegalAccessException,ClassNotFoundException {
    }

    public void prompt(boolean showdoc){

    }
}
