import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by rick on 7/27/2016.
 */
public class ReadBytes {

    private FileInputStream stream;

    public void readBytes() throws FileNotFoundException {

        File file = new File("files\\0.ogg");
        byte[] bFile = new byte[(int) file.length()];

        try {
            stream = new FileInputStream(file);
            stream.read(bFile);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        int i = 0;
        while (i < 27) {

            if (i < 4) {
                System.out.println("Printing capture pattern.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + bFile[i]);
                    i++;
                }
            }

            System.out.println("Version number: " + bFile[4]);
            System.out.println("Header type: " + bFile[5]);

            i = 6;

            if (i < 14) {
                System.out.println("Printing Granule Position.\n");
                for (int j = 0; j < 8; j++) {
                    System.out.println("Byte " + i + ": " + bFile[i]);
                    i++;
                }
            }

            if (i < 18) {
                System.out.println("Printing bitstream serial number.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + bFile[i]);
                    i++;
                }
            }

            if (i < 22) {
                System.out.println("Printing Page Sequence Number.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + bFile[i]);
                    i++;
                }
            }

            if (i < 26) {
                System.out.printf("Printing checksum.");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + bFile[i]);
                    i++;
                }
            }
            System.out.println("Byte for number of segments: " + bFile[i]);
            i++;
            System.out.println("CURRENT INDEX: " + i);

        }

        System.out.println("Done.");
    }
}
