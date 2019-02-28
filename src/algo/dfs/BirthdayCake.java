package algo.dfs;

import static java.lang.Math.min;

public class BirthdayCake {

    int N,M;
    int minArea = 1 << 30; //���ű����
    int area = 0; //���ڴ�еĵ���ı����
    //v,n,r,h ����һ��״̬
    void Dfs(int v, int n,int r,int h)
    //Ҫ��n��ȥ�����v,��ײ�뾶���ܳ���r,�߶Ȳ��ܳ���h
    //�����С��������� minArea
    {
        if( n == 0 ) {
            if(  v == 0 ) return;
            else {
                minArea = min(minArea,area);
                return; }
        }
        if( v <= 0)
            return ;
        //ö�ٵײ�뾶�͸߶�
        for( int rr = r; rr >=n; -- rr ) {
            if( n == M ) //�����
                area = rr * rr;
            for( int hh = h; hh >= n ; --hh ) {
                area += 2 * rr * hh;
                Dfs(v-rr*rr*hh,n-1,rr-1,hh-1);
                area -= 2 * rr * hh;
            }
        }
    }
}
