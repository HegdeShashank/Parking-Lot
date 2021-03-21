package helper;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {

    //This class is not meant for instantiated. Hence throw error when try to instantiate.
    private FileReader() {
        throw new IllegalStateException("Utility class, cannot be instantiated");
    }

    /***
     * Function that takes filename as input and return list of lines in the file.
     * @param fileName - name of the file that needs to be read.
     * @return - List of lines in the file.
     * @throws FileNotFoundException - If file not present in the system.
     */
    public static List<String> getLinesFromInputFile(String fileName) throws FileNotFoundException {
        List<String> lines = new ArrayList<>();
        File inputFile = new File(fileName);
        Scanner inputFileReader = new Scanner(inputFile);
        while (inputFileReader.hasNextLine()) {
            lines.add(inputFileReader.nextLine());
        }
        inputFileReader.close();
        return lines;
    }
}