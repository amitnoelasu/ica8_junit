import static org.junit.jupiter.api.Assertions.*;

class UrinalsTest {

    Urinals urinals = new Urinals();

    @org.junit.jupiter.api.Test
    void goodString() {
        String name = "Amit";
        assertFalse(urinals.goodString(name));
        System.out.println("===== "+name+" === TEST TWO EXECTUED");
    }
}