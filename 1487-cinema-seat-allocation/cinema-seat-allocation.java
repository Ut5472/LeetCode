class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer,Set<Integer>> reserve = new HashMap<>();
        for(int i=0;i<reservedSeats.length;i++){
            int row = reservedSeats[i][0];
            int col = reservedSeats[i][1];
            if(reserve.containsKey(row)){
                reserve.get(row).add(col);
            }else{
                Set<Integer> cols = new HashSet<>();
                cols.add(col);
                reserve.put(row,cols);
            }
        }
        int counter = (n-reserve.size())*2;
        for(int i:reserve.keySet()){
            Set<Integer> reservation = reserve.get(i);
                boolean left = true;
                boolean middle = true;
                boolean right = true;
                if(reservation.contains(2) || reservation.contains(3) || reservation.contains(4) || reservation.contains(5) ){
                    left = false;
                }if(reservation.contains(4) || reservation.contains(5) || reservation.contains(6) || reservation.contains(7) ){
                    middle = false;
                }if(reservation.contains(6) || reservation.contains(7) || reservation.contains(8) || reservation.contains(9) ){
                    right = false;
                }
                if(left && right){
                    counter += 2;
                }else if(left || middle || right){
                    counter++;
                }
        }
        
        return counter;
    }
}