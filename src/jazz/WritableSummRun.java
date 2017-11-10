package jazz;

/**
 * Created by user on 10.11.2017.
 */
public class WritableSummRun {

    public static void main(String[] args) {

        WritableSumm w = new WritableSumm();

        long n = ((long) (Math.random() * 1000000000000000L)) / 100;
        System.out.println(n + "\t" + w.numberToString(n));

    }
}
