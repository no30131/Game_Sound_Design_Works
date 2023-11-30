package DogDodge;

/* 閃避物們 5號 棕色鬣狗*/
import java.awt.*;
import java.util.Random;

public class DodgeObj5 extends GameObj {

	// 5號 棕色鬣狗圖片
	public static Image DodgeImgs5 = Toolkit.getDefaultToolkit().getImage("img/HY/HYW1.png");

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics5 = new Image[18];
	private int DodgeImgCount5 = 0;

	private boolean moveUpDown = false; // 用來控制斜走

	// 初始化時，決定是否斜走、斜走位置、斜走Y正負值等
	private int Diagonals;
	private int DiagonalsPlace;
	private int DiagonalsY;
	Random random = new Random();
	{ // 生成隨機值
		Diagonals = random.nextInt(10) + 1; // 10
		DiagonalsPlace = random.nextInt(501) + 100; // 100~600
		DiagonalsY = random.nextInt(1) + 1; // 1~2
	}

	static {
		for (int i = 0; i < DodgePics5.length; i++) {
			DodgePics5[i] = Toolkit.getDefaultToolkit().getImage("img/HY/HYW" + (i + 1) + ".png");
		}
	}

	public DodgeObj5() {
		super();
	}

	public DodgeObj5(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
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

		// 越界後移除
		if (x < -80) {
			this.x = -200;
			this.y = 200;
			GameUtils.removeList.add(this);
		}

		// 使用連續圖片
		if (DodgeImgCount5 < 18) {
			img = DodgePics5[DodgeImgCount5];
			super.paintSelf(gImage);
			DodgeImgCount5++;
		} else {
			// 當一個動畫循環結束，再重置回0，實現無限loop
			DodgeImgCount5 = 0;
		}

		// 檢查是否斜走
		if (x <= DiagonalsPlace) {
			if (Diagonals < 5) { // 40%的機率斜走
				moveUpDown = true;
			}
		}

		// 移動邏輯，根據moveUpDown的值來決定是否向上或向下移動
		if (moveUpDown) {
			if (DiagonalsY == 1) { // 向+Y走
				y += speed;
			} else { // 向-Y走
				y -= speed;
			}
		}

	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}
}
