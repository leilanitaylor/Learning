package juniorJavaDevClass.DataStructures;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ReadCSV {

    public static void main(String[] args) {
        // this method will read data from a CSV file
        List<String[]> data = new ArrayList<>();
        Path path = Paths.get("src/main/resources").resolve("accounts.csv");
        File fileName = path.toFile();
        String dataRow;

        try {
            // Open the file
            BufferedReader br = new BufferedReader((new FileReader(fileName)));

            // Read the data as long as it's not empty
            while ((dataRow = br.readLine()) != null) {
                // Parse the data by commas
                String[] line = dataRow.split(",");
                // add the data to the collection
                data.add(line);
            }
            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (String[] account : data) {
            System.out.print("[ ");
            for (String field : account) {
                System.out.print(field + " ");
            }
            System.out.println(" ]");
        }
    }
}
