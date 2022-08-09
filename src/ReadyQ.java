import java.util.ArrayList;

public class ReadyQ{
    private final ArrayList<Process> processesReadyQ;

    private static final ReadyQ instance = new ReadyQ();
    private ReadyQ (){
        processesReadyQ = new ArrayList<>();
    }
    public static ReadyQ getInstance() {
        return instance;
    }

    int getLength(){
        return processesReadyQ.size();
    }

    synchronized Process getProcess(int no){

        Process process = processesReadyQ.get(no);
        processesReadyQ.remove(no);

        System.out.println("readyQ remove out " + process.name);

        return process;
    }
    synchronized int addProcess(Process process){
        processesReadyQ.add(process);

        System.out.println("readyQ add " + process.name);

        return getLength();
    }
}
