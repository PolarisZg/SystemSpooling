public class Interrupt extends Exception{
    void content(){}
}

class EmptyOutputInterrupt extends Interrupt{
    public EmptyOutputInterrupt(){
        super();
    }

    void content(){
        SpoolingProcess spoolingProcess = SpoolingProcess.getInstance();
        spoolingProcess.type = Type.WAIT_2;
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

class SpoolingCacheFullInterrupt extends Interrupt{
    public SpoolingCacheFullInterrupt() {super();}

    void content(){
        Wait1Q.getInstance().addProcess();
    }
}

class UserProcessEndInterrupt extends Interrupt{
    public UserProcessEndInterrupt(){super();}

    void content(){
        SpoolingProcess.getInstance().setType(Type.READY);
    }
}
