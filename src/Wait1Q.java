import java.util.ArrayList;

public class Wait1Q {
    private final ArrayList<Process> processesWait1Q;

    private static final Wait1Q instance = new Wait1Q();
    private Wait1Q (){
        processesWait1Q = new ArrayList<>();
    }
    public static Wait1Q getInstance() {
        return instance;
    }

    int getLength(){
        return processesWait1Q.size();
    }

    synchronized void wakeProcess(){
        ReadyQ readyQ = ReadyQ.getInstance();
        for(int i = 0; i < processesWait1Q.size(); i++){
            readyQ.addProcess(processesWait1Q.get(i));
        }
        processesWait1Q.clear();

        System.out.println("wait1Q clear!!");

    }

    synchronized int addProcess(){
        Process process = CPU.getInstance().getNowProcess();
        processesWait1Q.add(process);

        System.out.println("wait1Q add " + process.name);

        return getLength();
    }
}
