/*	◆ 請任意輸入 2 ~ 4 個整數值，並建立三個方法執行以下動作並且輸出：
		➢ 方法一： 執行 a + b。
		➢ 方法二： 執行 a - b - c。
		➢ 方法三： 執行 a * b * c * d。						*/

public class Exercise_10_15 {

	public static void main(String[] args) {
		java.util.Scanner scn = new java.util.Scanner(System.in);
		System.out.print("請輸入 2 到 4 個整數值，以空格分隔： ");
        String input = scn.nextLine(); // 讀取整行輸入
        String[] numbers = input.split("\\s+"); // 用空格判斷，將輸入值分割為數個值

        int a = 0, b = 0, c = 0, d = 0; // 建立變數a, b, c, d
        
        if (numbers.length <2 ) { // 輸入未達兩個數值時
            System.out.println("請輸入 2 到 4 個整數值！");
        }
        if (numbers.length == 2) { // 輸入兩個數值時
            a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
            System.out.println("➢ 方法一 ( 執行 a + b ) : " + (a+b));
        }
        if (numbers.length == 3) { // 輸入三個數值時
        	a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
        	c = Integer.parseInt(numbers[2]);
            System.out.println("➢ 方法二 ( 執行 a - b - c ) : " + (a-b-c));
        }
        if (numbers.length >= 4) { // 輸入四個數值時 (超過第四個以後的就不存)
         	a = Integer.parseInt(numbers[0]);
            b = Integer.parseInt(numbers[1]);
        	c = Integer.parseInt(numbers[2]);    
        	d = Integer.parseInt(numbers[3]);
            System.out.println("➢ 方法三 ( 執行 a * b * c * d ) : " + (a*b*c*d));
        }

		scn.close();
	}
}
