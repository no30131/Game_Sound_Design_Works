package e;
import java.util.Scanner;

class UnitCost {			 // 1. 設計 UnitCost（單位成本）類別
	int cost; 				 //    包含一個整數欄位 cost 表示成本

	void getCost(int cost) { //    建立 getCost 方法，以傳回成本
		this.cost = cost;
		System.out.println("引擎成本為\n" + cost);
	}
}

class Engine extends UnitCost {  // 2. 建立 UnitCost 類別的子類別 Engine（引擎）類別
	int cc, year;	 			 //    建構引擎需要傳入引擎的 cc數 與 y年份
	int price, cost2;			 //    建立成本定價與Int引擎成本的變數
	float discount, cost1; 		 //	   建立折扣與引擎成本的變數
								 
	public Engine(int cc, int year) {
	this.cc = cc;
	this.year = year;

	// 成本定價： cc數 為 1800cc時，成本定價為 20000元； 為 2000cc時，成本定價為 25000元
	if(cc == 1800) { 
		price = 20000;
	} else if(cc == 2000) {
		price = 25000;
	}
	
	// 3. 以 y 年份判斷折扣， 2 < y < 5， 8折； 5 <= y < 10， 7折； 10 <= y 以上， 6折。
	if (year > 2 && year < 5) { 
		discount = 0.8f;
	} else if (year >= 5 && year < 10) {
		discount = 0.7f;
	} else if (year >= 10) {
		discount = 0.6f;
	} else {
		discount = 1;
	}
	
	cost1 = price * discount; // 計算引擎成本(成本定價*年份折扣)
	cost2 = (int) cost1; // 將引擎成本由浮點數轉為整數
  }
}

public class Exercise_17_15 {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		System.out.println("請輸入引擎cc數與年份(以一個半形冒號':'分隔)\ncc數只能輸入1800或2000"); 
		
		String input = scn.nextLine();	// 4. 輸入引擎 cc數與年份
		String[] values = input.split(":");	// 將輸入的值加入陣列並以:區隔開
		int cc1 = Integer.parseInt(values[0]); // 將陣列第一個值加到 cc1變數
		int year1 = Integer.parseInt(values[1]); // 將陣列第一個值加到 year1變數
		
		if(cc1 == 1800 || cc1 == 2000) { // 檢查cc數是否有正確輸入
			Engine e = new Engine(cc1, year1); // 建立 Engine物件
			e.getCost(e.cost2); // 呼叫方法輸出引擎成本。
		} else { // 若輸入不正確，顯示提示
			System.out.println("請輸入1800或2000！");
		}
		scn.close();
	}
}