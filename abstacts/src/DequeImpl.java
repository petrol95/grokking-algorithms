public class DequeImpl extends QueueImpl {

    public DequeImpl(int maxSize) {
        super(maxSize);
    }

    public void addLeft(int value) {
        if (front == DEFAULT_FRONT)
            front = data.length;
        data[--front] = value;
        size++;
        System.out.println("front = " + front);
        System.out.println("rear = " + rear);
    }

    public int removeRight() {
        int value = data[rear];
        if (rear == 0)
            rear = data.length - 1;
        else
            rear--;
        size--;
        return value;
    }

//    @Override
//    public void display() {
//        for (int i = 0; i < data.length; i++) {
//            System.out.println(data[i]);
//        }
//    }
}
