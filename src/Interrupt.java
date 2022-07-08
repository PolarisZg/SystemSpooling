public class Interrupt extends Exception{
}

class EmptyOutputInterrupt extends Interrupt{
    public EmptyOutputInterrupt(){
        super();
    }

    void content(){
        SpoolingProcess spoolingProcess = SpoolingProcess.getInstance();
        spoolingProcess.type = type.WAIT_2;
    }
}

class SpoolingEndInterrupt extends Interrupt{
    public SpoolingEndInterrupt(){
        super();
    }

    void content(){
        Wait1Q wait1Q = Wait1Q.getInstance();
        wait1Q.wakeProcess();
    }
}
