

public class oppg3g {
    public static void main(String[] args) {
        
        long n = (long) Math.pow(10,7);
        long tidfør = System.currentTimeMillis(); 
        tid(n);
        long tidetter = System.currentTimeMillis(); 
        System.out.println("10^7 bruker " + (long)(tidetter - tidfør) + " millisekund");
        
        n*= 10;

        tidfør = System.currentTimeMillis(); 
        tid(n);
        tidetter = System.currentTimeMillis(); 
        System.out.println("10^8 bruker " + (long)(tidetter - tidfør) + " millisekund");

        n*= 10;

        tidfør = System.currentTimeMillis(); 
        tid(n);
        tidetter = System.currentTimeMillis(); 
        System.out.println("10^9 bruker " + (long)(tidetter - tidfør) + " millisekund");

        /*n*= 10;

        tidfør = System.currentTimeMillis(); 
        tid(n);
        tidetter = System.currentTimeMillis(); 
        System.out.println("10^10 bruker " + (long)(tidetter - tidfør) + " millisekund");
        */
    }

    public static void tid(long n) {
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k = k + 5;
        }
    }
}
