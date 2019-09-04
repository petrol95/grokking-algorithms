import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

public class References {
    public static void main(String[] args) {

        // Strong reference
        Object a =  new Object();
        String str = new String("A");
        str = null; // очистка ссылки

        // Soft reference
        SoftReference sr = new SoftReference(new String("A"));
        System.out.println("sr: " + sr.get());

        // Weak reference
        WeakReference wr = new WeakReference(new String("A"));
        System.out.println("wr: " + wr.get());

        // Phantom reference
        ReferenceQueue rq = new ReferenceQueue();
        PhantomReference pr = new PhantomReference(new String("A"), rq);
        System.out.println("pr: " + pr.get());

        // finalize
        class MyObject {
            protected void finalize() throws Throwable {
                System.out.println("this: " + this);
            }
        }

        // пример удержания ссылки
        System.out.println("=====");
        MyObject obj = new MyObject();
        ReferenceQueue refQueue = new ReferenceQueue();
        WeakReference weakRef = new WeakReference(obj, refQueue);
        System.out.println("poll: " + refQueue.poll()); // null
        System.gc();
        System.out.println("poll: " + refQueue.poll()); // null
        System.out.println("referent: " + weakRef.get());

        // освобождение жесткой ссылки
        System.out.println("=====");
        obj = null;
        System.gc();
        System.out.println("poll: " + refQueue.poll());
        System.out.println("referent: " + weakRef.get()); // null

    }
}
