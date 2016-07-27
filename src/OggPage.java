/**
 * Created by rick on 7/27/2016.
 */
public class OggPage {

    private byte[]
            capturePattern, //The capture pattern or sync code is a magic number used to ensure synchronization when parsing Ogg files
            version, //This field indicates the version of the Ogg bitstream format, to allow for future expansion. It is currently(27/07/2016) mandated to be 0.
            headerType, //Bit: 0 = continuation of previous packet. 1 = Beginning of Stream. 2 = End of Stream.
            granulePosition, //A granule position is the time marker in Ogg files. It is an abstract value, whose meaning is determined by the codec.
            bitStreamSerial, //This field is a serial number that identifies a page as belonging to a particular logical bitstream. Each logical bitstream in a file has a unique value,
            pageSequence, //This field is a monotonically increasing field for each logical bitstream. The first page is 0, the second 1, etc.
            checkSum, //This field provides a CRC32 checksum of the data in the entire page (including the page header, calculated with the checksum field set to 0).
            pageSegments, //This field indicates the number of segments that exist in this page. It also indicates how many bytes are in the segment table that follows this field. There can be a maximum of 255 segments in any one page.
            segmentTable; //The segment table is a vector of 8-bit values, each indicating the length of the corresponding segment within the page body. The number of segments is determined from the preceding Page Segments field. Each segment is between 0 and 255 bytes in length.

    public OggPage(byte[] capturePattern, byte[] version, byte[] headerType, byte[] granulePosition, byte[] bitStreamSerial, byte[] pageSequence, byte[] checkSum, byte[] pageSegments, byte[] segmentTable) {

        this.capturePattern = capturePattern;
        this.version = version;
        this.headerType = headerType;
        this.granulePosition = granulePosition;
        this.bitStreamSerial = bitStreamSerial;
        this.pageSequence = pageSequence;
        this.checkSum = checkSum;
        this.pageSegments = pageSegments;
        this.segmentTable = segmentTable;

    }

    public OggPage() {}

    public byte[] getCapturePattern() {
        return capturePattern;
    }

    public void setCapturePattern(byte[] capturePattern) {
        this.capturePattern = capturePattern;
    }

    public byte[] getVersion() {
        return version;
    }

    public void setVersion(byte[] version) {
        this.version = version;
    }

    public byte[] getHeaderType() {
        return headerType;
    }

    public void setHeaderType(byte[] headerType) {
        this.headerType = headerType;
    }

    public byte[] getGranulePosition() {
        return granulePosition;
    }

    public void setGranulePosition(byte[] granulePosition) {
        this.granulePosition = granulePosition;
    }

    public byte[] getBitStreamSerial() {
        return bitStreamSerial;
    }

    public void setBitStreamSerial(byte[] bitStreamSerial) {
        this.bitStreamSerial = bitStreamSerial;
    }

    public byte[] getPageSequence() {
        return pageSequence;
    }

    public void setPageSequence(byte[] pageSequence) {
        this.pageSequence = pageSequence;
    }

    public byte[] getCheckSum() {
        return checkSum;
    }

    public void setCheckSum(byte[] checkSum) {
        this.checkSum = checkSum;
    }

    public byte[] getPageSegments() {
        return pageSegments;
    }

    public void setPageSegments(byte[] pageSegments) {
        this.pageSegments = pageSegments;
    }

    public byte[] getSegmentTable() {
        return segmentTable;
    }

    public void setSegmentTable(byte[] segmentTable) {
        this.segmentTable = segmentTable;
    }
}
