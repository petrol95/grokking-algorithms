/**
 * Первый вариант синхронизации: монитор - экземпляр класса
 */

public class Counter {
    private int c;
    public Counter() {
        this.c = 0;
    }

    public int value() {
        return c;
    }
    public synchronized void inc() {
        c++;
    }
    public synchronized void dec() {
        c--;
    }

    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread t1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.inc();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        });

        Thread t2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                counter.dec();
//                    try {
//                        Thread.sleep(1);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
            }
        });

        t1.start();
        t2.start();
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(counter.value());
    }
}
