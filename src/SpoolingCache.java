import java.io.*;

/*
* Spooling 程序有两个功能，
* 一个是向缓冲区输出 SpoolingOut2Cache
* 一个是向 io 设备输出 SpoolingOut2Io
* */

class Spooling {

    static final String cachePath = ".\\spoolingCache\\";
    static final String ioPath = ".\\spoolingIo\\";

    private static int fileNum = 0;
    private static final int topNum = 3;

    static OutputBlock SpoolingOut2Cache(String data, OutputBlock outputBlock) throws SpoolingCacheFullInterrupt {
        if(fileNum > topNum){
            throw new SpoolingCacheFullInterrupt();
        }

        String fileName = outputBlock.getName();
        File file = new File(cachePath + fileName + ".cacche");
        FileWriter fileWriter = null;
        try {
            fileWriter = new FileWriter(file);
            fileWriter.write("");
            fileWriter.write(data);
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        outputBlock.setPath(cachePath + fileName + ".cacche");
        outputBlock.setLength(file.length());
        fileNum ++;

        System.out.println("Spooling Cache add " + fileName );

        return outputBlock;
    }

    static void SpoolingOut2Io(OutputBlock outputBlock) throws SpoolingEndInterrupt {
        File file = new File(outputBlock.getPath());
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
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
        } catch (IOException e) {
            e.printStackTrace();
        }

        fileNum--;

        System.out.println("Spooling io add " + file.getName());

        throw new SpoolingEndInterrupt();

    }
}
