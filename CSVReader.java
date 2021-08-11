import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CSVReader {
    private static final char DELIMINATOR = ',';
    private Scanner fileScanner;


    public CSVReader(String file) {
        this(file, true);
    }

    /**
     * A constructor that requires the name of the file to open
     * @param file filename
     */
    public CSVReader(String file, boolean skipHeader) {
        try {
            fileScanner = new Scanner(new File(file));
            if(skipHeader) this.getNext();
        }catch (IOException io) {
            Logger.debug("File %s not found", file);
            System.exit(1);

        }
    }

    /**
     * Reads a line (nextLine()) and splits it into a String array by the DELIMINATOR, if the line is
     * empty it will also return null. This is the properway to check for CSV files as compared
     * to string.split - as it allows for "quoted" strings ,",",.
     * @return a String List if a line exits or null if not
     */
    public List<String> getNext() {
        if(hasNext()){
            String toSplit = fileScanner.nextLine();
            List<String> result = new ArrayList<>();
            int start = 0;
            boolean inQuotes = false;
            for (int current = 0; current < toSplit.length(); current++) {
                if (toSplit.charAt(current) == '\"') { // the char uses the '', but the \" is a simple "
                    inQuotes = !inQuotes; // toggle state
                }
                boolean atLastChar = (current == toSplit.length() - 1);
                if (atLastChar) {
                    result.add(toSplit.substring(start).replace("\"", "")); // remove the quotes from the quoted item
                } else {
                    if (toSplit.charAt(current) == DELIMINATOR && !inQuotes) {
                        result.add(toSplit.substring(start, current).replace("\"", ""));
                        start = current + 1;
                    }
                }
            }
            return result;
        }
        return null;
    }

    /**
     * Checks to see if the fileScanner has more lines and returns the answer.
     * @return true if the file scanner has more lines (hasNext())
     */
    public boolean hasNext() {
        return (fileScanner != null) && fileScanner.hasNext();
    }



}
