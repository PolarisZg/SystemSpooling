public class test {
    public static void main(String [] args){

        UserProcess userProcess = new UserProcess(0,"aaaa","qbctesta");
        ProcessController.addProcess(userProcess);
        try {
            for(int i = 0 ; i < 10 ; i++){
                (new Add(i)).start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class Add implements Runnable{

    private int i;
    private Thread t;

    Add(int i){
        this.i = i;
    }

    @Override
    public void run() {
        UserProcess userProcess = new UserProcess(0,i + "" + i + "" + i + "" + i,"qbctest" + i);
        ProcessController.addProcess(userProcess);
    }

    void start(){
        if(t == null) {
            t = new Thread(this, String.valueOf(i));
            t.start();
        }
    }
}
