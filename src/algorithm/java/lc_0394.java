class Solution {
    public String decodeString(String s) {
        Stack<String> preSt = new Stack<>();
        Stack<Integer> multiSt = new Stack<>();

        String pre = "";
        int multi = 0;
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c)) {
                pre += c;
            } else if (Character.isDigit(c)) {
                multi *= 10;
                multi += Character.getNumericValue(c);
            } else if (c == '[') {
                preSt.push(pre);
                multiSt.push(multi);
                pre = "";
                multi = 0;
            } else if (c == ']') {
                String multistring = makeString(pre, multiSt.pop());
                pre = preSt.pop();
                pre += multistring;
            }
        }
        
        return pre;
    }
    
    private String makeString(String s, int times) {
        String res = "";
        for(int i=0; i<times; i++) {
            res += s;
        }
        return res;
    }
}
