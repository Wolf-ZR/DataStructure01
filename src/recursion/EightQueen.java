package recursion;

public class EightQueen {
	static int count = 0;// 记录第几种

	public static void main(String[] args) {
		int[][] cotent = new int[8][8];
		eightQueen(0, cotent);
	}

	public static boolean noDanger(int row, int col, int[][] arr) {
		//只需判断上、左上、右上方
		// 上
		for (int r = row-1; r >= 0; r--) {
			if (arr[r][col] == 1) {
				return false;
			}
		}
		// 左上
		for (int r = row-1, c = col-1; r >= 0 && c >= 0; r--, c--) {
			if (arr[r][c] == 1) {
				return false;
			}
		}
		// 右上
		for (int r = row-1, c = col+1; r >= 0 && c < arr[0].length; r--, c++) {
			if (arr[r][c] == 1) {
				return false;
			}
		}
		return true;
	}

	public static void eightQueen(int row, int[][] arr) {
		if (row == 8) {
			//当8行都有皇后的时候说明满足条件
			System.out.println("第" + (++count) + "种");
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j] + " ");
				}
				System.out.println();
			}
		} else {
			int[][] newArr = new int[8][8];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					newArr[i][j] = arr[i][j];
				}
			}
			//每一行从左到右检查
			for (int col = 0; col < 8; col++) {
				
				if (noDanger(row, col, newArr)) {
					for (int c = 0; c < 8; c++) {
						newArr[row][c] = 0;
					}
					newArr[row][col] = 1;
					//上一行有皇后就进入下一行检查
					eightQueen(row + 1, newArr);
				}
			}
		}

	}
}