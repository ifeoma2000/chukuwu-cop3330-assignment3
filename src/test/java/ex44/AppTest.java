package ex44;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void jsonParse() {
        File file = new File("src/main/resources/exercise44_products.json");
        boolean exists = file.exists();
        assertTrue(exists);
    }
}