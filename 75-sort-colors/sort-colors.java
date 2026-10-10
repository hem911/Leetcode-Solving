class Solution {
    public void sortColors(int[] nums) {
        int n=nums.length;
        int l=0;
        int m=0;
        int h=n-1;
        while(m<=h){
            if(nums[m]==2){
                swap(nums,m,h);
                h--;
            }
            else if(nums[m]==0){
                swap(nums,m,l);
                l++;
                m++;
            }
            else{
                m++;
            }
        }    
    }
    private void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}