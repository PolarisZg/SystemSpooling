import java.util.ArrayList;

// 需要大改，把Arraylist改成数组，因为需要固定位置
// 不改了，再做一个spooling向输出井中的输出程序吧

public class OutputController {
    ArrayList<OutputBlock> arrayList;

    private static final OutputController instance = new OutputController();
    private OutputController(){
        arrayList = new ArrayList<>();
    }
    public static OutputController getInstance() {
        return instance;
    }

    static void add(String name, String data) throws Interrupt {
        OutputBlock outputBlock = new OutputBlock(name);
        outputBlock = Spooling.SpoolingOut2Cache(data,outputBlock);
        instance.arrayList.add(outputBlock);

        outCachePanel.getInstance().flashTextArea(instance.arrayList);
    }

    static OutputBlock getTopProcessData() throws EmptyOutputInterrupt {
        if(instance.arrayList.size() > 0) {
            OutputBlock outputBlock = instance.arrayList.get(0);
            instance.arrayList.remove(0);

            outCachePanel.getInstance().flashTextArea(instance.arrayList);
            return outputBlock;
        }
        else{
            throw new EmptyOutputInterrupt();
        }
    }

}

class OutputBlock{
    private String name;
    private String path;
    private long length;

    OutputBlock(String name){
        this.name = name;
    }

    String getName(){
        return name;
    }
    String getPath(){
        return path;
    }
    long getLength() {return length;}

    void setName(String name){
        this.name = name;
    }
    void setPath(String path){
        this.path = path;
    }
    void setLength(long length) {this.length = length;}

    private OutputBlock(){}
}
