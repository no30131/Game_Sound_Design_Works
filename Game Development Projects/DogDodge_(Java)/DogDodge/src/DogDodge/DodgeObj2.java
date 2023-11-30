package DogDodge;

/* 閃避物們 2號 藍色鼠鼠*/
import java.awt.*;

public class DodgeObj2 extends GameObj {

	//2號 藍色鼠鼠圖片
	public static Image DodgeImgs2 = Toolkit.getDefaultToolkit().getImage("img/BM/BMW1.png");

	// 使用連續圖片做閃避物動圖，參數0是閃避物總數，參數1是圖片總數
	private static Image[] DodgePics2 = new Image[8];
	private int DodgeImgCount2 = 0;
	
	static {
		for (int i = 0; i < DodgePics2.length; i++) {
			DodgePics2[i] = Toolkit.getDefaultToolkit().getImage("img/BM/BMW"+(i+1)+".png");
		}
	}

	public DodgeObj2() {
		super();
	}

	public DodgeObj2(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
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
		if (DodgeImgCount2 < 8) {
			img = DodgePics2[DodgeImgCount2];
			super.paintSelf(gImage);
			DodgeImgCount2++;
		} else {
			// 當一個動畫循環結束，再重置回0，實現無限loop
			DodgeImgCount2 = 0;
		}
	}

	@Override
	public Rectangle getRec() {
		return super.getRec();
	}

}
