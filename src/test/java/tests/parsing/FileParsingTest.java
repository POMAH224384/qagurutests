package tests.parsing;

import com.codeborne.pdftest.PDF;
import com.codeborne.selenide.Selenide;
import com.codeborne.xlstest.XLS;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class FileParsingTest {

    @Test
    void pdfParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='junit-user-guide-5.10.3.pdf']").download();

        PDF pdf = new PDF(download);
        assertEquals("Stefan Bechtold, Sam Brannen, Johannes Link, Matthias Merdes, Marc Philipp, Juliette de Rancourt, Christian Stein",
                pdf.author);
    }

    @Test
    void excelParseTest() throws Exception {
        open("https://junit.org/junit5/docs/current/user-guide/");
        File download = $("a[href*='some-excel.xls']").download();

        XLS xls = new XLS(download);
        assertTrue(xls.excel.getSheetAt(0).getRow(3).getCell(4).getStringCellValue()
                .startsWith("Some text"));
    }

    @Test
    void csvParsTest() throws Exception {

    }

}
