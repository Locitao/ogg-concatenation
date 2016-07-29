import org.apache.commons.lang.ArrayUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by rvanduijnhoven on 29/07/2016.
 * Attempt to simply paste .ogg files after each other.
 */
public class ConcatOggFiles {
    public static void main(String[] args) throws IOException {
        File file1 = new File("files\\0.ogg");
        File file2 = new File("files\\1.ogg");
        byte[] firstFile = new byte[(int) file1.length()];
        byte[] secondFile = new byte[(int) file2.length()];
        byte[] combined = ArrayUtils.addAll(firstFile, secondFile);
        FileOutputStream out = new FileOutputStream("test.ogg");
        out.write(combined);
        out.close();
        //shit don't work
    }
}
