/**
 * Второй вариант синхронизации: монитор - объект
 */

public class SynchBlock {
    private Object mon = new Object();

    public static void main(String[] args) {
        SynchBlock sb = new SynchBlock();
        new Thread(() -> sb.method()).start();
        new Thread(() -> sb.method()).start();
    }

    public void method() {
        System.out.println("Block 1 begins");
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Block 1 ends");

        synchronized (mon) {
            System.out.println("SynchBlock begins");
            for (int i = 6; i < 10; i++) {
                System.out.println(i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("SynchBlock ends");
        }
    }
}
