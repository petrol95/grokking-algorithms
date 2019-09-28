package mfu;

public class MFUdemo {

    public static void main(String[] args) {

        MFU mfu = new MFU();

        new Thread(() -> mfu.scan(5)).start();
        new Thread(() -> mfu.scan(10)).start();
        new Thread(() -> mfu.scan(15)).start();

        new Thread(() -> mfu.print(13)).start();
        new Thread(() -> mfu.print(3)).start();
        new Thread(() -> mfu.print(11)).start();
    }
}
