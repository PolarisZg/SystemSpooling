public class CPU {
    static final int DIE = 0;
    static final int ACTIVE = 1;
    private int state = DIE;
    private Process nowProcess;

    private static final CPU instance = new CPU();
    private CPU(){}
    public static CPU getInstance(){return instance;}

    void run(){
        while (true) {
            Process process = ProcessController.getAProcess();

            nowProcess = process;

            if(process == null){
                System.out.println("CPU BREAK!!");
                break;
            }

            try {
                System.out.println("------Process " + process.name + " in cpu in in");

                process.run();
            } catch (Interrupt e) {
                System.out.println("------Process " + process.name + " out cpu out out");
                e.content();
            }
        }
    }

    Process getNowProcess(){
        return nowProcess;
    }

    int getState(){
        return state;
    }

}
