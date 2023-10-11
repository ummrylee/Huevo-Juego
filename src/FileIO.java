import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;
import java.util.TimeZone;

/**
 * Imports and exports data (an ArrayList of Strings) to and from files,
 * provided their relative or fully-qualified filenames, and contains
 * information concerning separators used to define and inside of files.
 * Also contains a converter between save/load-compatible UTC timestamps
 * and user-readable output for efficient and comprehensible file IO.
 * @author Rylee
 * @version 1.0
 */
@SuppressWarnings({"unused", "WeakerAccess"})
public class FileIO {

    /**
     * The character separating data inside of a single entry in a .koala file
     */
    public static final String INDIVIDUAL_SEPARATOR = "~";
    /**
     * The character separating entries in a single line of a .koala file
     */
    public static final String ENTRY_SEPARATOR = "&";
    /**
     * The character(s) separating one line of a file from another on this operating system
     */
    public static final String FILE_SEPARATOR = System.getProperty("file.separator");
    /**
     * The character(s) separating one directory name from another in a filename on this operating system
     */
    public static final String LINE_SEPARATOR = System.getProperty("line.separator");

    /**
     * Reads the information contained within filename
     * and returns each line as String in an ArrayList
     * @param filename the relative or fully-qualified filename of the file to be read
     * @return an ArrayList of the contents of each line of the indicated file as Strings
     * @throws IOException in the event that an error occurs during file reading
     */
    public static ArrayList<String> readFile(String filename) throws IOException {

        Scanner scan = null;
        ArrayList<String> output = new ArrayList<>();

        try {
            FileReader reader = new FileReader(filename);
            scan = new Scanner(reader);
            while (scan.hasNextLine()) {
                String line = scan.nextLine();
                output.add(line);
            }
        } finally {
            if (scan != null) {
                scan.close();
            }
        }

        return output;

    }

    /**
     * Writes the information contained within data to filename in order such that
     * each index corresponds to the line number of the resulting file minus one
     * @param filename the relative or fully-qualified filename of the destination file
     * @param data an ArrayList of the desired contents of each line of the indicated file as Strings
     * @throws IOException in the event that an error occurs during file writing
     */
    public static void writeFile(String filename, ArrayList<String> data) throws IOException  {

        FileWriter writer = null;

        try {
            writer = new FileWriter(filename);
            for (String s : data) {
                writer.write(s);
                writer.write(LINE_SEPARATOR);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }

    }
    /**
     * Changes a UTC long into a MM/DD/YYYY HH:MM:SS String
     * @param utc a UTC timestamp in milliseconds
     * @return A string of the format DD/MM/YYYY HH:MM:SS
     */
    public static String convertToCalendar(long utc) {
        Calendar cal = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
        cal.setTimeInMillis(utc);

        String month = "" + (cal.get(Calendar.MONTH) + 1);
        String day = "" + cal.get(Calendar.DAY_OF_MONTH);
        String year = "" + cal.get(Calendar.YEAR);
        String hour = "" + cal.get(Calendar.HOUR_OF_DAY);
        String minute = "" + cal.get(Calendar.MINUTE);
        String second = "" + cal.get(Calendar.SECOND);

        // makes format look good
        if (month.length() < 2) {
            month = "0" + month;
        }
        if (day.length() < 2) {
            day = "0" + day;
        }
        if (hour.length() < 2) {
            hour = "0" + hour;
        }
        if (minute.length() < 2) {
            minute = "0" + minute;
        }
        if (second.length() < 2) {
            second = "0" + second;
        }

        return month + "/" + day + "/" + year + " at " + hour + ":" + minute + ":" + second;
    }
}