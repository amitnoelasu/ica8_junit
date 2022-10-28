import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
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
        assertFalse(urinals.goodString(tests[3]));

    }



    @Test
    void createFile() {
        assertNotNull(urinals.createFile());
    }

    @Test
    void countUrinals() {
        String[] tests = {"10001","0000","1001"};
        //integer input
        assertEquals(1, urinals.countUrinals(tests[0]));
        assertEquals(2, urinals.countUrinals(tests[1]));
        assertEquals(0, urinals.countUrinals(tests[2]));
        // string input
        assertEquals(0, urinals.countUrinals("abcd"));
    }

    @Test
    void writeToFile() {
        File f1 = new File("rule.txt");
        File f2 = new File("apple.txt");
        File f3 = new File("abc.png");
        try {
            //duplicate file
            assertTrue(urinals.writeToFile("test write to file", f1));

        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) { //IO exception
            System.out.println("IO exception");
        } catch (Exception e) { // Bad file name
            System.out.println(e.getMessage());
        }

        try {

            //bad file name
            assertTrue(urinals.writeToFile("test write to file", f2));

        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) { //IO exception
            System.out.println("IO exception");
        } catch (Exception e) { // Bad file name
            System.out.println(e.getMessage());
        }

        try {

            //IO exception
            assertTrue(urinals.writeToFile("test write to file", f3));
        } catch (FileAlreadyExistsException e) {
            System.out.println("File already exists");
        } catch (IOException e) { //IO exception
            System.out.println("IO exception");
        } catch (Exception e) { // Bad file name
            System.out.println(e.getMessage());
        }
    }

    @Test
    void openFile() {
        try {
            //File does not exist
            assertNull(urinals.openFile("abcd.txt"));
            //Empty file
            assertNotNull(urinals.openFile("emptyfile.dat"));
            //IO exception
            assertNotNull(urinals.openFile("abcd.txt"));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {

            //Empty file
            assertNotNull(urinals.openFile("emptyfile.dat"));

        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        try {

            //IO exception
            assertNotNull(urinals.openFile("abcd.txt"));
        } catch (FileNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}