package tests.parsing;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ZipParsingTest {

    @Test
    void testZipParse() throws IOException {
        try(InputStream is = ZipParsingTest.class.getResourceAsStream("zip/test.rar");
        ZipInputStream zis = new ZipInputStream(is)){
            ZipEntry entry = zis.getNextEntry();
            while(entry != null){
                assertEquals("xls.xlsx", entry.getName());
            }
        }
    }
}
