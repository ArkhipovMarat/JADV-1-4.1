public class Specialist implements Runnable {
    private CallCenter callCenter;
    private int processingTime;

    public Specialist(CallCenter callCenter, int processingTime) {
        this.callCenter = callCenter;
        this.processingTime = processingTime;
    }

    @Override
    public void run() {
        while (!callCenter.getCallsList().isEmpty()) {
            callCenter.processCall();
            try {
                Thread.sleep(processingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
