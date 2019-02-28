package algo.dfs;

import static java.lang.Math.min;

public class BirthdayCake {

    int N,M;
    int minArea = 1 << 30; //最优表面积
    int area = 0; //正在搭建中的蛋糕的表面积
    //v,n,r,h 构成一个状态
    void Dfs(int v, int n,int r,int h)
    //要用n层去凑体积v,最底层半径不能超过r,高度不能超过h
    //求出最小表面积放入 minArea
    {
        if( n == 0 ) {
            if(  v == 0 ) return;
            else {
                minArea = min(minArea,area);
                return; }
        }
        if( v <= 0)
            return ;
        //枚举底层半径和高度
        for( int rr = r; rr >=n; -- rr ) {
            if( n == M ) //底面积
                area = rr * rr;
            for( int hh = h; hh >= n ; --hh ) {
                area += 2 * rr * hh;
                Dfs(v-rr*rr*hh,n-1,rr-1,hh-1);
                area -= 2 * rr * hh;
            }
        }
    }
}
