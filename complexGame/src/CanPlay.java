public interface CanPlay {
    //mode=0 单机，mode=1 人机
    public void attack(Game1Actor a,int mode,boolean show);
    public void defense();
}