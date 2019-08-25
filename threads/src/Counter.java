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
}
