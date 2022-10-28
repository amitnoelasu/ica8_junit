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

}