abstract class Process {

    String name;
    int type;

    void run() throws Exception {}

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
    }

    protected UserProcess() {}

    @Override
    void run() throws Exception{
        super.run();
        OutputController.add(this.name,this.data);
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
    private SpoolingProcess(){}
    public static SpoolingProcess getInstance() {
        return instance;
    }


    @Override
    void run() throws Exception{
        super.run();
        Spooling.SpoolingOut2Io(OutputController.getTopProcessData());
    }
}
