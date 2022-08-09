
public class test {
    public static void main(String [] args){

        try {
            for(int i = 0 ; i < 10 ; i++){
                (new Add(i + "" + i + "" + i, "qbctese" + i)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        Thread cpuT = new Thread(new CPUThread(),"cpu");
        cpuT.start();

    }
}

class Add implements Runnable{

    private Thread t;
    private String name;
    private String data;

    Add(String name, String data){
        this.name = name;
        this.data = data;
    }

    @Override
    public void run() {
        UserProcess userProcess = new UserProcess(0,name,data);
        ProcessController.addProcess(userProcess);
    }

    void start(){
        if(t == null) {
            t = new Thread(this, name);
            t.start();
        }
    }
}
