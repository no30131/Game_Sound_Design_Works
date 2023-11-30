package DogDodge;

/* 玩家角色 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class PlayerObj extends GameObj {

	@Override
	public Image getImg() {
		return super.getImg();
	}

	public PlayerObj() {
		super();
	}

	private static int RandomPlayerIndex; // 定義成靜態變數

	// 儲存所有玩家角色圖片的檔案名稱
	private static String[] PlayerImgs = { "img/BC/BCW1.png", "img/YC/YCW1.png" };

	// 使用靜態區塊進行初始化，確保每個地方的值都會一致
	static {
		// 隨機抽一張圖作為本場玩家角色圖，並儲存值
		Random RandomPlayer = new Random();
		RandomPlayerIndex = RandomPlayer.nextInt(PlayerImgs.length);
	}

	public PlayerObj(Image img, int x, int y, int width, int height, double speed, GameMain frame) {
		super(img, x, y, width, height, speed, frame);

		// 使用滑鼠游標控制玩家角色的移動
		frame.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				PlayerObj.super.x = e.getX() - 15;
				PlayerObj.super.y = e.getY() - 20;
			}
		});
	}

	// 將本場抽到的玩家角色圖存成Image
	public static Image PlayerImg() {
		return Toolkit.getDefaultToolkit().getImage(PlayerImgs[RandomPlayerIndex]);
	}

	// 使用連續圖片做玩家角色動圖，參數0是角色總數，參數1是圖片總數
	static Image[][] PlayerPics = new Image[2][18];

	int PlayerImgCount = 0;

	static {
		for (int i = 0; i < PlayerPics[0].length; i++) {
			PlayerPics[0][i] = Toolkit.getDefaultToolkit().getImage("img/BC/BCW" + (i + 1) + ".png");
			PlayerPics[1][i] = Toolkit.getDefaultToolkit().getImage("img/YC/YCW" + (i + 1) + ".png");
		}
	}

	@Override
	public void paintSelf(Graphics gImage) {
		super.paintSelf(gImage);
		// 玩家角色使用連續圖片
		if (PlayerImgCount < 18) {
			img = PlayerPics[RandomPlayerIndex][PlayerImgCount];
			super.paintSelf(gImage);
			PlayerImgCount++;
		} else {
			// 當一個動畫循環結束，再重置回0，實現無限loop
			PlayerImgCount = 0;
		}
	}
}
