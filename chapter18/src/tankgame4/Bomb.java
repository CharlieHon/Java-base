package tankgame4;

public class Bomb {
    int x, y;   // 炸弹坐标
    int life = 9;   // 炸弹的生命周期
    boolean isLive = true;

    public Bomb(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // 减少生命值
    public void lifeDown() {    // 配合图片的爆炸效果
        if (life > 0) {
            life--;
        } else {
            isLive = false;
        }
    }
}
