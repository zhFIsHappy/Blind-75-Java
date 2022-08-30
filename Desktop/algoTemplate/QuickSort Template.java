public class Solution {
    /**
     * @param A: an integer array
     * @return: nothing
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        //quick sort
        quickSort(A,0,A.length -1);
    }
    private void quickSort(int[] A,int start, int end){
        if(start>= end){
            return ;
        }
        int left = start, right = end;
        int pivot = A[(start+end)/2];
        while(left <= right){
            while(A[left]<pivot){
                left++;
            }
            while(A[right] > pivot){
                right --;
            }
            if(left <= right){
                int temp = A[left];
                A[left] =A[right];
                A[right] = temp;

                left ++;
                right --;
            }
        }
        quickSort(A,start,right);
        quickSort(A,left,end);
    }
}