/**
 * Создать три потока, каждый из которых выводит определенную букву (А, И и С) 5 раз. Порядок - АВСАВСАВС
 */

public class WriteLetters {

    private static volatile char letter = 'A';
    private static final Object mon = new Object();

    public static void main(String[] args) {

        new Thread(() -> printA()).start();
        new Thread(() -> printB()).start();
        new Thread(() -> printC()).start();
    }

    private static void printA() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'A') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("A");
                letter = 'B';
                mon.notifyAll();
            }
        }
    }

    private static void printB() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'B') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("B");
                letter = 'C';
                mon.notifyAll();
            }
        }
    }

    private static void printC() {
        synchronized (mon) {
            for (int i = 0; i < 5; i++) {
                while (letter != 'C') {
                    try {
                        mon.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print("C");
                letter = 'A';
                mon.notifyAll();
            }
        }
    }
}
