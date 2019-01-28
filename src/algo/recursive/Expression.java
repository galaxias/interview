package algo.recursive;

public class Expression {

    int expression_value(StringTokener cin) //求一个表达式的值
    {
        int result = term_value(cin); //求第一项的值
        boolean more = true;
        while( more) {
            char op = cin.peek(); //看一个字符,不取走
            if( op == '+' || op == '-' ) {
                cin.get(); //从输入中取走一个字符
                int value = term_value(cin);
                if( op == '+' ) result += value;
                else result -= value;
            }
            else more = false;
        }
        return result;
    }
    int term_value(StringTokener cin) //求一个项的值
    {
        int result = factor_value(cin); //求第一个因子的值
        while(true) {
            char op = cin.peek();
            if( op == '*' || op == '/') {
                cin.get();
                int value = factor_value(cin);
                if( op == '*')
                    result *= value;
                else result /= value;
            }
            else
                break;
        }
        return result;
    }

    int factor_value(StringTokener cin) //求一个因子的值
    {
        int result = 0;
        char c = cin.peek();
        if( c == '(') {
            cin.get();
            result = expression_value(cin);
            cin.get();
        }
        else {
            while(Character.isDigit(c)) {
                result = 10 * result + c - '0';
                cin.get();
                c = cin.peek();
            }
        }
        return result;
    }

    public static void main(String[] args){

        String expression = "(2+3)*(5+7)+9/3";
        StringTokener tokener = new StringTokener(expression);
        Expression expression1 = new Expression();
        System.out.println(expression1.expression_value(tokener));

    }
}
