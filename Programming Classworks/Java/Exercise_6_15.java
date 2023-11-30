
public class Exercise_6_15 {

 /*	◆ 請以 Switch/if 語法製作一個程式，內容如下:
	➢ 請選擇 預計計算的圖形: 1. 圓形 2. 正方形 3. 長方形。
	➢ 根據第一項選擇的結果，會顯示出「請輸入半徑」、「請輸入邊長」 或「請輸入長、請輸入寬」。
	➢ 請選擇預計計算的項目: 1. 周長 2. 面積。
	➢ 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料。				  */
	
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("請輸入欲計算的圖形'編號'(圓形=1/正方形=2/長方形=3)： ");
		byte shape = scanner.nextByte();

		if (shape == 1) { // 當輸入圓形時
			System.out.print("請輸入半徑(可以有小數點)： ");
			float radius = scanner.nextFloat();
			double PI = 3.1415926;
			System.out.print("請輸入欲計算的項目'編號'(周長=1/面積=2)： ");
			byte circlecount = scanner.nextByte();

			if (circlecount == 1) { // 當輸入圓形，並欲計算周長時
				double circlelength = radius * 2 * PI;
				System.out.print("'圓形'半徑 " + radius + " 周長為：" + circlelength);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else if (circlecount == 2) { // 當輸入圓形，並欲計算面積時
				double circlearea = radius * radius * PI;
				System.out.print("'圓形'半徑 " + radius + " 面積為：" + circlearea);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else // 防呆，若輸入錯誤，提示正確應該輸入什麼
				System.out.println("請輸入'1'或'2'！");

		} else if (shape == 2) { // 當輸入正方形時
			System.out.print("請輸入邊長(可以有小數點)： ");
			float square = scanner.nextFloat();
			System.out.print("請輸入欲計算的項目'編號'(周長=1/面積=2)： ");
			byte squarecount = scanner.nextByte();

			if (squarecount == 1) { // 當輸入正方形，並欲計算周長時
				double squarelength = square * 4;
				System.out.print("'正方形'邊長 " + square + " 周長為：" + squarelength);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else if (squarecount == 2) { // 當輸入正方形，並欲計算面積時
				double squarearea = square * square;
				System.out.print("'正方形'邊長 " + square + " 面積為：" + squarearea);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else // 防呆，若輸入錯誤，提示正確應該輸入什麼
				System.out.println("請輸入'1'或'2'！");

		} else if (shape == 3) { // 當輸入長方形時
			System.out.print("請輸入長(可以有小數點)： ");
			float height = scanner.nextFloat();
			System.out.print("請輸入寬(可以有小數點)： ");
			float widht = scanner.nextFloat();
			System.out.print("請輸入欲計算的項目'編號'(周長=1/面積=2)： ");
			byte rectanglecount = scanner.nextByte();

			if (rectanglecount == 1) { // 當輸入長方形，並欲計算周長時
				double rectanglelength = (height + widht) * 2;
				System.out.print("'長方形'長 " + height + " 寬 " + widht + " 周長為：" + rectanglelength);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else if (rectanglecount == 2) { // 當輸入長方形，並欲計算面積時
				double rectanglearea = height * widht;
				System.out.print("'長方形'長 " + height + " 寬 " + widht + " 面積為：" + rectanglearea);
				// 根據第三項選擇，輸出「形狀、半徑/邊長/長、寬、周長/面積」的資料
			} else // 防呆，若輸入錯誤，提示正確應該輸入什麼
				System.out.println("請輸入'1'或'2'！");

		} else // 防呆，若輸入錯誤，提示正確應該輸入什麼
			System.out.println("請輸入'1'或'2'或'3'！");

		scanner.close();
	}

}
