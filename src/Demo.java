import javax.swing.*;
import java.awt.*;

public class Demo {
    Demo(){
        JFrame jFrame = new JFrame();
        jFrame.setLayout(new FlowLayout());

        jFrame.add(new ProcessInPanel().getjPanel());
        jFrame.add(CPUPanel.getInstance().getjPanel());

        jFrame.setDefaultCloseOperation(3);
        jFrame.setSize(500,500);
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
