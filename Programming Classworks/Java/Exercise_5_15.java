
public class Exercise_5_15 {
	
	/* 請寫出一個程式讀入一個整數，畫出以下形狀。
	   基本題：輸入3，呈現如下形狀。
	   *
	   **
	   ***                   
	   進階題：輸入3，呈現如下形狀。
	   *
	   **
	   ***
	   **
	   *						     */

	public static void main(String[] args) {
				
		java.util.Scanner scanner =
		new java.util.Scanner(System.in);
		System.out.print("請輸入一個整數： ");
		int num = scanner.nextInt(); //總共要做幾行
		scanner.close();
			
		for (int h = 1; h <= num ; h++ ) { //h=高度(幾行)
			for (int w = 1 ; w <= h ; w++ ) { //w=寬度(幾個字)
				System.out.print("*");
			} //內迴圈結束
			System.out.println();
		} //外迴圈結束，以上是基本題
		
		System.out.println("---------------");
				
		for (int h = 1; h <= num ; h++ ) { //h=高度(幾行)
			for (int w = 1 ; w <= h ; w++ ) { //w=寬度(幾個字)
				System.out.print("*");
			} //內迴圈結束
			System.out.println();
		} //外迴圈結束，進階題第一段和基本題一樣
		
		for (int h = 1 ; h <= num ; h++ ) { //h=高度(幾行)
			for (int w = h ; w < num ; w++ ) { //w=寬度(幾個字)
				System.out.print("*");
			} //內迴圈結束
			System.out.println();
		} //外迴圈結束，以上是進階題第二段
	}
}

