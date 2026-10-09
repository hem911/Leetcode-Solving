class Solution {
    public int[] sortedSquares(int[] nums) {
        int arr[]=new int[nums.length];
        int l=0;
        int ind=nums.length-1;
        int r=nums.length-1;
        while(ind!=-1){
            int left=nums[l]*nums[l];
            int right=nums[r]*nums[r];
            int val=Math.max(left,right);
            if(left<right){
                r--;
            }
            // else if(left==right){
            //     r--;
            // }
            else{
                l++;
            }
            arr[ind--]=val;
        }
        return arr;

    }
}