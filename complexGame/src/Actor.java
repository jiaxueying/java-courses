public class Actor{
    static int id=0;
    String name;
    public Actor(String username){
        id++;
        this.name=username;
    }
    public String getName() {
        return name;
    }

}
