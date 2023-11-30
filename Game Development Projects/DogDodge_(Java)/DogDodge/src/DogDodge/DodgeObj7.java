package DogDodge;

/* 閃避物們 7號 藍色狗狗*/
import java.awt.*;
import java.util.Random;

public class DodgeObj7 extends GameObj {

	// 7號 藍色狗狗圖片
	public static Image DodgeImgs7 = Toolkit.getDefaultToolkit().getImage("img/BD/BDW1.png");
	// 是否切換動作
	private static boolean switchImage = false;
	// 第二個動作執行的次數
	int secondActionCount = 0;
	// 切換動作時機點，在初始化時產生兩個隨機x值
	private int randomValue1;
	private int randomValue2;
	Random randomX = new Random();
	{ // 生成第一次和第二次換圖片的時機點
		randomValue1 = randomX.nextInt(351) + 150; // 351表示範圍的大小 (500 - 150 + 1)
		randomValue2 = randomX.nextInt(5) + 1;
	}

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics7 = new Image[18];
	private static Image[] DodgePics7_2 = new Image[12];
	private int DodgeImgCount7 = 0;
	private int DodgeImgCount7_2 = 0;

	static {
		for (int i = 0; i < DodgePics7.length; i++) {
			DodgePics7[i] = Toolkit.getDefaultToolkit().getImage("img/BD/BDW" + (i + 1) + ".png");
		}
		for (int i = 0; i < DodgePics7_2.length; i++) {
			DodgePics7_2[i] = Toolkit.getDefaultToolkit().getImage("img/BD/BDA" + (i + 1) + ".png");
		}
	}

	public DodgeObj7() {
		super();
	}

	public DodgeObj7(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);
	}

	public static boolean getSwitchImage() {
		return switchImage;
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

		// 第一個隨機值，跑到隨機的點後，換動作2
		if (x < randomValue1) {
			switchImage = true;
		}

		// 使用連續圖片
		if (!switchImage) {
			x -= speed;
			if (DodgeImgCount7 < 18) {
				img = DodgePics7[DodgeImgCount7];
				super.paintSelf(gImage);
				DodgeImgCount7++;
			} else {
				// 當一個動畫循環結束，再重置回0，實現無限loop
				DodgeImgCount7 = 0;
			}
		} else {
			// x -= speed; 換圖片時停止奔跑
			// 做完第二個隨機值次數的動作後，換回動作1
			if (secondActionCount < randomValue2) {
				if (DodgeImgCount7_2 < 12) {
					img = DodgePics7_2[DodgeImgCount7_2];
					super.paintSelf(gImage);
					DodgeImgCount7_2++;
				} else {
					// 當一個動畫循環結束，再重置回0，實現無限loop
					DodgeImgCount7_2 = 0;
					secondActionCount++;
				}
			} else {
				switchImage = false;
				// 將第一個隨機值改到畫面外，防止無限觸發
				randomValue1 = -300;
			}
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
