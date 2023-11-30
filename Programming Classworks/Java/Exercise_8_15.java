
/* 請以 String literal 或一般建構 (new) 的方式設計二變數 s1、s2，
      接著使用「==」和「equals」比較，輸出以下三種情況：
		1. s1 == s2：true；s1 equals s2：true。
		2. s1 == s2：false；s1 equals s2：true。
		3. s1 == s2：false；s1 equals s2：false。  		*/

public class Exercise_8_15 {

	public static void main(String[] args) {
		
		String s1 = "Super";
		String s2 = "Super";
		System.out.println("1. s1   ==   s2： " + (s1 == s2));    //true  
		System.out.println("   s1 equals s2： " + s1.equals(s2)); //true
		
		s1 = new String("Super");
		System.out.println("\n2. s1   ==   s2： " + (s1 == s2));  //false
		System.out.println("   s1 equals s2： " + s1.equals(s2)); //true
		
		s2 = s2.concat("Super");
		System.out.println("\n3. s1   ==   s2： " + (s1 == s2));  //false
		System.out.print("   s1 equals s2： " + s1.equals(s2));   //false

	}

}
