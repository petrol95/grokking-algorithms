package changing;

import java.util.concurrent.atomic.AtomicInteger;

public class ChangeValue {
    public static void main(String[] args) {

        // Error! variable should be final
//        int counter = 0;
//        Runnable r = () -> counter++;

        final AtomicInteger counter = new AtomicInteger(0);
        Runnable r = () -> counter.incrementAndGet();
    }
}
