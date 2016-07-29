import java.io.FileNotFoundException;

/**
 * Created by rick on 7/27/2016.
 */
public class Main {
    public static void main(String[] args) {

        ReadBytes rb = new ReadBytes();

        try {
            rb.readBytes();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
