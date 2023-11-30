/*  請建立父類別與子類別與其物件，並輸出如下細節：
	父類別物件 輸出 父 的出生年月日 (year、mon、date)
	子類別物件 輸出 子 的出生年月日					*/

class Father {
	int day, month, year;
	
	public void setBirthday(int year, int month, int day) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
}
class Son extends Father {}


public class Exercise_13_15 {
	public static void main(String[] args) {
		
		Father f = new Father();
		f.setBirthday(1993, 1, 10);
		System.out.println("Father Birthday: " + f.year + " 年 " + f.month + " 月 " + f.day + " 日");
		
		Son s = new Son();
		s.setBirthday(2023, 8, 15);
		System.out.println("Son Birthday: " + s.year + " 年 " + s.month + " 月 " + s.day + " 日");
		
	}
}
