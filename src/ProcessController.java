public class ProcessController {

    static Process getAProcess(){
        ReadyQ readyQ = ReadyQ.getInstance();
        int random = RandomNumber.getNumber() % 10;
        if(random == 0){
            return SpoolingProcess.getInstance();
        }
        else {
            return readyQ.getProcess(RandomNumber.getNumber() % readyQ.getLength());
        }
    }

    static void addProcess(Process process){
        ReadyQ readyQ = ReadyQ.getInstance();
        readyQ.addProcess(process);
    }
}
