package algo.enumeration;

public class PerfectCube {

    public void perfectCube(int n){

        for(int a = 2; a <= n; ++a)
            for(int b = 2; b < a; ++b)
                for(int c = b; c < a; ++c)
                    for(int d = c; d < a; ++d)
                        if( a*a*a == b*b*b + c*c*c +d*d*d)
                            System.out.format("Cube = %d, Triple = (%d,%d,%d)\n", a, b, c,d);

    }
    public static void main(String[] args){
        PerfectCube perfectCube = new PerfectCube();
        perfectCube.perfectCube(24);

    }

}
