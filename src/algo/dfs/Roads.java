package algo.dfs;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Roads {

    int K,N,R;
    List<List<Road>> cityMap = new ArrayList<>(); //�ڽӱ�// cityMap[i]�Ǵӵ�i��·�����ĳ��м���
    int minLen = 1 << 30; //��ǰ�ҵ�������·���ĳ���
    int totalLen; //�����ߵ�·���ĳ���
    int totalCost ; //�����ߵ�·���Ļ���
    int visited[] = new int[110]; //�����Ƿ��Ѿ��߹��ı��
    int minL[][] = new int[110][10100]; //minL[i][j]��ʾ��1��i��ģ�����Ϊj�����·��

    void Dfs(int s) //�� s��ʼ��N����
    {
        if (s == N) {
            minLen = min(minLen, totalLen);
            return;
        }
        for (int i = 0; i < cityMap.get(s).size(); ++i) {
            int d = cityMap.get(s).get(i).getD(); //s ��·����d
            if (visited[d] != 0) {
                int cost = totalCost + cityMap.get(s).get(i).getT();
                //�����Լ�֦
                if (cost > K)
                    continue;
                //�����Լ�֦
                //1)�����ǰ�Ѿ��ҵ�������·������ΪL ,��ô�ڼ��������Ĺ����У�
                // �ܳ����Ѿ����ڵ���L���߷����Ϳ���ֱ�ӷ����������ߵ�����
                //2) ��midL[k][m] ��ʾ���ߵ�����kʱ�ܹ�·��Ϊm�������£�����·���ĳ��ȡ�
                // ���ں����������У��ٴ��ߵ�kʱ��
                // �����·��ǡ��Ϊm���Ҵ�ʱ��·�������Ѿ����� midL[k][m],�򲻱�������ȥ�ˡ�
                if (totalLen + cityMap.get(s).get(i).getL() >= minLen ||
                        totalLen + cityMap.get(s).get(i).getL() >= minL[d][cost])
                    continue;
                //�ܳ���
                totalLen += cityMap.get(s).get(i).getL();
                //�ܿ���
                totalCost += cityMap.get(s).get(i).getT();
                minL[d][cost] = totalLen;
                visited[d] = 1;
                Dfs(d);
                //�߱��·�������ֻص�r.d ����֮ǰ���ӵĳ���
                visited[d] = 0;
                totalCost -= cityMap.get(s).get(i).getT();
                totalLen -= cityMap.get(s).get(i).getL();
            }
        }
    }
}
