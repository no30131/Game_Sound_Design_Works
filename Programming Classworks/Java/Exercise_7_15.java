/* ◆ 請建立一個設計圖A，裡面有Name，Size，Price，Quantity四項，
     初始值分別如下：
   Name：A 大樓設計圖  Size：30  Price：300萬  Quantity：20
 ◆ 接著請根據設計圖A建立二大樓 A1 及 A2 ，並修改裡面的設定值。
   A1 Name：A1大樓； Price：350萬
   A2 Name：A2大樓； Quantity：30
 ◆ 請以類別與物件的角度建立程式，並輸出 A1、A2的四項資訊。 */

class A_Building {
	public String Name;
	public int Size = 30;
	public int Price = 3_000_000;
	public int Quantity = 20;

	public void Information() {
		System.out.print("\nName: " + Name);
		System.out.println("\tSize: " + Size);
		System.out.print("Price: " + Price);
		System.out.print("\t\tQuantity: " + Quantity + "\n");
	}
}
	public class Exercise_7_15 {
		public static void main(String[] args) {
			A_Building A1 = new A_Building();
			A1.Name = "A1 Building";
			A1.Price = 3_500_000;
			A1.Information();

			A_Building A2 = new A_Building();
			A2.Name = "A2 Building";
			A2.Quantity = 30;
			A2.Information();
		}
	}
