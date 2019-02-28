package leetcode;

class Solution3 {
    public boolean isMatch(String text, String pattern) {

        if (pattern.isEmpty()){
            return text.isEmpty();
        }
        boolean first_match = (!text.isEmpty() &&
                (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*'){
            return (isMatch(text, pattern.substring(2)) ||
                    (first_match && isMatch(text.substring(1), pattern)));
        } else {
            return first_match && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args){

        String s = "aab";
        Solution3 solution3 = new Solution3();
        System.out.println(solution3.isMatch(s, "c*a*b"));
    }
}
