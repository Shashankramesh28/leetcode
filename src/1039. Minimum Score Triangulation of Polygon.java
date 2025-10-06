class Solution {
    int[][] matrix;
    public int minScoreTriangulation(int[] values) {
        int len = values.length;
        matrix = new int[len][len];
        return recursiveFunc(values, 0, len-1);
    }

    public int recursiveFunc(int[] arr, int start, int end){
        if(end - start < 2){
            return 0;
        }

        if(matrix[start][end] != 0){
            return matrix[start][end];
        }
        int minVal = Integer.MAX_VALUE;
        for(int k = start+1; k<end; k++){
            minVal = Math.min(minVal, recursiveFunc(arr, start, k)+arr[start]*arr[end]*arr[k]+recursiveFunc(arr, k, end));
        }
        return matrix[start][end] = minVal;
    }
}