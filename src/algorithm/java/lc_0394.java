class Solution {
    public String decodeString(String s) {
        Stack<String> stString = new Stack<>();
        Stack<Integer> stInt = new Stack<>();
        String res = "";
        int i=0;
        while(i<s.length()) {
            if(Character.isLetter(s.charAt(i))) {
                res += s.charAt(i++);
            }else if(Character.isDigit(s.charAt(i))) {
                int count = 0;
                while(Character.isDigit(s.charAt(i))) {
                    count = 10*count+(s.charAt(i)-'0');
                    i++;
                }
                stInt.push(count);
            }else if (s.charAt(i) == '[') {
                stString.push(res);
                res = "";
                i++;
            }else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                int count = stInt.pop();
                for(int j=0;j<count;j++) {
                    sb.append(res);
                }
                res = stString.pop() + sb.toString();
                i++;
            }
        }
        return res;
    }
}
