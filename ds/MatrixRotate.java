class MatrixRotate{

	public static void rotate(int[][] matrix){
		
		int n =3;
		for(int i=0;i<4;i++){
			for(int j=i;j<n-i;j++){
				int temp = matrix[i][j];
				matrix[i][j]= matrix[n-j][i];
				matrix[n-j][i] = matrix[n-i][n-j];
				matrix[n-i][n-j]= matrix[j][n-i];
				matrix[j][n-i]= temp;
			}
		}

	}

	public static void main(String ...args)throws Exception{
		
		int matrix[][] = {{1,2,3,4},
							{5,6,7,8},
							{9,10,11,12},
							{13,14,15,16}};

		rotate(matrix);
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++)
				System.out.print(matrix[i][j]+" ");

			System.out.println();
		}
			

	}

}
