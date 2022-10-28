import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals = new Urinals();

    @org.junit.jupiter.api.Test
    void goodString() {
        String[] tests = {"10001","0000","1001","011"};
        assertTrue(urinals.goodString(tests[0]));
        assertTrue(urinals.goodString(tests[1]));
        assertTrue(urinals.goodString(tests[2]));
        assertTrue(urinals.goodString(tests[3]));

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