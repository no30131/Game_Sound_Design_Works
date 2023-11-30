package DogDodge;

/* 閃避物們 3號 黃色狗狗*/
import java.awt.*;

public class DodgeObj3 extends GameObj {

	// 3號 黃色狗狗圖片
	public static Image DodgeImgs3 = Toolkit.getDefaultToolkit().getImage("img/YD/YDWL1.png");
	// 反向跑時
	public static Image DodgeImgs3_2 = Toolkit.getDefaultToolkit().getImage("img/YD/YDW1.png");

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics3 = new Image[18];
	private int DodgeImgCount3 = 0;
	// 反向跑時
	private static Image[] DodgePics3_2 = new Image[18];
	private int DodgeImgCount3_2 = 0;

	private boolean moveRight = false; // 用來控制方向

	static {
		for (int i = 0; i < DodgePics3.length; i++) {
			DodgePics3[i] = Toolkit.getDefaultToolkit().getImage("img/YD/YDWL" + (i + 1) + ".png");
			DodgePics3_2[i] = Toolkit.getDefaultToolkit().getImage("img/YD/YDW" + (i + 1) + ".png");
		}
	}

	public DodgeObj3() {
		super();
	}

	public DodgeObj3(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);
		if (x >= 690 && x <= 710) {
			moveRight = false;
		} else if (x >= -60 && x <= 0) {
			moveRight = true;
		}
	}

	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);

		// 與玩家角色碰撞檢測
		if (this.getRec().intersects(this.frame.playerObj.getRec())) {
			GameMain.state = 3;
		}

		// 檢查移動方向以及越界後移除
		if (!moveRight) {
			x -= speed;
			if (x < -80) {
				this.x = -200;
				this.y = 200;
				GameUtils.removeList.add(this);
			}
		} else if (moveRight) {
			x += speed;
			if (x > 710) {
				this.x = -200;
				this.y = 200;
				GameUtils.removeList.add(this);
			}
		}

		// 使用連續圖片
		if (!moveRight) {
			if (DodgeImgCount3 < 18) {
				img = DodgePics3[DodgeImgCount3];
				super.paintSelf(gImage);
				DodgeImgCount3++;
			} else {
				// 當一個動畫循環結束，再重置回1，實現無限loop
				DodgeImgCount3 = 1;
			}
		} else if (moveRight) {
			if (DodgeImgCount3_2 < 18) {
				img = DodgePics3_2[DodgeImgCount3_2];
				super.paintSelf(gImage);
				DodgeImgCount3_2++;
			} else {
				// 當一個動畫循環結束，再重置回1，實現無限loop
				DodgeImgCount3_2 = 1;
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
