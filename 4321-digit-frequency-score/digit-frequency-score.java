class Solution {
    public int digitFrequencyScore(int n) {
        HashMap<Integer,Integer>map=new HashMap<>();
        int sum=0;
        int temp=n;
        while(n!=0){
            int dig=n%10;
            map.put(dig,map.getOrDefault(dig,0)+1);
            n=n/10;
        }        
        for(Map.Entry<Integer,Integer>entry:map.entrySet()){
            sum+=(entry.getKey() * entry.getValue());
        }
        return sum;
    }
}