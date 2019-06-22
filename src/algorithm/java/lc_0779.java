class Solution {
    public int kthGrammar(int N, int K) {
        if(N==1 && K==1) return 0;
        int prev_k = (K+1)/2;
        int prev = kthGrammar(N-1, prev_k);
        if(prev==0 && prev_k==K/2) 
            return 1;
        else if(prev==0 && prev_k!=K/2)
            return 0;
        else if(prev==1 && prev_k==K/2)
            return 0;
        else
            return 1;
    }
}
