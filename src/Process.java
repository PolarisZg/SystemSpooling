import java.util.concurrent.TimeUnit;

abstract class Process {

    String name;
    int type;

    void run() throws Interrupt {}

    void setType(int type){
        this.type = type;
    }
    int getType(){
        return type;
    }
}

class UserProcess extends Process{
    int number;
    String data;

    UserProcess(int number, String name, String data){
        this.number = number;
        this.name = name;
        this.data = data;
        this.type = Type.READY;
    }

    protected UserProcess() {}

    @Override
    void run() throws Interrupt{
        super.run();

        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        OutputController.add(this.name,this.data);

        throw new UserProcessEndInterrupt();
    }

    int getNumber() {
        return number;
    }
    String getName() {
        return name;
    }
    void setData(String data) {
        this.data = data;
    }
}

class SpoolingProcess extends Process{
    private static final SpoolingProcess instance = new SpoolingProcess();
    private SpoolingProcess(){
        this.type = Type.READY;
        this.name = "Spooling";
    }
    public static SpoolingProcess getInstance() {
        return instance;
    }


    @Override
    void run() throws Interrupt{
        super.run();
        Spooling.SpoolingOut2Io(OutputController.getTopProcessData());
    }
}
