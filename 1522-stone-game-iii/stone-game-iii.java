class Solution {
    private int[] Alice(int[] stoneValue,int i,Map<Integer,int[]> dpAlice,Map<Integer,int[]> dpBob){
        int n = stoneValue.length;
        if(i>=n){
            int[] ret = new int[2];
            ret[0] = 0;
            ret[1] = 0;
            return ret;
        }
        if(dpAlice.containsKey(i)){
            return dpAlice.get(i);
        }
        int ans1 = stoneValue[i];
        int ans2 = Integer.MIN_VALUE;
        if (i + 1 < n)
            ans2 = stoneValue[i] + stoneValue[i + 1];

        int ans3 = Integer.MIN_VALUE;
        if (i + 2 < n)
            ans3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2];

        int[] bob1 = Bob(stoneValue, i + 1,dpAlice,dpBob);
        int[] bob2 = new int[]{0, 0};
        if (i + 1 < n) {
            bob2 = Bob(stoneValue, i + 2,dpAlice,dpBob);
        }
        int[] bob3 = new int[]{0, 0};
        if (i + 2 < n) {
            bob3 = Bob(stoneValue, i + 3,dpAlice,dpBob);
        }
        int[] value = new int[2];
        ans1 += bob1[0];
        ans2 += bob2[0];
        ans3 += bob3[0];
        if (ans1 >= ans2 && ans1 >= ans3) {
            value[0] = ans1;
            value[1] = bob1[1];
        } else if (ans2 >= ans3) {
            value[0] = ans2;
            value[1] = bob2[1];
        } else {
            value[0] = ans3;
            value[1] = bob3[1];
        }
        dpAlice.put(i,value);
        return value;
    }
    private int[] Bob(int[] stoneValue,int i,Map<Integer,int[]> dpAlice,Map<Integer,int[]> dpBob){
        int n = stoneValue.length;
        if(i>=n){
            int[] ret = new int[2];
            ret[0] = 0;
            ret[1] = 0;
            return ret;
        }
        if(dpBob.containsKey(i)){
            return dpBob.get(i);
        }
        int bob1 = stoneValue[i];

        int bob2 = Integer.MIN_VALUE;
        if (i + 1 < n) {
            bob2 = stoneValue[i] + stoneValue[i + 1];
        }

        int bob3 = Integer.MIN_VALUE;
        if (i + 2 < n) {
            bob3 = stoneValue[i] + stoneValue[i + 1] + stoneValue[i + 2];
        }
        int[] Alice1 = Alice(stoneValue, i + 1,dpAlice,dpBob);
        int[] Alice2 = new int[]{0, 0};
        if (i + 1 < n) {
            Alice2 = Alice(stoneValue, i + 2,dpAlice,dpBob);
        }
        int[] Alice3 = new int[]{0, 0};
        if (i + 2 < n) {
            Alice3 = Alice(stoneValue, i + 3,dpAlice,dpBob);
        }
        bob1 += Alice1[1];
        bob2 += Alice2[1];
        bob3 += Alice3[1];
        int[] value = new int[2];
        if (bob1 >= bob2 && bob1 >= bob3) {
            value[0] = Alice1[0];
            value[1] = bob1;
        } else if (bob2 >= bob3) {
            value[0] = Alice2[0];
            value[1] = bob2;
        } else {
            value[0] = Alice3[0];
            value[1] = bob3;
        }
        dpBob.put(i,value);
        return value;
    }
    public String stoneGameIII(int[] stoneValue) {
        Map<Integer,int[]> dpAlice = new HashMap<>();
        Map<Integer,int[]> dpBob = new HashMap<>();
        int[] ans = Alice(stoneValue,0,dpAlice,dpBob);
        if(ans[0]>ans[1]){
            return "Alice";
        }else if(ans[0]<ans[1]){
            return "Bob";
        }else{
            return "Tie";
        }
        //return "";

    }
}