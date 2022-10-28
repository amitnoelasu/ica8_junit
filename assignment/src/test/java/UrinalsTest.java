import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals = new Urinals();

    @org.junit.jupiter.api.Test
    void goodString() {
        String[] tests = {"10001","0000","1001"};
        for(String test: tests) {
            assertTrue(urinals.goodString(test));
        }
    }


    @Test
    void createFile() {
        assertNotNull(urinals.createFile());
    }

    @Test
    void countUrinals() {
        String[] tests = {"10001","0000","1001"};
        assertEquals(1, urinals.countUrinals(tests[0]));
        assertEquals(2, urinals.countUrinals(tests[1]));
        assertEquals(0, urinals.countUrinals(tests[2]));
    }
}