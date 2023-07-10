package app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriteService {

    public void fileWriteService(String fileName, String newFileText) {

        String path = FolderPath.BASE_PATH + fileName + ".txt";
        File file = new File(path);

        if (file.exists()) {
            throw new IllegalArgumentException("There is a file with same name. Try another one");
        } else {
            try (FileOutputStream fos = new FileOutputStream(path)) {
                fos.write(newFileText.getBytes());
                System.out.println("New file was successfully created and saved.");
            } catch (IOException e) {
                System.out.println("Something went wrong." + e.getMessage());
            }
        }
    }
}