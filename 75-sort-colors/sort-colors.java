class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0;
        int m=0;
        int h=n-1;
        while(m<=h){
            if(nums[m]==2){
                int temp=nums[m];
                nums[m]=nums[h];
                nums[h]=temp;
                h--;
            }
            else if(nums[m]==0){
                int temp=nums[m];
                nums[m]=nums[l];
                nums[l]=temp;
                l++;
                m++;
            }
            else{
                m++;
            }
        }    
    }
    private void swap(int a,int b){
        int temp=a;
        a=b;
        b=temp;
    }
}