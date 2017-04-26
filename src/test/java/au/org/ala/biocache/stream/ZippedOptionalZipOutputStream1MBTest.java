/**
 * 
 */
package au.org.ala.biocache.stream;

import au.org.ala.biocache.stream.OptionalZipOutputStream.Type;

/**
 * Test for {@link Type#zipped} when used with {@link OptionalZipOutputStream}.
 * 
 * @author Peter Ansell p_ansell@yahoo.com
 */
public class ZippedOptionalZipOutputStream1MBTest extends OptionalZipOutputStreamTest {

    @Override
    protected Type getTestType() {
        return Type.zipped;
    }

    @Override
    protected Integer getTestMaxIndividualFileSize() {
        return 1;
    }

}
