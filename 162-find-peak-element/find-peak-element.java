class Solution {
    public int findPeakElement(int[] nums) {
        int c=0;
        int n=nums.length;
        for(int i=0;i<n;i++){
            int left=Integer.MIN_VALUE;
            int right=Integer.MIN_VALUE;
            if(i!=0){ 
            left=nums[i-1];
            }
            if(i!=n-1){
            right=nums[i+1];
            }
            if(nums[i] > left && nums[i]>right){
                c=i;
                break;
            }
        }
        return c;

        
    }
}