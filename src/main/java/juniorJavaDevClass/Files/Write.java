package juniorJavaDevClass.Files;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Write {
    public static void main(String[] args) {
        // 1. Define the file (path) that we want to write
        String filename = "C:\\Users\\leilanitaylor\\OneDrive - Clearwater\\Documents\\Java Learning\\Files\\FileToWrite.txt";
        String message = "I'm writing data that will be placed in a file";

        // 2. Create the file in Java
        File file = new File(filename);

        // 3. Open the file
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);

            // 4. Write to the file
            fw.write(message);

            // 5. Close resources
            fw.close();
        } catch (IOException e) {
            System.out.println("ERROR: Cold not read file " + filename);
            e.printStackTrace();
        } finally {
            System.out.println("Closing the filewriter");
        }

    }
}
