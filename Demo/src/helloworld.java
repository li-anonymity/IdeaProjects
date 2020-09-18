public class helloworld {
    public static void main(String[] args) {
//        String abc = "123";
//        abc = "321";
//        System.out.println("hello world");
//        int a = 123;
//        long b = 1;
//        int c = (int) (a+b);
//        System.out.println(abc);
//        System.out.println(c);

        double minDetal = 1;
        float resulti =0;
        int resultj=0;
        for (float i = 0; i < 20; i++) {
            if (i%2 == 0){
                continue;
            }
            for (int j = 0; j <= i; j++) {
                if (j%2 == 0){
                    continue;
                }
                if (Math.abs(j/i - 0.618) < minDetal){
                    minDetal = Math.abs(j/i - 0.618);
                    resulti = i;
                    resultj = j;
                }
            }
        }
        System.out.printf("i=%f，j=%d\n",resulti,resultj);
    }
}
