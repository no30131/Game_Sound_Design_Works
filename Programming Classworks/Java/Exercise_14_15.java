/* 		請建立父類別與子類別，並輸出如下細節：
 * 		父類別 記載 父的出生年月日 (year、mon、date)
 * 		子類別 記載 子的出生年月日 				 		*/

package eee;

class Dad{
	int year = 1988, mon = 8, date = 8;
		void BD() {
		System.out.printf("Dad 的出生年月日是： %4d /%2d /%2d %n", year, mon, date);
	}
}

class Kid extends Dad{
	int year = 2022, mon = 2, date = 22 ;
		void BD() {
			System.out.printf("Kid 的出生年月日是： %4d /%2d /%2d %n", year, mon, date);
	}
}

public class Exercise_14_15 {
	public static void main(String[] args) {

		Dad Dad = new Dad();
		Dad.BD();
		Dad Kid = new Kid();
		Kid.BD();
		
	}
}
