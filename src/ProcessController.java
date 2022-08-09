public class ProcessController {

    static Process getAProcess(){
        int mooooooo = 2;
        // 这个变量将Spooling进程与普通进程被请求到的概率调整为 1 : moooooooo

        ReadyQ readyQ = ReadyQ.getInstance();
        int random = RandomNumber.getNumber() % (readyQ.getLength() * mooooooo + 1);
        if(random == 0){
            Process process = SpoolingProcess.getInstance();
            if(process.type == Type.WAIT_2){
                return null;
            }
            else
                return SpoolingProcess.getInstance();
        }
        else {
            return readyQ.getProcess((random - 1) / mooooooo);
        }
    }

    static void addProcess(Process process){

        ReadyQ readyQ = ReadyQ.getInstance();
        readyQ.addProcess(process);

        if(CPU.getInstance().getState() == CPU.DIE)
            activeCPU();
    }

    synchronized static void activeCPU(){
        if(CPU.getInstance().getState() == CPU.DIE){
            CPU.getInstance().run();
        }
    }
}
