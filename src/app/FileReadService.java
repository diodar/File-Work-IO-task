package app;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReadService {

    static FileInputStream fis;

    public void fileReadService(String fileName) {

        String path = FolderPath.BASE_PATH + fileName + ".txt";

        try {
            fis = new FileInputStream(path);
            int i;
            while ((i = fis.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
            System.out.println("There is no files with this name.");
        } finally {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}