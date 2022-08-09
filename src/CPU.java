import java.util.concurrent.TimeUnit;

public class CPU {
    static final int DIE = 0;
    static final int ACTIVE = 1;
    private int state = DIE;
    private Process nowProcess;

    private static final CPU instance = new CPU();
    private CPU(){}
    public static CPU getInstance(){return instance;}

    void run(){
            Process process = ProcessController.getAProcess();

            nowProcess = process;

            if(process == null){
                System.out.println("CPU BREAK!!");
                return;
            }

            try {
                System.out.println("------Process.Process " + process.name + " in cpu in in");
                CPUPanel.getInstance().setInfo(process.getClass().getName(),process.name);

                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                process.run();
            } catch (Interrupt e) {
                e.content();

                System.out.println("------Process.Process " + process.name + " out cpu out out");
                CPUPanel.getInstance().setInfo("","");
            }
    }

    Process getNowProcess(){
        return nowProcess;
    }

    int getState(){
        return state;
    }

}

class CPUThread implements Runnable{

    @Override
    public void run() {
        while (true){
            if(ReadyQ.getInstance().getLength() != 0 || SpoolingProcess.getInstance().type != Type.WAIT_2){
                CPU.getInstance().run();

                System.out.println("===readyQ length = " + ReadyQ.getInstance().getLength());
            }
        }
    }
}
