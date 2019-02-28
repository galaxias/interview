package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution5 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        char[] c=digits.toCharArray();
        int n = c.length;
        Map<String, char[]> map = new HashMap<String, char[]>() {
            {
                put("2", new char[]{'a', 'b', 'c'});
                put("3", new char[]{'d', 'e', 'f'});
                put("4", new char[]{'g', 'h', 'i'});
                put("5", new char[]{'j', 'k', 'l'});
                put("6", new char[]{'m', 'n', 'o'});
                put("7", new char[]{'p', 'q', 'r' , 's'});
                put("8", new char[]{'t', 'u', 'v'});
                put("9", new char[]{'w', 'x', 'y', 'z'});
            }
        };
        List<char[]> temp = new ArrayList<>();
        for(int i = 0; i < n; i++){
            String t = String.valueOf(c[i]);
            temp.add(map.get(t));
        }
        recursive(temp, temp.size()-1, new StringBuilder(), res);
        return res;
    }

    public void recursive(List<char[]> temp, int n, StringBuilder s, List<String> res){
        if(n < 0){
            res.add(s.toString());
            return;
        }
        char[] cArray = temp.get(n);
        for(int j = 0; j < cArray.length; j++){
            char c = cArray[j];
            s.append(c);
            n--;
            recursive(temp, n, s, res);
            s.deleteCharAt(s.length() - 1);
            n++;
        }
    }

    public static void main(String[] args){
        String s ="23";

        Solution5 solution5 = new Solution5();
        System.out.println(solution5.letterCombinations(s));
    }
}
