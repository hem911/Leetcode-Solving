class Solution {
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String alarrmon=arriveAlice.substring(0,2);
        String alarrd=arriveAlice.substring(3,5);
        int alarrdate=Integer.parseInt(alarrd);
        String alleamon=leaveAlice.substring(0,2);
        String allead=leaveAlice.substring(3,5);
        int alleadate=Integer.parseInt(allead);

        String bobarrmon=arriveBob.substring(0,2);
        String bobarrd=arriveBob.substring(3,5);
        int bobarrdate=Integer.parseInt(bobarrd);
        String bobleamon=leaveBob.substring(0,2);
        String boblead=leaveBob.substring(3,5);
        int bobleadate=Integer.parseInt(boblead);
        
        HashMap<String , Integer>map=new HashMap<>();
        map.put("01",0);
        map.put("02",31);
        map.put("03",59);
        map.put("04",90);
        map.put("05",120);
        map.put("06",151);
        map.put("07",181);
        map.put("08",212);
        map.put("09",243);
        map.put("10",273);
        map.put("11",304);
        map.put("12",334);
        int count =0;
        for(int i=map.get(alarrmon)+alarrdate;i<=map.get(alleamon)+alleadate;i++){
            for(int j=map.get(bobarrmon)+bobarrdate;j<=map.get(bobleamon)+bobleadate;j++){
                if(i==j){
                    count++;
                    break;
                }
            }
        }
        return count;



        
    }
}