class Solution {
    public boolean lemonadeChange(int[] bills) {
        int[] change = {0,0};
        for(int bill : bills) {
            switch (bill) {
                case 5 :
                    change[0]++; 
                    break;
                case 10:
                    change[0]--;
                    change[1]++;
                    break;
                case 20:
                    change[1]--;
                    if(change[1]<0) {
                        change[1]++;
                        change[0]-=3;
                    }else {
                        change[0]--;
                    }
                    break;
                default: break;
            }
            if(change[0]<0 || change[1]<0)
                return false;
        }
        return true;
    }
}
