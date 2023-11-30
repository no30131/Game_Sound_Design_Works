package DogDodge;

/* 遊戲主程式 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class GameMain extends JFrame {

	// 初始的遊戲狀態為 0 = 未開始
	public static int state = 0;
	// 雙緩存的圖片
	Image offScreenImage = null;
	// 視窗的長寬
	int width = 600;
	int height = 600;
	// 遊戲的重繪次數
	int count = 1;
	// 閃避物出現的數量
	int DodgeCount = 0;
	// 設定計時器的時間與狀態
	private boolean isCountingDown = false;
	Random random = new Random();	
	private int TimeLeft = random.nextInt(51) + 10;

	// 背景圖物件
	BgObj bgObj = new BgObj(GameUtils.BgImg(), 0, 0, 3);
	// 玩家角色物件
	public PlayerObj playerObj = new PlayerObj(PlayerObj.PlayerImg(), 250, 350, 39, 26, 0, this);

	// 開始遊戲按鈕與遊戲說明按鈕
	private JButton btn_start;
	private JButton btn_tips;

	// 遊戲啟動初始化
	public void launch() {

		// 設定視窗標題、尺寸、可見度、點擊關閉按鈕的動作，並將視窗置於螢幕中央
		this.setVisible(true);
		this.setSize(width, height);
		this.setLocationRelativeTo(null);
		this.setTitle("DogDodge");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		
		// 遊戲啟動時，先將背景以及玩家物件加入所有遊戲物件集合中
		GameUtils.gameObjList.add(bgObj);
		GameUtils.gameObjList.add(playerObj);

		// 遊戲失敗或勝利後，點擊畫面可再次開始遊戲
		/*this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getButton() == 1 && (state == 3 || state == 4)) {
					state = 1;
				}
			}
		});*/
		
		// 將開始遊戲按鈕與遊戲說明按鈕加到畫面中
		btn_start = new JButton();
		btn_start.setIcon(new ImageIcon(GameUtils.StartImg));
		btn_start.setBounds(100, 400, 154, 140);
		btn_start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				state = 1;
				remove(btn_start);
				remove(btn_tips);
				revalidate();
				repaint();
			}
		});

		btn_tips = new JButton();
		btn_tips.setIcon(new ImageIcon(GameUtils.TipsImg));
		btn_tips.setBounds(320, 400, 154, 140);
		btn_tips.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// 在這裡顯示說明視窗  //\n遊戲失敗或勝利後，點擊畫面再次開始遊戲。\n
				JOptionPane.showMessageDialog(null, "在限制時間內，操控貓貓來躲避所有動物們！\n\n遊戲中按空白鍵可暫停，再按一次恢復遊戲。\n", "DogDodge", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		add(btn_start);
		add(btn_tips);
		//repaint(); // 強制重新繪製視窗

		// 按下空白鍵暫停遊戲(需在英文輸入法，中文輸入法無法執行)
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 32) {
					switch (state) {
					case 1:
						state = 2;
						pauseTimer(); // 暫停計時器
						break;
					case 2:
						state = 1;
						startOrResumeTimer(); // 恢復計時器
						break;
					default:
					}
				}
			}
		});

		// 重複繪製
		while (true) {
			if (state == 1) {
				createObj();
				repaint();
			}

			try {
				Thread.sleep(25);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	// 遊戲內容繪製與狀態
	@Override
	public void paint(Graphics g) {
		if (offScreenImage == null) {
			offScreenImage = createImage(width, height);
		}
		Graphics gImage = offScreenImage.getGraphics();
		gImage.fillRect(0, 0, width, height);

		if (state == 0) {
			// 遊戲狀態 0未開始
			gImage.drawImage(GameUtils.InitialImg, 0, 0, this);
		}

		if (state == 1) {
			// 遊戲狀態 1遊戲中
			// 開始倒數計時
			if (!isCountingDown) {
				GameUtils.startCountdown(TimeLeft);
				isCountingDown = true;
			}
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			// 將已不在場上的物件刪除，節省資源
			GameUtils.gameObjList.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList1.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList2.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList3.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList4.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList5.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList6.removeAll(GameUtils.removeList);
			GameUtils.DodgeObjList7.removeAll(GameUtils.removeList);
			GameUtils.DO7_bulletObjList.removeAll(GameUtils.removeList);

			GameUtils.drawWord(gImage, "Time: " + GameUtils.getCountdownSeconds(), Color.green, 20, 30, 100);
			// 倒數到0獲勝
			if (GameUtils.getCountdownSeconds() == 0) {
				state = 4;
			}
		}

		if (state == 2) {
			// 遊戲狀態 2暫停
		}

		if (state == 3) {
			// 遊戲狀態 3失敗
			// 先繪製背景和遊戲元素
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			// 繪製碰撞爆炸圖片並顯示GAMEOVER圖片
			int bombWidth = GameUtils.BombImg.getWidth(null) * 2;
			int bombHeight = GameUtils.BombImg.getHeight(null) * 2;
			gImage.drawImage(GameUtils.BombImg, playerObj.getX() - bombWidth / 2 + 20,
					playerObj.getY() + 8 - bombHeight / 2, bombWidth, bombHeight, this);
			gImage.drawImage(GameUtils.OverImg, 105, 170, 366, 230, this);
		}

		if (state == 4) {
			// 遊戲狀態 4成功
			// 先繪製背景和遊戲元素
			for (int i = 0; i < GameUtils.gameObjList.size(); i++) {
				GameUtils.gameObjList.get(i).paintSelf(gImage);
			}
			// 繪製遊戲勝利圖片
			gImage.drawImage(GameUtils.WinImg, 30, 200, 543, 145, this);
		}
		g.drawImage(offScreenImage, 0, 0, null);
		count++;
		// 檢查場上物件數量
		System.out.println(GameUtils.gameObjList.size());
	}

	// 遊戲中要生成的物件們
	void createObj() {

		// 閃避物們 7號 藍色狗狗 動作2發射的子彈
		if (count % 15 == 0 && DodgeObj7.getSwitchImage() == true) {
			for (DodgeObj7 dodgeObj7 : GameUtils.DodgeObjList7) {
				int currentX = dodgeObj7.getX();
				int currentY = dodgeObj7.getY();
				GameUtils.DO7_bulletObjList.add(
						new DodgeObj7_BulletObj(GameUtils.DO7_BulletImg, currentX - 40, currentY + 10, 8, 6, 9, this));
				GameUtils.gameObjList.add(GameUtils.DO7_bulletObjList.get(GameUtils.DO7_bulletObjList.size() - 1));
			}
		}

		// 根據抽到的數字選擇要生成幾號閃避物
		if (count % 10 == 0) {
			int randomDodgeIndex = (int) (Math.random() * 7) + 1; // 生成 1 到 7 的隨機數字

			if (randomDodgeIndex == 1) { // 1號 棕色鼠鼠
				GameUtils.DodgeObjList1.add(
						new DodgeObj1(DodgeObj1.DodgeImgs1, 700, (int) (Math.random() * 13) * 47, 27, 13, 10, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList1.get(GameUtils.DodgeObjList1.size() - 1));
			} else if (randomDodgeIndex == 2) { // 2號 藍色鼠鼠
				GameUtils.DodgeObjList2.add(
						new DodgeObj2(DodgeObj2.DodgeImgs2, 700, (int) (Math.random() * 10) * 60, 20, 10, 15, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList2.get(GameUtils.DodgeObjList2.size() - 1));
			} else if (randomDodgeIndex == 3) { // 3號 黃色狗狗
				int x = (Math.random() < 0.4) ? 700 : -50; // 從左邊出現的機率是3成
				GameUtils.DodgeObjList3
						.add(new DodgeObj3(DodgeObj3.DodgeImgs3, x, (int) (Math.random() * 25) * 24, 40, 25, 4, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList3.get(GameUtils.DodgeObjList3.size() - 1));
			} else if (randomDodgeIndex == 4) { // 4號 棕色鳥鳥
				GameUtils.DodgeObjList4.add(
						new DodgeObj4(DodgeObj4.DodgeImgs4, 700, (int) (Math.random() * 30) * 20, 39, 30, 7, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList4.get(GameUtils.DodgeObjList4.size() - 1));
			} else if (randomDodgeIndex == 5) { // 5號 棕色鬣狗
				GameUtils.DodgeObjList5.add(
						new DodgeObj5(DodgeObj5.DodgeImgs5, 700, (int) (Math.random() * 32) * 19, 42, 32, 8, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList5.get(GameUtils.DodgeObjList5.size() - 1));
			} else if (randomDodgeIndex == 6) { // 6號 黑白二哈
				GameUtils.DodgeObjList6.add(
						new DodgeObj6(DodgeObj6.DodgeImgs6, 700, (int) (Math.random() * 39) * 15, 50, 39, 5, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList6.get(GameUtils.DodgeObjList6.size() - 1));
			} else { // 7號 藍色狗狗
				GameUtils.DodgeObjList7.add(
						new DodgeObj7(DodgeObj7.DodgeImgs7, 700, (int) (Math.random() * 34) * 18, 40, 34, 8, this));
				GameUtils.gameObjList.add(GameUtils.DodgeObjList7.get(GameUtils.DodgeObjList7.size() - 1));
			}
			DodgeCount++;
		}
	}

	// 開始或恢復計時器
	public void startOrResumeTimer() {
		// 恢復計時
		if (GameUtils.getCountdownSeconds() > 0 && !isCountingDown) {
			GameUtils.resumeCountdown();
			isCountingDown = true;
		}
		// 開始計時
		else {
			GameUtils.startCountdown(TimeLeft);
			isCountingDown = true;
		}
	}

	// 暫停計時器
	public void pauseTimer() {
		if (isCountingDown) {
			GameUtils.pauseCountdown();
			isCountingDown = false;
		}
	}

	// 停止計時器並歸零
	public void resetTimer() {
		GameUtils.resetCountdown();
		isCountingDown = false;
	}

	// 初始化遊戲程式
	public static void main(String[] args) {
		GameMain gameMain = new GameMain();
		gameMain.launch();
	}
}
