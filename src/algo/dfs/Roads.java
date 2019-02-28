package algo.dfs;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.min;

public class Roads {

    int K,N,R;
    List<List<Road>> cityMap = new ArrayList<>(); //邻接表。// cityMap[i]是从点i有路连到的城市集合
    int minLen = 1 << 30; //当前找到的最优路径的长度
    int totalLen; //正在走的路径的长度
    int totalCost ; //正在走的路径的花销
    int visited[] = new int[110]; //城市是否已经走过的标记
    int minL[][] = new int[110][10100]; //minL[i][j]表示从1到i点的，花销为j的最短路的

    void Dfs(int s) //从 s开始向N行走
    {
        if (s == N) {
            minLen = min(minLen, totalLen);
            return;
        }
        for (int i = 0; i < cityMap.get(s).size(); ++i) {
            int d = cityMap.get(s).get(i).getD(); //s 有路连到d
            if (visited[d] != 0) {
                int cost = totalCost + cityMap.get(s).get(i).getT();
                //可行性剪枝
                if (cost > K)
                    continue;
                //最优性剪枝
                //1)如果当前已经找到的最优路径长度为L ,那么在继续搜索的过程中，
                // 总长度已经大于等于L的走法，就可以直接放弃，不用走到底了
                //2) 用midL[k][m] 表示：走到城市k时总过路费为m的条件下，最优路径的长度。
                // 若在后续的搜索中，再次走到k时，
                // 如果总路费恰好为m，且此时的路径长度已经超过 midL[k][m],则不必再走下去了。
                if (totalLen + cityMap.get(s).get(i).getL() >= minLen ||
                        totalLen + cityMap.get(s).get(i).getL() >= minL[d][cost])
                    continue;
                //总长度
                totalLen += cityMap.get(s).get(i).getL();
                //总开销
                totalCost += cityMap.get(s).get(i).getT();
                minL[d][cost] = totalLen;
                visited[d] = 1;
                Dfs(d);
                //走别的路，可能又回到r.d 撤销之前增加的长度
                visited[d] = 0;
                totalCost -= cityMap.get(s).get(i).getT();
                totalLen -= cityMap.get(s).get(i).getL();
            }
        }
    }
}
