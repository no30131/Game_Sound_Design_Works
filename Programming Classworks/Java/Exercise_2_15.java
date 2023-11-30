
public class Exercise_2_15 {
	
 /*  請僅使用一個變數num，設定初始值為3
     之後應用++，--，+=，-=的方式(各用一次)
     輸出以下數字(不用順序)2，5，6，1       */
	
	public static void main(String[] args) {

		byte num = 3;
		System.out.println(num+=num); //6
		System.out.println(--num);    //5
		System.out.println(num-=4);	  //1
		System.out.println(++num);    //2
		
	}

}
