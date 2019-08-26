public class CalcArray {

    static final int size = 10_000_000;
    static final int h = size / 2;

    public static void main(String[] args) {
        oneThreadMethod();
        twoThreadsMethod();
    }

    public static void oneThreadMethod() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < size; i++) {
            arr[i] = (float) (arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
        System.out.println("One thread: " + (System.currentTimeMillis() - startTime));
    }

    public static void twoThreadsMethod() {
        float[] arr = new float[size];
        for (int i = 0; i < size; i++) {
            arr[i] = 1;
        }
        float[] arr1 = new float[h];
        float[] arr2 = new float[size];

        long startTime = System.currentTimeMillis();
        System.arraycopy(arr, 0, arr1, 0, h);
        System.arraycopy(arr, h, arr2, 0, h);

        new Thread(() -> {
            for (int i = 0; i < h; i++) {
                arr1[i] = (float) (arr1[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        new Thread(() -> {
            for (int i = h; i < size; i++) {
                arr2[i - h] = (float) (arr2[i - h] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
            }
        }).start();

        System.arraycopy(arr1, 0, arr, 0, h);
        System.arraycopy(arr2, 0, arr, h, h);
        System.out.println("Two threads: " + (System.currentTimeMillis() - startTime));
    }

}

