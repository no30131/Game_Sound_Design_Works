
public class Exercise_1 {

	public static void main(String[] args) {
		
		byte radius = 5;
		double PI = 3.1415926;
		double circle = radius*radius*PI;
		System.out.print("圓形面積為：" + circle);
		
		byte bottom = 10;
		byte height = 5;
		float triangle = bottom*height/2;
		System.out.print("\n三角形面積為：" + triangle);
		
		byte length = 5;
		byte width = 10;
		float square = length*width;
		System.out.print("\n方形面積為：" + square);
		
		double total = circle + triangle + square;
		System.out.print("\n此圖形面積為：" + total);
	
	}

}
