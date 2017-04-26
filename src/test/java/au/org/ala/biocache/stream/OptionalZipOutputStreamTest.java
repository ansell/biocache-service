package au.org.ala.biocache.stream;

import static org.junit.Assert.*;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.Timeout;

import au.org.ala.biocache.stream.OptionalZipOutputStream.Type;

/**
 * Abstract test for {@link OptionalZipOutputStream} to avoid duplicating the
 * test for zip and non-zip.
 * 
 * @author Peter Ansell p_ansell@yahoo.com
 */
public abstract class OptionalZipOutputStreamTest {

    @Rule
    public TemporaryFolder tempDir = new TemporaryFolder();

    @Rule
    public Timeout timeout = new Timeout(1, TimeUnit.MINUTES);

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    private Path testDir;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
        testDir = tempDir.newFolder("optionalzipoutputstreamtest").toPath();
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * @return The {@link Type} to use for this test
     */
    protected abstract Type getTestType();

    /**
     * @return the maximum individual file size to use for this test.
     */
    protected abstract Integer getTestMaxIndividualFileSize();

    private OptionalZipOutputStream getNewTestOutputStream() throws IOException {
        Type testType = getTestType();

        Path tempFile = Files.createTempFile(testDir, "optionalzipoutputstream",
                "." + (testType == Type.zipped ? "zip" : "dat"));
        OutputStream rawOutput = Files.newOutputStream(tempFile);
        OptionalZipOutputStream testOptionalOutput = new OptionalZipOutputStream(getTestType(), rawOutput,
                getTestMaxIndividualFileSize());
        return testOptionalOutput;
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#flush()}.
     */
    @Test
    public final void testFlushNothingWritten() throws Exception {
        try (OptionalZipOutputStream testOutput = getNewTestOutputStream();) {
            testOutput.flush();
        }
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#close()}.
     */
    @Test
    public final void testCloseNothingWritten() throws Exception {
        try (OptionalZipOutputStream testOutput = getNewTestOutputStream();) {
            testOutput.close();
        }
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#isNewFile(java.lang.Object, long)}.
     */
    @Test
    public final void testIsNewFileNothingWrittenNotFlushable() throws Exception {
        try (OptionalZipOutputStream testOutput = getNewTestOutputStream();) {
            testOutput.isNewFile(new Object(), 0L);
        }
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#putNextEntry(java.lang.String)}.
     */
    @Test
    public final void testPutNextEntry() throws Exception {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#closeEntry()}.
     */
    @Test
    public final void testCloseEntry() throws Exception {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#getType()}.
     */
    @Test
    public final void testGetType() throws Exception {
        fail("Not yet implemented"); // TODO
    }

    /**
     * Test method for
     * {@link au.org.ala.biocache.stream.OptionalZipOutputStream#getCurrentEntry()}.
     */
    @Test
    public final void testGetCurrentEntry() throws Exception {
        fail("Not yet implemented"); // TODO
    }

}
