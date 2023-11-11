package tankgame2;

public class EnemyTank extends Tank {
    // 敌方坦克数量多，可以放入到集合 Vector，因为考虑多线程问题
    public EnemyTank(int x, int y) {
        super(x, y);
    }
}
