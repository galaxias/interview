package algo.recursive;

public class Hanoi {

    public static void Hanoi(int n, char src,char mid,char dest)
    //将src座上的n个盘子，以mid座为中转，移动到dest座
    {
        if( n == 1) { //只需移动一个盘子
            System.out.println(src + "->" + dest);
            //直接将盘子从src移动到dest即可
            return ; //递归终止
        }
        Hanoi(n-1,src,dest,mid); //先将n-1个盘子从src移动到mid
        System.out.println(src + "->" + dest);
        //再将一个盘子从src移动到dest
        Hanoi(n-1,mid,src,dest); //最后将n-1个盘子从mid移动到dest
        return ;
    }

    public static void main(String[] args){

        //输入盘子数目
        Hanoi(3,'A','B','C');
    }
}
