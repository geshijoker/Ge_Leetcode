class Solution {
    public boolean isValid(String s) {
        if (s.isEmpty())
            return true;
        Stack<Character> stack = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char c = s.charAt(i);
            if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(c=='(')
                stack.push(')');
            else if (!stack.empty()) {
                if (stack.pop()!=c)
                    return false;
            }else
                return false;
        }
        return stack.empty();
    }
}
