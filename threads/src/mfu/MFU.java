package mfu;

/**
 * Написать класс МФУ, на котором возможно одновременно выполнять печать и сканирование документов, но нельзя
 * одновременно печатать и сканировать два документа. При печати в консоль выводится сообщение "Отпечатано 1, 2, 3,...
 * страницы", при сканировании - аналогично "Отсканировано...". Вывод в консоль с периодом в 50 мс.
 */

public class MFU {

    private Object lock1 = new Object();
    private Object lock2 = new Object();

    public void scan(int amount) {
        synchronized (lock1) {
            int scanPages = 0;
            for (int i = 0; i < amount; i++) {
                System.out.println("Отсканировано " + ++scanPages +" страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("*** Сканирование завершено");
        }
    }

    public void print(int amount) {
        synchronized (lock2) {
            int printPages = 0;
            for (int i = 0; i < amount; i++) {
                System.out.println("Отпечатано " + ++printPages + " страниц");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("*** Печать завершена");
        }
    }

}
