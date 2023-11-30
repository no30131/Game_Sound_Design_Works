package DogDodge;

/* 主要放遊戲中的各種集合、計時器、背景圖片等 */
import java.awt.*;
import java.util.*;

public class GameUtils {

	// 儲存所有背景圖片的檔案名稱
	private static String[] BgImgs = { "img/BG/bg_1.png", "img/BG/bg_2.png", "img/BG/bg_3.png", "img/BG/bg_4.png",
			"img/BG/bg_5.png" };

	// 選擇一個隨機的背景圖片
	public static Image BgImg() {
		Random RandomBg = new Random();
		int RandomBgIndex = RandomBg.nextInt(BgImgs.length);
		return Toolkit.getDefaultToolkit().getImage(BgImgs[RandomBgIndex]);
	}

	// state = 0 時的初始畫面底圖
	public static Image InitialImg = Toolkit.getDefaultToolkit().getImage("img/main2.png");
	// 開始遊戲按鈕與遊戲說明按鈕的圖
	public static Image StartImg = Toolkit.getDefaultToolkit().getImage("img/playBtn2.png");
	public static Image TipsImg = Toolkit.getDefaultToolkit().getImage("img/tipsBtn2.png");
	
	// 爆炸圖片
	public static Image BombImg = Toolkit.getDefaultToolkit().getImage("img/Chanterelles2.png");
	
	// state = 3 時的失敗文字圖
	public static Image OverImg = Toolkit.getDefaultToolkit().getImage("img/Fail.png");
	
	// state = 4 時的過關文字圖
	public static Image WinImg = Toolkit.getDefaultToolkit().getImage("img/Win.png");

	// 閃避物們 7號 藍色狗狗 動作2發射的子彈
	public static Image DO7_BulletImg = Toolkit.getDefaultToolkit().getImage("img/Ball.png");

	// 所有遊戲物體的集合
	public static java.util.List<GameObj> gameObjList = new ArrayList<>();
	// 要刪除的元素集合
	public static java.util.List<GameObj> removeList = new ArrayList<>();
	// 閃避物1的集合
	public static java.util.List<DodgeObj1> DodgeObjList1 = new ArrayList<>();
	// 閃避物2的集合
	public static java.util.List<DodgeObj2> DodgeObjList2 = new ArrayList<>();
	// 閃避物3的集合
	public static java.util.List<DodgeObj3> DodgeObjList3 = new ArrayList<>();
	// 閃避物4的集合
	public static java.util.List<DodgeObj4> DodgeObjList4 = new ArrayList<>();
	// 閃避物5的集合
	public static java.util.List<DodgeObj5> DodgeObjList5 = new ArrayList<>();
	// 閃避物6的集合
	public static java.util.List<DodgeObj6> DodgeObjList6 = new ArrayList<>();
	// 閃避物7的集合
	public static java.util.List<DodgeObj7> DodgeObjList7 = new ArrayList<>();
	
	// 閃避物們 7號 藍色狗狗 動作2發射的子彈的集合
	public static java.util.List<DodgeObj7_BulletObj> DO7_bulletObjList = new ArrayList<>();

	// 遊戲過關的倒數計時器
	private static Timer countdownTimer;
	private static int countdownSeconds;
	private static boolean timerRunning = true;

	public static void startCountdown(int seconds) {
		// 先檢查計時器是否運行
		if (!timerRunning) {
			timerRunning = true;
		}
		countdownSeconds = seconds;
		countdownTimer = new Timer();
		countdownTimer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				// 每秒執行一次計時器-1
				if (countdownSeconds > 0 && timerRunning) {
					countdownSeconds--; // 每秒減少1秒
				} else if (countdownSeconds > 1 && !timerRunning) {
					// 倒數還沒到0，遊戲暫停
				} else {
					// 倒數到0時，遊戲勝利
					countdownTimer.cancel();
					timerRunning = false; // 計時器停止
				}
			}
		}, 0, 1000);
	}
	
	// 從GameMain呼叫獲得當前倒數時間
	public static int getCountdownSeconds() {
		return countdownSeconds;
	}

	// 暫停計時
	public static void pauseCountdown() {
		timerRunning = false;
	}

	// 恢復計時
	public static void resumeCountdown() {
		timerRunning = true;
	}

	// 停止計時器的方法，重置倒數秒數為0
	public static void resetCountdown() {
		timerRunning = false;
		countdownSeconds = 0;
		if (countdownTimer != null) {
			countdownTimer.cancel();
		}
	}

	// 繪製字串的工具類
	public static void drawWord(Graphics gImage, String str, Color color, int size, int x, int y) {
		gImage.setColor(color);
		gImage.setFont(new Font("Arial", Font.BOLD, size));
		gImage.drawString(str, x, y);
	}

}
