package algo.enumeration;

public class CounterfeitDollar {


    char[][] left = new char[][]{
            {'A', 'B', 'C', 'D'},
            {'A', 'B', 'C', 'I'},
            {'A', 'B', 'I', 'J'}}; //天平左边硬币
    char[][] right = new char[][]{
            {'E', 'F', 'G', 'H'},
            {'E', 'F', 'J', 'K'},
            {'E', 'F', 'G', 'H'}}; //天平右边硬币
    char[][] result = new char[][]{
            {'e', 'v', 'e', 'n'},
            {'u', 'p'},
            {'e', 'v', 'e', 'n'}}; //结果

    boolean isFake(char c, boolean light) {
        boolean result1 = true;
        //light 为真表示假设假币为轻，否则表示假设假币为重
        for (int i = 0; i < 3; ++i) {
            char[][] pLeft = new char[3][];
            char[][] pRight = new char[3][]; //指向天平两边的字符串
            if (light) {
                pLeft[i] = left[i];
                pRight[i] = right[i];
            } else {
                pLeft[i] = right[i];
                pRight[i] = left[i];
            }
            switch (result[i][0]) {
                case 'u':
                    if (!isContain(pRight[i], c))
                        return false;
                    break;
                case 'e':
                    if (isContain(pLeft[i], c) || isContain(pRight[i], c))
                        return false;
                    break;
                case 'd':
                    if (!isContain(pLeft[i], c))
                        return false;
                    break;
            }
        }
        return true;
    }

    boolean isContain(char[] list, char t) {

        for (int i = 0; i < list.length; i++) {
            if (t == list[i]) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CounterfeitDollar counterfeitDollar = new CounterfeitDollar();
        for (char c = 'A'; c <= 'L'; c++) {
            if(c == 'K'){
                System.out.println(c);
            }
            if (counterfeitDollar.isFake(c, true)) {
                System.out.println(c + " is the counterfeit coin and it is light.");
                break;
            } else if (counterfeitDollar.isFake(c, false)) {
                System.out.println(c + " is the counterfeit coin and it is heavy.");
                break;
            }
        }
    }
}
