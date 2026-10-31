class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer>set =new HashSet<>();
        for(int x:nums){
            set.add(x);
        }
        int ma=0;
        for(int i:set){
            
            if(!set.contains(i-1) ){
                int c=1;
                int x=i;
               while(set.contains(x+1)){
                x=x+1;
                c=c+1;
                
               }
               ma=Math.max(ma,c);
               //break;
            }
            // else{
            //     break;
            // }
            
        }
        return ma;
        
    }
}