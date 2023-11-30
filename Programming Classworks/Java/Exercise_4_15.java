
public class Exercise_4_15 {

	/* 請使用迴圈敘述撰寫一程式，讓使用者輸入一個正整數 num，
	   利用迴圈計算從 1 到 num 之間(包含num)，所有 7 之倍數數字總和。*/
	
	public static void main(String[] args) {
		
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("請輸入一個正整數： ");
		int num = scanner.nextInt();
		int total = 0; 
		
		for (int i = 0; i < num; i+=7) { 
			total+=i;}  //計算i每次的值總和
			System.out.println("1 ~ " + num + " 的 7 倍數數字總和是： " + total);
						
			scanner.close();
			}
	}
