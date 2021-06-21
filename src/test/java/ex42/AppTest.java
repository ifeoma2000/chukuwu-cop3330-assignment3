package ex42;

import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void parseData() throws IOException {
        File file = new File("src/main/resources/exercise42_output.txt");
        boolean exists = file.exists();
       assertTrue(exists);
    }
}