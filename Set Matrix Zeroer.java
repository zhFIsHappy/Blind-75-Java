class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowZero = false;
        boolean colZero = false;
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i< m; i++){
            for(int j = 0 ; j < n ; j ++){
                if(matrix[i][j] == 0){
                    if(i == 0) rowZero = true;
                    if(j == 0) colZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                

            }
        }
        
        for(int j = 1; j < n; j++){
            if(matrix[0][j] == 0){
                for(int i =1; i < m; i ++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 1; i < m; i++){
            if(matrix[i][0] == 0){
                for(int j =1; j < n; j ++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(rowZero){
            for(int j = 0;j < n; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(colZero){
            for(int i =0; i< m ; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}