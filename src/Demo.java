import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Demo {
    Demo(){
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());

        jFrame.add(new ProcessInPanel().getjPanel());
        jFrame.add(CPUPanel.getInstance().getjPanel());
        jFrame.add(readyQPanel.getInstance().getjPanel());
        jFrame.add(waitQPanel.getInstance().getjPanel());
        jFrame.add(outCachePanel.getInstance().getjPanel());

        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(1800,600);
        jFrame.setVisible(true);
    }
}

class ProcessInPanel{
    private JPanel jPanel;

    ProcessInPanel(){
        this.jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createTitledBorder("创建用户进程"));

        jPanel.setLayout(new GridLayout(3,2));

        jPanel.add(new JLabel("name"));
        JTextField name = new JTextField();
        jPanel.add(name);

        jPanel.add(new JLabel("data"));
        JTextField data = new JTextField();
        jPanel.add(data);

        JButton add = new JButton("add Process");
        add.addActionListener(e -> {
            (new Add(name.getText(),data.getText())).start();
        });
        jPanel.add(add);
    }

    JPanel getjPanel(){
        return jPanel;
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

class CPUPanel{
    private JPanel jPanel;
    private JTextArea processInfo;

    private static final CPUPanel instance = new CPUPanel();
    public static CPUPanel getInstance(){return instance;}

    private CPUPanel(){
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createTitledBorder("C P U"));

        processInfo = new JTextArea(5,30);
        processInfo.setEnabled(false);
        jPanel.add(processInfo);
    }

    public void setInfo(String ClassName, String ProcessName){
        processInfo.setText("");
        processInfo.append(ClassName + System.lineSeparator());
        processInfo.append(ProcessName + System.lineSeparator());
    }

    JPanel getjPanel(){
        return jPanel;
    }
}

class readyQPanel{
    private JPanel jPanel;
    private JTextArea jTextArea;

    private static final readyQPanel instance = new readyQPanel();
    public static readyQPanel getInstance(){return instance;}

    private readyQPanel(){
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createTitledBorder("就 绪 队 列"));

        jTextArea = new JTextArea(30,30);
        jTextArea.setEnabled(false);
        jPanel.add(jTextArea);
    }

    JPanel getjPanel(){
        return jPanel;
    }

    void flashTextArea(ArrayList<Process> arrayList){
        jTextArea.setText("----------" + System.lineSeparator());

        for (Process process : arrayList) {
            UserProcess userProcess = (UserProcess) process;
            jTextArea.append("---name : " + userProcess.name + "     ---data :" + userProcess.data + System.lineSeparator() + "----------" + System.lineSeparator());
        }
    }
}

class waitQPanel{
    private JPanel jPanel;
    private JTextArea jTextArea;

    private static final waitQPanel instance = new waitQPanel();
    public static waitQPanel getInstance(){return instance;}

    private waitQPanel(){
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createTitledBorder("等 待 1 队 列"));

        jTextArea = new JTextArea(30,30);
        jTextArea.setEnabled(false);
        jPanel.add(jTextArea);
    }

    JPanel getjPanel(){
        return jPanel;
    }

    void flashTextArea(ArrayList<Process> arrayList){
        jTextArea.setText("----------" + System.lineSeparator());

        for (Process process : arrayList) {
            UserProcess userProcess = (UserProcess) process;
            jTextArea.append("---name : " + userProcess.name + "     ---data :" + userProcess.data + System.lineSeparator() + "----------" + System.lineSeparator());
        }
    }
}

class outCachePanel{
    private JPanel jPanel;
    private JTextArea jTextArea;

    private static final outCachePanel instance = new outCachePanel();
    public static outCachePanel getInstance(){return instance;}

    private outCachePanel(){
        jPanel = new JPanel();
        jPanel.setBorder(BorderFactory.createTitledBorder("输 出 缓 冲 块 队 列"));

        jTextArea = new JTextArea(30,30);
        jTextArea.setEnabled(false);
        jPanel.add(jTextArea);
    }

    JPanel getjPanel(){
        return jPanel;
    }

    void flashTextArea(ArrayList<OutputBlock> arrayList){
        jTextArea.setText("----------" + System.lineSeparator());

        for (OutputBlock outputBlock : arrayList) {
            jTextArea.append("---name : " + outputBlock.getName() + "     ---path :" + outputBlock.getPath() + System.lineSeparator() + "----------" + System.lineSeparator());
        }
    }
}
