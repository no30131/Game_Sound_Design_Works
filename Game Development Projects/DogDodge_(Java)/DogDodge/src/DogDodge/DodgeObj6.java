package DogDodge;

/* 閃避物們 6號 黑白二哈*/
import java.awt.*;
import java.util.Random;

public class DodgeObj6 extends GameObj {

	// 6號 黑白二哈圖片
	public static Image DodgeImgs6 = Toolkit.getDefaultToolkit().getImage("img/HS/HSW1.png");
	// 反向跑時
	public static Image DodgeImgs6_2 = Toolkit.getDefaultToolkit().getImage("img/HS/HSA1.png");

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics6 = new Image[18];
	private int DodgeImgCount6 = 0;
	// 反向跑時
	private static Image[] DodgePics6_2 = new Image[18];
	private int DodgeImgCount6_2 = 0;

	private boolean moveRight = false; // 用來控制方向

	// 初始化時，決定是否折返、折返位置
	private int TurnBack;
	private int TurnPlace;
	Random random = new Random();
	{ // 生成隨機值
		TurnBack = random.nextInt(10) + 1; // 10表示範圍的大小 (10 - 1 + 1)
		TurnPlace = random.nextInt(401) + 100; // 100~500
	}

	static {
		for (int i = 0; i < DodgePics6.length; i++) {
			DodgePics6[i] = Toolkit.getDefaultToolkit().getImage("img/HS/HSW" + (i + 1) + ".png");
			DodgePics6_2[i] = Toolkit.getDefaultToolkit().getImage("img/HS/HSA" + (i + 1) + ".png");
		}
	}

	public DodgeObj6() {
		super();
	}

	public DodgeObj6(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);
	}

	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);

		// 與玩家角色碰撞檢測
		if (this.getRec().intersects(this.frame.playerObj.getRec())) {
			GameMain.state = 3;
		}

		// 越界後移除
		if (x < -80) {
			this.x = -200;
			this.y = 200;
			GameUtils.removeList.add(this);
		}

		// 檢查是否轉向
		if (x <= TurnPlace) {
			if (TurnBack < 4) { // 30%的機率折返
				moveRight = true;
			}
		}

		// 移動邏輯，根據moveRight的值來決定移動方向
		if (!moveRight) {
			x -= speed;
		} else if (moveRight) {
			x += speed; // 向右跑
			if (x >= 700) { // 到達起點回頭
				moveRight = false;
				TurnPlace = -100;
			}
		}

		// 使用連續圖片
		if (!moveRight) {
			if (DodgeImgCount6 < 18) {
				img = DodgePics6[DodgeImgCount6];
				super.paintSelf(gImage);
				DodgeImgCount6++;
			} else {
				// 當一個動畫循環結束，再重置回1，實現無限loop
				DodgeImgCount6 = 1;
			} 
		} else if (moveRight) {
			if (DodgeImgCount6_2 < 18) {
				img = DodgePics6_2[DodgeImgCount6_2];
				super.paintSelf(gImage);
				DodgeImgCount6_2++;
			} else {
				// 當一個動畫循環結束，再重置回1，實現無限loop
				DodgeImgCount6_2 = 1;
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
