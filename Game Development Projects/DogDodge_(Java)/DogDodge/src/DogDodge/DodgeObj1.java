package DogDodge;

/* 閃避物們 1號 棕色鼠鼠*/
import java.awt.*;

public class DodgeObj1 extends GameObj {

	//1號 棕色鼠鼠圖片
	public static Image DodgeImgs1 = Toolkit.getDefaultToolkit().getImage("img/YM/YMW1.png");
	
	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics1 = new Image[12];
	private int DodgeImgCount1 = 0;
	
	static {
		for (int i = 0; i < DodgePics1.length; i++) {
			DodgePics1[i] = Toolkit.getDefaultToolkit().getImage("img/YM/YMW"+(i+1)+".png");
		}
	}

	public DodgeObj1() {
		super();
	}

	public DodgeObj1(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
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
		if (DodgeImgCount1 < 12) {
			img = DodgePics1[DodgeImgCount1];
			super.paintSelf(gImage);
			DodgeImgCount1++;
		} else {
			// 當一個動畫循環結束，再重置回0，實現無限loop
			DodgeImgCount1 = 0;
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
