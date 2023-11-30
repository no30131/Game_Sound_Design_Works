/* ◆ 請使用亂數產生介於 -15 ~ 130 的答案，然後進行猜數字的程式，
 	 並加入太大、太小、請重新輸入的判斷與輸入。並請在最後猜對時，輸出其總猜測次數。 */

public class Exercise_11_15 {

	public static void main(String[] args) {
		java.util.Random rdm = new java.util.Random();  //建立亂數生成器
		int answer = rdm.nextInt(130 - (-15) +1) + (-15); //生成範圍內的數
		System.out.println(answer);
		java.util.Scanner scn = new java.util.Scanner(System.in);
		int input = 0; //輸入的數
		int count = 0; //總猜測次數
		
		do {
			System.out.print("猜 -15 ~ 130 內的一個整數： ");
			input = scn.nextInt();
			count++;
			if (input > answer && input <= 130) { //太大時提醒
				System.out.println("\n太大了！");
			}
			if (input < answer && input >= -15) { //太小時提醒
				System.out.println("\n太小了！");
			}
			if (input < -15 || input > 130) { //超出範圍時提醒
				System.out.println("\n請輸入-15 ~ 130 內的整數！\n");
			}
		} while (input != answer);
		
		System.out.println("\n恭喜您猜對了！總猜測次數： " + count); //猜對顯示總次數
		
        scn.close();
	}
}
