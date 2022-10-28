import java.io.File;
import java.util.Scanner;

/*
    AUTHOR: Amit Noel Thokala
 */
public class Urinals {

    public static int RULE_NO = 0;
    boolean goodString(String str) {
        System.out.println("Not yet Implemented");
        return true;
    }

    String getStringFromKeyboard() {
        Scanner s = new Scanner(System.in);
        String input = s.nextLine().trim();
        return input;
    }

    File createFile() {

        String filePath = "rule"+RULE_NO+".txt";
        if(RULE_NO == 0) {
            filePath = "rule.txt";
        }
        File f = new File(filePath);
        while(f.exists()) {
            RULE_NO++;
            return createFile();
        }
        return f;
    }

    public static void main(String[] args) {

    }
}
