/*  1. 請建立類別 x，裡面有兩屬性 x1 ， x2，一個方法 x3，方法裡面的內容為 x4 = x1*x2。
	2. 請封裝類別 x 裡的屬性與方法。
	3. 輸入兩個數字帶入x1, x2，並計算其相乘結果後輸出。 		*/

public class Exercise_12_15{
	private double x1; double x2; double x4;  // 建立私有屬性 x1 x2 x4
			
	public void setX(double xx1, double xx2) { // 使用 set 來從外部修改 x1 x2
		x1 = xx1;
		x2 = xx2;
	}
		
	private double x3() {  // 建立方法 x3 來儲存 x4 = x1*x2 的值
		x4 = x1*x2;
		return x4 ;
	}

	public String getX() {  // 使用 get 來顯示 x3 的值
		return x1 + " * " + x2 + " = " + x3() ;
	}
	

	public static void main(String[] args) {

		Exercise_12_15 x = new Exercise_12_15(); // 創建一個 x 物件
				
		java.util.Scanner scn = new java.util.Scanner(System.in);
		System.out.print("請輸入 x1 的值(可含小數)： ");
		double xxx1 = scn.nextDouble(); // 將輸入的 x1 存到 xxx1
		System.out.print("請輸入 x2 的值(可含小數)： ");
		double xxx2 = scn.nextDouble(); // 將輸入的 x2 存到 xxx2
		
		x.setX(xxx1, xxx2); // 將 xxx1.xxx2 的值代回到 private 的 x1.x2
		System.out.println(x.getX()); // 顯示 x1*x2 的值
				
		scn.close();
	}
}

