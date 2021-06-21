package ex45;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void changeText() {
        File file = new File("src/main/resources/exercise45_input.txt");
        boolean exists = file.exists();
        assertTrue(exists);
    }
}