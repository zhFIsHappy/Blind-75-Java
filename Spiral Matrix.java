class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0) return res;
        int rowBegin = 0, colBegin = 0;
        int rowEnd = matrix.length -1, colEnd = matrix[0].length -1;
        while(rowBegin <= rowEnd && colBegin <= colEnd){
            for(int j = colBegin; j<= colEnd; j++){
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            for(int i = rowBegin; i<= rowEnd; i++){
                res.add(matrix[i][colEnd]);
            }
            colEnd --;
            // for not symmetric case, prevent going back
            if (rowBegin <= rowEnd) {
                // Traverse Left
                for (int j = colEnd; j >= colBegin; j--) {
                    res.add(matrix[rowEnd][j]);
                }
            }
            rowEnd--;

            if (colBegin <= colEnd) {
                // Traverse Up
                for (int j = rowEnd; j >= rowBegin; j--) {
                    res.add(matrix[j][colBegin]);
                }
            }
            colBegin++;
        }
        return res;
    }
}