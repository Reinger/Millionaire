import java.util.Random;

public class Generation {

    private final int[][] difficult = {
            //difficult=1
            {0, 78},

            //difficult=2
            {79, 155},

            //difficult=3
            {156, 244},

            //difficult=4
            {246, 347},

            //difficult=5
            {348, 466},

            //difficult=6
            {467, 632},

            //difficult=7
            {633, 768},

            //difficult=8
            {769, 881},

            //difficult=9
            {882, 983},

            //difficult=10
            {984, 1114},

            //difficult=11
            {1115, 1217},

            //difficult=12
            {1218, 1314},

            //difficult=13
            {1315, 1401},

            //difficult=14
            {1402, 1442},

            //difficult=15
            {1443, 1465}
    };

    public int Generat(int n) {
        return (new Random().nextInt(difficult[n-1][1] - difficult[n-1][0] + 1) + difficult[n-1][0]);
    }

    public int[] GeneratHalf(int n){
        int k;
        int[] a={1, 1, 1, 1};

        do{
            k=new Random().nextInt(3);
        }while(k!=n-1);

        a[n-1]=0;
        a[k]=0;

        return a;
    }
}
