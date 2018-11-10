class StockSpanner {
    Stack<int[]> stock;
    int size = 0;

    public StockSpanner() {
        stock = new Stack<>();
        size = 0;
    }
    
    public int next(int price) {
        int res = 1;
        while(!stock.isEmpty()) {
            if(price>=stock.peek()[0]){
                res+=stock.pop()[1];
            }else
                break;
        }
        stock.add(new int[]{price,res});
        size+=1;
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */
