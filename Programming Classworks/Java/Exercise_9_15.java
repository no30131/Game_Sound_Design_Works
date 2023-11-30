/* 請建立a 、 b 、 c 均為 4 列 3 行 (4x3) 的矩陣 (Matrix)，
   並將 a 矩陣和 b 矩陣的加總存放在 c 矩陣裡，並且將結果顯示在螢幕上。 */

public class Exercise_9_15 {
	//建立顯示矩陣的方法
	public static void printMatrix(int [][] matrix) {
		for (int x = 0 ; x < 4 ; x++) {
			for (int y = 0 ; y < 3 ; y++) {
				System.out.print(matrix[x][y] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		//建立a矩陣
		int [][] a = {{1, 2, 3}, {4, 5, 6},
					  {7, 8, 9}, {10, 11, 12}};

		System.out.println("a 矩陣： ");
		printMatrix(a); //呼叫方法秀出矩陣a
		
		//建立b矩陣，並且值為a矩陣+12
		int [][] b = new int[4][3];
		for (int x = 0 ; x < 4 ; x++) {
			for (int y = 0 ; y < 3 ; y++) {
				b[x][y] = a [x][y] +12;
			}
		}
		System.out.println("b 矩陣： ");
		printMatrix(b);
		
		//建立c矩陣，並且值為a+b矩陣
		int [][] c = new int[4][3];
		for (int x = 0 ; x < 4 ; x++) {
			for (int y = 0 ; y < 3 ; y++) {
						c[x][y] = a [x][y] + b[x][y];
					}
				}
				System.out.println("c 矩陣： ");
				printMatrix(c);
	}
}
