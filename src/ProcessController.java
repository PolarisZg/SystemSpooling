public class ProcessController {

    public static Process getAProcess(){
        int mooooooo = 2;
        // 这个变量将Spooling进程与普通进程被请求到的概率调整为 1 : moooooooo

        ReadyQ readyQ = ReadyQ.getInstance();
        int random = RandomNumber.getNumber();
        Process spooling = SpoolingProcess.getInstance();

        if(spooling.type == Type.READY){
            random = random % (readyQ.getLength() * mooooooo + 1);
            if(random == 0)
                return spooling;
            else
                return readyQ.getProcess(random / 10);
        }
        else{
            if(readyQ.getLength() > 0)
                return readyQ.getProcess(random % readyQ.getLength());
            else
                return null;
        }
    }

    public static void addProcess(Process process){

        ReadyQ readyQ = ReadyQ.getInstance();
        readyQ.addProcess(process);
    }
}
