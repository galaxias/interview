package leetcode;

import java.util.Stack;

class Solution6 {
    public boolean isValid(String s) {
        if(s.isEmpty()) return true;
        char[] c = s.toCharArray();
        Stack st = new Stack();
        for(int i = 0; i < c.length; i++){
            char t = c[i];
            if(t == '(' || t== '{' || t== '['){
                st.push(t);
            }
            if(t == ')' || t== '}' || t== ']'){
                char p = st.isEmpty()? ' ' : (char)st.pop();
                if(('(' == p && ')' == t) ||
                        ('{' == p && t == '}') ||
                        ('[' == p && t == ']')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        if(!st.isEmpty()) return false;
        return true;
    }

    public static void main(String[] args){
        String s ="]";

        Solution6 solution6 = new Solution6();
        System.out.println(solution6.isValid(s));
    }
}
