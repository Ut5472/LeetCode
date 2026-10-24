class Solution {
    private int daynum(String date){
        Map<String,Integer> map = new HashMap<>();
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
        int dayno = map.get(date.substring(0,2));
        dayno += Integer.parseInt(date.substring(3,5));
        return dayno;
    }
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob){
        int ArriveAlice = daynum(arriveAlice);
        int LeaveAlice = daynum(leaveAlice);
        int ArriveBob = daynum(arriveBob);
        int LeaveBob = daynum(leaveBob);
        int startOverlap = Math.max(ArriveAlice, ArriveBob);
        
        // The overlap ends on the earlier of the two leave dates
        int endOverlap = Math.min(LeaveAlice, LeaveBob);
        
        // If the start of the overlap is after the end, they never met
        if (startOverlap > endOverlap) {
            return 0;
        }
        
        // Number of overlapping days (inclusive)
        return (endOverlap - startOverlap) + 1;
    }
}