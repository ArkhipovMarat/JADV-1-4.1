public class Ats implements Runnable{
    private CallCenter callCenter;
    private int callsCount;
    private int callsPeriodicity;

    public Ats(CallCenter callCenter, int callsCount, int callsPeriodicity) {
        this.callCenter = callCenter;
        this.callsCount = callsCount;
        this.callsPeriodicity = callsPeriodicity;
    }

    @Override
    public void run() {
        for (int i = 0; i < callsCount; i++) {
            callCenter.recieveCall();
            try {
                Thread.sleep(callsPeriodicity);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
