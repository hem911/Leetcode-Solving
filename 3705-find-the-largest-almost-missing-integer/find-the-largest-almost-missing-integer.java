import java.util.*;
class Solution {
    public int largestInteger(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <= nums.length - k; i++) {
            HashSet<Integer>set=new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(nums[j]);
                // process nums[j]
                
            }
            for(int x:set){
                map.put(x,map.getOrDefault(x,0)+1);
            }
        }
        
        ArrayList<Integer>list=new ArrayList<>();
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        if (list.isEmpty()) {
            return -1;
        }

        return Collections.max(list);
        
        
    }
}