import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class test {
    public static void main(String [] args){
        try {
            UserProcess userProcess = new UserProcess(0,"1111","200000");
            userProcess.run();

            String s = "1";

            SpoolingProcess.getInstance().run();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
