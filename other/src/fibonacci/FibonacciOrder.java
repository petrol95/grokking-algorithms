package fibonacci;

/**
 * Функция, возвращающая порядковое число в последовательности Фибоначчи
 */

public class FibonacciOrder {

    public static void main(String[] args) {
        System.out.println(calculateNum(0));
        System.out.println(calculateNum(2));
        System.out.println(calculateNum(77));
    }

    private static int calculateNum(int n) {
        int fib1 = 1;
        int fib2 = 1;
        if (n <= 0 || n > 76) // проверка на корректность / защита от переполнения
            return 0;
        else if (n == 1 || n == 2)
            return 1;
        else {
            int i = 3;
            while (i <= n) {
                int fib3 = fib1 + fib2;
                if (i == n)
                    return fib3;
                else {
                    fib1 = fib2;
                    fib2 = fib3;
                    i++;
                }
            }
        }
        return 0;
    }
}
