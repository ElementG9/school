import java.lang.Math;
public class Practice {
    public static void main(String[] args) {
        Practice p = new Practice();
        System.out.println("--Restart--");
        
        System.out.println("sumOdds(11): " + p.sumOdds(11));
        
        System.out.print("piApprox(9223372036854775807L): ");
        System.out.println(p.piApprox(9223372036854775807L));
        
        System.out.print("numTails(10):");
        double tails = 0;
        double total = 0;
        for(double i=0;i<9223372036854775807L;i++) {
            tails += p.numTails(10);
            total += 10;
            System.out.println("Running: (" + i + "/9223372036854775807)");
        }
        System.out.println(tails/total);
        
        System.out.println("countRolls(3,3):");
        for(int i=0;i<10;i++) {
            System.out.println(p.countRolls(3,3));
        }
    }
    public int sumOdds(int upTo) {
        int sum = 0;
        for(int i=1;i<=upTo;i+=2) {
            sum += i;
        }
        return sum;
    }
    public double piApprox(long precision) {
        double quarterPi = 1;
        double positive = -1;
        for(long i=3L;i<precision;i+=2) {
            quarterPi += (positive / i);
            positive *= -1;
        }
        return quarterPi * 4;
    }
    public int numTails(int flips) {
        int numTails = 0;
        for(int i=0;i<flips;i++) {
            numTails += Math.random() < 0.5 ? 0 : 1;
        }
        return numTails;
    }
    public int countRolls(int n, int t) {
        if (!(0 < n && n < 7 && 0 < t)) return -1;
        int rolls = 0;
        int timesGotten = 0;
        while (timesGotten < t) {
            if (Math.floor(6 * Math.random()) + 1 == n) {
                timesGotten++;
            }
            rolls++;
        }
        return rolls;
    }
}
 