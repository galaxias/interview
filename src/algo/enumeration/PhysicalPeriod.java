package algo.enumeration;

public class PhysicalPeriod {

    private static final int N = 21252;

    public void compute(int p, int e, int i, int d){

        int caseNo = 0;
        ++ caseNo;
        int k;
        for(k = d+1; (k-p)%23 != 0; ++k);
        for(; (k-e)%28 != 0; k+= 23);
        for(; (k-i)%33 != 0; k+= 23*28);

        System.out.println("Case " + caseNo +
                ": the next triple peak occurs in " + (k-d) + " days.");
    }

    public static void main(String[] args){

        PhysicalPeriod physicalPeriod = new PhysicalPeriod();
        physicalPeriod.compute(0,0,0,0);
    }
}
