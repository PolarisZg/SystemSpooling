import java.io.*;

class Spooling {

    static final String cachePath = ".\\spoolingCache\\";
    static final String ioPath = ".\\spoolingIo\\";

    static OutputBlock SpoolingOut2Cache(String data, OutputBlock outputBlock) throws Exception {
        String fileName = outputBlock.getName();
        File file = new File(cachePath + fileName + ".cacche");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.write(data);
        fileWriter.flush();
        fileWriter.close();
        outputBlock.setPath(cachePath + fileName + ".cacche");
        return outputBlock;
    }

    static void SpoolingOut2Io(OutputBlock outputBlock) throws Exception{
        File file = new File(outputBlock.getPath());
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String data = bufferedReader.readLine();

        bufferedReader.close();
        fileReader.close();
        file.delete();

        file = new File(ioPath + outputBlock.getName() + ".txt");
        FileWriter fileWriter = new FileWriter(file);
        fileWriter.write("");
        fileWriter.write(data);
        fileWriter.flush();
        fileWriter.close();
    }
}
