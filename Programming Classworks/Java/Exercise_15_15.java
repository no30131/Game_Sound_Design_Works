/* 		我們三人(a，b，c) 都在同一公司，都需吃三餐，其中中餐一樣，但早，晚餐都不一樣。
	 	請以類別與抽象類別的搭配輸出結果。										*/

package eee;

abstract class human{				// 建立抽象主類別
	
	String SameLunch = "Mixigan";   // 每個人的午餐都是吃 Mixigan
	String Breakfast, Dinner;		// 每個人的早餐和晚餐先給空值，晚點再設定
	
	public abstract void Meals ();	// 建立抽象方法，讓每個人分別填入自己的早餐和晚餐
}

class A extends human{				// 建立 A 的類別，繼承 human 主類別
		public void Meals() { 			// 設定 A 的早餐和晚餐		
		Breakfast = "Veganlala";
		Dinner = "MissGreen";
		System.out.printf("A 的早餐是 %s ， 中餐是 %s ， 晚餐是 %s \n", Breakfast, SameLunch, Dinner);
	}
}

class B extends human{				// 建立 B 的類別，繼承 human 主類別
	public void Meals() { 			// 設定 B 的早餐和晚餐		
		Breakfast = "VeganTaipei";
		Dinner = "Baganhood";
		System.out.printf("B 的早餐是 %s ， 中餐是 %s ， 晚餐是 %s \n", Breakfast, SameLunch, Dinner);
	}
}

class C extends human{				// 建立 C 的類別，繼承 human 主類別
	public void Meals() { 			// 設定 C 的早餐和晚餐		
		Breakfast = "Veganday";
		Dinner = "UncleQ";
		System.out.printf("C 的早餐是 %s ， 中餐是 %s ， 晚餐是 %s ", Breakfast, SameLunch, Dinner);
	}
}

public class Exercise_15_15 {
	public static void main(String[] args) {
		human A = new A();
		A.Meals();
		human B = new B();
		B.Meals();
		human C = new C();
		C.Meals();

	}
}
