import java.util.Random;

public class Game2Actor extends Actor{
    int step;
    int stepsize;
    Game2Actor(String username){
        super(username);
        step=0;
        stepsize=0;
    }
    public void forward(int r){
        this.step+=(this.stepsize+r);
    }
    public void backward(int r){
        this.step-=(this.stepsize+r);
    }
    public int getStep() {
        return this.step;
    }
}
