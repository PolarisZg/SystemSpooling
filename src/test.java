
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

        Demo demo = new Demo();

    }
}
