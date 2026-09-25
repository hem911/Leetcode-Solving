class Solution {
    public int[] findPeakGrid(int[][] mat) {
        int result[]=new int[2];
        for(int i=0;i<mat.length;i++){
            int top=0,left=0,right=0,bottom=0;
            for(int j=0;j<mat[i].length;j++){
                if(i==0){ top=-1; }
                else{ top = mat[i-1][j]; }
                if(j==0){ left = -1; }
                else{ left=mat[i][j-1]; }
                if(i==mat.length-1){ bottom =-1; }
                else{ bottom=mat[i+1][j]; }
                if(j==mat[i].length-1){ right = -1; }
                else{ right= mat[i][j+1]; }
                int a=mat[i][j];
                if(a>top && a>bottom && a>left && a>right){
                    result[0]=i;
                    result[1]=j;
                }
            }
        }
        return result;
        
    }
}