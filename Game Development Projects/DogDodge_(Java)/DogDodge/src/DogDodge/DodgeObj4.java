package DogDodge;

/* 閃避物們 4號 棕色鳥鳥*/
import java.awt.*;

public class DodgeObj4 extends GameObj {

	// 4號 棕色鳥鳥圖片
	public static Image DodgeImgs4 = Toolkit.getDefaultToolkit().getImage("img/YB/YBW1.png");

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics4 = new Image[12];
	private int DodgeImgCount4 = 0;

	// x每隔一段間隔改變一次動作
	private int changeActionCounter = 0;
	private int baseX = 700;

	static {
		for (int i = 0; i < DodgePics4.length; i++) {
			DodgePics4[i] = Toolkit.getDefaultToolkit().getImage("img/YB/YBW" + (i + 1) + ".png");
		}
	}

	public DodgeObj4() {
		super();
	}

	public DodgeObj4(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);
	}

	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);
		x -= speed;

		// 與玩家角色碰撞檢測
		if (this.getRec().intersects(this.frame.playerObj.getRec())) {
			GameMain.state = 3;
		}

		// 越過邊界後移除
		if (x < -80) {
			this.x = -200;
			this.y = 200;
			GameUtils.removeList.add(this);
		}

		changeActionCounter++;
		if (x <= baseX - 180) {
			baseX -= 180;
			changeActionCounter = 0;
		}

		if (changeActionCounter >= 5) {
			y += speed / 3;
		} else {
			y -= speed + 5;
		}

		// 使用連續圖片
		if (DodgeImgCount4 < 12) {
			img = DodgePics4[DodgeImgCount4];
			super.paintSelf(gImage);
			DodgeImgCount4++;
		} else {
			// 當一個動畫循環結束，再重置回0，實現無限loop
			DodgeImgCount4 = 0;
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
