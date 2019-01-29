package algo.dynamicprogramming;

import sun.reflect.generics.tree.VoidDescriptor;

import static java.lang.Integer.max;

public class NumTriangle {

    static int D[][] = {
            {-1},
            {-1,7},
            {-1,3,8},
            {-1,8,1,0},
            {-1,2,7,4,4},
            {-1,4,5,2,6,5}};
    static int n = 5;
    //������õݹ�ķ�������ȱ���ÿ��·����
    // ���ڴ����ظ����㡣��ʱ�临�Ӷ�Ϊ 2n,���� n = 100 �У��϶���ʱ��
    //���ÿ���һ��MaxSum(r,j)�ͱ����������´��õ���ֵ��ʱ��ֱ��ȡ�ã�
    // �����ȥ�ظ����㡣��ô������O(n2)ʱ����ɼ��㡣��Ϊ�����ε����������� n(n+1)/2
    static int MaxSum(int i, int j){
        if(i==n)
            return D[i][j];
        int x = MaxSum(i+1,j);
        int y = MaxSum(i+1,j+1);
        return max(x,y)+D[i][j];
    }

    public static void main(String[] args){
        System.out.println(MaxSum(1,1));

    }
}
