class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> list = new ArrayList<>();
        boolean visited[]=new boolean[strs.length];
        for(int i=0;i<strs.length;i++){
            if(visited[i]){
                continue;
            }
            // list.add()
            List<String> strlist=new ArrayList<>();
            for(int j=i;j<strs.length;j++){
                
                if(isanagram(strs[i],strs[j])){
                    visited[j]=true;
                    strlist.add(strs[j]);
                }
                

            }
            // strlist.add(strs[i]);
            list.add(strlist);
        }
        return list;

        
    }
    public boolean isanagram(String s,String t){
        int freq[]=new int[26];
        if(s.length()!=t.length()){ return false; }
        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }
        for(int i=0;i<26;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
    }
}