package tests.demoqa;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class FileDownloadTest {

    @Test
    void downloadTest() throws IOException {
        open("https://github.com/qa-guru/niffler-st5/blob/master/README.md");
        File download = $("a[href*='qa-guru/niffler-st5/raw/master/README.md']").download();

        try (InputStream inputStream = new FileInputStream(download)){
            byte[] bytes = inputStream.readAllBytes();

            String fileAsString = new String(bytes, StandardCharsets.UTF_8);
            assertTrue(fileAsString.contains("Технологии, использованные в Niffler"));
        }
    }

    @Test
    void uploadTest() throws Exception {
        open("https://demoqa.com/automation-practice-form");
        $("input[type='file']").uploadFromClasspath("img/1.png");
    }
}
