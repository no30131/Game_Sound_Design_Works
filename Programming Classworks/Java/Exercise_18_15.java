import java.util.Scanner;

abstract class Clerk {
	String name;	// 員工姓名
	double rate;	// 每小時標準工資
	double hours;	// 工作時數
	double salary;	// 薪資

	Clerk(String n, double r, double h) {
		name = n; rate = r; hours = h;
	}

	abstract double salary();
}

class PartTime extends Clerk { // 繼承Clerk類別，兼職員工

	PartTime(String n, double r, double h){ // 以Clerk的值初始化
		super(n, r, h);
	}
	
	double salary(){ // 兼職員工薪資計算公式「每小時標準工資 * 工作時數」
		salary = rate * hours; 
		return salary; 
	}
}

class FullTime extends Clerk {	// 繼承Clerk類別，全職員工

	FullTime(String n, double r, double h){ // 以Clerk的值初始化
		super(n, r, h);
	}
	
	double salary() { // 全職員工薪資計算公式「8 × 每小時標準工資 + ((工作數 - 8) × 每小時標準工資 × 0.9)」
		salary = 8 * rate + ((hours-8) * rate * 0.9);
		return salary;
	}
}

public class Exercise_18_15 {
	public static void main(String argv[]) {
		String input = null;
		String pf; // 用以判斷員工性質為兼職或全職
		String n2; double r2, h2; // 員工姓名、每小時標準工資、工作時數
		
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("請依序輸入以單一個半形空格隔開的\n員工性質(請輸入P或F，P兼職，F全職)、"
					+ "姓名(不含空格的英文字串)、每小時標準工資(需>=0)、工作時數(需>=0)：");
			input = sc.nextLine(); // 讓使用者依序輸入以單一個半形空格隔開的員工資料，並將值存到input
			String [] values = input.split(" "); // 將值加到陣列以進行分割，以半形空格作為分割點
			sc.close();
			
			pf = values[0].toUpperCase();	// 將輸入的第一個值加入員工性質變數，並確保是大寫
			n2 = values[1];	// 將輸入的第二個值加入員工姓名變數
			r2 = Double.parseDouble(values[2]);	// 將輸入的第三個值加入每小時標準工資變數
			h2 = Double.parseDouble(values[3]); // 將輸入的第四個值加入工作時數變數
            
			if (values.length != 4) {
				System.out.println("輸入資料有誤，請重新輸入四個正確的值！");
				return;
			}
    
		    if (!n2.matches("[a-zA-Z]+")) {
		        System.out.println("請輸入不含空格的英文字！");
		        return;
		    }

		    if (r2 < 0 || h2 < 0) {
		        System.out.println("請輸入大於等於0的值！");
		        return;
		    }

			if (pf.equalsIgnoreCase("P")) { // 如果是兼職，執行PartTime的計算程式
				PartTime P = new PartTime(n2, r2, h2);
		        P.salary();
		        System.out.println("PartTime " + P.name + " " + P.salary);
		        // 輸出格式為【{員工性質} {員工姓名} {員工薪資}】，性質、姓名與工資中間各一個半形空格
		    } else if (pf.equalsIgnoreCase("F")) { // 如果是全職，執行FullTime的計算程式
		        FullTime F = new FullTime(n2, r2, h2);
		        F.salary();
		        System.out.println("FullTime " + F.name + " " + F.salary); 
		        // 輸出格式為【{員工性質} {員工姓名} {員工薪資}】，性質、姓名與工資中間各一個半形空格
		    } else {
		        System.out.println("請輸入P或F！");
		    }	     
		    
		} catch (Exception ex) { // 若輸入不在指定範圍的資料，輸出【error】。
			System.out.print("error1");
			return;
		}
	}
}
