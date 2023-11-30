
public class Exercise_3_15 {

	/*請使用選擇敘述撰寫程式,
	  讓使用者輸入一個整數,判斷是否為2或7的倍數。
	  ➢ 24是2的倍數	 ➢ -21是7的倍數
	  ➢ 28是2及7的倍數  ➢ -13不是2也不是7的倍數*/
	
	public static void main(String[] args) {
		java.util.Scanner scanner = new java.util.Scanner(System.in);
		System.out.print("輸入一個整數： ");
		int num = scanner.nextInt();
				
		if (num % 2 == 0 & num % 7 == 0)
			System.out.println(num + " 是 2 和 7 的倍數");
		else if (num % 7 == 0) 
			System.out.println(num + " 是 7 的倍數");
		else if (num % 2 == 0) 
			System.out.println(num + " 是 2 的倍數");
		else
			System.out.println(num + " 不是 2 也不是 7 的倍數");
	 
		scanner.close();
	   }
	}
