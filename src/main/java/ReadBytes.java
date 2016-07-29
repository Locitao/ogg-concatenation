import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rick on 7/27/2016.
 */
class ReadBytes {

    private FileInputStream stream;

    void readBytes() throws FileNotFoundException {

        File file = new File("files\\0.ogg");
        List<OggPage> pages = new ArrayList<>();
        byte[] fileBytes = new byte[(int) file.length()];

        try {
            stream = new FileInputStream(file);
            stream.read(fileBytes);
            stream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        OggPage oggPage = new OggPage();

        int i = 0;
        while (i < fileBytes.length - 27) {

            //First four bytes are part of the capture pattern of an Ogg page.
            try {
                byte[] cp = new byte[4];
                System.out.println("Printing capture pattern.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + fileBytes[i]);
                    cp[j] = fileBytes[i];
                    i++;
                }
                oggPage.setCapturePattern(cp);
            } catch (Exception ex) { ex.printStackTrace(); }

            //Version number and header type.
            System.out.println("Version number: " + fileBytes[4]);
            byte[] version = new byte[1];
            version[0] = fileBytes[4];
            oggPage.setVersion(version);
            System.out.println("Header type: " + fileBytes[5]);
            byte[] header = new byte[1];
            header[0] = fileBytes[5];
            oggPage.setHeaderType(header);

            i = i + 2;

            //The next 8 bytes is the granule position, depending on the codec, this could be the number of samples in the file, number of frames or something else entirely.
            try {
                byte[] gp = new byte[8];
                System.out.println("Printing Granule Position.\n");
                for (int j = 0; j < 8; j++) {
                    System.out.println("Byte " + i + ": " + fileBytes[i]);
                    gp[j] = fileBytes[i];
                    i++;
                }
                oggPage.setGranulePosition(gp);
            } catch (Exception ex) { ex.printStackTrace(); }

            //The bitstream serial is a way to determine which page belongs to which bitstream.
            try {
                byte[] bitStream = new byte[4];
                System.out.println("Printing bitstream serial number.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + fileBytes[i]);
                    bitStream[j] = fileBytes[i];
                    i++;
                }
                oggPage.setBitStreamSerial(bitStream);
            } catch (Exception ex) { ex.printStackTrace(); }

            //This field is a monotonically increasing field for each logical bitstream. The first page is 0, the second 1, etc. This allows implementations to detect when data has been lost.
            try {
                byte[] pageSequenceNumber = new byte[4];
                System.out.println("Printing Page Sequence Number.\n");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + fileBytes[i]);
                    pageSequenceNumber[j] = fileBytes[i];
                    i++;
                }
                oggPage.setPageSequence(pageSequenceNumber);
            } catch (Exception ex) { ex.printStackTrace(); }

            //This field provides a CRC32 checksum of the data in the entire page (including the page header, calculated with the checksum field set to 0).
            try {
                byte[] checksum = new byte[4];
                System.out.printf("Printing checksum.");
                for (int j = 0; j < 4; j++) {
                    System.out.println("Byte " + i + ": " + fileBytes[i]);
                    checksum[j] = fileBytes[i];
                    i++;
                }
                oggPage.setCheckSum(checksum);
            } catch(Exception ex) { ex.printStackTrace(); }

            System.out.println("Byte for number of segments: " + fileBytes[i]);
            byte[] pageSegments = new byte[1];
            pageSegments[0] = fileBytes[i];
            oggPage.setPageSegments(pageSegments);
            i++;
            System.out.println("CURRENT INDEX: " + i);

            pages.add(oggPage);
        }

        System.out.println("Size of list of pages: " + pages.size());
        System.out.println("Done.");
    }
}
