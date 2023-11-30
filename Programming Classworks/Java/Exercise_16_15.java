/*  辛苦一個月之後，終於快來到了中秋連假，我們(你，我，他)三人接下來的三天連假去的地方
	都不一樣。請以介面與類別/抽象類別搭配輸出結果。
							  */
package eee;

interface DAY1{
	void day1();
}

interface DAY2{
	void day2();
}

interface DAY3{
	void day3();
}

class YOU implements DAY1, DAY2, DAY3{
	public void day1() {
		System.out.print("你連假第一天去： Veganlala\t");
	}
	public void day2() {
		System.out.print("\t第二天去： Mixigan\t");
	}
	public void day3() {
		System.out.print("\t第三天去： MissGreen");
	}
} 

class ME implements DAY1, DAY2, DAY3{
	public void day1() {
		System.out.print("\n我連假第一天去： VeganTaipei");
	}
	public void day2() {
		System.out.print("\t第二天去： Baganhood");
	}
	public void day3() {
		System.out.print("\t第三天去： LovingHut");
	}
} 

class HE implements DAY1, DAY2, DAY3{
	public void day1() {
		System.out.print("\n他連假第一天去： Veganday\t");
	}
	public void day2() {
		System.out.print("\t第二天去： UncleQ\t");
	}
	public void day3() {
		System.out.print("\t第三天去： ChaoChao");
	}
} 

public class Exercise_16_15 {
	public static void main(String[] args) {
	
		YOU you = new YOU();
		you.day1();	you.day2();	you.day3();
		ME me = new ME();
		me.day1();	me.day2();	me.day3();
		HE he = new HE();
		he.day1();  he.day2();  he.day3();

	}
}
