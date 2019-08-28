import java.util.Arrays;

public class CalcArray {

    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {
        oneThreadMethod();
        twoThreadsMethod();
    }

    public static void oneThreadMethod() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        long startTime = System.currentTimeMillis();
        calcFormula(arr, 0);
        System.out.println("One thread: " + (System.currentTimeMillis() - startTime));
    }

    public static void twoThreadsMethod() {
        float[] arr = new float[size];
        Arrays.fill(arr, 1f);

        float[] arr1 = new float[h];
        float[] arr2 = new float[h];

        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        Thread t1 = new Thread(() -> {
            calcFormula(arr1, 0);
        });

        Thread t2 = new Thread(() -> {
            calcFormula(arr2, h);
        });

        try {
            t1.start();
            t2.start();
            System.arraycopy(arr1, 0, arr, 0, h);
            System.arraycopy(arr2, 0, arr, h, h);
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Two threads: " + (System.currentTimeMillis() - startTime));
    }

    private static void calcFormula(float[] arr, int shift) {
        for (int i = shift; i < (arr.length + shift); i++) {
            arr[i - shift] = (float) (arr[i - shift] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) *
                    Math.cos(0.4f + i / 2));
        }
    }

}

