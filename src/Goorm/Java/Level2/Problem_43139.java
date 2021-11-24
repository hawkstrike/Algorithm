package Goorm.Java.Level2;

// https://level.goorm.io/exam/43139/3%EC%B0%A8%EC%9B%90-%EB%B0%B0%EC%97%B4/quiz/1
public class Problem_43139 {
	public static void main(String[] args) throws Exception {
		StringBuffer sb = new StringBuffer();
		int[][][] arr = new int[3][3][3];
		int num = 1;
		
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				for (int k = 0; k < arr[i][j].length; k++) {
					//System.out.print(num + " ");
					sb.append(num + " ");
					num++;
				}
				
				//System.out.println();
				sb.append("\n");
			}
			
			//System.out.println();
			sb.append("\n");
		}
		
		System.out.print(sb.toString());
	}
}