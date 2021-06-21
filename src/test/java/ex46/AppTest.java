package ex46;

import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void countMatches() {
        File file = new File("src/main/resources/exercise46_input.txt");
        boolean exists = file.exists();
        assertTrue(exists);
    }
}