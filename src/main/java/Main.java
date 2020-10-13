public class Main {
    final static int GET_TO_WORK_PAUSE = 1000;

    static int callsCount = 100;
    static int callsPeriodicity = 100;
    static int processingTime = 1000;
    static int specialistsCount = 4;

    public static void main(String[] args) throws InterruptedException {
        CallCenter callCenter = new CallCenter();

        runAtcTask(callCenter, callsCount, callsPeriodicity);
        Thread.sleep(GET_TO_WORK_PAUSE);
        runSpecialistsTask(callCenter, specialistsCount, processingTime);
    }

    public static void runSpecialistsTask(CallCenter callCenter, int specialistsCount, int processingTime) {
        Runnable specialistTask = new Specialist(callCenter, processingTime);
        for (int i = 0; i < specialistsCount; i++) {
            Thread specialistThread = new Thread(specialistTask);
            specialistThread.start();
        }
    }

    public static void runAtcTask(CallCenter callCenter, int callsCount, int callsPeriodicity) {
        Runnable atsTask = new Ats(callCenter, callsCount, callsPeriodicity);
        Thread atcThread = new Thread(atsTask);
        atcThread.start();
    }

}
