package ex43;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class WebsiteGeneratorTest {

    @Test
    void createDirectories()
    {
        String path = System.getProperty("user.dir");
        File file = new File(path);
        System.out.println("Created " + path);
        File jsFolder = new File(path + "/js/");
        System.out.println("Created " + jsFolder);
        File cssFolder = new File(path + "/css/");
        System.out.println("Created " + cssFolder);
        assertTrue(jsFolder.exists());
        assertTrue(file.exists());
        assertTrue(cssFolder.exists());
    }
}