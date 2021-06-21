package ex41;

import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @Test
    void alphabetize()
    {
        Scanner scanner = new Scanner("src/main/resources/exercise41_output.txt");
        String line = " ";
        String prev;
        boolean isInAlphabeticalOrder = true;
        while(scanner.hasNextLine())
        {
            prev = line;
            line = scanner.nextLine();
            if(prev.compareTo(line)>0)
            {
                isInAlphabeticalOrder = false;
                break;
            }
        }
        assertTrue(isInAlphabeticalOrder);
    }
}