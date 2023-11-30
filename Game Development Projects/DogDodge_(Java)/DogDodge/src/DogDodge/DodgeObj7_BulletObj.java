package DogDodge;
/* 閃避物們 7號 藍色狗狗 動作2發射的子彈*/
import java.awt.*;

public class DodgeObj7_BulletObj extends GameObj {
	public DodgeObj7_BulletObj(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);
	}

	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);
		x -= speed;

		// 敵方子彈與玩家角色的碰撞檢測
		if (this.getRec().intersects(this.frame.playerObj.getRec())) {
			GameMain.state = 3;
		}

		// 敵方子彈越界後移除
		if (x < -20) {
			this.x = -300;
			this.y = 300;
			GameUtils.removeList.add(this);
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
