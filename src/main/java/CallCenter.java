import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class CallCenter {
    volatile static int callsCounter;
    volatile private Queue<Call> callsList = new ConcurrentLinkedQueue<>();

    public void recieveCall() {
        Call call = new Call("" + ++callsCounter, "some text");
        callsList.add(call);
        System.out.printf("> поступила новая заявка, присвоен номер:%s%n", callsCounter);
    }

    public void processCall() {
        if (!callsList.isEmpty()) System.out.printf(">>> заявка №%s обработана%n", callsList.poll().getId());
    }

    public Queue<Call> getCallsList() {
        return callsList;
    }
}
