class Solution {
    public void rotate(int[][] matrix) {
        int top =0;
        int down = matrix.length -1;
        while(top < down){
            int[] temp = matrix[top];
            matrix[top] = matrix[down];
            matrix[down] = temp;
            top ++;
            down--;
        }
        
        for(int i = 0 ; i <matrix.length; i++){
            for(int j = i+1; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}