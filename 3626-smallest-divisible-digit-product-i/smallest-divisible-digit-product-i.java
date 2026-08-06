class Solution {
    public int smallestNumber(int n, int t) {
        while(true){
            if(sumofnumbers(n) % t==0){
                return n;
            }
            else{
                n++;
            }
        }
        
    }
    public int sumofnumbers(int k){
        int sum=1;
        int p=k;
        while(p>0){
            int dig=p%10;
            sum=sum*dig;
            p=p/10;
        }
        return sum;
    }
}